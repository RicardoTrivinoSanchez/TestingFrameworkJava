package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeListPage extends BasePage {

    @FindBy(how = How.CSS, using = "[class*= 'btn-primary']")
    public WebElement btnCreate;

    public EmployeeListPage() {
        super();
    }
}
