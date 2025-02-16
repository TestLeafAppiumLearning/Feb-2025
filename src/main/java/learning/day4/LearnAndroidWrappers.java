package learning.day4;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.io.File;

public class LearnAndroidWrappers extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("", "", "UiAutomator2", File.separator + "apks" + File.separator + "leaforg.apk");
        showNotificationMenu();
        dataOffInAndroid();
        sleep(2000);
        dataOnInAndroid();
        sleep(5000);
        hideNotificationMenu();
        sleep(2000);
        closeApp();
    }
}
