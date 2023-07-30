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

public class BasicinformationPage {

	public WebDriver driver;

	public BasicinformationPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css = "policyTerm|businessPolicy")
	@CacheLookup
	WebElement businessOwned;

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
	public void basicInformationPage(DataTable table) throws InterruptedException {
        Thread.sleep(1000);
		
		for (Map<String, String> data : table.asMaps()) {

			
			driver.findElement(By.id("inputGroupID")).clear();
			driver.findElement(By.id("inputGroupID")).sendKeys(data.get("groupId"));
			Thread.sleep(1000);
			driver.findElement(By.id("inputUserName")).clear();
			driver.findElement(By.id("inputUserName")).sendKeys(data.get("userName"));
			Thread.sleep(1000);
			driver.findElement(By.id("inputPassword")).clear();
			driver.findElement(By.id("inputPassword")).sendKeys(data.get("password"));
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#authSubmit > div > div.col-6.offset-3")).click();
			
			if (driver.getPageSource().contains("Please enter a valid group ID") || driver.getPageSource()
					.contains("Authentication Failed. Please check your credentials and try again.  ")) {
				driver.close();
				Assert.assertTrue(false);
			} else {
				Assert.assertEquals("Tower Hill Insurance Group - Login", driver.getTitle());
			}
		}
	}
	
//	selectCheckbox
	
	
}