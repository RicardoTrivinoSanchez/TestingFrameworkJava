package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AndroidCervantesPageObject extends PageObject {

    @FindBy(how = How.ID, using = "heading_0")
    private WebElement header;

    public AndroidCervantesPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean isPageVisible() {
        waitUntilVisibilityOf(header);
        return titleEquals("Miguel de Cervantes");
    }

    private String getTitle() {
        return header.findElement(By.xpath("//*[1]")).getText().trim();
    }

    private boolean titleEquals(String title) {
        return getTitle().equals(title);
    }
}
