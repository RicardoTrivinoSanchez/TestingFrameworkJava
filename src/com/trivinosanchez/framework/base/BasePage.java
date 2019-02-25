package com.trivinosanchez.framework.base;

import org.openqa.selenium.support.PageFactory;

import static com.trivinosanchez.framework.base.DriverContext.driver;

public abstract class BasePage extends Base {

    public BasePage () {
        PageFactory.initElements(driver, this);
    }

    public <TPage extends BasePage> TPage as (Class<TPage> pageInstance) {
        try {
            return (TPage) this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
