package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.NAME, using = "UserName")
    private WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    private WebElement txtPassword;

    @FindBy(how = How.CSS, using = "[class*= 'btn-default']")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login (String userName, String password) {

        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.submit();
    }

}
