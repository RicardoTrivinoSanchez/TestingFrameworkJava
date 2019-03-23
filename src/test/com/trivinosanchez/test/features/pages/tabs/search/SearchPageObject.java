package com.trivinosanchez.test.features.pages.tabs.search;

import com.trivinosanchez.framework.base.PageObject;

public interface SearchPageObject extends PageObject {

    void enterText(String text);
    void submitSearch();
    void searchFor(String textToSearch);
}
