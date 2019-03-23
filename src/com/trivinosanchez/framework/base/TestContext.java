package com.trivinosanchez.framework.base;

import com.trivinosanchez.framework.utilities.PageBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@Getter
@NoArgsConstructor
public class TestContext {

    public enum Platform {
        Desktop, WebApp, Android
    }

    private WebDriver driver;
    private Browser browser;
    private Platform platform;
    private BasePageObject currentPageObject;

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

    public void initAndroid (WebDriver driver) {
        init(driver, Platform.Android);
    }

    private <TPage extends BasePageObject> TPage getInstance(Class<TPage> pageObject) {
        Object obj = PageBuilder.initElements(this, pageObject);
        return pageObject.cast(obj);
    }

    public <TPage extends BasePageObject> TPage getPageObjectAs(Class<TPage> pageObject) {
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