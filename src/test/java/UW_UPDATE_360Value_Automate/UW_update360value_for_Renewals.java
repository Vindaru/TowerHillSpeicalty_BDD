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
import com.ths.actiondriver.ExcelUtility;
import com.bdd.variables.API_Constant_Values;
import com.ths.actiondriver.*;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.WebDriverManager;
import utilities.ExcelUtils;

import com.ths.actiondriver.*;

public class UW_update360value_for_Renewals extends ExcelUtils {
	public static WebDriver driver;
	public static Properties properties;
	private WebDriverManager driverManager;
	private int priority;
	private Action action;

	public static void main(String[] args) throws Exception {

		// Start the browser and navigate to the homepage
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vdaru\\OneDrive - Tower Hill Insurance Group, LLC\\Desktop\\Automation\\Selenium\\sel-cucumber\\External Resources\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://oasis.thig.com");
		Thread.sleep(1000);
		// Login:
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		driver.findElement(By.id("inputGroupID")).clear();
		driver.findElement(By.id("inputGroupID")).sendKeys("THIG");
		Thread.sleep(1000);
		driver.findElement(By.id("inputUserName")).clear();
		driver.findElement(By.id("inputUserName")).sendKeys("THSAUTOMATION");
		Thread.sleep(1000);
		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys("Gr33ndogs");
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

		ExcelUtils.setExcelFile(API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename,
				"sheet1");
		int i, j;
		for (j = 0; j < ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); j++) {
			for (int a = 2; a < ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); a ++) {
				System.out.println(ExcelWSheet.getPhysicalNumberOfRows());
				// read values form EXCEL; \
				String policyNumbers = ExcelUtils.getCellData(a, 1);

				driver.findElement(By.id("quote-list-filter-policy-num")).clear();
				driver.findElement(By.id("quote-list-filter-policy-num")).sendKeys(policyNumbers);
				Thread.sleep(1000);
				System.out.println("Policy Number - " + policyNumbers);
				driver.findElement(By.id("quote-list-filter-submit")).click();
				Thread.sleep(2000);
				String Policy_Status_1 = driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[1]/td[8]"))
						.getText();
				String Policy_Status_2 = driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[3]/td[8]"))
						.getText();
				System.out.println(
						"The status of the First policy Image   " + policyNumbers + "   is == " + Policy_Status_1);
				System.out.println(
						"The status of the Second policy Image   " + policyNumbers + "   is == " + Policy_Status_2);
				if (Policy_Status_1.equals("RENEWAL")) {
					// click on 1st Image else click on 2nd
					driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[1]/td[5]")).click();
					System.out.println("Clicked on   " + policyNumbers + "with Status as == " + Policy_Status_1);
				} else if (Policy_Status_2.equals("RENEWAL")) {
					// click on 1st Image else click on 2nd
					driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[3]/td[5]")).click();
					System.out.println("Clicked on   " + policyNumbers + "with Status as == " + Policy_Status_2);
				}
				Thread.sleep(2000);
				
		        String pendingChanges = "Changes not allowed due to pending change on";
		        String pageSource = driver.getPageSource();
		        // Check if a matching element is found
		            if (pageSource.contains(pendingChanges)) {
		            	Thread.sleep(2000);
		            // Add an error message or perform the necessary action
		            String errorMessage = "Error: Changes not allowed due to pending change";
		            System.out.println("Error displaying : " + errorMessage);
					// Assuming row 10 and cell 5 for this example
					ExcelUtils.setExcelFile(
							API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename, "sheet1");
					
					ExcelUtils.ExcelWSheet.getRow(a).createCell(9).setCellValue("Pending changes = continue to next task"); // Task																														// stat
					ExcelUtils.ExcelWSheet.getRow(a).createCell(10).setCellValue(errorMessage); // comments
																																// to
																																// UW
					FileOutputStream fos = new FileOutputStream(
							API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename);
					ExcelWBook.write(fos);
					fos.close();

					driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]"))
							.click();
					Thread.sleep(5000);
		            System.out.println(errorMessage);
		        } else {

				// POLICY PAGE

				// Capture Premium / Coverage_A_initial and Value in 360value
				String initial_Premium = driver.findElement(By.xpath("//*[@id='memos']/div/div/h4[1]/span[2]/span"))
						.getText();
				String initial_Coverage_A = driver.findElement(By.name("policyTerm|coverages|coverageA"))
						.getAttribute("value");
				String initial_360Value = driver.findElement(By.name("policyTerm|coverages|replacementCostEstimate"))
						.getAttribute("value");
				String effectiveDate = driver.findElement(By.name("policyTerm|effectiveDate")).getAttribute("value");

				System.out.println("Values Captured initial_Premium  = " + initial_Premium);
				System.out.println("Values Captured initial_Coverage_A  = " + initial_Coverage_A);
				System.out.println("Values Captured initial_360Value  = " + initial_360Value);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[normalize-space(text())='Update 360Value']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn rate-button')]"))
						.click();
				Thread.sleep(3000);
				String updated_Premium = driver.findElement(By.xpath("//*[@id='memos']/div/div/h4[1]/span[2]/span"))
						.getText();
				String updated_Coverage_A = driver.findElement(By.name("policyTerm|coverages|coverageA"))
						.getAttribute("value");
				String updated_360Value = driver.findElement(By.name("policyTerm|coverages|replacementCostEstimate"))
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

				int fiftyPercentOfInitial = (Initial_COVA_VALUE * 50) / 100;

				// 1) If updated coverage A is less then Initial coverage A ----------- DO NOT
				// CONTINUE --> exit the policy and continue to next policy with a message
				// "UPDATED COVERAGE A IS LESS THEN INITIAL COVERAGE A"
				if (Updated_COVA_VALUE < Initial_COVA_VALUE) {
					System.out.println("Updated Coverage A is Less then initial_coverageAValue");
					// Assuming row 10 and cell 5 for this example
					ExcelUtils.setExcelFile(
							API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename, "sheet1");
					ExcelUtils.ExcelWSheet.getRow(a).createCell(2).setCellValue(Initial_Premium_VALUE); // Initial
																										// Premium
					ExcelUtils.ExcelWSheet.getRow(a).createCell(3).setCellValue(Initial_COVA_VALUE); // Initial Coverage
																										// A
					ExcelUtils.ExcelWSheet.getRow(a).createCell(4).setCellValue(Initial_360_VALUE); // Initial 360Value
					ExcelUtils.ExcelWSheet.getRow(a).createCell(5).setCellValue(Updated_Premium_VALUE); // Updated
																										// Premium
					ExcelUtils.ExcelWSheet.getRow(a).createCell(6).setCellValue(Updated_COVA_VALUE); // Updated Coverage
																										// A
					ExcelUtils.ExcelWSheet.getRow(a).createCell(7).setCellValue(Updated_360_VALUE); // Updated 360 value
					ExcelUtils.ExcelWSheet.getRow(a).createCell(10).setCellValue("Task Skipped - No Change Required"); // Task
																														// -
																														// status
					ExcelUtils.ExcelWSheet.getRow(a).createCell(11).setCellValue(
							"Coverage A is less than Initial Coverage: No change processed. "); // comments
																																// to
																																// UW
					FileOutputStream fos = new FileOutputStream(
							API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename);
					ExcelWBook.write(fos);
					fos.close();

					driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]"))
							.click();
					Thread.sleep(5000);
				} else if (Updated_COVA_VALUE == Initial_COVA_VALUE) {

					System.out.println("AS UPDATED COVERAGE A IS EQUAL TO INITIAL COVERAGE A ---  NO CHANGES ARE MADE");
					// Assuming row 10 and cell 5 for this example
					ExcelUtils.setExcelFile(
							API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename, "sheet1");
					ExcelUtils.ExcelWSheet.getRow(a).createCell(2).setCellValue(Initial_Premium_VALUE); // Initial
																										// Premium
					ExcelUtils.ExcelWSheet.getRow(a).createCell(3).setCellValue(Initial_COVA_VALUE); // Initial Coverage
																										// A
					ExcelUtils.ExcelWSheet.getRow(a).createCell(4).setCellValue(Initial_360_VALUE); // Initial 360Value
					ExcelUtils.ExcelWSheet.getRow(a).createCell(5).setCellValue(Updated_Premium_VALUE); // Updated
																										// Premium
					ExcelUtils.ExcelWSheet.getRow(a).createCell(6).setCellValue(Updated_COVA_VALUE); // Updated Coverage
																										// A
					ExcelUtils.ExcelWSheet.getRow(a).createCell(7).setCellValue(Updated_360_VALUE); // Updated 360 value
					ExcelUtils.ExcelWSheet.getRow(a).createCell(10).setCellValue("Task Skipped - No Change Required"); // Task
																														// -
																														// status
					ExcelUtils.ExcelWSheet.getRow(a).createCell(11).setCellValue(
							"Coverage A is equal to Initial Coverage: No change processed. "); // comments
																											// to UW
					FileOutputStream fos = new FileOutputStream(
							API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename);
					ExcelWBook.write(fos);
					fos.close();

					driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]"))
							.click();
					Thread.sleep(5000);

				} else {

					double initial_CoverageA_VALUE_PERC = Initial_COVA_VALUE; 
					double updated_CoverageA_VALUE_PERC = Updated_COVA_VALUE; 

					int percent = returnPercentage(initial_CoverageA_VALUE_PERC, updated_CoverageA_VALUE_PERC);
					System.out.println("Percentage Value === " + percent + "%");

					driver.findElement(By.xpath("//span[text()='Submit Changes']")).click();
					Thread.sleep(5000);
			        WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds

			        // Wait for the element to be present
			        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name,'saveMidtermChangesAction|effectiveDate')]")));
			        Thread.sleep(1000);
					
					driver.findElement(By.xpath("//input[contains(@name,'saveMidtermChangesAction|effectiveDate')]"))
							.sendKeys(effectiveDate);
					Select dr = new Select(
							driver.findElement(By.xpath("//select[contains(@name,'saveMidtermChangesAction')]")));
					dr.selectByVisibleText("Update Coverage Selections");
					Thread.sleep(1000);

			        String companyInititedChange = "Is this a Company initiated change?";

			        if (pageSource.contains(companyInititedChange)) {
			        	WebElement companyIntended = driver.findElement(By.xpath("//*[@name='policyTerm|saveMidtermChangesAction|companyInitiatedChange' and @value='Y']"));
			        	companyIntended.click();
			        	Thread.sleep(1000);
			        	String premiumChange = driver.findElement(By.xpath(
								"//span[contains(@data-identifier,'policyTerm|saveMidtermChangesAction|premiumChange')]"))
								.getText();
						System.out.println("Premium Changes === " + premiumChange);
						driver.findElement(By.xpath("//button[@id='submit-save-midterm-changes-button']")).click();
						Thread.sleep(10000);
						System.out.println(
								"AS UPDATED COVERAGE A IS GREATER THEN INITIAL COVERAGE A ---CONTINUE TO CONFIRM CHANGES");
						// Assuming row 10 and cell 5 for this example
						ExcelUtils.setExcelFile(
								API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename, "sheet1");
						ExcelUtils.ExcelWSheet.getRow(a).createCell(2).setCellValue(Initial_Premium_VALUE); // Initial
																											// Premium
						ExcelUtils.ExcelWSheet.getRow(a).createCell(3).setCellValue(Initial_COVA_VALUE); // Initial Coverage
																											// A
						ExcelUtils.ExcelWSheet.getRow(a).createCell(4).setCellValue(Initial_360_VALUE); // Initial 360Value
						ExcelUtils.ExcelWSheet.getRow(a).createCell(5).setCellValue(Updated_Premium_VALUE); // Updated
																											// Premium
						ExcelUtils.ExcelWSheet.getRow(a).createCell(6).setCellValue(Updated_COVA_VALUE); // Updated Coverage
																											// A
						ExcelUtils.ExcelWSheet.getRow(a).createCell(7).setCellValue(Updated_360_VALUE); // Updated 360 value
						ExcelUtils.ExcelWSheet.getRow(a).createCell(8).setCellValue(percent); // Percentage Change (Updated
																								// premium vs Initial
																								// Premium)
						ExcelUtils.ExcelWSheet.getRow(a).createCell(9).setCellValue(premiumChange); // Premium difference
																								// (Updated premium vs
																									// Initial Premium)
						ExcelUtils.ExcelWSheet.getRow(a).createCell(10).setCellValue("Task Complete – Approved and Processed "); // Task
						ExcelUtils.ExcelWSheet.getRow(a).createCell(11)
                         .setCellValue("TASK COMPLETED ---- Percentage of Coverage A change  == " + percent+"%"); // comments
																														// to
																														// UW
						FileOutputStream fos = new FileOutputStream(
								API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename);
						ExcelWBook.write(fos);
						fos.close();
						Thread.sleep(5000);
						driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]"))
								.click();
						Thread.sleep(5000);
			        } else {
			           
					String premiumChange = driver.findElement(By.xpath(
							"//span[contains(@data-identifier,'policyTerm|saveMidtermChangesAction|premiumChange')]"))
							.getText();
					System.out.println("Premium Changes === " + premiumChange);
					driver.findElement(By.xpath("//button[@id='submit-save-midterm-changes-button']")).click();
					Thread.sleep(10000);
					System.out.println(
							"Task Complete – Approved and Processed ");
					
					if (percent > 50) {
					// Assuming row 10 and cell 5 for this example
					ExcelUtils.setExcelFile(
							API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename, "sheet1");
					ExcelUtils.ExcelWSheet.getRow(a).createCell(2).setCellValue(Initial_Premium_VALUE); // Initial
																										// Premium
					ExcelUtils.ExcelWSheet.getRow(a).createCell(3).setCellValue(Initial_COVA_VALUE); // Initial Coverage
																										// A
					ExcelUtils.ExcelWSheet.getRow(a).createCell(4).setCellValue(Initial_360_VALUE); // Initial 360Value
					ExcelUtils.ExcelWSheet.getRow(a).createCell(5).setCellValue(Updated_Premium_VALUE); // Updated
																										// Premium
					ExcelUtils.ExcelWSheet.getRow(a).createCell(6).setCellValue(Updated_COVA_VALUE); // Updated Coverage
																										// A
					ExcelUtils.ExcelWSheet.getRow(a).createCell(7).setCellValue(Updated_360_VALUE); // Updated 360 value
					ExcelUtils.ExcelWSheet.getRow(a).createCell(8).setCellValue(percent); // Percentage Change (Updated
																							// premium vs Initial
																							// Premium)
					ExcelUtils.ExcelWSheet.getRow(a).createCell(9).setCellValue(premiumChange); // Premium difference
																								// (Updated premium vs
																								// Initial Premium)
					ExcelUtils.ExcelWSheet.getRow(a).createCell(10).setCellValue("Task Complete – UW Review Required "); // Task
																														// -
																														// status
					ExcelUtils.ExcelWSheet.getRow(a).createCell(11)
							.setCellValue("TASK COMPLETED ---- Percentage of Coverage A change  == " + percent+"%"); // comments
																													// to
																													// UW
					FileOutputStream fos = new FileOutputStream(
							API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename);
					ExcelWBook.write(fos);
					fos.close();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]"))
							.click();
					Thread.sleep(5000);
				} else {
					ExcelUtils.setExcelFile(
							API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename, "sheet1");
					ExcelUtils.ExcelWSheet.getRow(a).createCell(2).setCellValue(Initial_Premium_VALUE); // Initial
																										// Premium
					ExcelUtils.ExcelWSheet.getRow(a).createCell(3).setCellValue(Initial_COVA_VALUE); // Initial Coverage
																										// A
					ExcelUtils.ExcelWSheet.getRow(a).createCell(4).setCellValue(Initial_360_VALUE); // Initial 360Value
					ExcelUtils.ExcelWSheet.getRow(a).createCell(5).setCellValue(Updated_Premium_VALUE); // Updated
																										// Premium
					ExcelUtils.ExcelWSheet.getRow(a).createCell(6).setCellValue(Updated_COVA_VALUE); // Updated Coverage
																										// A
					ExcelUtils.ExcelWSheet.getRow(a).createCell(7).setCellValue(Updated_360_VALUE); // Updated 360 value
					ExcelUtils.ExcelWSheet.getRow(a).createCell(8).setCellValue(percent); // Percentage Change (Updated
																							// premium vs Initial
																							// Premium)
					ExcelUtils.ExcelWSheet.getRow(a).createCell(9).setCellValue(premiumChange); // Premium difference
																								// (Updated premium vs
																								// Initial Premium)
					ExcelUtils.ExcelWSheet.getRow(a).createCell(10).setCellValue("Task Complete – Approved and Processed "); // Task
																														// -
																														// status
					ExcelUtils.ExcelWSheet.getRow(a).createCell(11)
							.setCellValue("TASK COMPLETED ---- Percentage of Coverage A change  == " + percent+"%"); // comments
																													// to
																													// UW
					FileOutputStream fos = new FileOutputStream(
							API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename);
					ExcelWBook.write(fos);
					fos.close();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]"))
							.click();
					Thread.sleep(5000);
				}
			        }

			}
			}
			}
		}

	}

//	public static int returnPercentage(int actualCov, int updatedCov) {
//		int fin = ((updatedCov - actualCov)/updatedCov)*100;
//		return fin;
//		
//	}

	public static int returnPercentage(double initial, double updated) {
		if (initial == 0) {
			if (updated == 0) {
				return 0; // Handle the case when both values are zero.
			} else {
				return 100; // Handle the case when the initial value is zero but the updated value is not.
			}
		}

		double percentageChange = ((updated - initial) / Math.abs(initial)) * 100;
		return (int) Math.round(percentageChange);
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
