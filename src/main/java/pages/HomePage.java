package pages;

import io.appium.java_client.AppiumDriver;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        eleIsDisplayed(getWebElement(Locators.XPATH.asString(), "//android.view.View[@text=\"Rajkumar Ganesan\"]"));
    }

    public HomePage verifyUsersNameIsDisplayed() {
        verifyText(getWebElement(Locators.XPATH.asString(), "//android.view.View[@text=\"Rajkumar Ganesan\"]"), "Rajkumar Ganesan");
        return this;
    }
}
