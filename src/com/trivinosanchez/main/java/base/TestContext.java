package base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import utilities.PageBuilderUtil;

@Getter
@NoArgsConstructor
public class TestContext {

    public enum Platform {
        Desktop, WebApp, Android, iOS
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

    public void initIOS (WebDriver driver) {
        init(driver, Platform.iOS);
    }

    private <TPage extends BasePageObject> TPage getInstance(Class<TPage> pageObject) {
        Object obj = PageBuilderUtil.initElements(this, pageObject);
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

    public boolean isAndroid() {
        return platform == Platform.Android;
    }

    public boolean isIOS() {
        return platform == Platform.iOS;
    }

    public boolean isApp() {
        return platform == Platform.Android || platform == Platform.iOS;
    }
}