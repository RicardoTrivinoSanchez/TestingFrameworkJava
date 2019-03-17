package com.trivinosanchez.framework.utilities;

import com.trivinosanchez.framework.base.Browser;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class InitializerUtil {

    private static WebDriver getDriverForWeb(Browser.Name browserName) {

        WebDriver driver;
        String path = "src/com/trivinosanchez/framework/drivers/" + getDriverFolder() + "/";

        switch(browserName) {

            case Firefox:
                System.setProperty("webdriver.gecko.driver", path + "geckodriver");
                driver = new FirefoxDriver();
                break;

            case Chrome:
            default:
                System.setProperty("webdriver.chrome.driver", path + "chromedriver");
                driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriverForDesktop(String browserName) {
        return getDriverForWeb(Browser.Name.valueOf(browserName));
    }

    public static WebDriver getDriverForWebApp(String browserName) {
        String path = "src/com/trivinosanchez/framework/drivers/" + getDriverFolder() + "/";
        System.setProperty("webdriver.chrome.driver", path + "chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Pixel 2");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        return new ChromeDriver(chromeOptions);
    }

    private static String getDriverFolder() {
        return Platform.getCurrent().toString().toLowerCase();
    }
}
