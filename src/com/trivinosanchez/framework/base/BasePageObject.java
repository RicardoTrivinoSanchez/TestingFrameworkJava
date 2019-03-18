package com.trivinosanchez.framework.base;

import org.openqa.selenium.WebElement;

public interface BasePageObject {

    void sleep(int milliseconds);
    void waitUntilVisibilityOf(WebElement element);
}
