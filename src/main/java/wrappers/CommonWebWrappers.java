package wrappers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Set;

@SuppressWarnings("ALL")
public class CommonWebWrappers extends CommonNativeWrappers {

    // To launch the mobile web browser
    public boolean launchBrowser(String platformName, String URL, String udid,
                                 String chromeDriverPort, String wdaLocalPort, String mjpegServerPort, String webkitDebugProxyPort, boolean useExistingApp) {
        try {
            DesiredCapabilities dc = new DesiredCapabilities();
            // Comment the below line based on need
            if (useExistingApp) {
                // Below script helps to not clear the cache and data of the app
                dc.setCapability("appium:noReset", true);
                // Below script helps to re-launch the app everytime the session starts
                dc.setCapability("appium:forceAppLaunch", true);
                // Below script helps to close the app when driver.quit() is called
                dc.setCapability("appium:shouldTerminateApp", true);
            }
            // Mandatory desired capabilities
            // To pass the Unique Device IDentifier for parallel testing
            if (!udid.isEmpty()) {
                dc.setCapability("appium:udid", udid);
            }
            // For parallel testing to record videos
            if (!mjpegServerPort.isEmpty()) {
                dc.setCapability("appium:mjpegServerPort", mjpegServerPort);
            }
            if (platformName.equalsIgnoreCase("android")) {
                // For web app parallel testing
                if (!chromeDriverPort.isEmpty()) {
                    dc.setCapability("appium:chromedriverPort", chromeDriverPort);
                }
                // Comment the below line based on need
                dc.setCapability("appium:autoGrantPermissions", true);
                // Mandatory desired capabilities
                dc.setCapability("appium:browserName", "Chrome");
                dc.setCapability("appium:automationName", "UiAutomator2");
                driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), dc);
            } else if (platformName.equalsIgnoreCase("ios")) {
                // For web app parallel testing
                if (!wdaLocalPort.isEmpty()) {
                    dc.setCapability("appium:wdaLocalPort", wdaLocalPort);
                }
                if (!webkitDebugProxyPort.isEmpty()) {
                    dc.setCapability("appium:webkitDebugProxyPort", webkitDebugProxyPort);
                }
                // Mandatory desired capabilities
                dc.setCapability("appium:browserName", "Safari");
                dc.setCapability("appium:automationName", "XCUITest");
                // Comment the below line based on need
                dc.setCapability("appium:webviewConnectTimeout", 40000);
                dc.setCapability("appium:autoAcceptAlerts", true);
                dc.setCapability("appium:startIWDP", true);
                dc.setCapability("appium:nativeWebTap", true);
                driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), dc);
            }
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    // To switch the context as WEB-VIEW (Note: Not recommended for Android)
    public void switchWebView() {
        try {
            Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
            for (String contextName : contextNames) {
                if (contextName.contains("WEBVIEW")) {
                    ((SupportsContextSwitching) driver).context(contextName);
                    break;
                }
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // To scroll down in browser
    public boolean scrollDownInBrowser(int pixelsToBeScrolled) {
        try {
            JavascriptExecutor jse = driver;
            jse.executeScript("window.scrollBy(0," + pixelsToBeScrolled + "\")", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // To navigate back in browser
    public boolean navigateBackInBrowser() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // To load the given URL
    public boolean loadURL(String url) {
        driver.navigate().to(url);
        return true;
    }

    // To switch to last window
    public boolean switchToLastWindow() {
        sleep(5000);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String string : windowHandles) {
            driver.switchTo().window(string);
        }
        return true;
    }

    // To switch to first window
    public boolean switchToFirstWindow() {
        sleep(5000);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String string : windowHandles) {
            driver.switchTo().window(string);
            break;
        }
        return true;
    }
}