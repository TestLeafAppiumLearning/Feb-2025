package learning;

import wrappers.GenericWrappers;

public class AndroidCodeToCreateSession {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchApp("android","UiAutomator2","","","");
        gw.closeApp();
    }
}