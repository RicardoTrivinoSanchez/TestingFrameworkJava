package com.trivinosanchez.framework.base;

import org.openqa.selenium.support.PageFactory;

public class Base {

    protected static BasePage currentPage;

    protected <TPage extends BasePage> TPage getInstance (Class<TPage> page) {

        Object obj = PageFactory.initElements(DriverContext.getDriver(), page);
        return page.cast(obj);
    }
}