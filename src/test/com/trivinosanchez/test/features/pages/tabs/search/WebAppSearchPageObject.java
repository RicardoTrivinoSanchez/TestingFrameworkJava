package com.trivinosanchez.test.features.pages.tabs.search;

import com.trivinosanchez.framework.base.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WebAppSearchPageObject extends PageObject implements SearchPageObject {

    @FindBy(how = How.ID, using = "searchIcon")
    private WebElement searchIcon;

    @FindBy(how = How.XPATH, using = "//form/input[@class='search']")
    private WebElement searchBox;

    @FindBy(how = How.CLASS_NAME, using = "mw-ui-icon mw-ui-icon-mf-overlay-close mw-ui-icon-element   cancel")
//    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'cancel')]")
    private WebElement closeButton;

    public WebAppSearchPageObject(WebDriver driver) {
        super(driver);
    }

    public void enterText(String text) {
        searchBox.sendKeys(text);
    }

    public void submitSearch() {
        searchBox.sendKeys(Keys.ENTER);
    }

    public void searchFor(String textToSearch) {
        openSearchBox();
        enterText(textToSearch);
        submitSearch();
    }

    public void openSearchBox() {
        searchIcon.click();
        waitUntilVisibilityOf(searchBox);
    }

    public void closeSearchBox() {
        closeButton.click();
    }


}
