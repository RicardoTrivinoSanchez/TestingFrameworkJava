package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.FrameworkInitialize;
import com.trivinosanchez.test.features.pages.common.TopBarMenu;
import com.trivinosanchez.test.features.utils.StepsUtil;
import com.trivinosanchez.test.features.pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TopBarSteps extends FrameworkInitialize {

    @When("^clicking on Login button$")
    public void clickingOnLoginButton() {
        getCurrentPageAs(TopBarMenu.class).goToLoginPage();
    }

    @And("^there is a greeting for the user at the top bar$")
    public void thereIsAGreetingForTheUserAtTheTopBar() {
        String greetings = getCurrentPageAs(HomePage.class).getTopbar().getGreetings();
        Assert.assertTrue("Greetings should contain the username", greetings.contains(StepsUtil.username));
    }
}
