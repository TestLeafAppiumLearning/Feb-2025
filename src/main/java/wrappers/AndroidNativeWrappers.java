package wrappers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

import java.util.HashMap;

@SuppressWarnings("ALL")
public class AndroidNativeWrappers extends CommonWebWrappers {

    public boolean launchAndroidApp(String appPackage, String appActivity, String automationName,
                                    String app) {
        return launchApp("Android", "", appPackage, appActivity, automationName, "", "", "", "", "", app,
                "", "", true);
    }

    public boolean launchAndroidAppInParallel(String udid, String appPackage, String appActivity,
                                              String automationName, String chromeDriverPort, String mjpegServerPort, String systemPort, String app) {
        return launchApp("Android", udid, appPackage, appActivity, automationName, chromeDriverPort,
                systemPort, "", "", "", app, mjpegServerPort, "", true);
    }

    public boolean startAnAppUsingActivity(String appPackage, String appActivity) {
        try {
//            ((StartsActivity) getDriver()).startActivity(new Activity(appPackage, appActivity));
            HashMap<String, Object> params = new HashMap<>();
            params.put("intent", appPackage + "/" + appActivity);
            getDriver().executeScript("mobile: startActivity", params);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean pressEnter() {
        ((PressesKey) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
        return true;
    }

    public boolean pressBack() {
        ((PressesKey) getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
        return true;
    }

    public void showNotificationMenu() {
        ((AndroidDriver) getDriver()).openNotifications();
    }

    public void hideNotificationMenu() {
        pressBack();
    }

    public boolean dataOffInAndroid() {
        ((HasNetworkConnection) getDriver()).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
        sleep(2000);
        ((HasNetworkConnection) getDriver()).setConnection(new ConnectionStateBuilder().withDataDisabled().build());
        sleep(2000);
        return true;
    }

    public boolean dataOnInAndroid() {
        ((HasNetworkConnection) getDriver()).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
        sleep(2000);
        ((HasNetworkConnection) getDriver()).setConnection(new ConnectionStateBuilder().withDataEnabled().build());
        sleep(2000);
        return true;
    }

    public String getCurrentActivity() {
        return ((StartsActivity) getDriver()).currentActivity();
    }

    public String getCurrentAppPackage() {
        return ((StartsActivity) getDriver()).getCurrentPackage();
    }

}