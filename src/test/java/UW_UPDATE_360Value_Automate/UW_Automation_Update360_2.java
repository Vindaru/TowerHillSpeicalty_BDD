package UW_UPDATE_360Value_Automate;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ths.actiondriver.Action;
import com.bdd.variables.API_Constant_Values;
import pageObjects.WebDriverManager;
import utilities.ExcelUtils;

public class UW_Automation_Update360_2 extends ExcelUtils {
	public static WebDriver driver;
	public static Properties properties;
	private WebDriverManager driverManager;
	private int priority;
	private Action action;

	public static void main(String[] args) throws Exception {
	
		// Start the browser and navigate to the homepage
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vdaru\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://oasis.red.thig.com");
		Thread.sleep(1000);
		// Login:
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		driver.findElement(By.id("inputGroupID")).clear();
		driver.findElement(By.id("inputGroupID")).sendKeys("THIG");
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
			System.out.println("Disconnect Session is displaying = ");
		} else {
			System.out.println("Disconnect Session is not displaying");
		}
		Thread.sleep(1000);
		List<WebElement> dialogboxElement = driver.findElements(By.id("motd-dialog-close"));
		if (!dialogboxElement.isEmpty()) {
			WebElement dialogbox = dialogboxElement.get(0);
			dialogbox.click();
			System.out.println("dialogbox is displaying = ");
		} else {
			System.out.println("dialogbox is not displaying");
		}
		Thread.sleep(1000);
		// For each policy number, search on the home page

		ExcelUtils.setExcelFile(API_Constant_Values.update360_Path + API_Constant_Values.update360_File, "sheet1");
		int i, j;

