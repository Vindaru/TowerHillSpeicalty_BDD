package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bdd.variables.GlobalVariables;
import com.bdd.variables.ScenarioMataData;
import com.ths.actiondriver.Action;

import io.cucumber.datatable.DataTable;
import utilities.ObjectMap;

public class LoginPage<ScenarioMetaData> extends BasePage{
	public static Properties properties;
	public WebDriver driver;

	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id = "inputGroupID")
	@CacheLookup
	WebElement groupID;

	@FindBy(id = "inputUserName")
	@CacheLookup
	WebElement userName;

	@FindBy(id = "inputPassword")
	@CacheLookup
	WebElement password;

	@FindBy(css = "#authSubmit > div > div.col-6.offset-3")
	@CacheLookup
	WebElement submitButton;

	@FindBy(xpath = "//*[@id='application-container']/header/div/div/div/div[2]/div[1]/div[2]/div/a[2]/img")
	@CacheLookup
	WebElement logotFromApplicationContainer;

	@FindBy(css = "#custom-bootstrap-menu > div > div > div > a:nth-child(3)")
	@CacheLookup
	WebElement logotFromHomePage;

	@FindBy(css = "#application-container > div:nth-child(4) > div > div > div > form > button")
	@CacheLookup
	WebElement personallinesprotal;

	@FindBy(css = "#submit")
	@CacheLookup
	public
	WebElement DisconnectSession;

	public void setinputGroupID(String usergroupID) throws InterruptedException {
		Thread.sleep(1000);
		groupID.clear();
		groupID.sendKeys(usergroupID);
	}

	public void setinputuserName(String useruserName) throws InterruptedException {
		Thread.sleep(1000);
		userName.clear();
		userName.sendKeys(useruserName);
	}

	public void setinputPassword(String userpassword) throws InterruptedException {
		Thread.sleep(1000);
		password.clear();
		password.sendKeys(userpassword);
	}

	public void clickLogin() throws InterruptedException {
		Thread.sleep(1000);
		submitButton.click();
	}

	public void clicklogotFromApplicationContainer() throws InterruptedException {
		Thread.sleep(1000);
		logotFromApplicationContainer.click();
	}

	public void logotFromHomePage() throws InterruptedException {
		Thread.sleep(1000);
		logotFromHomePage.click();
	}

	public void personallinesportalbutton() throws InterruptedException {
		personallinesprotal.click();
	}

	public void DisconnectSession() throws InterruptedException {		
		DisconnectSession.click();
	}

	public void sleep() throws InterruptedException {

		Thread.sleep(2000);
	}

	public void logindetails(DataTable table) throws InterruptedException, FileNotFoundException, IOException {
         Thread.sleep(1000);
		
		for (Map<String, String> data : table.asMaps()) {			
			properties = new Properties();
	        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\vdaru\\THS-git-repo\\TowerHillSpeicalty_BDD\\THS_locators.properties")) {
	            properties.load(fileInputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        GlobalVariables.initializeObjectMap();
	     // Initialize the Action class with the WebDriver
	        action = new Action(driver);
	        ScenarioMataData scenarioData = new ScenarioMataData();
	        scenarioData.setDriver(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			driver.findElement(By.id("inputGroupID")).clear();
			driver.findElement(By.id("inputGroupID")).sendKeys("TS0A00");
			Thread.sleep(1000);
			driver.findElement(By.id("inputUserName")).clear();
			driver.findElement(By.id("inputUserName")).sendKeys("Vdaru");
			Thread.sleep(1000);
			driver.findElement(By.id("inputPassword")).clear();
			driver.findElement(By.id("inputPassword")).sendKeys("1Password");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#authSubmit > div > div.col-6.offset-3")).click();
			
			if (driver.getPageSource().contains("Please enter a valid group ID") || driver.getPageSource()
					.contains("Authentication Failed. Please check your credentials and try again.  ")) {
				driver.close();
				Assert.assertTrue(false);
			} else {
//				Assert.assertEquals("Tower Hill Insurance Group - Login", driver.getTitle());
			}
		}
	}
	

}
