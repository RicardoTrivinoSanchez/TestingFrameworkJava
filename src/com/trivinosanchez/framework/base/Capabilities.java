package com.trivinosanchez.framework.base;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

    private DesiredCapabilities capabilities = new DesiredCapabilities();

    private Capabilities() {}

    private static Capabilities forAndroid() {
        Capabilities caps = new Capabilities();
        caps.capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        return caps;
    }

    private Capabilities withBrowser(String browser) {
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
        return this;
    }

    private Capabilities withApp(String appPackage, String appActivity) {
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        return this;
    }

    public static DesiredCapabilities forAndroidBrowser(String browser) {
        Capabilities caps = forAndroid();
        caps.withBrowser(browser);
        return caps.capabilities;
    }

    public static DesiredCapabilities forAndroidApp(String appName) {
        Capabilities caps = forAndroid();
        caps.withApp("org.wikipedia", ".main.MainActivity");
        return caps.capabilities;
    }
}
