package com.trivinosanchez.framework.base;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public abstract class PageObject {

    private final WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public <TPage extends PageObject> TPage as (Class<TPage> componentInstance) {
        try {
            return (TPage) this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}