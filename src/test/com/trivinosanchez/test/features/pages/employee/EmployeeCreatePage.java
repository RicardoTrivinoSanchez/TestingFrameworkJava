package com.trivinosanchez.test.features.pages.employee;

import com.trivinosanchez.framework.base.BasePage;
import com.trivinosanchez.test.features.pages.common.TopBarMenu;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public class EmployeeCreatePage extends BasePage {

    private TopBarMenu topBar;
    private EmployeeCreateForm form;

    public EmployeeCreatePage(WebDriver driver) {
        super(driver);
        this.topBar = PageFactory.initElements(driver, TopBarMenu.class);
        this.form = PageFactory.initElements(driver, EmployeeCreateForm.class);
    }
}
