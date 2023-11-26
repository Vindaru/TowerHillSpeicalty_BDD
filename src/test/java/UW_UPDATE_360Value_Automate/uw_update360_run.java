package UW_UPDATE_360Value_Automate;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bdd.variables.API_Constant_Values;
import com.ths.actiondriver.ExcelUtility;
import pageObjects.HomePage;
import utilities.ExcelUtils;

public class uw_update360_run {
	public static void main(String[] args) throws Exception {
		WebDriver driver = initializeDriver();
		ExcelUtils.setExcelFile(API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename,
				"sheet1");

		for (int row = 2; row <= ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); row++) {
			int rowCount = ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println("Total Number of Rows in today run ==  " + rowCount);
			System.out.println("Current row number == " + row);
			String policyNumber = ExcelUtils.getCellData(row, 1); // (row,cell)
			performPolicyUpdate(driver, policyNumber, row);
		}
		System.out.println("Loop completed.");

		// driver.quit();
	}

	private static WebDriver initializeDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vdaru\\OneDrive - Tower Hill Insurance Group, LLC\\Desktop\\Automation\\Selenium\\sel-cucumber\\External Resources\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://oasis.red.thig.com"); // https://oasis.thig.com
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed - 10sec
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputGroupID")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.id("inputGroupID")).clear();
		driver.findElement(By.id("inputGroupID")).sendKeys("TS0A00"); // THIG
		Thread.sleep(1000);
		driver.findElement(By.id("inputUserName")).clear();
		driver.findElement(By.id("inputUserName")).sendKeys("Vdaru"); // THSAUTOMATION
		Thread.sleep(1000);
		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys("1Password"); // Gr33ndogs
		Thread.sleep(1000);
		driver.findElement(By.id("authSubmit")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='application-container']/div[2]/div/div/div/form/button")));
		driver.findElement(By.xpath("//*[@id='application-container']/div[2]/div/div/div/form/button")).click();
		Thread.sleep(1000);
		String disconnectSession = "Disconnect Session";
		String pageSource = driver.getPageSource();

		if (pageSource.contains(disconnectSession)) {
			List<WebElement> submitElements = driver.findElements(By.xpath("//*[@id='submit']"));
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
		return driver;
	}

	private static void performPolicyUpdate(WebDriver driver, String policyNumber, int row) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.id("quote-list-filter-policy-num")).clear();
		driver.findElement(By.id("quote-list-filter-policy-num")).sendKeys(policyNumber);
		Thread.sleep(1000);
		System.out.println("Policy Number - " + policyNumber);
		driver.findElement(By.id("quote-list-filter-submit")).click();
		Thread.sleep(2000);
		String Policy_Status_1 = driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[1]/td[8]"))
				.getText();
		String Policy_Status_2 = driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[3]/td[8]"))
				.getText();
		System.out.println("The status of the First policy Image   " + policyNumber + "   is == " + Policy_Status_1);
		System.out.println("The status of the Second policy Image   " + policyNumber + "   is == " + Policy_Status_2);
		if (Policy_Status_1.equals("RENEWAL")) {
			driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[1]/td[5]")).click();
			System.out.println("Clicked on   " + policyNumber + "with Status as == " + Policy_Status_1);
		} else if (Policy_Status_2.equals("RENEWAL")) {
			driver.findElement(By.xpath("//*[@id='quote-list']/table/tbody/tr[3]/td[5]")).click();
			System.out.println("Clicked on   " + policyNumber + "with Status as == " + Policy_Status_2);
		}
		Thread.sleep(2000);
		if (isPendingChanges(driver)) {
			handlePendingChanges(driver, row);
		} else {
			updatePolicy(driver, policyNumber, row);

		}
	}

	private static void updatePolicy(WebDriver driver, String policyNumber, int row) throws Exception {
		String initial_Premium = driver.findElement(By.xpath("//*[@id='memos']/div/div/h4[1]/span[2]/span")).getText();
		String initial_Coverage_A = driver.findElement(By.name("policyTerm|coverages|coverageA")).getAttribute("value");
		String initial_360Value = driver.findElement(By.name("policyTerm|coverages|replacementCostEstimate"))
				.getAttribute("value");
		System.out.println("Values Captured initial_Premium  = " + initial_Premium);
		System.out.println("Values Captured initial_Coverage_A  = " + initial_Coverage_A);
		System.out.println("Values Captured initial_360Value  = " + initial_360Value);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space(text())='Update 360Value']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn rate-button')]")).click();
		Thread.sleep(3000);
		String updated_Premium = driver.findElement(By.xpath("//*[@id='memos']/div/div/h4[1]/span[2]/span")).getText();
		String updated_Coverage_A = driver.findElement(By.name("policyTerm|coverages|coverageA")).getAttribute("value");
		String updated_360Value = driver.findElement(By.name("policyTerm|coverages|replacementCostEstimate"))
				.getAttribute("value");

		System.out.println("Values Captured updated_Coverage_A  = " + updated_Coverage_A);
		System.out.println("Values Captured updated_360Value  = " + updated_360Value);
		System.out.println("Values Captured updated_Premium  = " + updated_Premium);
		Thread.sleep(2000);

		boolean isUpdated_CoverageA_Less_then_Initial_CoverageA = isUpdateCoverageALessThanInitialCoverageA(
				updated_Coverage_A, initial_Coverage_A);
		boolean isUpdated_CoverageA_Same_As_Initial_CoverageA = isUpdatedCoverageASameAsInitialCoverageA(
				updated_Coverage_A, initial_Coverage_A);
		boolean isUpdated_CoverageA_greater_then_InitialCoverageA = isUpdateCoverageAGreaterThenInitialCoverageA(
				updated_Coverage_A, initial_Coverage_A);

		if (isUpdated_CoverageA_Less_then_Initial_CoverageA) {
			System.out.println("NO CHANGES WILL BE MADE -- due to decrease in Coveage A");
			handle_UpdateCoverageA_less_then_InitialCoverageA(driver, row, initial_Premium, initial_Coverage_A,
					initial_360Value, updated_Premium, updated_Coverage_A, updated_360Value);
		} else if (isUpdated_CoverageA_Same_As_Initial_CoverageA) {
			System.out.println("NO CHANGES WILL BE MADE -- due to no change in Coveage A ");
			handle_UpdateCoverageA_Same_as_InitialCoverageA(driver, row, initial_Premium, initial_Coverage_A,
					initial_360Value, updated_Premium, updated_Coverage_A, updated_360Value);
		} else if (isUpdated_CoverageA_greater_then_InitialCoverageA) {
			System.out.println(
					"Continue to make changes to the policy as Updated Coverage A is greater then Initial Coverage A");
			handle_UpdateCoverageA_greater_then_InitialCoverageA(driver, row, initial_Premium, initial_Coverage_A,
					initial_360Value, updated_Premium, updated_Coverage_A, updated_360Value );
		}
		saveExcelAndClose(driver, row);
	}

	private static boolean isPendingChanges(WebDriver driver) {
		String pendingChanges = "Changes not allowed due to pending change on";
		String pageSource = driver.getPageSource();
		return pageSource.contains(pendingChanges);
	}

	private static void handlePendingChanges(WebDriver driver, int row) throws Exception {
		String errorMessage = "Error: Changes not allowed due to pending change";
		System.out.println("Error displaying : " + errorMessage);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(10).setCellValue("Task Skipped – UW Review Required ");
		ExcelUtils.ExcelWSheet.getRow(row).createCell(11).setCellValue("Pending Change: No change processed. ");
		saveExcelAndClose(driver, row);
	}

	public static boolean isUpdateCoverageALessThanInitialCoverageA(String updatedCOVAValue, String initialCOVAValue) {

		updatedCOVAValue = updatedCOVAValue.replace(",", "");
		initialCOVAValue = initialCOVAValue.replace(",", "");
		System.out.println("Updated Coverage A is less then Initial Coverage A");
		int updatedValue = Integer.parseInt(updatedCOVAValue);
		int initialValue = Integer.parseInt(initialCOVAValue);

		return updatedValue < initialValue;
	}

	private static void handle_UpdateCoverageA_less_then_InitialCoverageA(WebDriver driver, int row,
			String Initial_Premium_VALUE, String Initial_COVA_VALUE, String Initial_360_VALUE,
			String Updated_Premium_VALUE, String Updated_COVA_VALUE, String Updated_360_VALUE) throws Exception {
		ExcelUtils.setExcelFile(API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename,
				"sheet1");
		ExcelUtils.ExcelWSheet.getRow(row).createCell(2).setCellValue(Initial_Premium_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(3).setCellValue(Initial_COVA_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(4).setCellValue(Initial_360_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(5).setCellValue(Updated_Premium_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(6).setCellValue(Updated_COVA_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(7).setCellValue(Updated_360_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(8).setCellValue("-");
		ExcelUtils.ExcelWSheet.getRow(row).createCell(9).setCellValue("-");
		ExcelUtils.ExcelWSheet.getRow(row).createCell(10).setCellValue("Task Skipped - No Change Required");
		ExcelUtils.ExcelWSheet.getRow(row).createCell(11)
				.setCellValue("Coverage A is less than Initial Coverage: No change processed. ");
	}

	public static boolean isUpdatedCoverageASameAsInitialCoverageA(String updatedCOVAValue, String initialCOVAValue) {
		updatedCOVAValue = updatedCOVAValue.replace(",", "");
		initialCOVAValue = initialCOVAValue.replace(",", "");
		System.out.println("Updated Coverage A is same as Initial Coverage A");
		int updatedValue = Integer.parseInt(updatedCOVAValue);
		int initialValue = Integer.parseInt(initialCOVAValue);

		return updatedValue == initialValue;
	}

	private static void handle_UpdateCoverageA_Same_as_InitialCoverageA(WebDriver driver, int row,
			String Initial_Premium_VALUE, String Initial_COVA_VALUE, String Initial_360_VALUE,
			String Updated_Premium_VALUE, String Updated_COVA_VALUE, String Updated_360_VALUE) throws Exception {
		ExcelUtils.setExcelFile(API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename,
				"sheet1");
		ExcelUtils.ExcelWSheet.getRow(row).createCell(2).setCellValue(Initial_Premium_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(3).setCellValue(Initial_COVA_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(4).setCellValue(Initial_360_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(5).setCellValue(Updated_Premium_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(6).setCellValue(Updated_COVA_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(7).setCellValue(Updated_360_VALUE);
		ExcelUtils.ExcelWSheet.getRow(row).createCell(8).setCellValue("-");
		ExcelUtils.ExcelWSheet.getRow(row).createCell(9).setCellValue("-");
		ExcelUtils.ExcelWSheet.getRow(row).createCell(10).setCellValue("Task Skipped - No Change Made");
		ExcelUtils.ExcelWSheet.getRow(row).createCell(11)
				.setCellValue("UpdatedCoverage A same as Initial Coverage : No change processed. ");
	}

	public static boolean isUpdateCoverageAGreaterThenInitialCoverageA(String updatedCOVAValue,
			String initialCOVAValue) {
		updatedCOVAValue = updatedCOVAValue.replace(",", "");
		initialCOVAValue = initialCOVAValue.replace(",", "");
		System.out.println("Updated Coverage A is less then Initial Coverage A");
		int updatedValue = Integer.parseInt(updatedCOVAValue);
		int initialValue = Integer.parseInt(initialCOVAValue);

		return updatedValue > initialValue;
	}

	private static void handle_UpdateCoverageA_greater_then_InitialCoverageA(WebDriver driver, int row,
			String Initial_Premium_VALUE, String Initial_COVA_VALUE, String Initial_360_VALUE,
			String Updated_Premium_VALUE, String Updated_COVA_VALUE, String Updated_360_VALUE) throws Exception {

		Thread.sleep(1000);
		String effectiveDate = driver.findElement(By.name("policyTerm|effectiveDate")).getAttribute("value");
		Thread.sleep(1000);

		int initialCOVAValue = Integer.parseInt(Initial_COVA_VALUE);
		int updatedCOVAValue = Integer.parseInt(Updated_COVA_VALUE);
		double percentChange = calculatePercentageChange(initialCOVAValue, updatedCOVAValue);
		System.out.println("Percentage Change: " + percentChange + "%");

		driver.findElement(By.xpath("//span[text()='Submit Changes']")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//input[contains(@name,'saveMidtermChangesAction|effectiveDate')]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@name,'saveMidtermChangesAction|effectiveDate')]"))
				.sendKeys(effectiveDate);
		Select dr = new Select(driver.findElement(By.xpath("//select[contains(@name,'saveMidtermChangesAction')]")));
		dr.selectByVisibleText("Update Coverage Selections");
		Thread.sleep(1000);

		String companyInititedChange = "Is this a Company initiated change?";
		String pageSource = driver.getPageSource();
		if (pageSource.contains(companyInititedChange)) {
			WebElement companyIntended = driver.findElement(
					By.xpath("//*[@name='policyTerm|saveMidtermChangesAction|companyInitiatedChange' and @value='Y']"));
			companyIntended.click();
			Thread.sleep(1000);
			String premiumChange = driver
					.findElement(By.xpath(
							"//span[contains(@data-identifier,'policyTerm|saveMidtermChangesAction|premiumChange')]"))
					.getText();
			System.out.println("Premium Changes === " + premiumChange);
			driver.findElement(By.xpath("//button[@id='submit-save-midterm-changes-button']")).click();
			Thread.sleep(10000);

			if (percentChange > 50) {
				ExcelUtils.setExcelFile(API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename,
						"sheet1");
				ExcelUtils.ExcelWSheet.getRow(row).createCell(2).setCellValue(Initial_Premium_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(3).setCellValue(Initial_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(4).setCellValue(Initial_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(5).setCellValue(Updated_Premium_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(6).setCellValue(Updated_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(7).setCellValue(Updated_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(6).setCellValue(Updated_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(7).setCellValue(Updated_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(8).setCellValue(percentChange);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(9).setCellValue(premiumChange);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(10).setCellValue("Task Complete – UW Review Required");
				ExcelUtils.ExcelWSheet.getRow(row).createCell(11).setCellValue(
						"TASK COMPLETED ---- Percentage of Coverage A change  ==  " + percentChange + "%");
			} else {
				ExcelUtils.setExcelFile(API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename,
						"sheet1");
				ExcelUtils.ExcelWSheet.getRow(row).createCell(2).setCellValue(Initial_Premium_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(3).setCellValue(Initial_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(4).setCellValue(Initial_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(5).setCellValue(Updated_Premium_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(6).setCellValue(Updated_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(7).setCellValue(Updated_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(6).setCellValue(Updated_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(7).setCellValue(Updated_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(8).setCellValue(percentChange);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(9).setCellValue(premiumChange);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(10)
						.setCellValue("Task Complete – Approved and Processed ");
				ExcelUtils.ExcelWSheet.getRow(row).createCell(11).setCellValue(
						"TASK COMPLETED ---- Percentage of Coverage A change  ==  " + percentChange + "%");

			}
		} else {
			String premiumChange = driver
					.findElement(By.xpath(
							"//span[contains(@data-identifier,'policyTerm|saveMidtermChangesAction|premiumChange')]"))
					.getText();
			System.out.println("Premium Changes === " + premiumChange);
			driver.findElement(By.xpath("//button[@id='submit-save-midterm-changes-button']")).click();
			Thread.sleep(10000);
			System.out.println("Task Complete – Approved and Processed ");
			if (percentChange > 50) {
				ExcelUtils.setExcelFile(API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename,
						"sheet1");
				ExcelUtils.ExcelWSheet.getRow(row).createCell(2).setCellValue(Initial_Premium_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(3).setCellValue(Initial_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(4).setCellValue(Initial_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(5).setCellValue(Updated_Premium_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(6).setCellValue(Updated_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(7).setCellValue(Updated_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(6).setCellValue(Updated_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(7).setCellValue(Updated_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(8).setCellValue(percentChange);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(9).setCellValue(premiumChange);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(10).setCellValue("Task Complete – UW Review Required");
				ExcelUtils.ExcelWSheet.getRow(row).createCell(11).setCellValue(
						"TASK COMPLETED ---- Percentage of Coverage A change  ==  " + percentChange + "%");
			} else {
				ExcelUtils.setExcelFile(API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename,
						"sheet1");
				ExcelUtils.ExcelWSheet.getRow(row).createCell(2).setCellValue(Initial_Premium_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(3).setCellValue(Initial_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(4).setCellValue(Initial_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(5).setCellValue(Updated_Premium_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(6).setCellValue(Updated_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(7).setCellValue(Updated_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(6).setCellValue(Updated_COVA_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(7).setCellValue(Updated_360_VALUE);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(8).setCellValue(percentChange);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(9).setCellValue(premiumChange);
				ExcelUtils.ExcelWSheet.getRow(row).createCell(10)
						.setCellValue("Task Complete – Approved and Processed ");
				ExcelUtils.ExcelWSheet.getRow(row).createCell(11).setCellValue(
						"TASK COMPLETED ---- Percentage of Coverage A change  ==  " + percentChange + "%");
			}
		}
	}

	private static void saveExcelAndClose(WebDriver driver, int row) throws Exception {
		FileOutputStream fos = new FileOutputStream(
				API_Constant_Values.update360_testpath + API_Constant_Values.upate360_filename);
		ExcelUtils.ExcelWBook.write(fos);
		fos.close();
		driver.findElement(By.xpath("//button[contains(@class, 'ember-view btn thig-btn cancel-button')]")).click();
		System.out.println("Policy is exited");
		Thread.sleep(5000);
	}

	private static double calculatePercentageChange(int initialValue, int updatedValue) {
		if (initialValue == 0) {
			return 0.0;
		}
		return ((double) (updatedValue - initialValue) / initialValue) * 100.0;
	}
}
