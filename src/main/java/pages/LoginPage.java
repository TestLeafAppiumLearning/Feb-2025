package pages;

import io.appium.java_client.AppiumDriver;
import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        eleIsDisplayed(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"));
    }

    public LoginPage enterUsername(String username) {
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enterValue(getWebElement(Locators.XPATH.asString(), "(//android.widget.EditText)[2]"), password);
        return this;
    }

    public LoginPage clearUsernameTxt() {
        clearValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"));
        return this;
    }

    public LoginPage clearPasswordTxt() {
        clearValue(getWebElement(Locators.XPATH.asString(), "(//android.widget.EditText)[2]"));
        return this;
    }

    public HomePage clickLoginButton() {
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        return new HomePage(driver);
    }

    public LoginPage clickLoginButtonForFailures() {
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        return this;
    }
}
