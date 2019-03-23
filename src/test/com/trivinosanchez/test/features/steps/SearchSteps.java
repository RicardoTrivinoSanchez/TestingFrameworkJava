package com.trivinosanchez.test.features.steps;

import com.trivinosanchez.framework.base.TestContext;
import com.trivinosanchez.test.features.pages.tabs.search.AndroidSearchPageObject;
import com.trivinosanchez.test.features.pages.tabs.search.DesktopSearchPageObject;
import com.trivinosanchez.test.features.pages.tabs.search.SearchPageObject;
import com.trivinosanchez.test.features.pages.tabs.search.WebAppSearchPageObject;
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
