package pageObjects;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	// create webdriver object for given browser
	public WebDriver createBrowserInstance(String browser) throws MalformedURLException {

		RemoteWebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome")) {

		    WebDriverManager.chromedriver().setup();
		    System.setProperty("webdriver.chrome.silentOutput", "true");

		    ChromeOptions options = new ChromeOptions();
		    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		    
		    // Uncomment the following lines if you want to set specific Chrome options
		    // Map<String, Object> prefs = new HashMap<String, Object>();
		    // prefs.put("profile.default_content_setting_values.notifications", 2);
		    // prefs.put("credentials_enable_service", false);
		    // prefs.put("profile.password_manager_enabled", false);
		    // options.setExperimentalOption("prefs", prefs);
		    // options.addArguments("disable-infobars");
		    // options.addArguments("--disable-extensions");
		    // options.addArguments("--disable-notifications");
		    // options.addArguments("--remote-allow-origins=*");
		    // options.addArguments("--incognito");

		    driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {

		    WebDriverManager.firefoxdriver().setup();

		    FirefoxOptions options = new FirefoxOptions();
		    options.addPreference("dom.webnotifications.enabled", false);
		    options.addPreference("signon.rememberSignons", false);
		    
		    // Uncomment the following lines if you want to set specific Firefox options
		    // options.addArguments("--disable-infobars");
		    // options.addArguments("--private"); // For incognito mode

		    driver = new FirefoxDriver(options);

		} else if (browser.equalsIgnoreCase("edge")) {

		    WebDriverManager.edgedriver().setup();

		    EdgeOptions options = new EdgeOptions();
		    // You can set specific Edge options here if necessary
		    
		    driver = new EdgeDriver(options);

		}
		return driver;
	}
}
