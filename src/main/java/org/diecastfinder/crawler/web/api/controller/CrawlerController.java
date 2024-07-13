package org.diecastfinder.crawler.web.api.controller;

import java.util.List;
import org.diecastfinder.crawler.services.CrawlerService;
import org.diecastfinder.model.FoundModelDto;
import org.diecastfinder.crawler.web.model.WantedModelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/crawler/find")
@RestController
public class CrawlerController {
    private final CrawlerService crawlerService;

    public CrawlerController(CrawlerService crawlerService) {
        this.crawlerService = crawlerService;
    }

    @PostMapping
    public ResponseEntity findWantedModel(@RequestBody WantedModelDto wantedModelDto) {
        List<FoundModelDto> foundModelDtos = crawlerService.findModel(wantedModelDto);

        return ResponseEntity.ok(foundModelDtos);
    }

}
