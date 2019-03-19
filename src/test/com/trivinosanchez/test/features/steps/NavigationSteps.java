package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.TestContext;
import com.trivinosanchez.framework.utilities.PageUtil;
import com.trivinosanchez.test.features.pages.AndroidCervantesPageObject;
import com.trivinosanchez.test.features.pages.AndroidLandingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class NavigationSteps {

    private TestContext context;

    public NavigationSteps(TestContext context) {
        this.context = context;
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

    @And("^the user is in the (.*) page on Android$")
    public void aUserIsInThePageOnAndroid(String page) {
        if (page.equals("Home")) {
            context.getCurrentPageObjectAs(AndroidLandingPage.class).pressSkip();
        }
    }

    @Then("^the user has been directed to (.*) page$")
    public void theUserHasBeenDirectedToPage(String page) throws Exception {
        if (context.isWeb()) {
            String expectedUrl = PageUtil.getPageUrl(page, context.isDesktop());
            String actualUrl = context.getBrowser().getCurrentPageUrl();
            Assert.assertTrue("Browser should be in " + expectedUrl + ", but it's in " + actualUrl,
                    context.getBrowser().isInUrl(expectedUrl));
        }
    }

    @Then("^the user has been directed to (.*) page on Android$")
    public void theUserHasBeenDirectedToPageOnAndroid(String page) {
        if (page.equals("Cervantes")) {
            Assert.assertTrue("App should be in Cervantes page",
                    context.getCurrentPageObjectAs(AndroidCervantesPageObject.class).isPageVisible());
        }
    }

}
