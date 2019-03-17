package com.trivinosanchez.test.features.pages.tabs.search;

import com.trivinosanchez.framework.base.BasePageObject;

public interface SearchPageObject extends BasePageObject {

    void enterText(String text);
    void submitSearch();
    void searchFor(String textToSearch);
}
