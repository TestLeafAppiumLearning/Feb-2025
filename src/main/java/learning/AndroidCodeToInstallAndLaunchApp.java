package learning;

import wrappers.GenericWrappers;

import java.io.File;

public class AndroidCodeToInstallAndLaunchApp {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchApp("android","UiAutomator2",System.getProperty("user.dir")+ File.separator+"apks"+File.separator+"leaforg.apk","","");
        gw.sleep(5000);
        gw.closeApp();
    }
}