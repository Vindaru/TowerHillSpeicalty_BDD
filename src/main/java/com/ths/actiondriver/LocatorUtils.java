/**
 * 
 */
package com.ths.actiondriver;

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;


public class LocatorUtils  {
	
	public static final String LOCATOR_FILE_PATH = "/THS-BDD/THS_locators.properties";
    private static Properties properties;

    static {
    	 properties = new Properties();
         try (FileInputStream fileInputStream = new FileInputStream(LOCATOR_FILE_PATH)) {
             properties.load(fileInputStream);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    public static String getLocator(String key) {
        return properties.getProperty(key);
    }

}
