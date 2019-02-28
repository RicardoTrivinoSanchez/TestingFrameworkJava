package com.trivinosanchez.framework.base;

import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends Base {

    private String url;

    public BasePage () {
        PageFactory.initElements(DriverContext.getDriver(), this);
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
