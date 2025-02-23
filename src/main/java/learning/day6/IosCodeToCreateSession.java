package learning.day6;

import wrappers.GenericWrappers;

public class IosCodeToCreateSession {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchIosApp("B0B6CCC1-4DCD-402F-B80C-AD0092C33346", "", "", "");
        gw.closeApp();
    }
}