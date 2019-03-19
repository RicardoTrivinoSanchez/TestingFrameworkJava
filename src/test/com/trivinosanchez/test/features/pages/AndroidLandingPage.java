package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AndroidLandingPage extends PageObject {

    @FindBy(how = How.ID, using = "org.wikipedia:id/fragment_onboarding_skip_button")
    private WebElement skipBtn;

    public AndroidLandingPage(WebDriver driver) {
        super(driver);
    }

    public void pressSkip() {
        skipBtn.click();
    }
}
