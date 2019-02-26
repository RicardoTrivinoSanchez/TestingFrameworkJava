package com.trivinosanchez.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

    public enum BrowserType {
        Firefox, Chrome, IE, Safari
    }

    private WebDriver driver;
    private BrowserType type;

    Browser (WebDriver driver) {
        this.driver = driver;
        if (driver instanceof FirefoxDriver) {
            type = BrowserType.Firefox;
        } else {
            type = BrowserType.Chrome;
        }
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public boolean isInUrl(String url) {
        return driver.getCurrentUrl().equals(url);
    }
}
