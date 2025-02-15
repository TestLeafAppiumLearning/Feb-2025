package learning;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import wrappers.GenericWrappers;

public class LearnSwipeWithinWebElement {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchApp("android", "UiAutomator2", "", "com.android.vending", "com.android.vending.AssetBrowserActivity");
        WebElement element = gw.driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"About this ad\"]/following-sibling::android.view.View)[1]"));
        gw.swipeLeftWithinWebElement(element);
        gw.sleep(2000);
        gw.swipeLeftWithinWebElement(element);
        gw.sleep(2000);
        gw.swipeRightWithinWebElement(element);
        gw.sleep(2000);
        gw.closeApp();
    }
}