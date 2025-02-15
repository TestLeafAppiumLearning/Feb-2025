package wrappers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class GenericWrappers {
    public static AppiumDriver driver;

    public void launchApp(String platformName, String automationName, String app, String appPackage, String appActivity) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", platformName);
        dc.setCapability("appium:automationName", automationName);
        if (!app.isEmpty()) {
            dc.setCapability("appium:app", app);
        }
        if (!appPackage.isEmpty()) {
            dc.setCapability("appium:appPackage", appPackage);
        }
        if (!appActivity.isEmpty()) {
            dc.setCapability("appium:appActivity", appActivity);
        }
        //TODO: Below cap will not bring the app from BG to FG, it will not close/quit the app after execution
        dc.setCapability("appium:noReset", true);
        try {
            if (platformName.equalsIgnoreCase("android")) {
                driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
            } else if (platformName.equalsIgnoreCase("ios")) {
                driver = new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void sleep(int mSec) {
        try {
            Thread.sleep(mSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeApp() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void enterText(WebElement ele, String data) {
        ele.sendKeys(data);
    }

    public void click(WebElement ele) {
        ele.click();
    }

    private void swipe(int startX, int startY, int endX, int endY) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(input, 1);
        sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(input.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    public void swipeUp() {
        int maxWidth = driver.manage().window().getSize().getWidth();
        int maxHeight = driver.manage().window().getSize().getHeight();
        int startX = (int) (maxWidth * 0.5);
        int startY = (int) (maxHeight * 0.8);
        int endX = (int) (maxWidth * 0.5);
        int endY = (int) (maxHeight * 0.2);
        swipe(startX, startY, endX, endY);
    }

    public void swipeDown() {
        int maxWidth = driver.manage().window().getSize().getWidth();
        int maxHeight = driver.manage().window().getSize().getHeight();
        int startX = (int) (maxWidth * 0.5);
        int startY = (int) (maxHeight * 0.2);
        int endX = (int) (maxWidth * 0.5);
        int endY = (int) (maxHeight * 0.8);
        swipe(startX, startY, endX, endY);
    }

    public void swipeLeft() {
        int maxWidth = driver.manage().window().getSize().getWidth();
        int maxHeight = driver.manage().window().getSize().getHeight();
        int startX = (int) (maxWidth * 0.9);
        int startY = (int) (maxHeight * 0.5);
        int endX = (int) (maxWidth * 0.1);
        int endY = (int) (maxHeight * 0.5);
        swipe(startX, startY, endX, endY);
    }

    public void swipeRight() {
        int maxWidth = driver.manage().window().getSize().getWidth();
        int maxHeight = driver.manage().window().getSize().getHeight();
        int startX = (int) (maxWidth * 0.1);
        int startY = (int) (maxHeight * 0.5);
        int endX = (int) (maxWidth * 0.9);
        int endY = (int) (maxHeight * 0.5);
        swipe(startX, startY, endX, endY);
    }

    public void swipeUpWithinWebElement(WebElement ele) {
        int eleStartX = ele.getRect().getX();
        int eleStartY = ele.getRect().getY();
        int eleWidth = ele.getRect().getWidth();
        int eleHeight = ele.getRect().getHeight();
        int startX = (int) (eleStartX + (eleWidth * 0.5));
        int startY = (int) (eleStartY + (eleHeight * 0.9));
        int endX = (int) (eleStartX + (eleWidth * 0.5));
        int endY = (int) (eleStartY + (eleHeight * 0.1));
        swipe(startX, startY, endX, endY);
    }

    public void swipeDownWithinWebElement(WebElement ele) {
        int eleStartX = ele.getRect().getX();
        int eleStartY = ele.getRect().getY();
        int eleWidth = ele.getRect().getWidth();
        int eleHeight = ele.getRect().getHeight();
        int startX = (int) (eleStartX + (eleWidth * 0.5));
        int startY = (int) (eleStartY + (eleHeight * 0.1));
        int endX = (int) (eleStartX + (eleWidth * 0.5));
        int endY = (int) (eleStartY + (eleHeight * 0.9));
        swipe(startX, startY, endX, endY);
    }

    public void swipeLeftWithinWebElement(WebElement ele) {
        int eleStartX = ele.getRect().getX();
        int eleStartY = ele.getRect().getY();
        int eleWidth = ele.getRect().getWidth();
        int eleHeight = ele.getRect().getHeight();
        int startX = (int) (eleStartX + (eleWidth * 0.9));
        int startY = (int) (eleStartY + (eleHeight * 0.5));
        int endX = (int) (eleStartX + (eleWidth * 0.1));
        int endY = (int) (eleStartY + (eleHeight * 0.5));
        swipe(startX, startY, endX, endY);
    }

    public void swipeRightWithinWebElement(WebElement ele) {
        int eleStartX = ele.getRect().getX();
        int eleStartY = ele.getRect().getY();
        int eleWidth = ele.getRect().getWidth();
        int eleHeight = ele.getRect().getHeight();
        int startX = (int) (eleStartX + (eleWidth * 0.1));
        int startY = (int) (eleStartY + (eleHeight * 0.5));
        int endX = (int) (eleStartX + (eleWidth * 0.9));
        int endY = (int) (eleStartY + (eleHeight * 0.5));
        swipe(startX, startY, endX, endY);
    }

    public void pinch() {
        int maxWidth = driver.manage().window().getSize().getWidth();
        int maxHeight = driver.manage().window().getSize().getHeight();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(input, 1);
        sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxWidth * 0.25), (int) (maxHeight * 0.75)));
        sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(input.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), (int) (maxWidth * 0.5), (int) (maxHeight * 0.5)));
        sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        PointerInput input1 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        Sequence sequence1 = new Sequence(input1, 1);
        sequence1.addAction(input1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxWidth * 0.75), (int) (maxHeight * 0.25)));
        sequence1.addAction(input1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence1.addAction(input1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), (int) (maxWidth * 0.5), (int) (maxHeight * 0.5)));
        sequence1.addAction(input1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence,sequence1));
    }

    public void zoom() {
        int maxWidth = driver.manage().window().getSize().getWidth();
        int maxHeight = driver.manage().window().getSize().getHeight();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(input, 1);
        sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxWidth * 0.5), (int) (maxHeight * 0.5)));
        sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(input.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), (int) (maxWidth * 0.25), (int) (maxHeight * 0.75)));
        sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        PointerInput input1 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        Sequence sequence1 = new Sequence(input1, 1);
        sequence1.addAction(input1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxWidth * 0.5), (int) (maxHeight * 0.5)));
        sequence1.addAction(input1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence1.addAction(input1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), (int) (maxWidth * 0.75), (int) (maxHeight * 0.25)));
        sequence1.addAction(input1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence,sequence1));
    }

}
