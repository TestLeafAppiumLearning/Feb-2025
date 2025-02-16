package learning.day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnWebAppInAndroid extends GenericWrappers {
    @Test
    public void runCode() {
        launchChromeBrowser("https://www.google.com");
        enterValue(getWebElement(Locators.NAME.asString(), "q"), "Appium");
        pressEnter();
        System.out.println(getText(getWebElement(Locators.TAG_NAME.asString(), "a")));
        closeApp();
    }
}
