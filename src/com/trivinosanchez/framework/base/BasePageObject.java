package com.trivinosanchez.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObject {

    private final TestContext context;
    final WebDriver driver;
    private final WebDriverWait wait;

    public BasePageObject(TestContext context) {
        this.context = context;
        this.driver = context.getDriver();
        this.wait = new WebDriverWait(context.getDriver(), 10);
    }

    <TPage extends BasePageObject> TPage as (Class<TPage> componentInstance) {
        try {
            return (TPage) this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void waitUntilVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}