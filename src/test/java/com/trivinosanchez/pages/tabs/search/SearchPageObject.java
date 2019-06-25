package com.trivinosanchez.pages.tabs.search;

import base.PageObject;

public interface SearchPageObject extends PageObject {

    void enterText(String text);
    void submitSearch();
    void searchFor(String textToSearch);
}
