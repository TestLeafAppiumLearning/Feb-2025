package learning.day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.io.File;

public class LearnSwitchBetweenAppsWithActivity extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "UiAutomator2", File.separator + "apks" + File.separator + "leaforg.apk");
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), "rajkumar@testleaf.com");
        enterValue(getWebElement(Locators.XPATH.asString(), "(//android.widget.EditText)[2]"), "Leaf@123");
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        verifyAndInstallApp("com.amazon.mShop.android.shopping", File.separator + "apks" + File.separator + "Amazon.apk");
//        activateOrRelaunchApp("com.amazon.mShop.android.shopping");
        startAnAppUsingActivity("com.amazon.mShop.android.shopping", "com.amazon.mShop.home.HomeActivity");
        sleep(5000);
//        terminateOrStopRunningApp("com.testleaf.leaforg");
        activateOrRelaunchApp("com.testleaf.leaforg");
        sleep(3000);
        closeApp();
    }
}
