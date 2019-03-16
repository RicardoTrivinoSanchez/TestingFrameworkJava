package com.trivinosanchez.framework.utilities;

import com.trivinosanchez.framework.base.Browser.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class InitializerUtil {

    public static WebDriver getDriverForDesktop(BrowserType browserType) {

        WebDriver driver;
        String path = "src/com/trivinosanchez/framework/drivers/" + getDesktopOS() + "/";

        switch(browserType) {

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

    public static WebDriver getDriverForDesktop(String browser) {
        return getDriverForDesktop(BrowserType.valueOf(browser));
    }

    private static String getDesktopOS() {
        String desktopOS = "";
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")){
            desktopOS = "windows";

        } else if (osName.contains("osx")){
            desktopOS = "macoS";

        } else if (osName.contains("nix") || osName.contains("aix") || osName.contains("nux")) {
            desktopOS = "linux";
        }
        return desktopOS;
    }
}
