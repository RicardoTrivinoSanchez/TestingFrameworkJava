package com.trivinosanchez.test.features.pages.employee;

import com.trivinosanchez.framework.base.BasePage;
import com.trivinosanchez.test.features.model.Employee;
import com.trivinosanchez.test.features.utils.EmployeeTableUtil;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeTable extends BasePage {

    @FindBy(how = How.CSS, using = "[class= 'table']")
    @Getter
    private WebElement employeeTable;

    private EmployeeTableUtil table;

    public EmployeeTable() {
        super();
        table = new EmployeeTableUtil(employeeTable);
    }

    public boolean isEmployeeInTheRow(Employee employee, int rowNumber) {
        return employee.compare(table.getEmployeeFromRow(rowNumber));
    }

    public boolean isEmployeeInTheTable(Employee employee) {
        for (int row=1; row < table.getRows().size(); row++) {
            if (isEmployeeInTheRow(employee, row)) {
                return true;
            }
        }
        return false;
    }
}
