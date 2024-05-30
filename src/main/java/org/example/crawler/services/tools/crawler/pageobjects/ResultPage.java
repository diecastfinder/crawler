package org.example.crawler.services.tools.crawler.pageobjects;

import com.microsoft.playwright.Page;
import java.util.List;
import org.example.crawler.web.model.FoundModelDto;

public class ResultPage {

    Page page;

    private String lotCss = "css=article";
    private PagerElement pager = new PagerElement(page);

    public ResultPage(Page page) {
        this.page = page;
    }

    public List<FoundModelDto> getLots() {

        Integer maxPage = pager.getMaxPageNo();
        List<LotElement> lots = page.locator(lotCss).all().stream().map(LotElement::new).toList();
        for (int i = 2; i <= maxPage; i++) {
            pager.openPage(i);
            lots.addAll(page.locator(lotCss).all().stream().map(LotElement::new).toList());
        }

        return lots.stream().map(LotElement::getModel).toList();
    }

}
