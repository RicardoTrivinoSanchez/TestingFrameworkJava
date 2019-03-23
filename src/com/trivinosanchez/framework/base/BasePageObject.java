package com.trivinosanchez.framework.base;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public abstract class BasePageObject {

    protected final TestContext context;
    protected final WebDriverWait wait;

    public BasePageObject(TestContext context) {
        this.context = context;
        this.wait = new WebDriverWait(context.getDriver(), 10);
    }

    public <TPage extends BasePageObject> TPage as (Class<TPage> componentInstance) {
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

    public void waitUntilVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}