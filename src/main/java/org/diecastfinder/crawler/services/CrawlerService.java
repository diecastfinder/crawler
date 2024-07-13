package org.diecastfinder.crawler.services;

import java.util.List;
import org.diecastfinder.model.FoundModelDto;
import org.diecastfinder.crawler.web.model.WantedModelDto;

public interface CrawlerService {
    List<FoundModelDto> findModel(WantedModelDto wanted);
}
