package com.trivinosanchez.framework.base;

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

    public static DesiredCapabilities forAndroidBrowser(String browser) {
        Capabilities caps = forAndroid();
        caps.withBrowser(browser);
        return caps.capabilities;
    }
}
