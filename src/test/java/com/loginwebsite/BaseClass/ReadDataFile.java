package com.loginwebsite.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFile {
    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("./data.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

