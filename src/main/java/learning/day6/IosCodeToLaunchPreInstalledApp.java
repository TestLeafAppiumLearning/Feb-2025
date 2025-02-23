package learning.day6;

import wrappers.GenericWrappers;

public class IosCodeToLaunchPreInstalledApp {
    public static void main(String[] args) {
        //Note: Application is already installed in device
        GenericWrappers gw = new GenericWrappers();
//        gw.launchIosApp("B0B6CCC1-4DCD-402F-B80C-AD0092C33346","","com.example.apple-samplecode.UICatalog","/apks/UiCatalog.zip");
        gw.launchIosApp("B0B6CCC1-4DCD-402F-B80C-AD0092C33346", "", "com.example.apple-samplecode.UICatalog", "");
        gw.sleep(5000);
        gw.closeApp();
    }
}