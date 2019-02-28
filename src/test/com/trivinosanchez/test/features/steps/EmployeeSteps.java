package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.FrameworkInitialize;
import com.trivinosanchez.test.features.pages.EmployeeCreatePage;
import com.trivinosanchez.test.features.pages.EmployeeListPage;
import com.trivinosanchez.test.features.utils.StepsUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeSteps extends FrameworkInitialize {

    @When("^clicking on Create New Employee button$")
    public void clickingOnCreateNewEmployeeButton() {
        currentPage = getInstance(EmployeeListPage.class);
        currentPage.as(EmployeeListPage.class).clickOnCreateEmployee();
    }

    @When("^creating a user$")
    public void creatingAUser() {
        currentPage = getInstance(EmployeeCreatePage.class);
        StepsUtil.employee = currentPage.as(EmployeeCreatePage.class).getForm().fillIn();
        currentPage.as(EmployeeCreatePage.class).getForm().clickCreateButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^the user is visible in the Employee List$")
    public void theUserIsVisibleInTheEmployeeList() {
        currentPage = getInstance(EmployeeListPage.class);
        currentPage.as(EmployeeListPage.class).getTable().isEmployeeInTheTable(StepsUtil.employee);
    }
}
