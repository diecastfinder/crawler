package org.example.crawler.services;

import java.util.List;
import org.example.crawler.web.model.FoundModelDto;
import org.example.crawler.web.model.WantedModelDto;

public interface CrawlerService {
    List<FoundModelDto> findModel(WantedModelDto wanted);
}
