package com.trivinosanchez.pages.tabs.search;

import base.BasePageObject;
import base.TestContext;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DesktopSearchPageObject extends BasePageObject implements SearchPageObject {

    @FindBy(how = How.ID, using = "searchInput")
    private WebElement searchBox;

    public DesktopSearchPageObject(TestContext context) {
        super(context);
    }

    public void enterText(String text) {
        searchBox.sendKeys(text);
    }

    public void submitSearch() {
        searchBox.sendKeys(Keys.ENTER);
    }

    public void searchFor(String textToSearch) {
        enterText(textToSearch);
        submitSearch();
    }

    public boolean isVisible() {
        return false;
    }
}
