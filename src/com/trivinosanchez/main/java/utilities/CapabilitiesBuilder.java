package utilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesBuilder {

    private DesiredCapabilities capabilities = new DesiredCapabilities();

    private CapabilitiesBuilder() {}

    private void setCapability(String capabilityName, String value) {
        capabilities.setCapability(capabilityName, value);
    }

    private void setCapability(String capabilityName, boolean value) {
        capabilities.setCapability(capabilityName, value);
    }

    //DEVICE

    private static CapabilitiesBuilder forAndroid() {
        CapabilitiesBuilder builder = new CapabilitiesBuilder();
        builder.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        builder.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        return builder;
    }

    private static CapabilitiesBuilder forIOS() {
        CapabilitiesBuilder builder = new CapabilitiesBuilder();
        builder.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        builder.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        builder.setCapability("showXcodeLog", true);
        builder.setCapability("clearSystemFiles", true);
        builder.setCapability("noReset", true);
        builder.setCapability("fullReset", false);
        return builder;
    }

    private static CapabilitiesBuilder forIOSSimulator() {
        CapabilitiesBuilder builder = forIOS();
        builder.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
        builder.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
        builder.setCapability(MobileCapabilityType.UDID, SettingsUtil.getSimulatorUDID());
        return builder;
    }

    private static CapabilitiesBuilder forIOSDevice() {
        CapabilitiesBuilder builder = forIOS();
        builder.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
        builder.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        builder.setCapability(MobileCapabilityType.UDID, SettingsUtil.getDeviceUDID());
        builder.setCapability("xcodeOrgId", SettingsUtil.getXcodeOrgId());
        builder.setCapability("xcodeSigningId", "iPhone Developer");
        builder.setCapability("startIWDP", true);
//        builder.setCapability("updatedWDABundleId", "http://www.apple.com/DTDs/PropertyList-1.0.dtd">);
//        builder.setCapability("useNewWDA", true);
//        builder.setCapability("waitForQuiescence", false);
        return builder;
    }

    //BROWSER

    private CapabilitiesBuilder withBrowser(String browser) {
        this.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
        return this;
    }

    public static DesiredCapabilities forAndroidBrowser(String browser) {
        return forAndroid().withBrowser(browser).capabilities;
    }

    public static DesiredCapabilities forIOSDeviceBrowser(String browser) {
        return forIOSDevice().withBrowser(browser).capabilities;
    }

    public static DesiredCapabilities forIOSSimulatorBrowser(String browser) {
        return forIOSSimulator().withBrowser(browser).capabilities;
    }

    //APP

    private CapabilitiesBuilder withAndroidApp(String appPackage, String appActivity) {
        this.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        this.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        return this;
    }

    private CapabilitiesBuilder withIOSApp(String bundleId) {
        this.setCapability(IOSMobileCapabilityType.BUNDLE_ID, bundleId);
        return this;
    }

    public static DesiredCapabilities forAndroidWikipediaApp() {
        return forAndroid().withAndroidApp("org.wikipedia", ".main.MainActivity").capabilities;
    }

    public static DesiredCapabilities forIOSWikipediaApp() {
        return forIOSDevice().withIOSApp("org.wikimedia.wikipedia").capabilities;
    }
}
