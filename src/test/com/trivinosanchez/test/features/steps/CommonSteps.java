package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.Browser;
import com.trivinosanchez.framework.base.DriverContext;
import com.trivinosanchez.framework.base.FrameworkInitialize;
import com.trivinosanchez.test.features.utils.PageUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CommonSteps extends FrameworkInitialize {

    @Before
    public void setUp() {
        initializeBrowser(Browser.BrowserType.Chrome);
    }

    @After
    public void endUp() {
        if (DriverContext.getDriver() != null) {
            DriverContext.getDriver().quit();
        }
    }

    @Given("^a user in the (.*) page$")
    public void aUserInThePage(String page) throws Exception {
        String url = PageUtils.getPageUrl(page);
        DriverContext.getBrowser().goToUrl(url);
        DriverContext.getBrowser().maximize();
    }

    @Given("^a logged user in the (.*) page$")
    public void aLoggedUserInThePage(String page) throws Throwable {
        aUserInThePage("Login");
        LoginSteps.execute().loggingAs("admin", "password");
        aUserInThePage(page);
    }

    @Then("^the user is directed to (.*) page$")
    public void theUserIsDirectedToPage(String page) throws Exception {
        String url = PageUtils.getPageUrl(page);
        Assert.assertTrue("Browser should be in " + url, DriverContext.getBrowser().isInUrl(url));
    }
}
