package learning.day7;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnWebAppInIos extends GenericWrappers {
    @Test
    public void runCode() {
        launchSafariBrowser("https://www.google.com", "B0B6CCC1-4DCD-402F-B80C-AD0092C33346");
        click(getWebElement(Locators.NAME.asString(), "q"));
        enterValue(getWebElement(Locators.NAME.asString(), "q"), "Appium", false);
//        switchNativeView();
//        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Search"));
//        switchWebView();
        clickGivenKeyboardButtonInIosByAccessibilityId("Search");
        sleep(5000);
        System.out.println(getText(getWebElement(Locators.TAG_NAME.asString(), "a")));
        closeApp();
    }
}
