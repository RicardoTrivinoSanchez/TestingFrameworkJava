package com.trivinosanchez.framework.utilities;

import com.trivinosanchez.framework.config.Settings;

import java.util.Properties;

public class PageUtil {

    private static final String PROPERTIES_URL = "src/com/trivinosanchez/framework/config/PageUrls.properties";
    private static final Properties PAGE_PATHS = PropertiesUtil.getProperties(PROPERTIES_URL);

    public static String getPageUrl(String page, boolean isDesktop) {

        String key = getKeyFor(page);

        if (!PAGE_PATHS.containsKey(key)) {
            try {
                throw new Exception(page + " page doesn't exist");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Settings.getBaseUrl(isDesktop) + PAGE_PATHS.getProperty(key);
    }

    private static String getKeyFor(String page) {
        page = page.toLowerCase()
                .replaceAll("(destop|webapp|android|ios)(\\w)(page)(object)", "page.$2");
        return "page." + page;
    }
}
