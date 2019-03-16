package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.TestContext;
import com.trivinosanchez.test.features.pages.HomePage;
import cucumber.api.java.en.When;

public class SearchSteps {

    private TestContext context;

    public SearchSteps(TestContext context) {
        this.context = context;
    }

    @When("^searching for '(.*)'$")
    public void searchingFor(String stringToSearch) throws Throwable {
        context.getCurrentPageAs(HomePage.class).searchFor(stringToSearch);
        Thread.sleep(3000);
    }
}
