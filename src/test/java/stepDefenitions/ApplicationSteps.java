package stepDefenitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.management.ObjectName;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ths.actiondriver.Action;
import com.ths.actiondriver.CoverageValidator_coverageA;
import com.ths.actiondriver.CoverageValidator_coverageB;
import com.ths.actiondriver.CoverageValidator_coverageC;
import com.bdd.variables.ScenarioMataData;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.WebDriverManager;

public class ApplicationSteps extends BasePage {
	public static Properties properties;
	public static WebDriver driver;
	private WebDriverManager driverManager;
	private int priority;
	private Action action;
	private Scenario scenario;
	private CoverageValidator_coverageA CoverageValidation;
	private static String storedPolicyNumber;

	@Before
	public void setup(Scenario scenario) {

		for (String tag : scenario.getSourceTagNames()) {
			if (tag.startsWith("@Priority")) {
				priority = Integer.parseInt(tag.substring(9));
				break;
			}
		}
		this.scenario = scenario;
	}

	@Given("^.*rpmLogin$")
	public void InternalAgentLogintoRPMsuccessfully(DataTable table) throws Throwable {
		DataTable geturlString = table;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vdaru\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		action = new Action(driver);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for (Map<String, String> data : table.asMaps()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			if (data.containsValue("red")) {
				driver.get("https://oasis.red.thig.com");
			} else if (data.containsValue("yellow")) {
				driver.get("https://oasis.yellow.thig.com");
			} else if (data.containsValue("green")) {
				driver.get("https://oasis.green.thig.com");
			}
			lp.logindetails(table);
			System.out.println("User successfully logged in");
			Thread.sleep(1000);
			lp.personallinesportalbutton();
			System.out.println("Successfully clicked on ----   PersonalLines to continue to HomePage");
			Thread.sleep(1000);
			if (lp.DisconnectSession != null) {
				Thread.sleep(1000);
				lp.DisconnectSession();
				System.out.println("Disconnect Page is displayed");
			} else {
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
			// Assuming the value you want to enter is in the "Value" column of the
			String valueToEnter = data.get("Value").trim();
			if (valueToEnter.equals("<today>")) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				valueToEnter = dateFormat.format(date);
				// action.type(objectName, valueToEnter);
				System.out.println("I am hear --value is Date ---  ");
			}
			// DataTable.
			System.out.println("I am hear --value is not Date ---  ");
			// Use the "type" method of the "action" object to enter text into the element.
			action.type(objectName, valueToEnter);
		}
	}

	@When("^.*enterCoveragesAfterValidation$")
	public void enterCoveragesAfterValidation(DataTable table) throws Exception {
		ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());

		int dwellingCoverage = 0;
		int otherStructuresCoverage = 0;
		int personalPropertiesCoverage = 0;
		String lastObjectName = "";
		String lastValueToEnter = "";

		for (Map<String, String> data : table.asMaps()) {
			String objectName = data.get("ObjectName").trim();
			String valueToEnter = data.get("Value").trim();

			switch (objectName) {
			case "policyPage.dwelling_covA":
				dwellingCoverage = Integer.parseInt(valueToEnter);
				break;
			case "policyPage.otherStructures_covB":
				otherStructuresCoverage = Integer.parseInt(valueToEnter);
				break;
			case "policyPage.personalProperties_covC":
				personalPropertiesCoverage = Integer.parseInt(valueToEnter);
				break;
			}
			lastObjectName = objectName;
			lastValueToEnter = valueToEnter;
		}
		
