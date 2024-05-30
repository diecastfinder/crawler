package org.example.crawler.services.tools.crawler;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.util.List;
import org.example.crawler.web.model.FoundModelDto;
import org.example.crawler.web.model.WantedModelDto;
import org.springframework.beans.factory.annotation.Value;

public class Crawler {
    private final static String URL_PREFIX = "oferty/kolekcje-i-sztuka/q/";
    private final static String URL_POSTFIX = "";

    @Value("${webresource}")
    private static String BASE_URL;

    public static List<FoundModelDto> find(WantedModelDto wanted) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();


            page.navigate(BASE_URL + URL_PREFIX + wanted.getName());
            System.out.println(page.title());
        }

        return null;
    }

}
