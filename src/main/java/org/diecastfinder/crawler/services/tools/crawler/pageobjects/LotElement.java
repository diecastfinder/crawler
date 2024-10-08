package org.diecastfinder.crawler.services.tools.crawler.pageobjects;

import com.microsoft.playwright.Locator;
import org.apache.commons.lang3.StringUtils;
import org.diecastfinder.crawler.config.WebConfig;
import org.diecastfinder.crawler.config.WebConfigHelper;
import org.diecastfinder.model.FoundModelDto;

public class LotElement {

    private String BASE_URL = WebConfig.BASE_URL;

    private final Locator element;

    private final String linkToLotCss = "css=a";
    private final String titleCss = "css=h3";
    private final String producerXpath = "xpath=//li/div[contains(text(),\"Marka\")]/span";
    private final String priceCss = "css=.ml-offer-price__dollars";
    private final String currencyCss = "css=.ml-offer-price__currency";

    public LotElement(Locator element) {
        this.element = element;
    }

    public FoundModelDto getModel() {

        return FoundModelDto.builder()
            .uri(StringUtils.chop(BASE_URL) + element.locator(linkToLotCss).getAttribute("href"))
            .lotTitle(element.locator(titleCss).innerText())
            .producer(element.locator(producerXpath).isVisible() ? element.locator(producerXpath).innerText() : null)
            .price(Integer.valueOf(element.locator(priceCss).innerText().replace(" ", "")))
            .currency(StringUtils.stripAccents(element.locator(currencyCss).innerText()).replaceAll("[^\\p{ASCII}]", ""))
            .build();
    }
}
