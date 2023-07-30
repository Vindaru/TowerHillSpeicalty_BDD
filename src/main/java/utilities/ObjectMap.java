package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;


public class ObjectMap {
	
	public Properties prop;
	
	public ObjectMap(String strPath) throws FileNotFoundException, IOException {
		 prop = new Properties();
		 try (FileInputStream rpmfileinput = new FileInputStream(strPath)) {
	            prop.load(rpmfileinput);
	        } catch (IOException e) {
	            System.out.println("Emessage---" + e.getMessage());
	        }
				
	}
	
	public By getLocator (String strElement) throws Exception{
		
		String locator = "";
		String locatorType = "";
		String locatorValue = "";
		
		try {
			locator = prop.getProperty(strElement);
			locatorType = locator.split(":")[0];
			locator = locator.substring(locator.indexOf(":")+1);
			
		}catch (Exception e) {
			System.out.println("Following element is not in the list of existing properties:    "+ strElement);
		}
		By byId = null;
		switch(locatorType.toLowerCase()) {
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
			System.out.println("locator value ==="+ locatorValue);
			byId = By.xpath(locatorValue);
			break;
			default:
				throw new Exception("Unknow locator type '" + locatorType + "'");
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
