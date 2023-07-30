package pageObjects;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import com.ths.actiondriver.Action;
import com.ths.actiondriver.LocatorUtils;

public class BasePage {
	public WebDriver driver;
	public LoginPage<?> lp;
	public HomePage hp;
	public Action action;
	public BasicinformationPage bp;
	public LocatorUtils loc;
	public class BaseClass {
	    WebDriver driver;
	    
	    
	    @After 
	    public void quit() {
	    	driver.quit();
	    }
	}
}
	    
	
