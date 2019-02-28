package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TopBarMenu extends BasePage {

    @FindBy(how = How.LINK_TEXT, using = "Login")
    private WebElement lnkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    private WebElement lnkEmployeeList;

    @FindBy(how = How.XPATH, using = "//a[@title = \"Manage\"]")
    private WebElement lnkAccount;

    public TopBarMenu() {
        super();
    }

    public BasePage goToLoginPage () {
        lnkLogin.click();
        return getInstance(LoginPage.class);
    }

    public BasePage goToEmployeeListPage () {
        lnkEmployeeList.click();
        return getInstance(EmployeeListPage.class);
    }

    public String getGreetings() {
        return lnkAccount.getText();
    }
}
