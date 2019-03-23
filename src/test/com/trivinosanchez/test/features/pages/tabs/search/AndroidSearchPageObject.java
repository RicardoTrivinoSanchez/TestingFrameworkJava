package com.trivinosanchez.test.features.pages.tabs.search;

import com.trivinosanchez.framework.base.BasePageObject;
import com.trivinosanchez.framework.base.TestContext;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AndroidSearchPageObject extends BasePageObject implements SearchPageObject {

    @FindBy(how = How.ID, using = "org.wikipedia:id/search_container")
    private WebElement searchContainer;

    @FindBy(how = How.ID, using = "org.wikipedia:id/search_src_text")
    private WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='org.wikipedia:id/search_toolbar']/android.widget.ImageButton")
    private WebElement backArrow;

    public AndroidSearchPageObject(TestContext context) {
        super(context);
    }

    public void enterText(String text) {
        waitUntilVisibilityOf(searchBox);
        searchBox.sendKeys(text);
    }

    public void submitSearch() {
        ((AndroidDriver) context.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void searchFor(String textToSearch) {
        openSearchBox();
        enterText(textToSearch);
        submitSearch();
    }

    public void openSearchBox() {
        waitUntilVisibilityOf(searchContainer);
        searchContainer.click();
    }

    public void closeSearchBox() {
        backArrow.click();
    }

    public boolean isOpen() {
        return false;
    }
}
