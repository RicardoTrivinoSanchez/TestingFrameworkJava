package com.trivinosanchez.framework.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
@NoArgsConstructor
public class TestContext {

    public enum Platform {
        Desktop, WebApp
    }

    private WebDriver driver;
    private Browser browser;
    private Platform platform;
    private PageObject currentPageObject;

    private void init (WebDriver driver, Platform platform) {
        this.driver = driver;
        this.browser = new Browser(driver);
        this.platform = platform;
    }

    public void initDesktop (WebDriver driver) {
        init(driver, Platform.Desktop);
    }

    public void initWebApp (WebDriver driver) {
        init(driver, Platform.WebApp);
    }

    private <TPage extends PageObject> TPage getInstance (Class<TPage> pageObject) {
        Object obj = PageFactory.initElements(this.driver, pageObject);
        return pageObject.cast(obj);
    }

    public <TPage extends PageObject> TPage getCurrentPageObjectAs(Class<TPage> pageObject) {
        currentPageObject = getInstance(pageObject);
        return getCurrentPageObject().as(pageObject);
    }

    public boolean isDesktop() {
        return platform == Platform.Desktop;
    }

    public boolean isWebApp() {
        return platform == Platform.WebApp;
    }

    public boolean isWeb() {
        return platform == Platform.Desktop || platform == Platform.WebApp;
    }
}