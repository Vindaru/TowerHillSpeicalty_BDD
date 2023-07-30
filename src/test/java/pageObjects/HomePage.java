package pageObjects;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css = "#motd-dialog")
	@CacheLookup
	WebElement homePageTitle;

	@FindBy(css = "#application-container > div.row-fluid.portalPageHeader > div > div > div.portalHeaderRight.portalBlueGradient.span10 > div.pull-right.portalHeaderRightText")
	@CacheLookup
	WebElement homePageAgentDetails;

	@FindBy(css = "#motd-dialog")
	@CacheLookup
	WebElement homePageDialogbox;

	@FindBy(id = "motd-dialog-close")
	@CacheLookup
	WebElement homePageDialogboxclosebutton;

	@FindBy(css = "#motd-dialog > dt")
	@CacheLookup
	WebElement DialogboxHeadertext;

	@FindBy(css = "#divPolicySearchForm")
	@CacheLookup
	WebElement PolicySearchbluebox;

	@FindBy(css = "#divPolicySearchForm")
	@CacheLookup
	WebElement agnecyOveerSearchbluebox;

	@FindBy(css = "#quote-list > table > tbody > tr:nth-child(1) > td.policy-num-cell")
	@CacheLookup
	WebElement getfirstpolicynumber;

	@FindBy(css = "#quote-list > table > tbody > tr:nth-child(1) > td.policy-num-cell > a")
	@CacheLookup
	WebElement getpolicynumberafterSearch;

	@FindBy(id = "quote-list-filter-policy-num")
	@CacheLookup
	WebElement searchPolicyfilter;

	@FindBy(css = "#quote-list-filter-submit")
	@CacheLookup
	WebElement searchbuttonHomepage;

	@FindBy(css = "#agent-id")
	@CacheLookup
	WebElement overrideAgentID;

	@FindBy(css = "#application-container > div:nth-child(6) > div:nth-child(1) > div:nth-child(5) > form:nth-child(3) > div.sideFormButtons > button:nth-child(1)")
	@CacheLookup
	WebElement agencyOverrideSaveButton;

	@FindBy(css = "portalMessage")
	@CacheLookup
	By agencyOverrideSuccessmessage;

	@FindBy(css = "#portalMessage-note > div > button")
	@CacheLookup
	WebElement agencyoverrideSuccessClosebutton;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul")
	@CacheLookup
	WebElement rpmContainerMenu;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li.active > a")
	@CacheLookup
	WebElement rpmContainerMenuHOME;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(2) > a")
	@CacheLookup
	WebElement rpmContainerMenuPORTAL;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(3) > a")
	@CacheLookup
	WebElement rpmContainerMenuQUOTES;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(4) > a")
	@CacheLookup
	WebElement rpmContainerMenuPOLICYMANAGEMENT;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(5) > a")
	@CacheLookup
	WebElement rpmContainerMenuADMIN;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(6) > a")
	@CacheLookup
	WebElement rpmContainerMenuSUPPORTDOCS;

	// policynumber search validation

	@FindBy(css = "#quote-list > table > tbody > tr:nth-child(1) > td.expand-cell > img")
	@CacheLookup
	WebElement policySearchExpandbutton;

	@FindBy(css = "#quote-list > table > tbody > tr:nth-child(1) > td.form-cell")
	@CacheLookup
	WebElement policySearchFormdisplay;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(6) > a")
	@CacheLookup
	By policySearchPolicyNum;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(6) > a")
	@CacheLookup
	WebElement policySearchEffectiveDate;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(6) > a")
	@CacheLookup
	WebElement policySearchInsuredName;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(6) > a")
	@CacheLookup
	WebElement policySearchEStatus;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(6) > a")
	@CacheLookup
	WebElement policySearchState;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(6) > a")
	@CacheLookup
	WebElement policySearchAgency;

	@FindBy(css = "#custom-bootstrap-menu > div > div > ul > li:nth-child(6) > a")
	@CacheLookup
	WebElement policySearchCreated;

	@FindBy(xpath = "//button[@class='ember-view btn thig-btn cancel-button']")
	@CacheLookup
	WebElement exitPolicy;

	public void homePageAgentDetails() throws InterruptedException {
		Thread.sleep(1000);
		homePageAgentDetails.isDisplayed();
	}

	public void homePageDialogbox() throws InterruptedException {
		Thread.sleep(1000);

		if (homePageDialogbox.isDisplayed()) {
			System.out.println("Homepage Dialog box is displayed ");
			Thread.sleep(1000);
			Assert.assertEquals(DialogboxHeadertext.getText(), "Messages and Updates");
			homePageDialogboxclosebutton.click();
		} else {
			System.out.println("Homepage Dialog box is not displayed ");
		}

	}

	public void getsearchpolicy() throws InterruptedException {
		Thread.sleep(1000);
		PolicySearchbluebox.isDisplayed();
		System.out.println("PolicySearchbluebox is displayed ");
		Thread.sleep(1000);
		// get first policy on the homepage to search
		String policynum = getfirstpolicynumber.getText();
		System.out.println(policynum);
		Thread.sleep(500);
		searchPolicyfilter.sendKeys(policynum);
		Thread.sleep(500);
		searchbuttonHomepage.click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Boolean waitforelement;
		waitforelement = wait
				.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText(policynum), policynum));
		Thread.sleep(1000);
		while (driver.findElement(By.linkText(policynum)) != null) {
			try {
				getpolicynumberafterSearch.click();
				Thread.sleep(1000);
				waitforelement = wait.until(ExpectedConditions.textToBePresentInElementLocated(
						By.xpath("//span[@data-identifier= 'policyTerm|policyNum']"), policynum));
				exitPolicy.click();
				waitforelement = wait
						.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText(policynum), policynum));
			} catch (StaleElementReferenceException e) {

			}
			break;
		}
	}

	public void agencyOverride() throws InterruptedException {
		Thread.sleep(1000);
		agnecyOveerSearchbluebox.isDisplayed();
		System.out.println("agnecyOveerSearchbluebox is displayed ");
		Thread.sleep(1000);
		overrideAgentID.clear();
		Thread.sleep(1000);
		overrideAgentID.sendKeys("TS0A00"); // using test agency to override.
		Thread.sleep(500);
		agencyOverrideSaveButton.click();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("portalMessage")));
		Thread.sleep(1000);
		if (driver.findElements(By.cssSelector("#portalMessage-note > div > ul > li")).contains("successfully")) {
			;
			Assert.assertTrue(false);
			Thread.sleep(1000);
			agencyoverrideSuccessClosebutton.click();

		} else {
			Assert.assertTrue(true);
		}

	}


	
	public void selectState(DataTable table) throws InterruptedException {
		rpmContainerMenuQUOTES.click();
		Thread.sleep(500);
		
		for (Map<String, String> data : table.asMaps()) {
			
			if(data.containsValue("AL")) {
				driver.findElement(By.linkText("AL")).click();
				System.out.println("Selected State == AL");
			}else if(data.containsValue("AR")){
				driver.findElement(By.linkText("AR")).click();
				System.out.println("Selected State == AR");
			}else if(data.containsValue("AZ")){
				driver.findElement(By.linkText("AZ")).click();
				System.out.println("Selected State == AZ");
			}else if(data.containsValue("GA")){
				driver.findElement(By.linkText("GA")).click();
				System.out.println("Selected State == GA");
			}else if(data.containsValue("IL")){
				driver.findElement(By.linkText("IL")).click();
				System.out.println("Selected State == IL");
			}else if(data.containsValue("IN")){
				driver.findElement(By.linkText("IN")).click();
				System.out.println("Selected State == IN");
			}else if(data.containsValue("LA")){
				driver.findElement(By.linkText("LA")).click();
				System.out.println("Selected State == LA");
			}else if(data.containsValue("MI")){
				driver.findElement(By.linkText("MI")).click();
				System.out.println("Selected State == MI");
			}else if(data.containsValue("MO")){
				driver.findElement(By.linkText("MO")).click();
				System.out.println("Selected State == MO");
			}else if(data.containsValue("MS")){
				driver.findElement(By.linkText("MS")).click();
				System.out.println("Selected State == MS");
			}else if(data.containsValue("NC")){
				driver.findElement(By.linkText("NC")).click();
				System.out.println("Selected State == NC");
			}else if(data.containsValue("OH")){
				driver.findElement(By.linkText("OH")).click();
				System.out.println("Selected State == OH");
			}else if(data.containsValue("SC")){
				driver.findElement(By.linkText("SC")).click();
				System.out.println("Selected State == SC");
			}else if(data.containsValue("TN")){
				driver.findElement(By.linkText("TN")).click();
				System.out.println("Selected State == TN");
			}else if(data.containsValue("TX")){
				driver.findElement(By.linkText("TX")).click();
				System.out.println("Selected State == TX");
			}else if(data.containsValue("WI")){
				driver.findElement(By.linkText("WI")).click();
				System.out.println("Selected State == WI");
			}
		}

		 
	}
	
}
