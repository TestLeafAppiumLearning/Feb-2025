package learning;

import wrappers.GenericWrappers;

import java.io.File;

public class AndroidCodeToLaunchPreInstalledApp {
    public static void main(String[] args) {
        //Note: Application is already installed in device
        GenericWrappers gw = new GenericWrappers();
        gw.launchApp("android","UiAutomator2","","com.testleaf.leaforg","com.testleaf.leaforg.MainActivity");
        gw.sleep(5000);
        gw.closeApp();
    }
}