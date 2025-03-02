package testRunner;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import wrappers.GenericWrappers;

@CucumberOptions(features = "src/test/resources/features",
        glue = "pages", publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {

    public AppiumServiceBuilder builder;
    public AppiumDriverLocalService service;

    @BeforeSuite
    public void startAppiumServer() {
        builder = new AppiumServiceBuilder();
        builder.usingPort(4723);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload");
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Appium server started.");
    }

    @AfterSuite
    public void stopAppiumServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium server stopped.");
        }
    }

    @Parameters({"app", "appPackage", "appActivity", "udid", "systemPort"})
    @BeforeMethod
    public void bm(String app, String appPackage, String appActivity, @Optional("") String udid, @Optional("") String systemPort) {
        new GenericWrappers()
                .launchAndroidAppInParallel(udid, appPackage, appActivity,
                        "UiAutomator2", "", "",
                        systemPort, app);
    }

    @AfterMethod
    public void am() {
        new GenericWrappers().closeApp();
    }
}