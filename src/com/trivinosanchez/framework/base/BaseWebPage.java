package com.trivinosanchez.framework.base;

import com.trivinosanchez.framework.utilities.PageUtil;

public class BaseWebPage extends BasePageObject {

    protected final String url;

    public BaseWebPage(TestContext context) {
        super(context);
        url = PageUtil.getPageUrl(this.getClass().getSimpleName(), context.isDesktop());
    }

    public boolean isOpen() {
        return context.getBrowser().isInUrl(url);
    }
}
