package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.TestContext;
import com.trivinosanchez.test.features.pages.employee.EmployeeCreatePage;
import com.trivinosanchez.test.features.pages.employee.EmployeeListPage;
import com.trivinosanchez.test.features.utils.StepsUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeSteps {

    private TestContext context;

    public EmployeeSteps(TestContext context) {
        this.context = context;
    }

    @When("^clicking on Create New Employee button$")
    public void clickingOnCreateNewEmployeeButton() {
        context.getCurrentPageAs(EmployeeListPage.class).clickOnCreateEmployee();
    }

    @When("^creating a user$")
    public void creatingAUser() {
        StepsUtil.employee = context.getCurrentPageAs(EmployeeCreatePage.class).getForm().fillIn();
        context.getCurrentPageAs(EmployeeCreatePage.class).getForm().clickCreateButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^the user is visible in the Employee List$")
    public void theUserIsVisibleInTheEmployeeList() {
        context.getCurrentPageAs(EmployeeListPage.class).getTable().isEmployeeInTheTable(StepsUtil.employee);
    }
}
