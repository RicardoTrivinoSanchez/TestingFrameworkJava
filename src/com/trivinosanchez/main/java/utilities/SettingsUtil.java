package utilities;

import java.util.Properties;

public class SettingsUtil {

    private static final String PROPERTIES_URL = "/home/ricardo/Projects/TestingFrameworkJava/src/com/trivinosanchez/main/resources/GlobalConfig.properties";
    private static final Properties CONFIG = PropertiesUtil.getProperties(PROPERTIES_URL);

    public static String getBaseUrl(boolean isDesktop) {
        if (isDesktop) {
            return CONFIG.getProperty("desktop.base.url");
        }
        return CONFIG.getProperty("webapp.base.url");
    }
}
