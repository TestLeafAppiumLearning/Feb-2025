package learning;

import wrappers.GenericWrappers;

import java.io.File;

public class AndroidCodeToLaunchPreInstalledAppWithRightActivity {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchApp("android","UiAutomator2",System.getProperty("user.dir")+ File.separator+"apks"+File.separator+"Amazon.apk","com.amazon.mShop.android.shopping","com.amazon.mShop.home.HomeActivity");
        gw.sleep(5000);
        gw.closeApp();
    }
}