package org.diecastfinder.crawler.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfigHelper {

    @Value("${webresource}")
    private String BASE_URL;

    @PostConstruct
    public void init() {
        WebConfig.BASE_URL = BASE_URL;
    }
}
