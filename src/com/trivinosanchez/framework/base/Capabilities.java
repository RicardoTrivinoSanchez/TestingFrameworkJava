package com.trivinosanchez.framework.base;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

    private DesiredCapabilities capabilities = new DesiredCapabilities();

    private Capabilities() {}

    private static Capabilities forAndroid() {
        Capabilities caps = new Capabilities();
        caps.capabilities.setCapability("platform", "Android");
        caps.capabilities.setCapability("deviceName", "Android Device");
        return caps;
    }

    private Capabilities withBrowser(String browser) {
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        return this;
    }

    public static DesiredCapabilities forAndroidBrowser(String browser) {
        return forAndroid().withBrowser(browser).capabilities;
    }
}
