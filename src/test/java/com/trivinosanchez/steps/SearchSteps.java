package com.trivinosanchez.steps;

import base.TestContext;
import com.trivinosanchez.pages.tabs.search.AndroidSearchPageObject;
import com.trivinosanchez.pages.tabs.search.DesktopSearchPageObject;
import com.trivinosanchez.pages.tabs.search.SearchPageObject;
import com.trivinosanchez.pages.tabs.search.WebAppSearchPageObject;
import cucumber.api.java.en.When;

public class SearchSteps {

    private TestContext context;
    private SearchPageObject searchPageObject;

    public SearchSteps(TestContext context) {
        this.context = context;
        switch(context.getPlatform()) {
            case Desktop:
                searchPageObject = context.getPageObjectAs(DesktopSearchPageObject.class);
                break;
            case WebApp:
                searchPageObject = context.getPageObjectAs(WebAppSearchPageObject.class);
                break;
            case Android:
                searchPageObject = context.getPageObjectAs(AndroidSearchPageObject.class);
                break;
        }
    }

    @When("^searching for '(.*)'$")
    public void searchingFor(String stringToSearch) {
        searchPageObject.searchFor(stringToSearch);
    }
}
