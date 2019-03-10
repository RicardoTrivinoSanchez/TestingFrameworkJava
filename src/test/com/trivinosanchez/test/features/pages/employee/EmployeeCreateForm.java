package com.trivinosanchez.test.features.pages.employee;

import com.trivinosanchez.framework.base.BasePage;
import com.trivinosanchez.test.features.model.Employee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeCreateForm extends BasePage {

    @FindBy(how = How.ID, using = "Name")
    private WebElement txtName;

    @FindBy(how = How.ID, using = "Salary")
    private WebElement txtSalary;

    @FindBy(how = How.ID, using = "DurationWorked")
    private WebElement txtDurationWorked;

    @FindBy(how = How.ID, using = "Grade")
    private WebElement txtGrade;

    @FindBy(how = How.ID, using = "Email")
    private WebElement txtEmail;

    @FindBy(how = How.CSS, using = "[class*= 'btn-default']")
    private WebElement btnCreate;

    public EmployeeCreateForm(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        txtName.sendKeys(name);
    }

    public void enterSalary(String salary) {
        txtSalary.sendKeys(salary);
    }

    public void enterDurationWorked(String days) {
        txtDurationWorked.sendKeys(days);
    }

    public void enterGrade(String grade) {
        txtGrade.sendKeys(grade);
    }

    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void clickCreateButton() {
        btnCreate.click();
    }

    public Employee fillIn() {
        Employee employee = Employee.autogenerate();
        fillIn(employee);
        return employee;
    }

    public void fillIn(Employee employee) {
        enterName(employee.getName());
        enterSalary(employee.getSalary());
        enterDurationWorked(employee.getDurationWorked());
        enterGrade(employee.getGrade());
        enterEmail(employee.getEmail());
    }
}
