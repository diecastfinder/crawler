package org.example.crawler.services.tools.crawler.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.crawler.web.model.FoundModelDto;

public class LotElement {

    private Locator element;

    private String linkToLotCss = "css=a";
    private String titleCss = "css=h3";
    private String producerXpath = "xpath=//li/div[contains(text(),‘Marka’)]/span";
    private String priceCss = "css=.ml-offer-price__dollars";
    private String currencyCss = "css=.ml-offer-price__currency";

    public LotElement(Locator element) {
        this.element = element;
    }

    public FoundModelDto getModel() {

        return FoundModelDto.builder()
            .uri(element.locator(linkToLotCss).getAttribute("href"))
            .lotTitle(element.locator(titleCss).innerText())
            .producer(element.locator(producerXpath).innerText())
            .price(Integer.valueOf(element.locator(priceCss).innerText()))
            .currency(element.locator(currencyCss).innerText())
            .build();
    }
}
