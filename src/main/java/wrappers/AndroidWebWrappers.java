package wrappers;

@SuppressWarnings("ALL")
public class AndroidWebWrappers extends AndroidNativeWrappers {

    public boolean launchChromeBrowser(String URL) {
        return launchBrowser("Android", URL, "", "", "", "", "", true);
    }

    public boolean launchChromeBrowserInParallel(String URL, String udid, String chromeDriverPort,
                                                 String mjpegServerPort) {
        return launchBrowser("Android", URL, udid, chromeDriverPort, "", mjpegServerPort, "", true);
    }

    public boolean deleteChromeCookies() {
        driver.manage().deleteAllCookies();
        return true;
    }

}