package com.trivinosanchez.framework.base;

import org.openqa.selenium.WebElement;

public interface PageObject {

    void sleep(int milliseconds);
    boolean isOpen();
    void waitUntilVisibilityOf(WebElement element);
}
