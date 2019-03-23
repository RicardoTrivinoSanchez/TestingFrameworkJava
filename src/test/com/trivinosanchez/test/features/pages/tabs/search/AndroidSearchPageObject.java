package com.trivinosanchez.test.features.pages.tabs.search;

import com.trivinosanchez.framework.base.BaseAndroidPageObject;
import com.trivinosanchez.framework.base.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AndroidSearchPageObject extends BaseAndroidPageObject implements SearchPageObject {

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
        submit();
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
