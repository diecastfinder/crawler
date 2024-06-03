package org.example.crawler.services.tools.crawler.pageobjects;

import com.microsoft.playwright.Locator;
import org.apache.commons.lang3.StringUtils;
import org.example.crawler.web.model.FoundModelDto;
import org.springframework.beans.factory.annotation.Value;

public class LotElement {

    @Value("${webresource}")
    private String BASE_URL;

    private Locator element;

    private String linkToLotCss = "css=a";
    private String titleCss = "css=h3";
    private String producerXpath = "xpath=//li/div[contains(text(),\"Marka\")]/span";
    private String priceCss = "css=.ml-offer-price__dollars";
    private String currencyCss = "css=.ml-offer-price__currency";

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
