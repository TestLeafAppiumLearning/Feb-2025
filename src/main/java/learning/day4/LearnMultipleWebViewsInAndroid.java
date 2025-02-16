package learning.day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.io.File;

public class LearnMultipleWebViewsInAndroid extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("", "", "UiAutomator2", File.separator + "apks" + File.separator + "TheApp-v1.10.0.apk");
        click(getWebElement(Locators.XPATH.asString(), "//android.widget.TextView[@text=\"Dual Webview Demo\"]"));
        printContext();
        switchContext("WEBVIEW_io.cloudgrey.the_app");
        switchToLastWindow();
        System.out.println(getText(getWebElement(Locators.TAG_NAME.asString(), "h2")));
        switchToFirstWindow();
        System.out.println(getText(getWebElement(Locators.TAG_NAME.asString(), "h2")));
        closeApp();
    }
}
