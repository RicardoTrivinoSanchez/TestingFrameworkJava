package com.trivinosanchez.pages.tabs.search;

import base.BasePageObject;
import base.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class iOSSearchPageObject extends BasePageObject implements SearchPageObject {

    @FindBy(how = How.NAME, using = "Buscar en Wikipedia")
//    @iOSXCUITFindBy(accessibility = "Buscar en Wikipedia")
    private WebElement searchContainer;

    @FindBy(how = How.NAME, using = "Buscar en Wikipedia")
//    @iOSXCUITFindBy(accessibility = "Buscar en Wikipedia")
    private WebElement searchBox;

    @FindBy(how = How.NAME, using = "Cancelar")
//    @iOSXCUITFindBy(accessibility = "Cancelar")
    private WebElement cancelBtn;

    @FindBy(how = How.NAME, using = "Search")
//    @iOSXCUITFindBy(accessibility = "Search")
    private WebElement searchKeyboardBtn;

    @FindBy(how = How.XPATH, using = "//XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    private WebElement result;

    public iOSSearchPageObject(TestContext context) {
        super(context);
    }

    public void enterText(String text) {
        waitUntilVisibilityOf(searchBox);
        searchBox.sendKeys(text);
    }

    public void submitSearch() {
        searchKeyboardBtn.click();
    }

    public void selectResult() {
        result.click();
    }

    public void searchFor(String textToSearch) {
        openSearchBox();
        enterText(textToSearch);
        submitSearch();
        selectResult();
    }

    public void openSearchBox() {
        waitUntilVisibilityOf(searchContainer);
        searchContainer.click();
    }

    public void closeSearchBox() {
        cancelBtn.click();
    }

    public boolean isVisible() {
        waitUntilVisibilityOf(searchContainer);
        return searchContainer.isDisplayed();
    }
}
