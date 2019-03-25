package utilities;

import java.util.Properties;

public class PageUtil {

    private static final String PROPERTIES_URL = "/home/ricardo/Projects/TestingFrameworkJava/src/com/trivinosanchez/main/resources/PageUrls.properties";
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
        return SettingsUtil.getBaseUrl(isDesktop) + PAGE_PATHS.getProperty(key);
    }

    private static String getKeyFor(String page) {
        page = page.toLowerCase()
                .replaceAll("(destop|webapp|android|ios)(\\w)(page)(object)", "page.$2");
        return "page." + page;
    }
}
