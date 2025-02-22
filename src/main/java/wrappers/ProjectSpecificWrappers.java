package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificWrappers extends GenericWrappers{
    @Parameters({"udid","appPackage","appActivity","systemPort","app"})
    @BeforeMethod
    public void bm(String udid, String appPackage, String appActivity, String systemPort, String app) {
        launchAndroidAppInParallel(udid,appPackage,appActivity,"UiAutomator2","","",systemPort,app);
//        launchAndroidApp("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "UiAutomator2", "/apks/Leaforg.apk");
    }
    @AfterMethod
    public void am() {
        closeApp();
    }
}