		for (int a = 1; a < ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); a++) {
			
			Thread.sleep(2000);
			int numberofrows = ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println("number of rows: " + numberofrows);

			String PolicyNumber = ExcelUtils.getCellData(a, 0);

			WebDriverWait wait = new WebDriverWait(driver, 30); // 30 is the timeout in seconds
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quote-list-filter-policy-num")));
			driver.findElement(By.id("quote-list-filter-policy-num")).clear();
			driver.findElement(By.id("quote-list-filter-policy-num")).sendKeys(PolicyNumber);
			Thread.sleep(1000);
			System.out.println("Policy Number - " + PolicyNumber);
			driver.findElement(By.id("quote-list-filter-submit")).click();
			Thread.sleep(2000);
			String Policy_Status_1 = driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[1]/td[8]"))
					.getText();
			String Policy_Status_2 = driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[3]/td[8]"))
					.getText();
			System.out
					.println("The status of the First policy Image   " + PolicyNumber + "   is == " + Policy_Status_1);
			System.out
					.println("The status of the Second policy Image   " + PolicyNumber + "   is == " + Policy_Status_2);
			if (Policy_Status_1.equals("RENEWAL")) {
				// click on 1st Image else click on 2nd
				driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[1]/td[5]")).click();
				System.out.println("Clicked on   " + PolicyNumber + "with Status as == " + Policy_Status_1);
			} else if (Policy_Status_2.equals("RENEWAL")) {
				// click on 1st Image else click on 2nd
				driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[3]/td[5]")).click();
				System.out.println("Clicked on   " + PolicyNumber + "with Status as == " + Policy_Status_2);
			}
			Thread.sleep(2000);
			// POLICY PAGE

			// Capture Premium / Coverage_A_initial and Value in 360value
			String initial_Premium = driver.findElement(By.xpath("//*[@id='memos']/div/div/h4[1]/span[2]/span"))
					.getText();
			String initial_Coverage_A = driver.findElement(By.name("policyTerm|coverages|coverageA"))
					.getAttribute("value");
			String initial_360Value = driver.findElement(By.name("policyTerm|coverages|replacementCostEstimate"))
					.getAttribute("value");
			Thread.sleep(1000);
			System.out.println("Values Captured initial_Premium  = " + initial_Premium);
			System.out.println("Values Captured initial_Coverage_A  = " + initial_Coverage_A);
			System.out.println("Values Captured initial_360Value  = " + initial_360Value);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//button[contains(@class, 'ember-view btn thig-btn update-rc')]")));
			driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn update-rc')]")).click();
			Thread.sleep(10000);
			js.executeScript("window.scrollTo(0, 0)"); 
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ember-view btn thig-btn rate-button')]")));
			element.click();

			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("policyTerm|underwriting|squareFootage")));
			String updated_Premium = driver.findElement(By.xpath("//*[@id='memos']/div/div/h4[1]/span[2]/span"))
					.getText();
			String updated_Coverage_A = driver.findElement(By.name("policyTerm|coverages|coverageA"))
					.getAttribute("value");
			String updated_360Value = driver.findElement(By.name("policyTerm|coverages|replacementCostEstimate"))
					.getAttribute("value");
			String renewal_EffectiveDate = driver.findElement(By.name("policyTerm|effectiveDate"))
					.getAttribute("value");
			System.out.println("Values Captured updated_Coverage_A  = " + updated_Coverage_A);
			System.out.println("Values Captured updated_360Value  = " + updated_360Value);
			System.out.println("Values Captured updated_Premium  = " + updated_Premium);
			Thread.sleep(2000);

			int Initial_Premium_VALUE = sanitizeAndConvert(initial_Premium);
			int Initial_COVA_VALUE = sanitizeAndConvert(initial_Coverage_A);
			int Initial_360_VALUE = sanitizeAndConvert(initial_360Value);
			int Updated_Premium_VALUE = sanitizeAndConvert(updated_Premium);
			int Updated_COVA_VALUE = sanitizeAndConvert(updated_Coverage_A);
			int Updated_360_VALUE = sanitizeAndConvert(updated_360Value);
			boolean coverageIncreasedBy50PercentOrMore = (Updated_COVA_VALUE >= (1.5 * Initial_COVA_VALUE));
			

			ExcelUtils.setExcelFile(API_Constant_Values.update360_Path + API_Constant_Values.update360_File, "sheet1");
			Thread.sleep(1000);
			// ...
			if (Updated_Premium_VALUE < Initial_Premium_VALUE) {
				System.out.println("Updated Coverage A is Less then initial_coverageAValue");
				ExcelUtils.ExcelWSheet.getRow(a).createCell(1)
						.setCellValue("Updated Coverage A is Less then initial_coverageAValue");
				driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]"))
						.click();
			} 
			if (coverageIncreasedBy50PercentOrMore) {
				System.out.println("Updated Coverage A is greater then 50% of Initial Coverage A");
				System.out.println("Coverage A increased by 50% or more.");
				ExcelUtils.ExcelWSheet.getRow(a).createCell(1)
						.setCellValue("Updated Coverage A is greater then 50% of Initial Coverage A");
//				driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]"))
//						.click();

			} else {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn save-button')]"))
						.click();
				
				Thread.sleep(2000);
//				driver.switchTo().frame(driver.findElement(By.id("save-midterm-changes-modal")));
//				Thread.sleep(2000);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.name("policyTerm|saveMidtermChangesAction|effectiveDate")));
				driver.findElement(By.name("policyTerm|saveMidtermChangesAction|effectiveDate"))
						.sendKeys(renewal_EffectiveDate);
				Thread.sleep(1000);
				Select select = new Select(
						driver.findElement(By.name("policyTerm|saveMidtermChangesAction|transactionReason")));
				select.selectByVisibleText("Update Coverage Selections");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='submit-save-midterm-changes-button']")).click();

				Thread.sleep(2000);
				ExcelUtils.ExcelWSheet.getRow(a).createCell(1).setCellValue("SUCCESSFULL UPDATED RENWAL POLICY");
				//*[@id='notification-container']/div[2]/div
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[@id='notification-container']/div[2]/div")));
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='notification-container']/div[2]/div")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]"))
						.click();
			}
			Thread.sleep(1000);
			FileOutputStream fos = new FileOutputStream(
					API_Constant_Values.update360_Path + API_Constant_Values.update360_File);
			ExcelWBook.write(fos);
			fos.close();

		}
	}

	public static int sanitizeAndConvert(String value) {
		String sanitizedValue = value.replace(",", "").replace("$", "").trim();

		if (sanitizedValue.contains(".")) {
			sanitizedValue = sanitizedValue.substring(0, sanitizedValue.indexOf('.'));
		}

		try {
			return Integer.parseInt(sanitizedValue);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void PercentageIncreaseCalculator(String value) {

	 
	        double initial_Coverage_A = 200000;
	        double updated_Coverage_A = 400000;

	        double percentageIncrease = ((updated_Coverage_A - initial_Coverage_A) / initial_Coverage_A) * 100;

	        System.out.println("Percentage Increase: " + percentageIncrease + "%");
	    
	}
	
	
}
