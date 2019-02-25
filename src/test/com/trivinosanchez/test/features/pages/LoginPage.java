package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;

    @FindBy(how = How.NAME, using = "Login")
    public WebElement btnLogin;

    public LoginPage() {
        super();
    }

    public void login (String userName, String password) {

        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.submit();
    }

}
