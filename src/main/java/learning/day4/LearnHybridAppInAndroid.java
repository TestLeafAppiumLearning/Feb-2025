package learning.day4;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.io.File;

public class LearnHybridAppInAndroid extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "UiAutomator2", File.separator + "apks" + File.separator + "leaforg.apk");
        printContext();
        switchContext("WEBVIEW_com.testleaf.leaforg");
        enterValue(getWebElement(Locators.TAG_NAME.asString(), "input"), "rajkumar@testleaf.com");
        enterValue(driver.findElement(AppiumBy.xpath("(//input)[2]")), "Leaf@123");
        click(getWebElement(Locators.XPATH.asString(), "//button[@type='submit']"));
        sleep(5000);
        closeApp();
    }

}
