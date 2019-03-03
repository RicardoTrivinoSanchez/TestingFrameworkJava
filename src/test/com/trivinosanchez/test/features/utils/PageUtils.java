package com.trivinosanchez.test.features.utils;

import com.trivinosanchez.framework.config.Settings;
import com.trivinosanchez.framework.utilities.PropertiesUtil;

import java.util.Properties;

public class PageUtils {

    private static final String PROPERTIES_URL = "src/com/trivinosanchez/framework/config/PageUrls.properties";
    private static final Properties PAGE_PATHS = PropertiesUtil.getProperties(PROPERTIES_URL);

    public static String getPageUrl(String page) throws Exception {

        String key = getKeyFor(page);

        if (!PAGE_PATHS.containsKey(key)) {
            throw new Exception(page + " page doesn't exist");
        }
        return Settings.getBaseUrl() + PAGE_PATHS.getProperty(key);
    }

    private static String getKeyFor(String page) {
        page = page.replace(" ", ".");
        return "page." + page.toLowerCase();
    }
}
