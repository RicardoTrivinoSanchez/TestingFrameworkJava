package com.trivinosanchez.test.features.pages.tabs.search;

import com.trivinosanchez.framework.base.BasePageObject;
import com.trivinosanchez.framework.base.TestContext;
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

    public boolean isOpen() {
        return false;
    }
}
