package org.diecastfinder.crawler.services.tools.crawler.pageobjects;

import com.microsoft.playwright.Page;

public class PagerElement {

    private final Page page;

    private final String pagerMaxPageValueCss = "css=.ml-pagination input";

    public PagerElement(Page page) {
        this.page = page;
    }

    public Integer getMaxPageNo() {
        if (page.locator(pagerMaxPageValueCss).count() > 0) {
            return Integer.valueOf(page.locator(pagerMaxPageValueCss).first().getAttribute("max"));
        }
        else {
            return 0;
        }
    }

    public void openNextPage() {
        String currentPageUri = page.url().split("\\?")[0];
        page.navigate(currentPageUri + "?page" + getCurrentPageNo() + 1);
    }

    public void openPage(Integer pageNumber) {
        String currentPageUri = page.url().split("\\?")[0];
        page.navigate(currentPageUri + "?page=" + pageNumber);
    }

    private Integer getCurrentPageNo() {
        return Integer.valueOf(page.locator(pagerMaxPageValueCss).getAttribute("value"));
    }

}
