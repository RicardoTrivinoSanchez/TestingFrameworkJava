package com.trivinosanchez.test.features.pages.tabs.search;

import com.trivinosanchez.framework.base.PageObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AndroidSearchPageObject extends PageObject implements SearchPageObject {

    @FindBy(how = How.ID, using = "org.wikipedia:id/search_container")
    private WebElement searchContainer;

    @FindBy(how = How.ID, using = "org.wikipedia:id/search_src_text")
    private WebElement searchBox;

    public AndroidSearchPageObject(WebDriver driver) {
        super(driver);
    }

    public void enterText(String text) {
        waitUntilVisibilityOf(searchContainer);
        searchContainer.click();
        waitUntilVisibilityOf(searchBox);
        searchBox.sendKeys(text);
    }


    public void submitSearch() {
//        searchBox.sendKeys(Keys.ENTER);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }


    public void searchFor(String textToSearch) {
        enterText(textToSearch);
        submitSearch();
    }
}
