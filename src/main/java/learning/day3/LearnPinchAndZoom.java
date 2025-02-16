package learning.day3;

import wrappers.GenericWrappers;

import java.io.File;

public class LearnPinchAndZoom {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchAndroidApp("", "", "UiAutomator2", File.separator + "apks" + File.separator + "MultiTouch Test_1.4.2.apk");
        gw.sleep(3000);
        gw.pinchInApp();
        gw.sleep(3000);
        gw.zoomInApp();
        gw.sleep(3000);
        gw.closeApp();
    }
}