package learning.day2;

import wrappers.GenericWrappers;

public class AndroidCodeToCreateSession {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchAndroidApp("", "", "UiAutomator2", "");
        gw.closeApp();
    }
}