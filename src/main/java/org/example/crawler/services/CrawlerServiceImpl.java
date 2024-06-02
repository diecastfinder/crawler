package org.example.crawler.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.crawler.services.tools.crawler.Crawler;
import org.example.crawler.web.model.FoundModelDto;
import org.example.crawler.web.model.WantedModelDto;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrawlerServiceImpl implements CrawlerService {

    @Override
    public List<FoundModelDto> findModel(WantedModelDto wanted) {
        log.debug(String.format("Trying to find model '%s'.", wanted.getName()));
        return Crawler.find(wanted);
    }
}
