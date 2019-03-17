package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.TestContext;
import com.trivinosanchez.framework.utilities.InitializerUtil;
import com.trivinosanchez.framework.utilities.PageUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CommonSteps {

    private TestContext context;

    public CommonSteps(TestContext context) {
        this.context = context;
    }

    @Given("^a user on (.*) browsing from (.*)$")
    public void aUserOnPlatformBrowsingFromBrowser(String platform, String browser) {
        if (TestContext.Platform.valueOf(platform) == TestContext.Platform.Desktop) {
            context.initDesktop(InitializerUtil.getDriverForDesktop(browser));
        } else if (TestContext.Platform.valueOf(platform) == TestContext.Platform.WebApp) {
            context.initWebApp(InitializerUtil.getDriverForWebApp(browser));
        }
    }

    @And("^the user is in the (.*) page$")
    public void aUserIsInThePage(String page) throws Exception {
        if (context.isWeb()) {
            String url = PageUtil.getPageUrl(page, context.isDesktop());
            if (context.isDesktop()) {
                context.getBrowser().maximize();
            }
            context.getBrowser().goToUrl(url);
        }
    }

    @Then("^the user is directed to (.*) page$")
    public void theUserIsDirectedToPage(String page) throws Exception {
        if (context.isWeb()) {
            String expectedUrl = PageUtil.getPageUrl(page, context.isDesktop());
            String actualUrl = context.getBrowser().getCurrentPageUrl();
            Assert.assertTrue("Browser should be in " + expectedUrl + ", but it's in " + actualUrl,
                    context.getBrowser().isInUrl(expectedUrl));
        }
    }
}
