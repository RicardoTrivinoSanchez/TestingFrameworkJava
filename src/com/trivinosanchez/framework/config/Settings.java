package com.trivinosanchez.framework.config;

import com.trivinosanchez.framework.utilities.PropertiesUtil;

import java.util.Properties;

public class Settings {

    private static final String PROPERTIES_URL = "src/com/trivinosanchez/framework/config/GlobalConfig.properties";
    private static final Properties CONFIG = PropertiesUtil.getProperties(PROPERTIES_URL);

    public static String getBaseUrl() {
        return CONFIG.getProperty("base.url");
    }
}
