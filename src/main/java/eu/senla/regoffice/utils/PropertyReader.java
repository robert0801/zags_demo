package eu.senla.regoffice.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final Properties prop = new Properties();

    static {
        try (InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream("application.properties")) {
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String baseUrl() {
        return prop.getProperty("base.url");
    }

    public static String getLogin() {
        return prop.getProperty("login");
    }

    public static String getPassword() {
        return prop.getProperty("password");
    }
}
