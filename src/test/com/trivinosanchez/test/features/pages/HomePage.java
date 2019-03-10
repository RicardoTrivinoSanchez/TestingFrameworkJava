package com.trivinosanchez.test.features.pages;

import com.trivinosanchez.framework.base.BasePage;
import com.trivinosanchez.test.features.pages.common.TopBarMenu;
import lombok.Getter;

@Getter
public class HomePage extends BasePage {

    private TopBarMenu topBar;

    public HomePage() {
        super();
        this.topBar = new TopBarMenu();
    }
}
