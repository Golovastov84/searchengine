package searchengine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.repositories.SiteSqlRepository;
import searchengine.services.IndexingState;
import searchengine.services.SiteProcessing;
import searchengine.services.StatisticsService;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    SiteSqlRepository siteSqlRepository;

    private final StatisticsService statisticsService;
    /*private final PageProcessing pageProcessing;*/
    private final boolean indexingBoolean;

    public ApiController(StatisticsService statisticsService, SiteProcessing siteProcessing) {
        this.statisticsService = statisticsService;
        /*this.pageProcessing = pageProcessing;*/
        indexingBoolean = false;
//        indexingBoolean = true;
    }

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsResponse> statistics() {
        return ResponseEntity.ok(statisticsService.getStatistics());
    }

    @GetMapping("/startIndexing")
    public ResponseEntity<?> startIndexing(){
        HashMap<String, Boolean> answer = new HashMap<>();
       /* PageProcessing pageProcessing = new PageProcessing();*/
        IndexingState indexingState;
        if(indexingBoolean) {
            answer.put("result", indexingBoolean);
            return new ResponseEntity<>(answer, HttpStatus.OK);
        }
        indexingState = new IndexingState(indexingBoolean, 1);
        return new ResponseEntity<>(indexingState, HttpStatus.CONFLICT);
    }

    /*public void startIndexing(){

    }*/
}
