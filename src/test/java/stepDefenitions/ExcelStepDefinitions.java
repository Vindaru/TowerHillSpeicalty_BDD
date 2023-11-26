package stepDefenitions;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.ths.actiondriver.Action;
import com.ths.actiondriver.CoverageValidator_coverageA;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import com.ths.actiondriver.*;

import pageObjects.WebDriverManager;

public class ExcelStepDefinitions extends BasePage {
	private static String storedPolicyNumber; // to store the policy numbers
	public static Properties properties;
	public static WebDriver driver;
	private WebDriverManager driverManager;
	private int priority;
	private Action action;
	private Scenario scenario;
	private CoverageValidator_coverageA CoverageValidation;

	private Workbook workbook;
	private Sheet sheet;

	@Given("^.*getPolicyNumbersFromExcel$")
	public void getPolicyNumbersFromExcel() throws IOException {
		action = new Action(driver);
		List<String> policyNumbersList = new ArrayList<>();
		String excelpath = "C:\\Users\\vdaru\\OneDrive - Tower Hill Insurance Group, LLC\\Desktop\\UW_UPDATE_RENWAL ENG\\REN_UPDATE_360Value.xlsx";
		FileInputStream fis = new FileInputStream(new File(excelpath));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

		int startingRowIndex = 1; // to start from the second row
		int endingRowIndex = sheet.getLastRowNum();
		; // specify n, the last row index you want to read

		for (int rowIndex = startingRowIndex; rowIndex <= endingRowIndex; rowIndex++) {
			Row row = sheet.getRow(rowIndex);
			if (row != null) {
				Cell cell = row.getCell(0); // fetching from column 0
				if (cell != null) {
					policyNumbersList.add(cell.toString().trim());
				}
			}
		}

		workbook.close();
		fis.close();

		// Convert the List of policy numbers to a single string (comma separated)
		storedPolicyNumber = String.join(",", policyNumbersList);
		System.out.println("List of Policies = " + storedPolicyNumber);
	}

	@Then("^.*userEntersPolicyNumberEXCEL$")
	public void userEntersPolicyNumber(DataTable table) throws Exception {
		action = new Action(driver);

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

	public String getValueFromExcelByColumnName(String excelFileName, String sheetName, int rowNum, String columnName)
			throws IOException {
		FileInputStream fis = new FileInputStream(new File(excelFileName));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row headerRow = sheet.getRow(0);
		int columnNum = 0;
		for (Cell cell : headerRow) {
			if (cell.getStringCellValue().trim().equals(columnName)) {
				columnNum = cell.getColumnIndex();
				break;
			}
		}
		if (columnNum == -1) {
			workbook.close();
			fis.close();
			return null; // Column not found
		}

		Row row = sheet.getRow(rowNum);
		if (row == null) {
			workbook.close();
			fis.close();
			return null; // Row not found
		}

		Cell cell = row.getCell(columnNum);
		if (cell == null) {
			workbook.close();
			fis.close();
			return null; // Cell not found
		}

		String value = cell.getStringCellValue();
		workbook.close();
		fis.close();
		return value;
	}

	public int getNumberOfRows(String excelFileName, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(new File(excelFileName));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int numRows = sheet.getPhysicalNumberOfRows();
		workbook.close();
		fis.close();
		return numRows;
	}
	
	public void Action(WebDriver driver) {
	    this.driver = driver;
	}

}
