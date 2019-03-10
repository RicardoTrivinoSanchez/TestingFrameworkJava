package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.TestContext;
import com.trivinosanchez.framework.utilities.PageUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static com.trivinosanchez.framework.utilities.InitializerUtil.getDriverForDesktop;

public class CommonSteps {

    private TestContext context;

    public CommonSteps(TestContext context) {
        this.context = context;
    }

    @Given("^a user browsing from (.*)$")
    public void aUserNavigatingFromBrowser(String browser) {
        context.init(getDriverForDesktop(browser));
    }

    @Given("^(a|the) user in the (.*) page$")
    public void aUserInThePage(String page) throws Exception {
        String url = PageUtil.getPageUrl(page);
        context.getBrowser().goToUrl(url);
        context.getBrowser().maximize();
    }

    @Given("^a user in the (.*) page browsing from (.*)$")
    public void aUserInThePageBrowsingFromBrowser(String page, String browser) throws Exception {
        aUserNavigatingFromBrowser(browser);
        aUserInThePage(page);
    }

    @Given("^(a|the) logged user in the (.*) page$")
    public void aLoggedUserInThePage(String page) throws Throwable {
        aUserInThePage("Login");
        LoginSteps.execute(context).loggingAs("admin", "password");
        aUserInThePage(page);
    }

    @Given("^a logged user in the (.*) page browsing from (.*)$")
    public void aLoggedUserInThePage(String page, String browser) throws Throwable {
        aUserNavigatingFromBrowser(browser);
        aLoggedUserInThePage(page);
    }

    @Then("^the user is directed to (.*) page$")
    public void theUserIsDirectedToPage(String page) throws Exception {
        String expectedUrl = PageUtil.getPageUrl(page);
        String actualUrl = context.getBrowser().getCurrentPageUrl();
        Assert.assertTrue("Browser should be in " + expectedUrl + ", but it's in " + actualUrl,
                context.getBrowser().isInUrl(expectedUrl));
    }
}
