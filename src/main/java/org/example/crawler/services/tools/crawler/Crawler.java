package org.example.crawler.services.tools.crawler;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.util.List;
import java.util.Objects;
import org.example.crawler.services.tools.crawler.pageobjects.ResultPage;
import org.example.crawler.web.model.FoundModelDto;
import org.example.crawler.web.model.WantedModelDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Crawler {
    private final static String URL_PREFIX = "oferty/kolekcje-i-sztuka/q/";

    @Value("${webresource}")
    private String BASE_URL;

    public List<FoundModelDto> find(WantedModelDto wanted) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate(BASE_URL + URL_PREFIX + wanted.getName());

            ResultPage resultPage = new ResultPage(page);
            List<FoundModelDto> lotsFoundByName = resultPage.getLots();
            return lotsFoundByName.stream()
                .filter(l -> Objects.nonNull(l.getPrice()) && l.getPrice() >= wanted.getMinPrice() && l.getPrice() <= wanted.getMaxPrice())
                .filter(l -> Objects.isNull(wanted.getProducer()) || Objects.isNull(l.getProducer()) || l.getProducer().equals(wanted.getProducer()))
                .map(l -> l.setNameRequested(wanted.getName()))
                .toList();
        } catch (Exception e) {
            System.out.printf("Attempt to find '%s' failed.%n", wanted.getName());
            e.printStackTrace();
        }
        return null;
    }
}
