package org.diecastfinder.crawler.services.tools.crawler.pageobjects;

import com.microsoft.playwright.Page;
import java.util.ArrayList;
import java.util.List;
import org.diecastfinder.model.FoundModelDto;

public class ResultPage {

    private final Page page;

    private final String lotCss = "css=article";
    private final PagerElement pager;

    public ResultPage(Page page) {
        this.page = page;
        this.pager = new PagerElement(page);
    }

    public List<FoundModelDto> getLots() {

        Integer maxPage = pager.getMaxPageNo();
        List<FoundModelDto> lots = new ArrayList<>();

        if (maxPage != 0) {
            for (int i = 1; i <= maxPage; i++) {
                if (i >= 2) {
                    pager.openPage(i);
                }
                lots.addAll(page.locator(lotCss).all().stream()
                    .map(LotElement::new)
                    .map(LotElement::getModel)
                    .toList());
            }
        }

        return lots;
    }

}
