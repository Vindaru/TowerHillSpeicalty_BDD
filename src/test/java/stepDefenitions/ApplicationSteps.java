package stepDefenitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ths.actiondriver.Action;
import com.ths.actiondriver.LocatorUtils;
import com.bdd.*;
import com.bdd.variables.ScenarioMataData;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class ApplicationSteps extends BasePage {
	public static Properties properties;
	public static WebDriver driver;
	
	private Action action;

	@Given("^.*rpmLogin$")
	public void InternalAgentLogintoRPMsuccessfully(DataTable table) throws Throwable {
		DataTable geturlString = table;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vdaru\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		for (Map<String, String> data : table.asMaps()) {		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");			
			if(data.containsValue("red")) {
				driver.get("https://oasis.red.thig.com");
			}else if(data.containsValue("yellow")) {
				driver.get("https://oasis.Yellow.thig.com");
			}else if(data.containsValue("green")) {
				driver.get("https://oasis.green.thig.com");
			}
			lp.logindetails(table);
			System.out.println("User successfully logged in");
			Thread.sleep(1000);
			lp.personallinesportalbutton();
			System.out.println("PersonalLines");
			Thread.sleep(1000);
			if(lp.DisconnectSession != null) {
				Thread.sleep(1000);
				lp.DisconnectSession();
				System.out.println("Disconnect Page is displayed");
			}else {
				Thread.sleep(1000);
				System.out.println("Disconnect Page is not displayed");
			}
				
			Thread.sleep(1000);
			hp.homePageDialogbox();
			System.out.println("Dialog box is closed");
			
		}
	}	
	@When("userEntersText")
	 public void userEntersText(String locatorKey, String text) throws InterruptedException {
	        String locator = LocatorUtils.getLocator(locatorKey);
	        WebElement element = driver.findElement(By.xpath(locator));
	        Thread.sleep(1000);
	        element.clear();
	        element.sendKeys(text);
	    }
	 
	 @When("userClicksonButton")
	 public void userClicksonbutton(String locatorKey) throws InterruptedException {
	        String locator = LocatorUtils.getLocator(locatorKey);
	        WebElement element = driver.findElement(By.xpath(locator));
	        Thread.sleep(1000);
	        element.click();
	    }
	 
//	 @When("userSelectsdropdownbyValue")
//	 public void userSelectsdropdownbyValue(String locatorKey) throws InterruptedException {
//	        String locator = LocatorUtils.getLocator(locatorKey);
//	        WebElement element = driver.findElement(By.xpath(locator));
//	        Thread.sleep(1000);
//	        element.click();
//	    }
	

	@When("waitForPageLoad")
	public static void waitForPageLoad() {
		try {
			(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
				}
			});
		} catch (Exception ex) {
			((JavascriptExecutor) driver).executeScript("window.stop();");
		}
	}


	@And("Sleep 2000ms")
	public void wait_until_page_load() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Then("^.*verify next page title$") 
	public void verify_next_page_title(DataTable table) throws InterruptedException {
		for (Map<String, String> data : table.asMaps()) {		
            Thread.sleep(1000);
			if(data.containsValue("pageTitle")) {
				String currentpageTitle = driver.getTitle();
				System.out.println("Current page title - " +  currentpageTitle);
				Assert.assertEquals(currentpageTitle, data);				
			}	
		}
	}
	
	@Then("Close browse")
	public void Closebrowse() throws InterruptedException {
		driver.close();
	}
	
	
	
	@Then("verify AgencyOverride.")
	public void verifyAgencyOverride() throws InterruptedException {
		hp.agencyOverride();
	}

	@Then("perform Search functionality")
	public void performSearchfunctionality() throws InterruptedException {
		hp.getsearchpolicy();
	} 
	
	//SelectObject
	
	@Then("^.*SelectObject$")
	public void SelectObject(DataTable table) throws InterruptedException {
		for (Map<String, String> data : table.asMaps()) {		
            Thread.sleep(1000);
            if(data.containsValue("AL")){
            	hp.selectState(table);
            }
		}            
            
	}
	
	@Then("^.*enterRiskaddress$")
	public void enterRiskaddress(DataTable table) throws InterruptedException {
		for (Map<String, String> data : table.asMaps()) {		
            Thread.sleep(1000);
            bp.basicInformationPage(table);
		}            
            
	}
	
	
	@Then("^.*selectRadiobutton$")
	public void selectRadiobutton(DataTable datatable) throws Exception {
		ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());
		for (Map<String, String> data : datatable.asMaps()) {
			String objectName = data.get("ObjectName").trim();
			System.out.println("Object name -   "   + objectName);
			 action = new Action();
			action.click(objectName);
		}
	   }         
            
	
	

	@And("ExitPolicy")
	public void ExitPolicytoHomePage() throws InterruptedException {
		hp.getsearchpolicy();
	}
	
	
	
	@Then("Enter Insured Basicinformation details")
	public void enter_insured_basicinformation_details(DataTable table) throws InterruptedException {
	    bp.basicInformationPage(table);
	}

}
