package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/java/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error: Could not find config.properties at src/test/java/resources/config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}