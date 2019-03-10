package com.trivinosanchez.test.features.utils;

import com.trivinosanchez.framework.utilities.InitializerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementTableUtil extends InitializerUtil {

    private WebElement table;

    public WebElementTableUtil(WebElement table) {
        this.table = table;
    }

    public List<WebElement> getRows() {
        return table.findElements(By.cssSelector("[tbody > tr]"));
    }

    public int getNumberOfRows() {
        return getRows().size();
    }

    public WebElement getRow(int rowNumber) {
        return getRows().get(rowNumber);
    }

    public List<WebElement> getCellsFromRow(int rowNumber) {
        return getRow(rowNumber).findElements(By.cssSelector("[td]"));
    }

    public int getNumberOfColumns() {
        return getCellsFromRow(1).size();
    }

    public WebElement getCell(int rowNumber, int colNumber) {
        return getCellsFromRow(rowNumber).get(colNumber);
    }

}
