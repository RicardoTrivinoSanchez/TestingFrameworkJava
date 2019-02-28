package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.BasePage;
import lombok.Getter;

@Getter
public class EmployeeCreatePage extends BasePage {

    private TopBarMenu topBar;
    private EmployeeCreateForm form;

    public EmployeeCreatePage() {
        super();
        topBar = new TopBarMenu();
        form = new EmployeeCreateForm();
    }
}
