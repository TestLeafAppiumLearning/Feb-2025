package learning.day6;

import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class IosFirstScript {
    public static void main(String[] args) {
        //Note: Application is already installed in device
        GenericWrappers gw = new GenericWrappers();
        gw.launchIosApp("B0B6CCC1-4DCD-402F-B80C-AD0092C33346", "", "com.example.apple-samplecode.UICatalog", "/apks/UiCatalog.zip");
        gw.click(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Action Sheets"));
        gw.click(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Okay / Cancel"));
        gw.click(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "OK"));
        gw.click(gw.getWebElement(CommonNativeWrappers.Locators.XPATH.asString(), "//XCUIElementTypeButton[@name=\"UICatalog\"]"));
        gw.sleep(5000);
        gw.closeApp();
    }
}