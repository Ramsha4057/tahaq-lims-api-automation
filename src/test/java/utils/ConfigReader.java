package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {

        try {

            FileInputStream file = new FileInputStream(
                    "src/test/resources/configs/qa.properties");

            properties = new Properties();

            properties.load(file);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }


    public static String getClickUpProperty(String key) {

    Properties properties = new Properties();

    try {

        FileInputStream file =
                new FileInputStream(
                        "src/test/resources/configs/clickup.properties"
                );

        properties.load(file);

    } catch (Exception e) {

        e.printStackTrace();
    }

    return properties.getProperty(key);
}
}