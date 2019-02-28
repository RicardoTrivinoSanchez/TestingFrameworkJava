package com.trivinosanchez.test.features.seleniumTest;

import com.trivinosanchez.framework.base.Browser.BrowserType;
import com.trivinosanchez.framework.base.DriverContext;
import com.trivinosanchez.framework.base.FrameworkInitialize;
import com.trivinosanchez.test.features.pages.HomePage;
import com.trivinosanchez.test.features.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends FrameworkInitialize {

    @Before
    public void setUp() {

        initializeBrowser(BrowserType.Chrome);
        //driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
        DriverContext.getBrowser().goToUrl("http://eaapp.somee.com/");
        DriverContext.getBrowser().maximize();
    }

    @After
    public void endUp() {
        if (DriverContext.getDriver() != null) {
            DriverContext.getDriver().quit();
        }
    }

    @Test
    public void Login() throws InterruptedException {

        currentPage = getInstance(HomePage.class);
        currentPage = currentPage.as(HomePage.class).getTopbar().goToLoginPage();

        Thread.sleep(1000);

        currentPage.as(LoginPage.class).login("admin", "password");

        Thread.sleep(1000);
    }
}
