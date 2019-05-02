package utilities;

import base.Browser;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class InitializerUtil {

    private static WebDriver getDriverForWeb(Browser.Name browserName) {

        WebDriver driver;
        String path = "src/com/trivinosanchez/framework/drivers/" + getDriverFolder() + "/";

        switch(browserName) {

            case Firefox:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case Chrome:
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriverForDesktop(String browserName) {
        return getDriverForWeb(Browser.Name.valueOf(browserName));
    }

    public static WebDriver getDriverForWebApp(String browserName) throws MalformedURLException {
        AndroidDriver driver = new AndroidDriver(
                getAppiumServerUrl(),
                CapabilitiesBuilder.forAndroidBrowser(browserName));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriverForAndroid(String appName) throws MalformedURLException {
        AndroidDriver<WebElement> driver = new AndroidDriver<>(
                getAppiumServerUrl(),
                CapabilitiesBuilder.forAndroidWikipediaApp());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriverForIOS(String appName) throws MalformedURLException {
        IOSDriver<WebElement> driver = new IOSDriver<>(
                getAppiumServerUrl(),
                CapabilitiesBuilder.forIOSWikipediaApp());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private static String getDriverFolder() {
        return Platform.getCurrent().toString().toLowerCase();
    }

    private static URL getAppiumServerUrl() throws MalformedURLException {
        return new URL("http://localhost:4723/wd/hub");
    }
}
