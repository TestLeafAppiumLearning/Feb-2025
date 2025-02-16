package learning.day3;

import wrappers.GenericWrappers;

import java.io.File;

public class LearnPointerInput {

    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchAndroidApp("", "", "UiAutomator2", File.separator + "apks" + File.separator + "MultiTouch Test_1.4.2.apk");
        gw.sleep(5000);
        gw.swipe("up");
        gw.sleep(3000);
        gw.swipe("down");
        gw.sleep(3000);
        gw.swipe("left");
        gw.sleep(3000);
        gw.swipe("right");
        gw.sleep(2000);
        gw.doubleTap(200, 300);
        gw.sleep(2000);
        gw.longPress(300, 500);
    }

}