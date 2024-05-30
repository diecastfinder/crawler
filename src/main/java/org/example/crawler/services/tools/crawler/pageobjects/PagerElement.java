package org.example.crawler.services.tools.crawler.pageobjects;

import com.microsoft.playwright.Page;
import java.io.StringReader;

public class PagerElement {

    private Page page;

    private String pagerMaxPageValueCss = "css=.ml-pagination input";

    public PagerElement(Page page) {
        this.page = page;
    }

    public Integer getMaxPageNo() {
        return Integer.valueOf(page.locator(pagerMaxPageValueCss).getAttribute("max"));
    }

    public void openNextPage() {
        String currentPageUri = page.url().split("/?")[0];
        page.navigate(currentPageUri + "?page" + getCurrentPageNo() + 1);
    }

    public void openPage(Integer pageNumber) {
        String currentPageUri = page.url().split("/?")[0];
        page.navigate(currentPageUri + "?page" + pageNumber);
    }

    private Integer getCurrentPageNo() {
        return Integer.valueOf(page.locator(pagerMaxPageValueCss).getAttribute("value"));
    }

}
