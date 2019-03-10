package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.BasePage;
import com.trivinosanchez.test.features.pages.common.TopBarMenu;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomePage extends BasePage {

    private TopBarMenu topBar;

    public HomePage(WebDriver driver) {
        super(driver);
        this.topBar = PageFactory.initElements(driver, TopBarMenu.class);
    }
}
