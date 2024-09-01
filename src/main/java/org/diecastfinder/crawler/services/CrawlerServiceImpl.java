package org.diecastfinder.crawler.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diecastfinder.crawler.config.JmsConfig;
import org.diecastfinder.crawler.services.tools.crawler.Crawler;
import org.diecastfinder.model.FoundModelDto;
import org.diecastfinder.model.WantedModelDto;
import org.diecastfinder.model.factories.AddModelEventFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrawlerServiceImpl implements CrawlerService {

    private final Crawler crawler;
    private final JmsTemplate jmsTemplate;

    @Override
    public List<FoundModelDto> findModel(WantedModelDto wanted) {
        log.debug(String.format("Trying to find model '%s'.", wanted.getName()));

        List<FoundModelDto> foundModelDtos = crawler.find(wanted);
        log.debug(String.format("Sending %d models found by request '%s'.", foundModelDtos.size(), wanted.getName()));
        foundModelDtos.forEach(m -> jmsTemplate
            .convertAndSend(JmsConfig.ADD_MODEL_QUEUE, AddModelEventFactory.getAddModelEvent(m)));
        log.debug(String.format("Models found by request '%s' were sent.", wanted.getName()));

        return foundModelDtos;
    }
}
