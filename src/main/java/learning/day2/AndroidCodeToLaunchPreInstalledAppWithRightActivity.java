package learning.day2;

import wrappers.GenericWrappers;

import java.io.File;

public class AndroidCodeToLaunchPreInstalledAppWithRightActivity {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchAndroidApp("com.amazon.mShop.android.shopping", "com.amazon.mShop.home.HomeActivity", "UiAutomator2", File.separator + "apks" + File.separator + "Amazon.apk");
        gw.sleep(5000);
        gw.closeApp();
    }
}