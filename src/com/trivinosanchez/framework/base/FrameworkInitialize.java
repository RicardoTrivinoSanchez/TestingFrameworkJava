package com.trivinosanchez.framework.base;

import com.trivinosanchez.framework.base.Browser.BrowserType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.trivinosanchez.framework.base.DriverContext.driver;

public class FrameworkInitialize extends Base {

    public void initializeBrowser (BrowserType browserType) {

        switch(browserType) {

            case Firefox:
                System.setProperty("webdriver.gecko.driver", "/home/capitole-consulting/Projects/TestingFrameworkJava/src/com/trivinosanchez/framework/drivers/linux/geckodriver");
                driver = new FirefoxDriver();
                break;

            case Chrome:
            default:
                driver = new ChromeDriver();
        }
    }
}
