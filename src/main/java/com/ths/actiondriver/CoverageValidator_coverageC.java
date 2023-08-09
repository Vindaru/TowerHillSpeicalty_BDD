/**
 * 
 */
package com.ths.actiondriver;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CoverageValidator_coverageC {
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

		String covA_Value = driver.findElement(By.xpath("//*[@name='policyTerm|coverages|coverageA']")).getText();
		System.out.println("coverageA Value =   " + covA_Value);

		System.out.println("Get value selected statevalue =  " + statevalue);
		System.out.println("Get value selected policyFormValue =  " + policyFormValue);
		System.out.println("Get value selected occupancyValue =  " + occupancyValue);

		// ... other parts of your code
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
		isStateValueCW = statevalue.equals("Ohio") || statevalue.equals("Wisconsin") || statevalue.equals("Indiana")
				|| statevalue.equals("Missouri") || statevalue.equals("Alabama") || statevalue.equals("Arizona")
				|| statevalue.equals("South Carolina") || statevalue.equals("Arkansas")
				|| statevalue.equals("Tennessee") || statevalue.equals("Louisiana") || statevalue.equals("Georgia")
				|| statevalue.equals("Mississippi") || statevalue.equals("Michigan")
				|| statevalue.equals("North Carolina") || statevalue.equals("Texas") || statevalue.equals("Illinois");
	}

	public void validatePolicy(int personalPropertiesCoverage) throws Exception {
		// Fetch the Coverage A value from the web page
		String covA_Value = driver.findElement(By.xpath("//*[@name='policyTerm|coverages|coverageA']"))
				.getAttribute("value");
		covA_Value = covA_Value.replace(",", "");
		int covA_Valueint = Integer.parseInt(covA_Value);

		WebElement CovC_Click = driver.findElement(By.xpath("//*[@name='policyTerm|coverages|coverageC']"));
		CovC_Click.click();
		Thread.sleep(1000);
		String covC_Default_Value = driver.findElement(By.xpath("//*[@name='policyTerm|coverages|coverageC']"))
				.getAttribute("value");
		covC_Default_Value = covC_Default_Value.replace(",", "");
		Thread.sleep(1000);
		// covC_Defaultint = Integer.parseInt(covC_Default_Value);
		int covC_Defaultint;
		try {
			if (covC_Default_Value != null && !covC_Default_Value.trim().isEmpty()) {
				covC_Defaultint = Integer.parseInt(covC_Default_Value);
			} else {
				covC_Defaultint = 0;
			}
		} catch (NumberFormatException e) {
			covC_Defaultint = 0;
		}
		System.out.println("Value of Cov C - " + covC_Defaultint);
		// List of exempted states for specific default values
		List<String> HO3_DefaultToZeroStates = Arrays.asList("South Carolina", "Mississippi", "Michigan", "Tennessee",
				"Louisiana");
		List<String> statesForH1 = Arrays.asList("Texas", "South Carolina", "Mississippi", "Louisiana");
		// List<String> HO3_DefaultToZeroStates = Arrays.asList("SC", "MS", "MI", "TN",
		// "LA");

		String product = "DP-1, DP-3, MH, HO-3, HO-1, HO-4, HO-6";
		String state = "Alabama, Arizona, Arkansas, Georgia, Illinois, Indiana, Mississippi, Missouri, Michigan, "
				+ "Tennessee, North Carolina, South Carolina, Ohio, Texas, Wisconsin, Louisiana";

		int covA = covA_Valueint;
		int covC_10 = (int) Math.round(covA_Valueint * 0.10);
		int covC_40 = (int) Math.round(covA_Valueint * 0.2);
		int covC_30 = (int) Math.round(covA_Valueint * 0.30);
		int covC_50 = (int) Math.round(covA_Valueint * 0.50);

		if (product.contains("DP-1") || product.contains("DP-3") || product.contains("HO-4") || product.contains("HO-6")
				|| product.contains("HO-1") || product.contains("HO-3")) {
			if (HO3_DefaultToZeroStates.contains(state) && product.contains("HO-3")) {
				if (covC_Defaultint > covC_50) {
					throw new Exception(
							"Default value for PersonalProperty H3 in " + state + " should be 50% of Coverage A.");
				} else if (covC_Defaultint > covC_50) {
					throw new Exception(
							"Default value for PersonalProperty H3 in " + state + " should be 50% of Coverage A.");
				}
			} else if (statesForH1.contains(state) && product.contains("HO-1")) {
				if (covC_Defaultint != covC_40) {
					throw new Exception(
							"Default value for H1-PersonalProperty in " + state + " should be 40% of Coverage A.");
				}
			} else if (covC_Defaultint != 0) {
				System.out.println("value of this2---" + (covC_Defaultint != (2 * covA_Valueint / 100)));
				throw new Exception("Default value for H1 in " + state + " should be 10% of Coverage A.");
			}
		}

		if (product.contains("DP-1") || product.contains("DP-3")) {
			if (personalPropertiesCoverage < 0) {
				throw new Exception("Min value for DP1/DP3 in " + state + " should be greater than 0");
			}
		} else if (product.contains("HO-3")) {
			if (HO3_DefaultToZeroStates.contains(state) && personalPropertiesCoverage < 0) {
				throw new Exception("Min value for PersonalProperty H3 in " + state + " should be greater than 0");
			} else if (!HO3_DefaultToZeroStates.contains(state) && covC_Defaultint < covC_50) {
				throw new Exception("Min value for PersonalProperty H3 in " + state + " should be 50% of Coverage A.");
			}
		} else if (product.contains("HO-1") && statesForH1.contains(state) && personalPropertiesCoverage < 0) {
			throw new Exception("Min value for H1-PersonalProperty in " + state + " should be greater than 0");
		} else if (product.contains("HO-6") && covC_Defaultint < 5000) {
			throw new Exception("Min value for H6-PersonalProperty in " + state + " should be greater than 5000");
		}

		// Maximum value checks
		if (product.contains("DP-1")) {
			if (product.contains("DP-1") && isOccupancyValueNotAResidence) {
				if (personalPropertiesCoverage > 10000) {
					throw new Exception(
							"Max value for DP1 in " + state + " when not a residence should not exceed 10,000");
				}
			} else if (personalPropertiesCoverage > covA) {
				throw new Exception("Max value for DP1 in " + state + " should not exceed 100% of Coverage A");
			}
		} else if (product.contains("DP-3") || product.contains("HO-3") || product.contains("HO-1")) {
			if (personalPropertiesCoverage > covA) {
				throw new Exception(
						"Max value for " + product + " in " + state + " should not exceed 100% of Coverage A");
			}
		} else if (product.contains("HO-4") && personalPropertiesCoverage > 500000) {
			throw new Exception("Max value for HO-4 PersonalProperty in " + state + " should not exceed 500,000");
		} else if (product.contains("HO-6") && personalPropertiesCoverage > 500000) {
			throw new Exception("Max value for HO-6 PersonalProperty in " + state + " should not exceed 500,000");
		} else if (product.contains("MH")) {
			double maxAllowed = Math.max(covA, 20000);
			if (personalPropertiesCoverage > maxAllowed) {
				throw new Exception("Max value for MH PersonalProperty in " + state
						+ " should not exceed the greater of 100% of Coverage A or 20,000");
			}
		}
	}

	public void validatePoliciesCovC(int personalPropertiesCoverage, String ObjectName, String Value) throws Exception {
		if (isStateValueCW && isPolicyD1) {
			validatePolicy(personalPropertiesCoverage);
			action = new Action(driver);
			action.type(ObjectName, Value);
		}
	}

	public CoverageValidator_coverageC(WebDriver driver) {
		this.driver = driver;
	}
}
