package learning.day7;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnHybridAppInIos extends GenericWrappers {

    @Test
    public void runCode() {
        launchIosApp("B0B6CCC1-4DCD-402F-B80C-AD0092C33346", "", "com.example.apple-samplecode.UICatalog", "");
        swipe("up");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Web View"));
        printContext();
        switchWebView();
//        click(getWebElement(Locators.ID.asString(), "globalnav-menutrigger-button"));
        click(getWebElement(Locators.LINK_TEXT.asString(), "Buy"));
        sleep(5000);
        closeApp();
    }

}
