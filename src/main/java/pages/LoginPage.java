package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(id = "")
    WebElement userNameTxtBox;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    @iOSXCUITFindBy(id = "")
    WebElement passwordTxtBox;

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(id = "")
    WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
        eleIsDisplayed(userNameTxtBox);
    }

    @Given("Verify Login page is displayed")
    public void verifyLoginPage() {
        eleIsDisplayed(userNameTxtBox);
    }

    @Given("I enter the username as {string}")
    public LoginPage enterUsername(String username) {
        enterValue(userNameTxtBox, username);
        return this;
    }

    @Given("I enter the password as {string}")
    public LoginPage enterPassword(String password) {
        enterValue(passwordTxtBox, password);
        return this;
    }

    public LoginPage clearUsernameTxt() {
        clearValue(userNameTxtBox);
        return this;
    }

    public LoginPage clearPasswordTxt() {
        clearValue(passwordTxtBox);
        return this;
    }

    @Given("I click the login button")
    public void clickLoginButton() {
        click(loginBtn);
    }

}
