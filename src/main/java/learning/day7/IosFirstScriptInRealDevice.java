package learning.day7;

import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class IosFirstScriptInRealDevice {
    public static void main(String[] args) {
        //Note: Update the data so it work on real devices
        GenericWrappers gw = new GenericWrappers();
        gw.launchIosApp("<real device UDID>", "<Team ID of developer>", "", "<Real device application path>");
        gw.click(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Action Sheets"));
        gw.click(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Okay / Cancel"));
        gw.click(gw.getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "OK"));
        gw.click(gw.getWebElement(CommonNativeWrappers.Locators.XPATH.asString(), "//XCUIElementTypeButton[@name=\"UICatalog\"]"));
        gw.sleep(5000);
        gw.closeApp();
    }
}