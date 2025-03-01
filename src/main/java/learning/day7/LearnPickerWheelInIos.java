package learning.day7;

import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class LearnPickerWheelInIos {
    public static void main(String[] args) {
        //Note: Application is already installed in device
        GenericWrappers gw = new GenericWrappers();
//        gw.launchIosApp("B0B6CCC1-4DCD-402F-B80C-AD0092C33346","","com.example.apple-samplecode.UICatalog","/apks/UiCatalog.zip");
        gw.launchIosApp("B0B6CCC1-4DCD-402F-B80C-AD0092C33346", "", "com.example.apple-samplecode.UICatalog", "");
        gw.click(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Picker View"));
        gw.chooseNextOptionInPickerWheel(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        gw.chooseNextOptionInPickerWheel(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Green color component value"));
        gw.chooseNextOptionInPickerWheel(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Blue color component value"));
//        gw.swipeWithinWebElement("up",gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        String text = gw.getText(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        int choose = 90;
        boolean greater = Integer.parseInt(text) > choose;
        System.out.println(greater);
        if (!greater) {
            while (Integer.parseInt(gw.getText(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Red color component value"))) != choose) {
                gw.chooseNextOptionInPickerWheel(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Red color component value");
            }
        } else {
            while (Integer.parseInt(gw.getText(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Red color component value"))) != choose) {
                gw.choosePreviousOptionInPickerWheel(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Red color component value");
            }
        }

        gw.enterValue(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Green color component value"), "200");
        gw.closeApp();
    }
}