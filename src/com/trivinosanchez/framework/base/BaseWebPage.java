package com.trivinosanchez.framework.base;

import com.trivinosanchez.framework.utilities.PageUtil;

public abstract class BaseWebPage extends BasePageObject {

    private final String url;
    protected final Browser browser;

    protected BaseWebPage(TestContext context) {
        super(context);
        this.browser = context.getBrowser();
        url = PageUtil.getPageUrl(this.getClass().getSimpleName(), context.isDesktop());
    }

    public boolean isOpen() {
        return browser.isInUrl(url);
    }
}
