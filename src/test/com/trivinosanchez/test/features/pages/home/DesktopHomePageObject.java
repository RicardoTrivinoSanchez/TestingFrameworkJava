package com.trivinosanchez.test.features.pages.home;

import com.trivinosanchez.framework.base.BaseWebPage;
import com.trivinosanchez.framework.base.PageObjectNew;
import com.trivinosanchez.framework.base.TestContext;
import com.trivinosanchez.test.features.pages.tabs.search.DesktopSearchPageObject;
import lombok.Getter;

@Getter
public class DesktopHomePageObject extends BaseWebPage implements HomePage, PageObjectNew {

    DesktopSearchPageObject searchBox;

    public DesktopHomePageObject(TestContext context) {
        super(context);
        searchBox = new DesktopSearchPageObject(context);
    }
}
