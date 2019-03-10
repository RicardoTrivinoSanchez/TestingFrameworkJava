package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.TestContext;
import com.trivinosanchez.test.features.utils.PageUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static com.trivinosanchez.framework.utilities.InitializerUtil.getDriverForDesktop;

public class CommonSteps {

    private TestContext context;

    public CommonSteps(TestContext context) {
        this.context = context;
    }

    @Given("^a user navigating with (.*)$")
    public void aUserNavigatingWithBrowser(String browser) {
        System.out.println("Browser: " + browser);
        context.init(getDriverForDesktop(browser));
    }

    @Given("^a user in the (.*) page$")
    public void aUserInThePage(String page) throws Exception {
        String url = PageUtils.getPageUrl(page);
        context.getBrowser().goToUrl(url);
        context.getBrowser().maximize();
    }

    @Given("^a logged user in the (.*) page$")
    public void aLoggedUserInThePage(String page) throws Throwable {
        aUserInThePage("Login");
        LoginSteps.execute(context).loggingAs("admin", "password");
        aUserInThePage(page);
    }

    @Then("^the user is directed to (.*) page$")
    public void theUserIsDirectedToPage(String page) throws Exception {
        String url = PageUtils.getPageUrl(page);
        Assert.assertTrue("Browser should be in " + url, context.getBrowser().isInUrl(url));
    }
}
