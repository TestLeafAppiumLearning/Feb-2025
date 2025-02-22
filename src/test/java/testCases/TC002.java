package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.GenericWrappers;
import wrappers.ProjectSpecificWrappers;

public class TC002 extends ProjectSpecificWrappers {
    @Test
    public void runCode() {
        new LoginPage(driver)
                .clearUsernameTxt()
                .enterUsername("lokesh")
                .clearPasswordTxt()
                .enterPassword("Leaf@123")
                .clickLoginButtonForFailures();
    }
}
