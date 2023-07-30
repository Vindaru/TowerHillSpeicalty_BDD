package com.bdd.variables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.LinkedHashMap;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utilities.ObjectMap;

import  java.util.LinkedList;
import java.util.Properties;

import utilities.ObjectMap;


/**
 * This Class contains all the global variables set for the framework
 * 
 * 
 */
public class GlobalVariables {

	public static final String FIREFOX_DRIVER_PATH="src/test/resources/drivers/geckodriver.exe";
	public static final String CHROME_DRIVER_PATH="src/test/resources/drivers/chromedriver.exe";
	public static final String IE_DRIVER_PATH="src/test/resources/drivers/IEDriverServer.exe";
	
	public static RemoteWebDriver driver = null;
	public static final DesiredCapabilities capability = null;
	public static String featureName,currentScenarioName,ScenarioName,logFolderName,logFolder,logFileName;
    public static boolean skipStatusFlag=false;
    
    //api 
   
    public static String uri,finalURI;
    
    //db
    public static Connection getdbConnection=null;
    public static Connection con;
    public static LinkedHashMap<String,LinkedList<String>> resultvalues;
    
    
    public static ObjectMap objMap = null;

    public static void initializeObjectMap() {
        if (objMap == null) {
            // Pass the correct path of locators.properties here when creating an instance of ObjectMap
            objMap = new ObjectMap("C:\\Users\\vdaru\\THS-git-repo\\TowerHillSpeicalty_BDD\\THS_locators.properties");
        }
    }
    
}
