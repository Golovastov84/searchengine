package searchengine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import searchengine.repositories.IndexSqlRepository;
import searchengine.repositories.LemmaRepository;
import searchengine.repositories.PageSqlRepository;
import searchengine.repositories.SiteSqlRepository;

@Controller
public class DefaultController {


    /**
     * Метод формирует страницу из HTML-файла index.html,
     * который находится в папке resources/templates.
     * Это делает библиотека Thymeleaf.
     */
    @Autowired
    SiteSqlRepository siteSqlRepository;

    @Autowired
    PageSqlRepository pageSqlRepository;

    @Autowired
    LemmaRepository lemmaRepository;

    @Autowired
    IndexSqlRepository indexSqlRepository;
    @RequestMapping("/")
    public String index() {
        /*SiteSql siteSql = new SiteSql();
        siteSql.setStatus(SiteIndexingStatus.INDEXING);
        siteSql.setStatusTime(LocalDateTime.now());
        siteSql.setLastError("NULL");
        siteSql.setUrl("https://sysout.ru/");
        siteSql.setName("sysout");
        siteSqlRepository.save(siteSql);*/

        /*PageSql pageSql = new PageSql();
        pageSql.setSiteId(siteSqlRepository.findById(1).get());
        pageSql.setPath("/news/2023/02/24/5pogibli/");
        pageSql.setCode(200);
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines =  Files.readAllLines(Paths.get("src/main/resources/content1.txt")*//*, StandardCharsets.*//*);

            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        pageSql.setContent(builder.toString());
        pageSqlRepository.save(pageSql);*/

        /*SiteSql siteSql = null;
        siteSql = siteSqlRepository.findById(1).get();*/
//        siteSqlRepository.deleteById(1);
//        siteSqlRepository.deleteById(1);

//        System.out.println(siteSqlRepository.findAllContains("Лент", 1).get(0).getName());
//        System.out.println(siteSqlRepository.findAll().size());

        return "index";
    }
}
