package testCases;

import pages.LoginPage;
import wrappers.GenericWrappers;

public class TC001 {
    public static void main(String[] args) {
        new GenericWrappers().launchAndroidApp("com.testleaf.leaforg","com.testleaf.leaforg.MainActivity","UiAutomator2","/apks/Leaforg.apk");
        new LoginPage()
                .clearUsernameTxt()
                .enterUsername("rajkumar@testleaf.com")
                .clearPasswordTxt()
                .enterPassword("Leaf@123")
                .clickLoginButton()
                .verifyUsersNameIsDisplayed()
                .verifyUsersNameIsDisplayed();
    }
}
