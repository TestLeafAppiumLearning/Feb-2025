package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import wrappers.GenericWrappers;

@CucumberOptions(features = "src/test/resources/features",
        glue = "pages")

public class TestRunner extends AbstractTestNGCucumberTests {
    @Parameters({"app", "appPackage", "appActivity", "udid", "systemPort"})
    @BeforeMethod
    public void bm(String app, String appPackage, String appActivity, @Optional("") String udid, @Optional("") String systemPort) {
        new GenericWrappers()
                .launchAndroidAppInParallel(udid,appPackage,appActivity,
                        "UiAutomator2","","",
                        systemPort,app);
    }

    @AfterMethod
    public void am() {
        new GenericWrappers().closeApp();
    }
}