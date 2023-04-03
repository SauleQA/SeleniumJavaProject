package org.sauleqa.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.util.Properties;

@Slf4j
public class PropertyLoader {
    public static String getProperty(String propertyName) {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/app.properties");
            properties.load(file);
        } catch (Exception e) {
            log.error("Error while loading properties {}", e.getMessage());
        }
        return properties.getProperty(propertyName);
    }
}
