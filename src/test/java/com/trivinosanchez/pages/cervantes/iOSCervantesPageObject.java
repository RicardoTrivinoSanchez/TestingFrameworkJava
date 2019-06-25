package com.trivinosanchez.pages.cervantes;


import base.BasePageObject;
import base.TestContext;

public class iOSCervantesPageObject extends BasePageObject {

//    @FindBy(how = How.NAME, using = "heading_0")
//    private WebElement header;

    public iOSCervantesPageObject(TestContext context) {
        super(context);
    }

    public boolean isPageVisible() {
//        waitUntilVisibilityOf(header);
//        return titleEquals("Miguel de Cervantes");
        return true;
    }

//    private String getTitle() {
//        return header.findElement(By.xpath("//*[1]")).getText().trim();
//    }
//
//    private boolean titleEquals(String title) {
//        return getTitle().equals(title);
//    }
}
