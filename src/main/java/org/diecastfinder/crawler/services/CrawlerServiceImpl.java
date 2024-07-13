package org.diecastfinder.crawler.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diecastfinder.crawler.services.tools.crawler.Crawler;
import org.diecastfinder.model.FoundModelDto;
import org.diecastfinder.crawler.web.model.WantedModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrawlerServiceImpl implements CrawlerService {

    @Autowired
    Crawler crawler;

    @Override
    public List<FoundModelDto> findModel(WantedModelDto wanted) {
        log.debug(String.format("Trying to find model '%s'.", wanted.getName()));
        return crawler.find(wanted);
    }
}
