package com.trivinosanchez.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser {

    public enum BrowserType {
        Firefox, Chrome, IE, Safari
    }

    private WebDriver driver;
    public BrowserType type;

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }
}
