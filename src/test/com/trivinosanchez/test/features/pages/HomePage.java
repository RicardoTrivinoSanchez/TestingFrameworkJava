package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.BasePage;
import lombok.Getter;

@Getter
public class HomePage extends BasePage {

    private TopBarMenu topbar;

    public HomePage() {
        super();
        topbar = new TopBarMenu();
    }
}
