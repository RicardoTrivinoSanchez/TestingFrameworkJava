package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.BasePageObject;
import com.trivinosanchez.framework.base.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AndroidLandingPage extends BasePageObject {

    @FindBy(how = How.ID, using = "org.wikipedia:id/fragment_onboarding_skip_button")
    private WebElement skipBtn;

    public AndroidLandingPage(TestContext context) {
        super(context);
    }

    public void pressSkip() {
        skipBtn.click();
    }
}
