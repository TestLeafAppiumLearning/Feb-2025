package learning.day2;

import io.appium.java_client.AppiumBy;
import wrappers.GenericWrappers;

public class AndroidFirstScript {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchAndroidApp("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "UiAutomator2", "");
        gw.enterValue(gw.driver.findElement(AppiumBy.className("android.widget.EditText")), "rajkumar@testleaf.com");
        gw.enterValue(gw.driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")), "Leaf@123");
        gw.click(gw.driver.findElement(AppiumBy.className("android.widget.Button")));
        gw.sleep(5000);
        gw.closeApp();
    }
}