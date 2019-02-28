package com.trivinosanchez.framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    public static Properties getProperties(String filepath) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filepath));
        } catch (IOException e) {
            e.getStackTrace();
        }
        return properties;
    }
}
