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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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
		
		action = new Action(driver);
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
	@When("^.*userEntersText$")
    public void userEntersText(DataTable table) throws Exception {
        ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());

        for (Map<String, String> data : table.asMaps()) {
            String objectName = data.get("ObjectName").trim();
            System.out.println("Object name - " + objectName);
            // Assuming the value you want to enter is in the "Value" column of the DataTable.
            String valueToEnter = data.get("Value").trim();
            // Use the "type" method of the "action" object to enter text into the element.
            action.type(objectName, valueToEnter);
        }
    }
	 
	 @When("^.*userClicksonButton$")
	 public void userClicksonbutton(DataTable table) throws Exception {
		 ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());

	        for (Map<String, String> data : table.asMaps()) {
	        	String objectName = data.get("ObjectName").trim();
	        Thread.sleep(1000);
	        action.click(objectName);
	        }
	    }
	 
//	
	 @Then("^.*selectDropdownvalue$")
	    public void selectDropdownvalue(DataTable table) throws Exception {
	        ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());

	        for (Map<String, String> data : table.asMaps()) {
	            String objectName = data.get("ObjectName").trim();
	            System.out.println("Object name - " + objectName);
	            // Assuming the value you want to enter is in the "Value" column of the DataTable.
	            String valueToEnter = data.get("Value").trim();
	            // Use the "type" method of the "action" object to enter text into the element.
	            action.selectBySendkeys(objectName, valueToEnter);
	        }
	    }
	

	 @Then("^.*waitForPageLoad$")
	public static void waitForPageLoad() {
		try {
			(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
				}
			});
		} catch (Exception ex) {
			((JavascriptExecutor) driver).executeScript("window.stop();");
		}
	}


	 @Then("^.*verifyObjectIsPresent$")
	    public void verifyObjectIsPresent(DataTable datatable) {
	        List<Map<String, String>> data = datatable.asMaps(String.class, String.class);
	        
	        for (Map<String, String> row : data) {
	            String objectName = row.get("ObjectName");

	            try {
	                // Use the objectName to find the element
	                driver.findElement(By.name(objectName));

	                // Element found, page loaded successfully
	                System.out.println("Element with name '" + objectName + "' is present. Page loaded successfully.");
	            } catch (NoSuchElementException e) {
	                // Element not found, page not loaded successfully
	                throw new AssertionError("Element with name '" + objectName + "' is not present. Page not loaded successfully.");
	            }
	        }
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
            	hp.selectState(table);          
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
			action = new Action(driver);
			action.clickradiobutton(objectName);
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
