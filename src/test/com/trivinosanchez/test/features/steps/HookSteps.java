package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.Browser;
import com.trivinosanchez.framework.base.DriverContext;
import com.trivinosanchez.framework.base.FrameworkInitialize;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HookSteps extends FrameworkInitialize {

    @Before
    public void setUp() {
        initializeBrowser(Browser.BrowserType.Chrome);
    }

    @Before("@Web")
    public void setUpWeb() {
        System.out.println();
        System.out.println("Web tests");
        System.out.println();
    }

    @Before("@Mobile")
    public void setUpMobile() {
        System.out.println();
        System.out.println("Mobile tests");
        System.out.println();
    }

    @After
    public void endUp() {
        if (DriverContext.getDriver() != null) {
            DriverContext.getDriver().quit();
        }
    }
}
