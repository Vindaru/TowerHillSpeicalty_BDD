/**
 * 
 */
package com.ths.actiondriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.THS_States_Utils;

public class CoverageValidator_coverageA {
	static WebDriver driver = null;
	private Action action;
	// Define all the boolean variables as class members to be accessible in all the
	// methods
	boolean isStateValueCW;
	boolean isPolicyD1;
	boolean isPolicyD3;
	boolean isPolicyH3;
	boolean isPolicyH4;
	boolean isPolicyH6;
	boolean isPolicyH1;
	boolean isPolicyMH;
	boolean isOccupancyValueOwner;
	boolean isOccupancyValueSeasonal;
	boolean isOccupancyValueRental;
	boolean isOccupancyValueVacant;
	boolean isOccupancyValueNotAResidence;

	public void readData() {
		WebElement stateSelected = driver.findElement(By.xpath("//*[@name='policyTerm|location|address|state']"));
		WebElement policyFormSelected = driver.findElement(By.xpath("//*[@name='policyTerm|policyForm']"));
		WebElement occupancySelected = driver.findElement(By.xpath("//*[@name='policyTerm|location|occupancy']"));

		Select select = new Select(stateSelected);
		WebElement selectedOption = select.getFirstSelectedOption();
		String statevalue = selectedOption.getText();

		Select select1 = new Select(policyFormSelected);
		WebElement selectedOption1 = select1.getFirstSelectedOption();
		String policyFormValue = selectedOption1.getText();

		Select select2 = new Select(occupancySelected);
		WebElement selectedOption2 = select2.getFirstSelectedOption();
		String occupancyValue = selectedOption2.getText();

		System.out.println("Get value selected statevalue =  " + statevalue);
		System.out.println("Get value selected policyFormValue =  " + policyFormValue);
		System.out.println("Get value selected occupancyValue =  " + occupancyValue);

		// ... other parts of your code

		isStateValueCW = statevalue.equals("Ohio") || statevalue.equals("Wisconsin") || statevalue.equals("Indiana")
				|| statevalue.equals("Missouri") || statevalue.equals("Alabama") || statevalue.equals("Arizona")
				|| statevalue.equals("South Carolina") || statevalue.equals("Arkansas") || statevalue.equals("TN")
				|| statevalue.equals("Louisiana") || statevalue.equals("Georgia") || statevalue.equals("Mississippi")
				|| statevalue.equals("Illinois");
		isPolicyD1 = policyFormValue.equals("DP-1");
		isPolicyD3 = policyFormValue.equals("DP-3");
		isPolicyH3 = policyFormValue.equals("HO-3");
		isPolicyH4 = policyFormValue.equals("HO-4");
		isPolicyH6 = policyFormValue.equals("HO-6");
		isPolicyMH = policyFormValue.equals("MH");
		isPolicyH1 = policyFormValue.equals("HO-1");
		isOccupancyValueOwner = occupancyValue.equals("Owner");
		isOccupancyValueSeasonal = occupancyValue.equals("Seasonal");
		isOccupancyValueVacant = occupancyValue.equals("Vacant");
		isOccupancyValueRental = occupancyValue.equals("Rental");
		isOccupancyValueNotAResidence = occupancyValue.equals("Not A Residence");
		
		isStateValueCW = THS_States_Utils.getShortForm(statevalue) != null || 
				THS_States_Utils.getFullName(statevalue) != null;
	}

	public void checkDwellingCoverage(int dwellingCoverage, int min, int max) throws Exception {
		if (dwellingCoverage < min || dwellingCoverage > max) {
			throw new Exception("Dwelling coverage is invalid = can not be more then " + max + " or less then " + min);
		}
	}

	public void validatePolicyD1(int dwellingCoverage) throws Exception {
		if (isOccupancyValueOwner || isOccupancyValueRental) {
			checkDwellingCoverage(dwellingCoverage, 20000, 500000);
		} else if (isOccupancyValueSeasonal || isOccupancyValueNotAResidence) {
			checkDwellingCoverage(dwellingCoverage, 5000, 500000);
		} else if (isOccupancyValueVacant) {
			checkDwellingCoverage(dwellingCoverage, 5000, 1000000);
		} 
	}

	public void validatePolicyD3(int dwellingCoverage) throws Exception {
		if (isOccupancyValueOwner) {
			checkDwellingCoverage(dwellingCoverage, 75000, 500000);
		} else if (isOccupancyValueSeasonal || isOccupancyValueVacant) {
			checkDwellingCoverage(dwellingCoverage, 75000, 1000000);
		} else if (isOccupancyValueRental) {
			checkDwellingCoverage(dwellingCoverage, 75000, 750000);
		}

	}

	public void validatePolicyH3(int dwellingCoverage, int otherStructuresCoverage, int personalPropertiesCoverage)
			throws Exception {
		if (isOccupancyValueOwner || isOccupancyValueSeasonal) {
			checkDwellingCoverage(dwellingCoverage, 150000, 750000);
		}
	}

	public void validatePolicyH6(int dwellingCoverage, int otherStructuresCoverage, int personalPropertiesCoverage)
			throws Exception {
		if (isOccupancyValueOwner || isOccupancyValueSeasonal || isOccupancyValueRental) {
			checkDwellingCoverage(dwellingCoverage, 5000, 500000);
		}

	}

	public void validatePolicyMC(int dwellingCoverage, int otherStructuresCoverage, int personalPropertiesCoverage)
			throws Exception {
		if (isOccupancyValueOwner || isOccupancyValueSeasonal || isOccupancyValueRental) {
			checkDwellingCoverage(dwellingCoverage, 5000, 300000);
		}

	}

	public void validatePolicyH1(int dwellingCoverage, int otherStructuresCoverage, int personalPropertiesCoverage)
			throws Exception {
		if (isOccupancyValueOwner || isOccupancyValueSeasonal) {
			checkDwellingCoverage(dwellingCoverage, 150000, 750000);
		}


	}

	public void validatePolicies(int dwellingCoverage, String ObjectName, String Value) throws Exception {
		if (isStateValueCW && isPolicyD1) {
			validatePolicyD1(dwellingCoverage);
			action = new Action(driver);
			action.type(ObjectName, Value);
			System.out.println("Processed dwellingCoverage: " + dwellingCoverage);
		}

	}

	public CoverageValidator_coverageA(WebDriver driver) {
		CoverageValidator_coverageA.driver = driver;
	}
}
