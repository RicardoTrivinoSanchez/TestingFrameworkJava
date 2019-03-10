package com.trivinosanchez.framework.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
@NoArgsConstructor
public class TestContext {

    private WebDriver driver;
    private Browser browser;
    @Setter
    private BasePage currentPage;

    public void init (WebDriver driver) {
        this.driver = driver;
        this.browser = new Browser(driver);
    }

    private <TPage extends BasePage> TPage getInstance (Class<TPage> page) {
        Object obj = PageFactory.initElements(this.driver, page);
        return page.cast(obj);
    }

    public <TPage extends BasePage> TPage getCurrentPageAs (Class<TPage> page) {
        currentPage = getInstance(page);
        return getCurrentPage().as(page);
    }
}