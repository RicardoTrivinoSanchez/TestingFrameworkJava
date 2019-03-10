package com.trivinosanchez.framework.utilities;

import com.trivinosanchez.framework.base.Browser.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class InitializerUtil {

    public static WebDriver getDriverForDesktop(BrowserType browserType) {

        WebDriver driver;

        switch(browserType) {

            case Firefox:
                System.setProperty("webdriver.gecko.driver", "src/com/trivinosanchez/framework/drivers/linux/geckodriver");
                driver = new FirefoxDriver();
                break;

            case Chrome:
            default:
                System.setProperty("webdriver.chrome.driver", "src/com/trivinosanchez/framework/drivers/linux/chromedriver");
                driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriverForDesktop(String browser) {
        return getDriverForDesktop(BrowserType.valueOf(browser));
    }
}
