package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.FrameworkInitialize;
import com.trivinosanchez.test.features.utils.StepsUtil;
import com.trivinosanchez.test.features.pages.LoginPage;
import cucumber.api.java.en.When;

public class LoginSteps extends FrameworkInitialize {

    public static LoginSteps execute() {
        return new LoginSteps();
    }

    @When("^logging as \"(.*)\" with password \"(.*)\"$")
    public void loggingAs(String username, String password) throws Throwable {
        StepsUtil.username = username;
        getCurrentPageAs(LoginPage.class).login(username, password);
        Thread.sleep(1000);
    }
}
