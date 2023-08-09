/**
 * 
 */
package com.ths.actiondriver;

import java.util.List;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CoverageValidator_coverageB {
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

	public void validatePolicy(int otherStructuresCoverage) throws Exception {
		// Fetch the Coverage A value from the web page
		String covA_Value = driver.findElement(By.xpath("//*[@name='policyTerm|coverages|coverageA']"))
				.getAttribute("value");
		covA_Value = covA_Value.replace(",", "");
		int covA_Valueint = Integer.parseInt(covA_Value);
		
		WebElement covbclick = driver.findElement(By.xpath("//*[@name='policyTerm|coverages|coverageB']"));
		covbclick.click();
		Thread.sleep(1000);
		String covB_Default_Value = driver.findElement(By.xpath("//*[@name='policyTerm|coverages|coverageB']"))
				.getAttribute("value");
		covB_Default_Value = covB_Default_Value.replace(",", "");
		Thread.sleep(1000);
		int covB_Defaultint = Integer.parseInt(covB_Default_Value);

		// List of exempted states for specific default values
		List<String> H3with2Percent = Arrays.asList("South Carolina", "Mississippi", "Michigan", "Tennessee",
				"Louisiana");
		List<String> statesForH1 = Arrays.asList("Texas", "South Carolina", "Mississippi", "Louisiana");

		String product = "DP-1, DP-3, MH, HO-3, HO-1, HO-4, HO-6";
		String state = "Alabama, Arizona, Arkansas, Georgia, Illinois, Indiana, Mississippi, Missouri, Michigan, "
				+ "Tennessee, North Carolina, South Carolina, Ohio, Texas, Wisconsin, Louisiana";

		
		int covA = covA_Valueint;
		int covB_10 = (int) Math.round(covA_Valueint * 0.10);
		int covB_02 = (int) Math.round(covA_Valueint * 0.2);
		int covB_25 = (int) Math.round(covA_Valueint * 0.25);
		int covB_50 = (int) Math.round(covA_Valueint * 0.50);
		
		
		
		// Validate default value
		if (product.contains("DP-1") || product.contains("DP-3") || product.contains("HO-3") || product.contains("HO-1")) {
			if (H3with2Percent.contains(state) && product.equals("HO-3")) {
				if (covB_Defaultint != covB_02) {
					System.out.println("value of this 1---" + (covB_Defaultint != (2 * covA_Valueint / 100)));
					throw new Exception("Default value for H3 in " + state + " should be 2% of Coverage A.");
				}
			} else if (statesForH1.contains(state) && product.contains("HO-1")) {
				if (covB_Defaultint != covB_02) {
					System.out.println("value of this2---" + (covB_Defaultint != (2 * covA_Valueint / 100)));
					throw new Exception("Default value for H1 in " + state + " should be 10% of Coverage A.");
				}
			} else {
				if (covB_Defaultint != covB_10) {
					throw new Exception("Default value should be 10% of Coverage A.");
				}
			}
		}
		// Validate minimum value
		if (product.contains("DP-1") || product.contains("DP-3") || product.contains("HO-3")  || product.contains("HO-1")) {
			if (H3with2Percent.contains(state) && product.equals("HO-3")) {
				if (otherStructuresCoverage < covB_02) {
					throw new Exception("minimum value for H3 in " + state + " should be 2% of Coverage A.");
				}
			} else if (statesForH1.contains(state) && product.contains("HO-1")) {
				if (otherStructuresCoverage < covB_02) {
					throw new Exception("minimum value for H1 in " + state + " should be 10% of Coverage A.");
				}
			} else {
				if (otherStructuresCoverage < covB_10) {
					throw new Exception("minimum value should be 10% of Coverage A.");
				}
			}
		}
		// Validate maximum value
		if (product.contains("DP-1") || product.contains("DP-3") || product.contains("HO-3")  || product.contains("HO-1")) {
			if (otherStructuresCoverage > covB_50) {
				throw new Exception("Max value should be 50% of Coverage A.");
			}
		} else if (product.contains("HO-1") && statesForH1.contains(state)) {
			if (otherStructuresCoverage > covB_25) {
				throw new Exception("Max value for H1 in " + state + " should be 25% of Coverage A.");
			}
		} else if (product.contains("MH")) {
			if (otherStructuresCoverage > covA_Valueint) {
				throw new Exception("Max value for MH should be 100% of Coverage A.");
			}
		}
	}
	

	public void validatePoliciesCovB(int otherStructuresCoverage, String ObjectName, String Value) throws Exception {
		if (isStateValueCW && isPolicyD1) {
			validatePolicy(otherStructuresCoverage);
			action = new Action(driver);
			action.type(ObjectName, Value);
		}
	}

	public CoverageValidator_coverageB(WebDriver driver) {
		this.driver = driver;
	}
}
