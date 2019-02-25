package com.trivinosanchez.test.features.seleniumTest;

import com.trivinosanchez.framework.base.Browser.BrowserType;
import com.trivinosanchez.framework.base.FrameworkInitialize;
import com.trivinosanchez.test.features.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.trivinosanchez.framework.base.DriverContext.driver;

public class LoginTest extends FrameworkInitialize {

    @Before
    public void setUp() {

        initializeBrowser(BrowserType.Firefox);
        driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @After
    public void endUp() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void Login() {

        currentPage = getInstance(LoginPage.class);
        currentPage.as(LoginPage.class).login("admin", "admin");
    }
}
