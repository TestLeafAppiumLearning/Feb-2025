package wrappers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class GenericWrappers {
    public static AppiumDriver driver;

    public void launchApp(String platformName, String automationName, String app, String appPackage, String appActivity) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", platformName);
        dc.setCapability("appium:automationName", automationName);
        if (!app.isEmpty()) {
            dc.setCapability("appium:app", app);
        }
        if (!appPackage.isEmpty()) {
            dc.setCapability("appium:appPackage", appPackage);
        }
        if (!appActivity.isEmpty()) {
            dc.setCapability("appium:appActivity", appActivity);
        }
        try {
            if (platformName.equalsIgnoreCase("android")) {
                driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
            } else if (platformName.equalsIgnoreCase("ios")) {
                driver = new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void sleep(int mSec) {
        try {
            Thread.sleep(mSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeApp() {
        if(driver!=null) {
            driver.quit();
        }
    }

    public void enterText(WebElement ele, String data) {
        ele.sendKeys(data);
    }

    public void click(WebElement ele) {
        ele.click();
    }
}
