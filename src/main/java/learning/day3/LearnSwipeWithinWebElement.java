package learning.day3;

import org.openqa.selenium.WebElement;
import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class LearnSwipeWithinWebElement {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchAndroidApp("com.android.vending", "com.android.vending.AssetBrowserActivity", "UiAutomator2", "");
        WebElement element = gw.getWebElement(CommonNativeWrappers.Locators.XPATH.asString(), "(//android.view.View[@content-desc=\"About this ad\"]/following-sibling::android.view.View)[1]");
        gw.swipeWithinWebElement("left", element);
        gw.sleep(2000);
        gw.swipeWithinWebElement("left", element);
        gw.sleep(2000);
        gw.swipeWithinWebElement("right", element);
        gw.sleep(2000);
        gw.closeApp();
    }
}