package searchengine.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchengine.config.Site;
import searchengine.config.SitesList;
import searchengine.model.PageLocal;
import searchengine.model.PageSql;
import searchengine.model.SiteSql;
import searchengine.repositories.SiteSqlRepository;

import java.util.Set;
import java.util.concurrent.ForkJoinPool;

@Service
@RequiredArgsConstructor
public class SiteIndexingResults {
    private final SitesList sites;
//    private final Set<SiteSql> siteSqlSet;
    private final SiteProcessing pageProcessing;
    @Autowired
    SiteSqlRepository siteSqlRepository;

    public void getIndexing() {
//        siteSqlSet.addAll(siteSqlRepository.findAll());
    for(Site site : sites.getSites()){
        SiteSql siteSqlLocal = null;
        // получение сущности сайта из базы данных
        for (SiteSql siteSql : siteSqlRepository.findAll()){
            if(site.getUrl().equals(siteSql.getUrl())){
                siteSqlLocal = siteSql;
            }
        }
        // начало многозадачности
        ForkJoinPool pool = new ForkJoinPool();
        SiteProcessing system = new SiteProcessing(site.getUrl());
        pool.execute(system);
        pool.shutdown();
        Set<PageLocal> results;
        // to do
        results = system.compute();
        for (PageLocal pageLocal : results) {

            PageSql pageSql = new PageSql();
            pageSql.setSiteSql(siteSqlLocal);
            pageSql.setPath(pageSql.getPath());
            pageSql.setCode(200);
            pageSql.setContent(pageSql.getContent());
//            pageSql.setPath(name);
        }

        /*for (String name : results) {
            int level = name.split("/").length - 1;
            System.out.println((String.join("", Collections.nCopies(level, "\t"))).concat(name));
        }*/
     }
    }

}
