package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HookSteps {

    private TestContext context;

    public HookSteps(TestContext context) {
        this.context = context;
    }

    @Before("@Web")
    public void setUpWeb() {
        System.out.println("Web tests");
    }

    @Before("@Mobile")
    public void setUpMobile() {
        System.out.println("Mobile tests");
    }

    @After
    public void endUp() {
        if (context.getDriver() != null) {
            context.getDriver().quit();
        }
    }
}