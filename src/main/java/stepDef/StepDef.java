package stepDef;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class StepDef {
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public void launchApp(String app, String appPackage, String appActivity, String udid, String systemPort) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("appium:automationName", "UiAutomator2");
        dc.setCapability("appium:app", System.getProperty("user.dir") + app);
        dc.setCapability("appium:appPackage", appPackage);
        dc.setCapability("appium:appActivity", appActivity);
        if (!udid.isEmpty())
            dc.setCapability("appium:udid", udid);
        if (!systemPort.isEmpty())
            dc.setCapability("appium:systemPort", systemPort);
        try {
            driver.set(new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), dc));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Given("I enter the username as {string}")
    public void enterUn(String un) {
        driver.get().findElement(AppiumBy.className("android.widget.EditText")).sendKeys(un);
    }

    @Given("I enter the password as {string}")
    public void enterPwd(String pass) {
        driver.get().findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")).sendKeys(pass);
    }

    @Given("I click the login button")
    public void clickLogin() {
        driver.get().findElement(AppiumBy.className("android.widget.Button")).click();
    }

    @Given("Verify Home page is displayed")
    public void verifyHomePage() {
        assert driver.get().findElement(AppiumBy.xpath("//android.view.View[@text=\"Rajkumar Ganesan\"]")).isDisplayed() != false;
    }

    @Given("Verify Login page is displayed")
    public void verifyLoginPage() {
        assert driver.get().findElement(AppiumBy.className("android.widget.EditText")).isDisplayed() != false;
    }
}
