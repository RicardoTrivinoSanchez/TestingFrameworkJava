package com.trivinosanchez.framework.base;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public abstract class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public <TPage extends BasePage> TPage as (Class<TPage> componentInstance) {
        try {
            return (TPage) this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}