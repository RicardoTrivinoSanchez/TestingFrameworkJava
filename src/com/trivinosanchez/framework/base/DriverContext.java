package com.trivinosanchez.framework.base;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class DriverContext {

    @Getter
    private static WebDriver driver;
    @Getter
    private static Browser browser;

    protected static void setDriver(WebDriver webdriver) {
        driver = webdriver;
        browser = new Browser(driver);
    }
}
