package com.trivinosanchez.test.features.utils;

import com.trivinosanchez.test.features.model.Employee;
import org.openqa.selenium.WebElement;

public class EmployeeTableUtil extends WebElementTableUtil {

    public EmployeeTableUtil(WebElement table) {
        super(table);
    }

    public Employee getEmployeeFromRow(int rowNumber) {
        return new Employee(
                getNameFromRow(rowNumber),
                getSalaryFromRow(rowNumber),
                getDurationWorkedeFromRow(rowNumber),
                getGradeFromRow(rowNumber),
                getEmailFromRow(rowNumber)
        );
    }

    public String getNameFromRow(int rowNumber) {
        return getCell(rowNumber, 1).getText();
    }

    public String getSalaryFromRow(int rowNumber) {
        return getCell(rowNumber, 2).getText();
    }

    public String getDurationWorkedeFromRow(int rowNumber) {
        return getCell(rowNumber, 3).getText();
    }

    public String getGradeFromRow(int rowNumber) {
        return getCell(rowNumber, 4).getText();
    }

    public String getEmailFromRow(int rowNumber) {
        return getCell(rowNumber, 5).getText();
    }
}
