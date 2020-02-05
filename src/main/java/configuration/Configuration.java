package configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String RESOURCES_PATH = "src\\main\\resources\\";
    private static Properties properties;

    private static void readProperties() {
        if (properties == null) {
            properties = new Properties();
        }
        try {
            properties.load(new FileReader(new File(RESOURCES_PATH, "mailbox.properties")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getMainUrl() {
        initializeProperties();
        return properties.getProperty("mainUrl");
    }

    public static String getLogin() {
        initializeProperties();
        return properties.getProperty("login");
    }

    public static String getPassword() {
        initializeProperties();
        return properties.getProperty("password");
    }

    private static void initializeProperties() {
        if (properties == null) {
            readProperties();
        }
    }
}