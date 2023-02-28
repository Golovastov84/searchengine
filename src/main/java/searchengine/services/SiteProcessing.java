package searchengine.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import searchengine.model.PageLocal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
/*@RequiredArgsConstructor*/
// to do  PageLocal -> String
public class SiteProcessing extends RecursiveTask<Set<PageLocal>> {
    private static final long serialVersionUID = 1L;
    private final String path;
    private PageLocal pageLocal;

    /*private final StatisticsService statisticsService;*/

    /*private final SitesList sites;*/

    public SiteProcessing(String path) {
        this.path = path;
    }

    @Override
    protected Set<PageLocal> compute() {

        Set<String> setAdress = new TreeSet<>(new ClientComparator());
        List<SiteProcessing> tasks = new ArrayList<>();
        Set<PageLocal> pageLocals = new TreeSet<>();
        try {

            Document docSkillboxSite =
                    Jsoup.connect(path).ignoreHttpErrors(true).timeout(5000).get();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ArrayList<String> listAdress = new ArrayList<>();
            Elements elements = docSkillboxSite.select("a[href]");

            elements.forEach(element -> {
                String absHref = element.attr("abs:href");
                listAdress.add(getRegex(path + "[^\\/]+[\\/]?", absHref));
            });
            for (String name : listAdress) {
                if (name.endsWith("/") && !name.equals(path) && !checkFile(name, setAdress)) {
                   // fix code, upgrade constructor

                    SiteProcessing task = new SiteProcessing(name);
                    task.fork();
                    tasks.add(task);
                    setAdress.add(name);
                    pageLocals.add(setPageLocal(name, docSkillboxSite));
                } else {
                    if (!name.equals("") && !name.endsWith("#")) {
                        setAdress.add(name);
                        pageLocals.add(setPageLocal(name, docSkillboxSite));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // to do
//        addResultsFromTasks(setAdress, tasks);
        return pageLocals;
//        return setAdress;
    }

    private PageLocal setPageLocal(String name, Document document){

        return new PageLocal(name, document.toString());
    }

    private boolean checkFile(String name, Set<String> setAdress) {
        return setAdress.contains(name);
    }

    private void addResultsFromTasks(Set<PageLocal> list, List<SiteProcessing> tasks) {
        for (SiteProcessing item : tasks) {
            list.addAll(item.join());
        }
    }

    private static String getRegex(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int start = 0;
        int end = 0;
        while (matcher.find()) {
            start = matcher.start();
            end = matcher.end();
        }
        return text.substring(start, end);
    }
}


