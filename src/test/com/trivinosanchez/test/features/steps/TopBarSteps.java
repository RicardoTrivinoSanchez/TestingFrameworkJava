package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.TestContext;
import com.trivinosanchez.test.features.pages.HomePage;
import com.trivinosanchez.test.features.pages.common.TopBarMenu;
import com.trivinosanchez.test.features.utils.StepsUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TopBarSteps {

    private TestContext context;

    public TopBarSteps(TestContext context) {
        this.context = context;
    }

    @When("^clicking on Login link$")
    public void clickingOnLoginLink() {
        context.getCurrentPageAs(TopBarMenu.class).goToLoginPage();
    }

    @When("^clicking on Employee List link$")
    public void clickingOnEmployeeListLink() {
        context.getCurrentPageAs(TopBarMenu.class).goToEmployeeListPage();
    }

    @And("^there is a greeting for the user at the top bar$")
    public void thereIsAGreetingForTheUserAtTheTopBar() {
        String greetings = context.getCurrentPageAs(HomePage.class).getTopBar().getGreetings();
        Assert.assertTrue("Greetings should contain the username", greetings.contains(StepsUtil.username));
    }
}
