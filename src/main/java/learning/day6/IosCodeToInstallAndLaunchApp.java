package learning.day6;

import wrappers.GenericWrappers;

public class IosCodeToInstallAndLaunchApp {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchIosApp("B0B6CCC1-4DCD-402F-B80C-AD0092C33346", "", "", "/apks/UiCatalog.zip");
        gw.sleep(5000);
        gw.closeApp();
    }
}