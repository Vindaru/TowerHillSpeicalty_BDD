/**
 * 
 */
package com.ths.actiondriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoverageValidator {
	public static WebDriver driver;

	public static void validateCoverages(int dwellingCoverage, int otherStructuresCoverage,
			int personalPropertiesCoverage) throws Exception {

		String statevalue = driver.findElement(By.xpath("//*[@name='policyTerm|location|address|state']"))
				.getAttribute("value");
		String policyFormValue = driver.findElement(By.xpath("//*[@name='policyTerm|policyForm']"))
				.getAttribute("value");
		String occupancyValue = driver.findElement(By.xpath("//*[@name='policyTerm|location|occupancy']"))
				.getAttribute("value");
		System.out.println("State =  " + statevalue);
		System.out.println("policyFormValue =  " + policyFormValue);
		System.out.println("occupancyValue =  " + occupancyValue);

		// scenerios :
		boolean isStateValueCW = statevalue.equals("OH") || statevalue.equals("WI") || statevalue.equals("IN")
				|| statevalue.equals("MO") || statevalue.equals("AL") || statevalue.equals("AZ")
				|| statevalue.equals("SC") || statevalue.equals("AR") || statevalue.equals("TN")
				|| statevalue.equals("LA") || statevalue.equals("GA") || statevalue.equals("MS")
				|| statevalue.equals("IL");
		boolean isPolicyD1 = policyFormValue.equals("D1");
		boolean isPolicyD3 = policyFormValue.equals("D3");
		boolean isPolicyH3 = policyFormValue.equals("H3");
		boolean isPolicyH4 = policyFormValue.equals("H4");
		boolean isPolicyH6 = policyFormValue.equals("H6");
		boolean isPolicyMH = policyFormValue.equals("MC");
		boolean isPolicyH1 = policyFormValue.equals("H1");
		boolean isOccupancyValueOwner = occupancyValue.equals("Owner");
		boolean isOccupancyValueSeasonal = occupancyValue.equals("Seasonal");
		boolean isOccupancyValueVacant = occupancyValue.equals("Vacant");
		boolean isOccupancyValueRental = occupancyValue.equals("Rental");
		boolean isOccupancyValueNotAResidence = occupancyValue.equals("Not A Residence");

	// DP-1 
		if (isStateValueCW & isPolicyD1) {

			if (isOccupancyValueOwner || isOccupancyValueRental) {
				if (dwellingCoverage < 20000 || dwellingCoverage > 500000) {
					throw new Exception(
							"Dwelling coverage is invaid = can not be more then  500000 or less then 20000");
				}

				if (otherStructuresCoverage > 0.2 * dwellingCoverage) {
					throw new Exception("Other structures coverage should not be more than 20% of dwelling coverage");
				}

				if (personalPropertiesCoverage > dwellingCoverage) {
					throw new Exception("Personal properties coverage should not be greater than dwelling coverage");
				}
			}else if(isOccupancyValueSeasonal || isOccupancyValueNotAResidence) {
				if (dwellingCoverage < 5000 || dwellingCoverage > 500000) {
					throw new Exception(
							"Dwelling coverage is invaid = can not be more then  500000 or less then 5000");
				}

				if (otherStructuresCoverage > 0.2 * dwellingCoverage) {
					throw new Exception("Other structures coverage should not be more than 20% of dwelling coverage");
				}

				if (personalPropertiesCoverage > dwellingCoverage) {
					throw new Exception("Personal properties coverage should not be greater than dwelling coverage");
				}
			}else if(isOccupancyValueVacant) {
				if (dwellingCoverage < 5000 || dwellingCoverage > 1000000) {
					throw new Exception(
							"Dwelling coverage is invaid = can not be more then  1000000 or less then 5000");
				}

				if (otherStructuresCoverage > 0.2 * dwellingCoverage) {
					throw new Exception("Other structures coverage should not be more than 20% of dwelling coverage");
				}

				if (personalPropertiesCoverage > dwellingCoverage) {
					throw new Exception("Personal properties coverage should not be greater than dwelling coverage");
				}
				
			}

		}
		
		// DP-3 
				if (isStateValueCW & isPolicyD3) {

					if (isOccupancyValueOwner) {
						if (dwellingCoverage < 75000 || dwellingCoverage > 500000) {
							throw new Exception(
									"Dwelling coverage is invaid = can not be more then  75000 or less then 75000");
						}

						if (otherStructuresCoverage > 0.2 * dwellingCoverage) {
							throw new Exception("Other structures coverage should not be more than 20% of dwelling coverage");
						}

						if (personalPropertiesCoverage > dwellingCoverage) {
							throw new Exception("Personal properties coverage should not be greater than dwelling coverage");
						}
					} else if(isOccupancyValueSeasonal || isOccupancyValueVacant) {
						if (dwellingCoverage < 75000 || dwellingCoverage > 1000000) {
							throw new Exception(
									"Dwelling coverage is invaid = can not be more then  1000000 or less then 75000");
						}

						if (otherStructuresCoverage > 0.2 * dwellingCoverage) {
							throw new Exception("Other structures coverage should not be more than 20% of dwelling coverage");
						}

						if (personalPropertiesCoverage > dwellingCoverage) {
							throw new Exception("Personal properties coverage should not be greater than dwelling coverage");
						}
					}else if(isOccupancyValueRental) {
						if (dwellingCoverage < 75000 || dwellingCoverage > 750000) {
							throw new Exception(
									"Dwelling coverage is invaid = can not be more then  750000 or less then 75000");
						}

						if (otherStructuresCoverage > 0.2 * dwellingCoverage) {
							throw new Exception("Other structures coverage should not be more than 20% of dwelling coverage");
						}

						if (personalPropertiesCoverage > dwellingCoverage) {
							throw new Exception("Personal properties coverage should not be greater than dwelling coverage");
						}
						
					}

				}	
				
				// HO-3 
				//System.out.pritnln();
				if (isStateValueCW & isPolicyH3) {

					if (isOccupancyValueOwner || isOccupancyValueSeasonal) {
						if (dwellingCoverage < 150000 || dwellingCoverage > 750000) {
							throw new Exception(
									"Dwelling coverage is invaid = can not be more then  750000 or less then 75000");
						}

						if (otherStructuresCoverage > 0.2 * dwellingCoverage) {
							throw new Exception("Other structures coverage should not be more than 20% of dwelling coverage");
						}

						if (personalPropertiesCoverage > dwellingCoverage) {
							throw new Exception("Personal properties coverage should not be greater than dwelling coverage");
						}
					} 

				}
				
				// HO-6 
				//System.out.pritnln();
				if (isStateValueCW & isPolicyH6) {

					if (isOccupancyValueOwner || isOccupancyValueSeasonal || isOccupancyValueRental) {
						if (dwellingCoverage < 5000 || dwellingCoverage > 500000) {
							throw new Exception(
									"Dwelling coverage is invaid = can not be more then  500000 or less then 5000");
						}

						if (otherStructuresCoverage > 0.2 * dwellingCoverage) {
							throw new Exception("Other structures coverage should not be more than 20% of dwelling coverage");
						}

						if (personalPropertiesCoverage > dwellingCoverage) {
							throw new Exception("Personal properties coverage should not be greater than dwelling coverage");
						}
					} 

				}
				
				// MH 
				//System.out.pritnln();
				if (isStateValueCW & isPolicyMH) {

					if (isOccupancyValueOwner || isOccupancyValueSeasonal || isOccupancyValueRental) {
						if (dwellingCoverage < 5000 || dwellingCoverage > 300000) {
							throw new Exception(
									"Dwelling coverage is invaid = can not be more then  300000 or less then 5000");
						}

						if (otherStructuresCoverage > 0.2 * dwellingCoverage) {
							throw new Exception("Other structures coverage should not be more than 20% of dwelling coverage");
						}

						if (personalPropertiesCoverage > dwellingCoverage) {
							throw new Exception("Personal properties coverage should not be greater than dwelling coverage");
						}
					} 

				}
				
				// HO-1 or HO- Basic 
				//System.out.pritnln();
				if (isStateValueCW & isPolicyH3) {

					if (isOccupancyValueOwner || isOccupancyValueSeasonal) {
						if (dwellingCoverage < 150000 || dwellingCoverage > 750000) {
							throw new Exception(
									"Dwelling coverage is invaid = can not be more then  750000 or less then 75000");
						}

						if (otherStructuresCoverage > 0.2 * dwellingCoverage) {
							throw new Exception("Other structures coverage should not be more than 20% of dwelling coverage");
						}

						if (personalPropertiesCoverage > dwellingCoverage) {
							throw new Exception("Personal properties coverage should not be greater than dwelling coverage");
						}
					} 

				}
		
		
	}
}
