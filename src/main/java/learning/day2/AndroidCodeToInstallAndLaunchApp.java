package learning.day2;

import wrappers.GenericWrappers;

import java.io.File;

public class AndroidCodeToInstallAndLaunchApp {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchAndroidApp("", "", "UiAutomator2", File.separator + "apks" + File.separator + "leaforg.apk");
        gw.sleep(5000);
        gw.closeApp();
    }
}