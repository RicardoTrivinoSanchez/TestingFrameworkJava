package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
public class HomePage extends BasePage {

    @FindBy(how = How.ID, using = "searchInput")
    public WebElement searchBox;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToSearch(String stringToSearch) {
        searchBox.sendKeys(stringToSearch);
    }

    public void search() {
        searchBox.sendKeys(Keys.ENTER);
    }

    public void searchFor(String stringToSearch) {
        enterTextToSearch(stringToSearch);
        search();
    }
}
