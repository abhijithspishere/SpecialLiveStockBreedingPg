package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static String environment = "qa";

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try {
            String configPath = "src/test/resources/config.properties";
            FileInputStream input = new FileInputStream(configPath);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String envKey = environment + "." + key;
        String value = properties.getProperty(envKey);

        // Fallback to default property
        if (value == null) {
            value = properties.getProperty(key);
        }

        return value != null ? value.trim() : null;
    }

    // Add these methods to your existing ConfigReader class

    public static String getUsername(String role) {
        // role can be "flio", "ahelp", "doctor", "admin"
        return getProperty(role + ".username");
    }

    public static String getPassword(String role) {
        return getProperty(role + ".password");
    }

    // Optional: get login URL
    public static String getLoginUrl() {
        return getProperty("login.url");
    }

    public static void setEnvironment(String env) {
        environment = env;
    }

    public static String getEnvironment() {
        return environment;
    }

    // Helper methods for common properties
    public static String getAppUrl() {
        return getProperty("app.url");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(getProperty("implicit.wait"));
    }

    public static int getPageLoadTimeout() {
        return Integer.parseInt(getProperty("page.load.timeout"));
    }
}