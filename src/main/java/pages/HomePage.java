package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Rajkumar Ganesan\"]")
    @iOSXCUITFindBy(id = "")
    WebElement usersNameInHomePage;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()),this);
        eleIsDisplayed(usersNameInHomePage);
    }

    @Given("Verify Home page is displayed")
    public HomePage verifyUsersNameIsDisplayed() {
        verifyText(usersNameInHomePage, "Rajkumar Ganesan");
        return this;
    }
}
