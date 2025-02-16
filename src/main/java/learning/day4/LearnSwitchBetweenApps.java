package learning.day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.io.File;

public class LearnSwitchBetweenApps extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "UiAutomator2", File.separator + "apks" + File.separator + "leaforg.apk");
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), "rajkumar@testleaf.com");
        enterValue(getWebElement(Locators.XPATH.asString(), "(//android.widget.EditText)[2]"), "Leaf@123");
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        verifyAndInstallApp("com.easylabs.multitouch", File.separator + "apks" + File.separator + "MultiTouch Test_1.4.2.apk");
        activateOrRelaunchApp("com.easylabs.multitouch");
        sleep(5000);
        swipe("up");
//        terminateOrStopRunningApp("com.testleaf.leaforg");
        activateOrRelaunchApp("com.testleaf.leaforg");
        sleep(3000);
        closeApp();
    }
}
