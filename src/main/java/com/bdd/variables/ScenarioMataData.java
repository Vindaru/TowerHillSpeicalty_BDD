package com.bdd.variables;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class ScenarioMataData implements Serializable{
	
	private String gbGroupID;
	private String gbUserID;
	private WebDriver driver;
	
	
	
	public String getGbGroupID () {
		return gbGroupID;
	}
	
	public String getGbUserID () {
		return gbUserID;
	}
	
	public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
	
	public WebDriver getDriver () {
		return driver;
	}
	private Map <String,String> dynamicDataMap = new HashMap<String, String>();



	public static ScenarioMataData get(int hashCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
