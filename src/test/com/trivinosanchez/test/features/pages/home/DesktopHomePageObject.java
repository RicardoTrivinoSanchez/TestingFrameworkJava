package com.trivinosanchez.test.features.pages.home;

import com.trivinosanchez.framework.base.PageObject;
import com.trivinosanchez.test.features.pages.tabs.search.DesktopSearchPageObject;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class DesktopHomePageObject extends PageObject implements HomePage {

    DesktopSearchPageObject searchBox;

    public DesktopHomePageObject(WebDriver driver) {
        super(driver);
        searchBox = new DesktopSearchPageObject(driver);
    }

}
