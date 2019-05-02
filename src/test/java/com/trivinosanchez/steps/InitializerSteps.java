package com.trivinosanchez.steps;

import base.TestContext;
import cucumber.api.java.en.Given;
import utilities.InitializerUtil;

import java.net.MalformedURLException;

public class InitializerSteps {

    private TestContext context;

    public InitializerSteps(TestContext context) {
        this.context = context;
    }

    @Given("^a user on Desktop browsing from (.*)$")
    public void aUserOnDesktopBrowsingFromBrowser(String browser) {
        context.initDesktop(InitializerUtil.getDriverForDesktop(browser));
    }

    @Given("^a user on WebApp browsing from (.*)$")
    public void aUserOnWebAppBrowsingFromBrowser(String browser) throws MalformedURLException {
        context.initWebApp(InitializerUtil.getDriverForWebApp(browser));
    }

    @Given("^a user with the (.*) app on Android$")
    public void aUserWithTheAppOnAndroid(String appName) throws MalformedURLException {
        context.initAndroid(InitializerUtil.getDriverForAndroid(appName));
    }

    @Given("^a user with the (.*) app on iOS$")
    public void aUserWithTheWikipediaAppOnIOS(String appName) throws MalformedURLException {
        context.initIOS(InitializerUtil.getDriverForIOS(appName));
    }
}
