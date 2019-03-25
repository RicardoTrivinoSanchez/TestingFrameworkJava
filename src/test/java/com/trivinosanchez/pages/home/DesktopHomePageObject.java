package com.trivinosanchez.pages.home;

import base.BaseWebPage;
import base.TestContext;
import com.trivinosanchez.pages.tabs.search.DesktopSearchPageObject;
import lombok.Getter;

@Getter
public class DesktopHomePageObject extends BaseWebPage implements HomePage {

    DesktopSearchPageObject searchBox;

    public DesktopHomePageObject(TestContext context) {
        super(context);
        searchBox = new DesktopSearchPageObject(context);
    }
}
