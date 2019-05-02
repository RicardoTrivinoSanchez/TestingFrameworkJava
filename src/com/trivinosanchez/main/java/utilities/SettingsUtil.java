package utilities;

import java.util.Properties;

public class SettingsUtil {

    private static final String PROPERTIES_URL = "/Users/ricardo.trivino/Projects/TestingFrameworkJava/src/com/trivinosanchez/main/resources/GlobalConfig.properties";
//    private static final String PROPERTIES_URL = "/home/ricardo/Projects/TestingFrameworkJava/src/com/trivinosanchez/main/resources/GlobalConfig.properties";
    private static final String IOS_PROPERTIES_URL = "/Users/ricardo.trivino/Projects/TestingFrameworkJava/src/com/trivinosanchez/main/resources/iOSConfig.properties";
    private static final Properties CONFIG = PropertiesUtil.getProperties(PROPERTIES_URL);
    private static final Properties IOS_CONFIG = PropertiesUtil.getProperties(IOS_PROPERTIES_URL);

    public static String getBaseUrl(boolean isDesktop) {
        if (isDesktop) {
            return CONFIG.getProperty("desktop.base.url");
        }
        return CONFIG.getProperty("webapp.base.url");
    }

    public static String getXcodeOrgId() {
        return IOS_CONFIG.getProperty("xcode.org.id");
    }

    public static String getSimulatorUDID() {
        return IOS_CONFIG.getProperty("iphone.simulator.udid");
    }

    public static String getDeviceUDID() {
        return IOS_CONFIG.getProperty("iphone.device.udid");
    }
}