		 switch (lastObjectName) {

	        case "policyPage.dwelling_covA":
	        	CoverageValidator_coverageA coverageValidationA = new CoverageValidator_coverageA(driver);
				coverageValidationA.readData();
				coverageValidationA.validatePolicies(dwellingCoverage, lastObjectName, lastValueToEnter);
				System.out.println("Values processed; dwellingCoverage = " + dwellingCoverage);
	            break;
	        case "policyPage.otherStructures_covB":
	        	CoverageValidator_coverageB coverageValidationB = new CoverageValidator_coverageB(driver);
				coverageValidationB.readData();
				coverageValidationB.validatePoliciesCovB(otherStructuresCoverage, lastObjectName, lastValueToEnter);
				System.out.println("Values processed; dwellingCoverage = " + otherStructuresCoverage);
	            break;
	        case "policyPage.personalProperties_covC":
	        	CoverageValidator_coverageC coverageValidationC = new CoverageValidator_coverageC(driver);
				coverageValidationC.readData();
				coverageValidationC.validatePoliciesCovC(personalPropertiesCoverage, lastObjectName, lastValueToEnter);
				System.out.println("Values processed; dwellingCoverage = " + personalPropertiesCoverage);	            
				break;
	    }		
	}

	@When("^.*verifytextValue$")
	public void verifytextValue(DataTable table) throws Exception {
		ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());

		for (Map<String, String> data : table.asMaps()) {
			String objectName = data.get("ObjectName").trim();
			// Assuming the value you want to enter is in the "Value" column of the
			// DataTable.
			String valueToEnter = data.get("Value").trim();
			// Use the "type" method of the "action" object to enter text into the element.
			action.getElementTextorValue(objectName);
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
			// Assuming the value you want to enter is in the "Value" column of the
			// DataTable.
			String valueToEnter = data.get("Value").trim();
			// Use the "type" method of the "action" object to enter text into the element.
			action.selectByVisibleText(objectName, valueToEnter);
		}
	}

	@Then("^.*waitForPageLoad$")
	public void waitForPageLoad() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 45); // 45 seconds timeout
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
				}
			});
		} catch (TimeoutException e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	@When("^.*verifyTextDetails$")
	public void verifyTextDetails(DataTable table) throws Exception {
		ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());

		for (Map<String, String> data : table.asMaps()) {
			String objectName = data.get("ObjectName").trim();
			// Assuming the value you want to enter is in the "Value" column of the
			// DataTable.
			String valueToVerify = data.get("Value").trim();
			if (valueToVerify.equals("<today>")) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				valueToVerify = dateFormat.format(date);
			}
			// Use the "type" method of the "action" object to enter text into the element.
			action.verifyTextValue(objectName, valueToVerify);
		}
	}

	@Then("^.*verifyObjectIsPresent$")
	public void verifyObjectIsPresent(DataTable table) throws Exception {
		ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());

		for (Map<String, String> data : table.asMaps()) {
			String objectName = data.get("ObjectName").trim();
			action.isElementPresent(objectName);

		}
	}

	@Then("^.*clickonlinktext$")
	public void clickonlinktext(DataTable table) throws Exception {
		WebElement linkElement = null;
		ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());
		for (Map<String, String> data : table.asMaps()) {
			String value = data.get("Value").trim();
			if (value.contains("<storedPolicyNumber>")) {
				linkElement = driver.findElement(By.linkText(storedPolicyNumber));
				linkElement.click();
				Thread.sleep(1000);
			} else {
				Thread.sleep(1000);
				System.out.println("Value of policy to click is === " + value);
				linkElement = driver.findElement(
						By.xpath("//*[contains(text(),'" + value + "') and @class='text-link policy-num-link']"));
				System.out.println("xpath === " + linkElement);
				linkElement.click();
				Thread.sleep(1000);
			}
		}
	}

	@Then("^.*getPolicyNumber$")
	public void getPolicyNumber(DataTable table) throws Exception {
		ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());

		for (Map<String, String> data : table.asMaps()) {
			String objectName = data.get("ObjectName").trim();
			storedPolicyNumber = action.getElementTextorValue(objectName);
		}
	}

	@Then("^.*userEntersPolicyNumber$")
	public void userEntersPolicyNumber(DataTable table) throws Exception {
		for (Map<String, String> data : table.asMaps()) {
			String objectName = data.get("ObjectName").trim();
			String value = data.get("Value").trim();
			// If the value starts and ends with "<" and ">", it means it's a placeholder.
			// We replace the placeholder with the actual stored policy number.
			if (value.startsWith("<") && value.endsWith(">")) {
				value = value.replace("<", "").replace(">", ""); // Remove angle brackets
				value = storedPolicyNumber;
				action.type(objectName, value);
			} else {
				Thread.sleep(1000);
				action.type(objectName, value);
				Thread.sleep(1000);
			}

			System.out.println("Entering value - " + value);

		}
	}

	@Then("^.*getElementText$")
	public void getElementTextorValue(DataTable table) throws Exception {
		ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());

		for (Map<String, String> data : table.asMaps()) {
			String objectName = data.get("ObjectName").trim();
			action.getElementTextorValue(objectName);
		}
	}

	@Then("^.*getColorOfTheElement$")
	public void getColorOfTheElement(DataTable table) {

		ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());

		for (Map<String, String> data : table.asMaps()) {
			String objectName = data.get("ObjectName").trim();
			// Replace "element-id" with the actual ID of the element
			By locator = By.xpath(objectName);
			WebElement element = driver.findElement(locator);

			// Get the color attribute of the element using getCssValue()
			String color = element.getCssValue("color");
			System.out.println("Element color: " + color);

			// You can add your color validation logic here using assertions
			// For example, assert that the color matches the expected color.
			Assert.assertEquals("rgb(255, 0, 0)", color); // Replace with your expected color value
		}
	}

	@Then("^.*verify next page title$")
	public void verify_next_page_title(DataTable table) throws InterruptedException {
		for (Map<String, String> data : table.asMaps()) {
			Thread.sleep(1000);
			if (data.containsValue("pageTitle")) {
				String currentpageTitle = driver.getTitle();
				System.out.println("Current page title - " + currentpageTitle);
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

	// SelectObject

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

	@After
	public void tearDown(Scenario scenario) throws InterruptedException {
		Thread.sleep(2000);
		ScenarioMataData scData = ScenarioMataData.get(Thread.currentThread().hashCode());
		driver.close();
	}

}
