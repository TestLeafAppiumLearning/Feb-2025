package learning.day2;

import wrappers.GenericWrappers;

public class AndroidCodeToLaunchPreInstalledApp {
    public static void main(String[] args) {
        //Note: Application is already installed in device
        GenericWrappers gw = new GenericWrappers();
        gw.launchAndroidApp("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "UiAutomator2", "");
        gw.sleep(5000);
        gw.closeApp();
    }
}