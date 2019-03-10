package com.trivinosanchez.test.features.pages.employee;

import com.trivinosanchez.framework.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeListPage extends BasePage {

    @Getter
    private EmployeeTable table;

    @FindBy(how = How.CSS, using = "[class*= 'btn-primary']")
    private WebElement btnCreate;

    public EmployeeListPage(WebDriver driver) {
        super(driver);
        table = new EmployeeTable(driver);
    }

    public void clickOnCreateEmployee() {
        btnCreate.click();
    }
}
