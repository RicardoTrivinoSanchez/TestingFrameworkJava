package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.Browser.BrowserType;
import com.trivinosanchez.framework.base.DriverContext;
import com.trivinosanchez.framework.base.FrameworkInitialize;
import com.trivinosanchez.test.features.pages.HomePage;
import com.trivinosanchez.test.features.pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps extends FrameworkInitialize {

    private String username;

    @Before
    public void setUp() {
        initializeBrowser(BrowserType.Chrome);
    }

    @After
    public void endUp() {
        if (DriverContext.getDriver() != null) {
            DriverContext.getDriver().quit();
        }
    }

    @Given("^a user in the (.*) page$")
    public void aUserInTheHomePage(String page) throws Exception {
        String url = "http://eaapp.somee.com";
        switch(page.toUpperCase()) {
            case "HOME":
                break;
            case "LOGIN":
                url = url + "/Account/Login";
                break;
            default:
                throw new Exception(page + " page doesn't exist");
        }
        DriverContext.getBrowser().goToUrl(url);
        DriverContext.getBrowser().maximize();
    }

    @When("^logging as \"(.*)\" with password \"(.*)\"$")
    public void loggingAsWithPassword(String username, String password) throws Throwable {
        this.username = username;
        currentPage = getInstance(LoginPage.class);
        currentPage.as(LoginPage.class).login(username, password);
        Thread.sleep(1000);
    }

    @Then("^the user is directed to the Home Page$")
    public void theUserIsDirectedToTheHomePage() {
        String url = "http://eaapp.somee.com/";
        Assert.assertTrue("Browser should be in " + url, DriverContext.getBrowser().isInUrl(url));
    }

    @And("^there is a greeting for the user at the top bar$")
    public void thereIsAGreetingForTheUserAtTheTopBar() {
        currentPage = getInstance(HomePage.class);
        String greetings = currentPage.as(HomePage.class).getGreetings();
        Assert.assertTrue("Greetings should contain the username", greetings.contains(this.username));
    }
}
