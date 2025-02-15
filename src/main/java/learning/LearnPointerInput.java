package learning;

import wrappers.GenericWrappers;

import java.io.File;

public class LearnPointerInput {

    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchApp("android", "UiAutomator2", System.getProperty("user.dir") + File.separator + "apks" + File.separator + "MultiTouch Test_1.4.2.apk", "", "");
        gw.sleep(5000);
        gw.swipeUp();
        gw.sleep(3000);
        gw.swipeDown();
        gw.sleep(3000);
        gw.swipeLeft();
        gw.sleep(3000);
        gw.swipeRight();
    }

}