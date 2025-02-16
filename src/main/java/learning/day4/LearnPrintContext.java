package learning.day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.io.File;

public class LearnPrintContext extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "UiAutomator2", File.separator + "apks" + File.separator + "leaforg.apk");
        printContext();
        closeApp();
    }

}
