package learning.day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.io.File;

public class LearnRemoveAndInstallApp extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("", "", "UiAutomator2", "");
        verifyAndInstallApp("com.testleaf.leaforg", File.separator + "apks" + File.separator + "leaforg.apk");
        closeApp();
    }

}
