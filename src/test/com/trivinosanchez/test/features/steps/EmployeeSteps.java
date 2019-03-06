package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.FrameworkInitialize;
import com.trivinosanchez.test.features.pages.employee.EmployeeCreatePage;
import com.trivinosanchez.test.features.pages.employee.EmployeeListPage;
import com.trivinosanchez.test.features.utils.StepsUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeSteps extends FrameworkInitialize {

    @When("^clicking on Create New Employee button$")
    public void clickingOnCreateNewEmployeeButton() {
        getCurrentPageAs(EmployeeListPage.class).clickOnCreateEmployee();
    }

    @When("^creating a user$")
    public void creatingAUser() {
        StepsUtil.employee = getCurrentPageAs(EmployeeCreatePage.class).getForm().fillIn();
        getCurrentPageAs(EmployeeCreatePage.class).getForm().clickCreateButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^the user is visible in the Employee List$")
    public void theUserIsVisibleInTheEmployeeList() {
        getCurrentPageAs(EmployeeListPage.class).getTable().isEmployeeInTheTable(StepsUtil.employee);
    }
}
