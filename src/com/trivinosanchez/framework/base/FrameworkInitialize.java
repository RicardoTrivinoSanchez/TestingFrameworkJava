package com.trivinosanchez.framework.base;

import com.trivinosanchez.framework.base.Browser.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkInitialize extends Base {

    protected void initializeBrowser (BrowserType browserType) {

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

        DriverContext.setDriver(driver);
    }
}
