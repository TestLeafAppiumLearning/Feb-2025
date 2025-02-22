package pages;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {

    public HomePage(){
        eleIsDisplayed(getWebElement(Locators.XPATH.asString(), "//android.view.View[@text=\"Rajkumar Ganesan\"]"));
    }

    public HomePage verifyUsersNameIsDisplayed() {
        verifyText(getWebElement(Locators.XPATH.asString(), "//android.view.View[@text=\"Rajkumar Ganesan\"]"),"Rajkumar Ganesan");
        return new HomePage();
    }
}
