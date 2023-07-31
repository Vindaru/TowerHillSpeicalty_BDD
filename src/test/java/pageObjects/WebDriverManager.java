package pageObjects;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
	public class BaseClass {
	    
		WebDriver driver;
	    
	   
		public void closeDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
	
	}
}
	    
	
