package com.trivinosanchez.framework.base;

public abstract class BasePage {

    private String url;

    public <TPage extends BasePage> TPage as (Class<TPage> pageInstance) {
        try {
            return (TPage) this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
