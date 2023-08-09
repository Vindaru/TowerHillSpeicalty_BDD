#Author: vdaru@thspecialty.com
Feature: AL_DP1.feature

  Background: 
    Given Internal Agent login successfully  | rpmLogin
      | URL |
      | red |

  #@DP1_OWNER_ACV @Priority1
  Scenario: Verify valid agent is successfully able create a policy in state ALABAMA with riskaddress "NOT COSTAL" with Occupancy as Owner/DP1/ACV
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as Alabama | SelectObject
      | State |
      | AL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value              |
      | basicinformationapage.insuredfirstname | Test               |
      | basicinformationapage.insuredlastName  | Test AL            |
      | basicinformationapage.riskStreet       | 1280 Washington Dr |
      | basicinformationapage.riskUnitAPTLOT   |                 41 |
      | basicinformationapage.riskCity         | Moody              |
      | basicinformationapage.riskZipcode      |              35004 |
      | basicinformationapage.insuredDOB       | 02/02/1993         |
    And wait for the page to load | waitForPageLoad
    Then Select Occupancy value |  selectDropdownvalue
      | ObjectName                      | Value |
      | basicinformationapage.occupancy | Owner |
    And wait for the page to load | waitForPageLoad
    And Is FireHyderate located with in 1000 ft  |  selectRadiobutton
      | ObjectName                               |
      | basicinformationapage.nearFireHydrantYES |
    And wait for the page to load | waitForPageLoad
    And Click on validateButton  |  userClicksonButton
      | ObjectName                           |
      | basicinformationapage.validateButton |
    And wait for the page to load | waitForPageLoad
    And Confirm Address  |  userClicksonButton
      | ObjectName                           |
      | basicinformationapage.confirmAddress |
    And wait for the page to load | waitForPageLoad
    And Verify if page is loaded successfully by validationg Object displaying | verifyObjectIsPresent
      | ObjectName                      |
      | basicinformationapage.yearBuilt |
    Then Enter Yearbult as '2000' | userEntersText
      | ObjectName                      | Value |
      | basicinformationapage.yearBuilt |  2000 |
    And wait for the page to load | waitForPageLoad
    Then Select PolicyForm  | selectDropdownvalue
      | ObjectName                       | Value |
      | basicinformationapage.policyForm | DP-1  |
    And wait for the page to load | waitForPageLoad
    Then Select Dwelling Loss Settlement  | selectDropdownvalue
      | ObjectName                                   | Value             |
      | basicinformationapage.dwellingLossSettlement | Actual Cash Value |
    And wait for the page to load | waitForPageLoad
    Then Click on validateButton  |  userClicksonButton
      | ObjectName                             |
      | basicinformationapage.consentToProceed |
    And wait for the page to load | waitForPageLoad
    And Select mailingAddressToggle to YES |  selectRadiobutton
      | ObjectName                                    |
      | basicinformationapage.mailingAddressToggleYES |
    And wait for the page to load | waitForPageLoad
    And Select Applicant moved as NO |  selectRadiobutton
      | ObjectName                                |
      | basicinformationapage.hasApplicantMovedNO |
    And wait for the page to load | waitForPageLoad
    Then Click on Continue Button to go to Policy Page  |  userClicksonButton
      | ObjectName                           |
      | basicinformationapage.continuebutton |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  verifyObjectIsPresent
      | ObjectName                 |
      | policyPage.getPolicyNumber |
    Then get Policy number  |  getPolicyNumber
      | ObjectName                 |
      | policyPage.getPolicyNumber |
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |
    And wait for the page to load | waitForPageLoad
    And Agent landed on Homepage | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    And wait for the page to load | waitForPageLoad
    Then Enter policy number to Search <storedPolicyNumber> | userEntersPolicyNumber
      | ObjectName                     | Value                |
      | homepage.searchforpolicynumber | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName                  |
      | homepage.submitSearchbutton |
    And wait for the page to load | waitForPageLoad
    Then Click on ExpandPolicyButton   |  userClicksonButton
      | ObjectName                  |
      | homepage.expandSearchPolicy |
    And wait for the page to load | waitForPageLoad
    Then Expand the policy searching and verify the details below,   | verifyTextDetails
      | ObjectName                   | Value        |
      | homepage.policyEffectiveDate | <today>      |
      | homepage.firstNameLastName   | Test Test AL |
      | homepage.policyStatus        | LEAD         |
      | homepage.policyState         | AL           |
      | homepage.policyAgency        | 0A00         |
      | homepage.policycreatedBy     | V Daru       |
