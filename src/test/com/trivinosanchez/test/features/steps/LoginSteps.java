package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.TestContext;
import com.trivinosanchez.test.features.pages.LoginPage;
import com.trivinosanchez.test.features.utils.StepsUtil;
import cucumber.api.java.en.When;

public class LoginSteps {

    private TestContext context;

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    public static LoginSteps execute(TestContext context) {
        return new LoginSteps(context);
    }

    @When("^logging as \"(.*)\" with password \"(.*)\"$")
    public void loggingAs(String username, String password) throws Throwable {
        StepsUtil.username = username;
        context.getCurrentPageAs(LoginPage.class).login(username, password);
        Thread.sleep(1000);
    }
}
