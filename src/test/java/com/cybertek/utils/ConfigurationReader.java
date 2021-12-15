package com.cybertek.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this util class is usEd to read values from configuration.properties file
 */

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {
        try {
            // open the file inputstream
            FileInputStream inputStream = new FileInputStream("configuration.properties");
            // load to properties object
            properties.load(inputStream);

            //close the file after loading. Free up memory
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while reading configuration file");
        }
    }

    /**\
     * Methot is used to read from a configuration.properties file
     * @param Key -> key name is properties file
     * @return -> value fo the key. return null if key not found
     * Ex: driver.get(ConfigurationReader.getProperty("url"));
     */
    public static String getProperty (String key){
    return properties.getProperty(key);
    }
}
