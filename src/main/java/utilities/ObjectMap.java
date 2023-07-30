package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;


public class ObjectMap {
	
	public Properties prop;
	
	public ObjectMap(String filePath) {
        // Initialize the prop object
        prop = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            prop.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public By getLocator(String strElement) throws Exception {
	    String locator = prop.getProperty(strElement);
	    String locatorType = locator.split(":")[0];
	    String locatorValue = locator.substring(locator.indexOf(":") + 1);

	    By byId = null;
	    switch (locatorType.toLowerCase()) {
	        case "id":
	            byId = By.id(locatorValue);
	            break;
	        case "name":
	            byId = By.name(locatorValue);
	            break;
	        case "classname":
	        case "class":
	            byId = By.className(locatorValue);
	            break;
	        case "tagname":
	        case "tag":
	            byId = By.tagName(locatorValue);
	            break;
	        case "linktext":
	        case "link":
	            byId = By.linkText(locatorValue);
	            break;
	        case "partiallinktext":
	            byId = By.partialLinkText(locatorValue);
	            break;
	        case "cssselector":
	        case "css":
	            byId = By.cssSelector(locatorValue);
	            break;
	        case "xpath":
	            byId = By.xpath(locatorValue);
	            break;
	        default:
	            throw new Exception("Unknown locator type '" + locatorType + "'");
	    }
	    return byId;
	}
	
	public String[] getLocatorStringValue (String strElement) throws Exception {
		String locator = prop.getProperty(strElement);
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		return new String[] {
				locatorType, locatorValue
		};
	}
	
}
