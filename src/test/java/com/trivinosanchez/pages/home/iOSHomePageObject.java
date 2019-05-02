package com.trivinosanchez.pages.home;


import base.BasePageObject;
import base.TestContext;
import com.trivinosanchez.pages.tabs.search.SearchPageObject;
import com.trivinosanchez.pages.tabs.search.iOSSearchPageObject;
import lombok.Getter;

@Getter
public class iOSHomePageObject extends BasePageObject implements HomePage {

    SearchPageObject searchBox;

    public iOSHomePageObject(TestContext context) {
        super(context);
        searchBox = context.getPageObjectAs(iOSSearchPageObject.class);
    }

    public boolean isVisible() {
        return searchBox.isVisible();
    }
}
