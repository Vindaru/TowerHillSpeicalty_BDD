package UW_UPDATE_360Value_Automate;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.ths.actiondriver.Action;
import com.ths.actiondriver.ExcelUtility;
import com.bdd.variables.API_Constant_Values;
import com.ths.actiondriver.*;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.WebDriverManager;
import utilities.ExcelUtils;

import com.ths.actiondriver.*;

public class UW_Automation_Update360 extends BasePage {
	public static WebDriver driver;
	public static Properties properties;
	private WebDriverManager driverManager;
	private int priority;
	private Action action;
	
	public static void main(String[] args) throws Exception {
		
		String excelPath = "C:\\Users\\vdaru\\OneDrive - Tower Hill Insurance Group, LLC\\Desktop\\UW_UPDATE_RENWAL ENG\\REN_UPDATE_360Value.xlsx";
		
		// Read the policy numbers
		List<String> policyNumbers;
		try {
			policyNumbers = ExcelUtility.readFromExcel(excelPath, "Sheet1");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		// Start the browser and navigate to the homepage
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vdaru\\OneDrive - Tower Hill Insurance Group, LLC\\Desktop\\Automation\\Selenium\\sel-cucumber\\External Resources\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://oasis.red.thig.com");
		Thread.sleep(1000);
		// Login:
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		driver.findElement(By.id("inputGroupID")).clear();
		driver.findElement(By.id("inputGroupID")).sendKeys("TS0A00");
		Thread.sleep(1000);
		driver.findElement(By.id("inputUserName")).clear();
		driver.findElement(By.id("inputUserName")).sendKeys("Vdaru");
		Thread.sleep(1000);
		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys("1Password");
		Thread.sleep(1000);
		driver.findElement(By.id("authSubmit")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//*[@id='application-container']/div[2]/div/div/div/form/button")).click();
		Thread.sleep(1000);
		 List<WebElement> submitElements = driver.findElements(By.xpath("//*[@id='submit']"));
	        if (!submitElements.isEmpty()) {
	            WebElement submitButton = submitElements.get(0);
	            submitButton.click();
	            System.out.println("Disconnect Session is displaying = " );
	        }else {
	        	System.out.println("Disconnect Session is not displaying" );
	        }
	        Thread.sleep(1000); 
	        List<WebElement> dialogboxElement = driver.findElements(By.id("motd-dialog-close"));
	        if (!dialogboxElement.isEmpty()) {
	            WebElement dialogbox = dialogboxElement.get(0);
	            dialogbox.click();
	            System.out.println("dialogbox is displaying = " );
	        }else {
	        	System.out.println("dialogbox is not displaying" );
	        }
	        Thread.sleep(1000);
	        
		// For each policy number, search on the homepage
		for (String policyNumber : policyNumbers) {
			driver.findElement(By.id("quote-list-filter-policy-num")).clear();
			driver.findElement(By.id("quote-list-filter-policy-num")).sendKeys(policyNumber);
			Thread.sleep(1000);
			System.out.println("Policy Number - " + policyNumber);
			driver.findElement(By.id("quote-list-filter-submit")).click();
			Thread.sleep(2000);
			String Policy_Status_1 = driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[1]/td[8]")).getText();
			String Policy_Status_2 = driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[3]/td[8]")).getText();
			System.out.println("The status of the First policy Image   "+ policyNumber + "   is == " + Policy_Status_1);
			System.out.println("The status of the Second policy Image   "+ policyNumber + "   is == " + Policy_Status_2);
			if (Policy_Status_1.equals("RENEWAL")) {
				//click on 1st Image else click on 2nd
				driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[1]/td[5]")).click();
				System.out.println("Clicked on   "+ policyNumber + "with Status as == " + Policy_Status_1);
			}else if(Policy_Status_2.equals("RENEWAL")) {
				//click on 1st Image else click on 2nd
				driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[3]/td[5]")).click();
				System.out.println("Clicked on   "+ policyNumber + "with Status as == " + Policy_Status_2);				
			}
			Thread.sleep(2000);			
			// POLICY PAGE
				
			
			// Capture Premium / Coverage_A_initial and Value in 360value
			String initial_Premium = driver.findElement(By.xpath("//*[@id='memos']/div/div/h4[1]/span[2]/span")).getText();
			String initial_Coverage_A = driver.findElement(By.name("policyTerm|coverages|coverageA")).getAttribute("value");
			String initial_360Value = driver.findElement(By.name("policyTerm|coverages|replacementCostEstimate")).getAttribute("value");
			
			System.out.println("Values Captured initial_Premium  = "+  initial_Premium);
			System.out.println("Values Captured initial_Coverage_A  = "+  initial_Coverage_A);
			System.out.println("Values Captured initial_360Value  = "+  initial_360Value);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space(text())='Update 360Value']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn rate-button')]")).click();
			Thread.sleep(3000);
			String updated_Premium = driver.findElement(By.xpath("//*[@id='memos']/div/div/h4[1]/span[2]/span")).getText();
			String updated_Coverage_A = driver.findElement(By.name("policyTerm|coverages|coverageA")).getAttribute("value");
			String updated_360Value = driver.findElement(By.name("policyTerm|coverages|replacementCostEstimate")).getAttribute("value");
			
			System.out.println("Values Captured updated_Coverage_A  = "+  updated_Coverage_A);
			System.out.println("Values Captured updated_360Value  = "+  updated_360Value);
			System.out.println("Values Captured updated_Premium  = "+  updated_Premium);
			Thread.sleep(2000);	
			
			int Initial_Premium_VALUE = sanitizeAndConvert(initial_Premium);
		    int Initial_COVA_VALUE = sanitizeAndConvert(initial_Coverage_A);
		    int Initial_360_VALUE = sanitizeAndConvert(initial_360Value);
		    
		    int Updated_Premium_VALUE = sanitizeAndConvert(updated_Premium);
		    int Updated_COVA_VALUE = sanitizeAndConvert(updated_Coverage_A);
		    int Updated_360_VALUE = sanitizeAndConvert(updated_360Value);
			
		    int fiftyPercentOfInitial = (Initial_COVA_VALUE * 50) / 100;		 

			/*
			 *    1)  If updated coverage A is less then Initial coverage A  -----------  DO NOT CONTINUE --> exit the policy and continue to next policy with a message "" 
			 *    2)  If updated coverage A is greater then 50% if Initial Cov A -----------  CONTINUE to save changes and add message --- updated coverage A is greater then Initial coverage a ny more the 50%
			 *    
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			
		   // 1)  If updated coverage A is less then Initial coverage A  -----------  DO NOT CONTINUE --> exit the policy and continue to next policy with a message "UPDATED COVERAGE A IS LESS THEN INITIAL COVERAGE A" 
			 if(Updated_Premium_VALUE < Initial_Premium_VALUE) {
			     System.out.println("Updated Coverage A is Less then initial_coverageAValue");
			     driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]")).click();
			     // Assuming row 10 and cell 5 for this example
			     ExcelUtility.writeToExcel(excelPath, "Sheet1", policyNumbers, "UPDATED COVERAGE A IS LESS THEN INITIAL COVERAGE A");
			 } else if(Updated_Premium_VALUE == Initial_Premium_VALUE){
				 ExcelUtility.writeToExcel(excelPath, "Sheet1", policyNumbers, "No Changes");
				 driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]")).click();
				 
			 }else {
				 
				 // 0,5% incresed or 50% or 200 % -- continve to confirm changes but we have to add percentage of increase
				 int percent = returnPercentage(Initial_Premium_VALUE,Updated_Premium_VALUE);
				 System.out.println(percent);
				 driver.findElement(By.xpath("//span[text()='Submit Changes']")).click();
				 driver.findElement(By.xpath("//input[contains(@name,'saveMidtermChangesAction|effectiveDate')]")).sendKeys("");
				 Select dr = new Select(driver.findElement(By.xpath("//select[contains(@name,'saveMidtermChangesAction')]")));
	             dr.selectByVisibleText("Update Coverage Selections");
	             String premiumChange = driver.findElement(By.xpath("//span[contains(@data-identifier,'policyTerm|saveMidtermChangesAction|premiumChange')]")).getText();
	             System.out.println(premiumChange);
	             driver.findElement(By.xpath("//button[@id='submit-save-midterm-changes-button']")).click();		
	             Thread.sleep(10000);
	             ExcelUtility.writeToExcel(excelPath, "Sheet1", policyNumbers, "Percentage Change ----- " +percent+" and premium change is :"+premiumChange);
	             driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]")).click();
			 }
			 
			

		}
		
		 
		

	}
	
	public static int returnPercentage(int actualCov, int updatedCov) {
		int fin = ((updatedCov - actualCov)/updatedCov)*100;
		return fin;
		
	}
	
	public static int sanitizeAndConvert(String value) {
	    String sanitizedValue = value.replace(",", "")
	                                 .replace("$", "")
	                                 .trim();
	    
	    if(sanitizedValue.contains(".")) {
	        sanitizedValue = sanitizedValue.substring(0, sanitizedValue.indexOf('.'));
	    }

	    try {
	        return Integer.parseInt(sanitizedValue);
	    } catch(NumberFormatException e) {
	        e.printStackTrace();
	        // For the purpose of this example, I'm returning a default value. 
	        // You might want to handle this differently in your application.
	        return 0; 
	    }
	}
}


//else if(Updated_COVA_VALUE > fiftyPercentOfInitial) {
//    System.out.println("Updated Coverage A is greater then 50% of Initial Coverage A");
//    driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]")).click();
//    // Assuming row 10 and cell 6 for this example
//    //ExcelUtility.writeToExcel(excelPath, "Sheet1", 10, 6, "UPDATED COVERAGE GREATER THAN 50%");
//    ExcelUtility.writeToExcel(excelPath, "Sheet1", policyNumbers, "UPDATED COVERAGE GREATER THAN 50%");
//} else {
//	 ExcelUtility.writeToExcel(excelPath, "Sheet1", policyNumbers, "TEST DONE");
