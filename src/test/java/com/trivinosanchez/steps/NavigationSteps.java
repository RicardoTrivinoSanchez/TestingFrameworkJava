package com.trivinosanchez.steps;

import base.TestContext;
import com.trivinosanchez.pages.cervantes.AndroidCervantesPageObject;
import com.trivinosanchez.pages.cervantes.iOSCervantesPageObject;
import com.trivinosanchez.pages.home.iOSHomePageObject;
import com.trivinosanchez.pages.landing.AndroidLandingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utilities.PageUtil;

public class NavigationSteps {

    private TestContext context;

    public NavigationSteps(TestContext context) {
        this.context = context;
    }

    @And("^the user is in the (.*) page$")
    public void aUserIsInThePage(String page) {
        if (context.isWeb()) {
            String url = PageUtil.getPageUrl(page, context.isDesktop());
            if (context.isDesktop()) {
                context.getBrowser().maximize();
            }
            context.getBrowser().goToUrl(url);
            Assert.assertTrue(context.getBrowser().isInUrl(url));
        }
    }

    @And("^the user is in the (.*) page on Android$")
    public void aUserIsInThePageOnAndroid(String page) {
        if (page.equals("Home")) {
            context.getPageObjectAs(AndroidLandingPage.class).pressSkip();
        }
    }

    @And("^the user is in the (.*) page on iOS$")
    public void aUserIsInThePageOnIOS(String page) {
        if (page.equals("Home")) {
            context.getPageObjectAs(iOSHomePageObject.class).isVisible();
        }
    }

    @Then("^the user has been directed to (.*) page$")
    public void theUserHasBeenDirectedToPage(String page) {
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
                    context.getPageObjectAs(AndroidCervantesPageObject.class).isPageVisible());
        }
    }

    @Then("^the user has been directed to (.*) page on iOS$")
    public void theUserHasBeenDirectedToPageOnIOS(String page) {
        if (page.equals("Cervantes")) {
            Assert.assertTrue("App should be in Cervantes page",
                    context.getPageObjectAs(iOSCervantesPageObject.class).isPageVisible());
        }
    }
}
