package com.trivinosanchez.test.features.pages.tabs.search;

import com.trivinosanchez.framework.base.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DesktopSearchPageObject extends PageObject implements SearchPageObject {

    @FindBy(how = How.ID, using = "searchInput")
    public WebElement searchBox;

    public DesktopSearchPageObject (WebDriver driver) {
        super(driver);
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
}
