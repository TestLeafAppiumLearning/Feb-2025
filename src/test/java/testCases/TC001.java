package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.GenericWrappers;
import wrappers.ProjectSpecificWrappers;

public class TC001 extends ProjectSpecificWrappers {

    @Test
    public void runCode() {
        new LoginPage(driver)
                .clearUsernameTxt()
                .enterUsername("rajkumar@testleaf.com")
                .clearPasswordTxt()
                .enterPassword("Leaf@123")
                .clickLoginButton()
                .verifyUsersNameIsDisplayed()
                .verifyUsersNameIsDisplayed();
    }

}
