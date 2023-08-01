#Author: vdaru@thspecialty.com
Feature: IL_DP1.feature

  Background: 
    Given Internal Agent login successfully  | rpmLogin
      | URL |
      | red |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state IL with riskaddress "NOT COSTAL" with Occupancy as Owner/DP1/ACV
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as IL | SelectObject
      | State |
      | IL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test IL         |
      | basicinformationapage.riskStreet       | 900 S Bishop St |
      | basicinformationapage.riskUnitAPTLOT   |               1 |
      | basicinformationapage.riskCity         | Chicago         |
      | basicinformationapage.riskZipcode      |           60607 |
      | basicinformationapage.insuredDOB       | 02/02/1993      |
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
    Then Click on policy to go to Policy Page   |  userClicksonButton
      | ObjectName                 | Value                |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  clickonlinktext
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state IL with riskaddress "NOT COSTAL" with Occupancy as Seasonal/DP1/ACV
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as IL | SelectObject
      | State |
      | IL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test IL         |
      | basicinformationapage.riskStreet       | 900 S Bishop St |
      | basicinformationapage.riskUnitAPTLOT   |               1 |
      | basicinformationapage.riskCity         | Chicago         |
      | basicinformationapage.riskZipcode      |           60607 |
      | basicinformationapage.insuredDOB       | 02/02/1993      |
    And wait for the page to load | waitForPageLoad
    Then Select Occupancy value |  selectDropdownvalue
      | ObjectName                      | Value    |
      | basicinformationapage.occupancy | Seasonal |
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
    Then Click on policy to go to Policy Page   |  userClicksonButton
      | ObjectName                 | Value                |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  clickonlinktext
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state IL with riskaddress "NOT COSTAL" with Occupancy as Rental/DP1/ACV
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as IL | SelectObject
      | State |
      | IL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test IL         |
      | basicinformationapage.riskStreet       | 900 S Bishop St |
      | basicinformationapage.riskUnitAPTLOT   |               1 |
      | basicinformationapage.riskCity         | Chicago         |
      | basicinformationapage.riskZipcode      |           60607 |
      | basicinformationapage.insuredDOB       | 02/02/1993      |
    And wait for the page to load | waitForPageLoad
    Then Select Occupancy value |  selectDropdownvalue
      | ObjectName                      | Value  |
      | basicinformationapage.occupancy | Rental |
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
    Then Click on policy to go to Policy Page   |  userClicksonButton
      | ObjectName                 | Value                |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  clickonlinktext
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state IL with riskaddress "NOT COSTAL" with Occupancy as Vacant/DP1/ACV
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as IL | SelectObject
      | State |
      | IL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test IL         |
      | basicinformationapage.riskStreet       | 900 S Bishop St |
      | basicinformationapage.riskUnitAPTLOT   |               1 |
      | basicinformationapage.riskCity         | Chicago         |
      | basicinformationapage.riskZipcode      |           60607 |
      | basicinformationapage.insuredDOB       | 02/02/1993      |
    And wait for the page to load | waitForPageLoad
    Then Select Occupancy value |  selectDropdownvalue
      | ObjectName                      | Value  |
      | basicinformationapage.occupancy | Vacant |
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
    Then Click on policy to go to Policy Page   |  userClicksonButton
      | ObjectName                 | Value                |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  clickonlinktext
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state IL with riskaddress "NOT COSTAL" with Occupancy as Not A Residence/DP1/ACV
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as IL | SelectObject
      | State |
      | IL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test IL         |
      | basicinformationapage.riskStreet       | 900 S Bishop St |
      | basicinformationapage.riskUnitAPTLOT   |               1 |
      | basicinformationapage.riskCity         | Chicago         |
      | basicinformationapage.riskZipcode      |           60607 |
      | basicinformationapage.insuredDOB       | 02/02/1993      |
    And wait for the page to load | waitForPageLoad
    Then Select Occupancy value |  selectDropdownvalue
      | ObjectName                      | Value           |
      | basicinformationapage.occupancy | Not A Residence |
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
    Then Click on policy to go to Policy Page   |  userClicksonButton
      | ObjectName                 | Value                |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  clickonlinktext
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state IL with riskaddress "NOT COSTAL" with Occupancy as Owner/DP1/Full Repair Cost
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as IL | SelectObject
      | State |
      | IL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test IL         |
      | basicinformationapage.riskStreet       | 900 S Bishop St |
      | basicinformationapage.riskUnitAPTLOT   |               1 |
      | basicinformationapage.riskCity         | Chicago         |
      | basicinformationapage.riskZipcode      |           60607 |
      | basicinformationapage.insuredDOB       | 02/02/1993      |
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
      | ObjectName                                   | Value            |
      | basicinformationapage.dwellingLossSettlement | Full Repair Cost |
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
    Then Click on policy to go to Policy Page   |  userClicksonButton
      | ObjectName                 | Value                |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  clickonlinktext
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state IL with riskaddress "NOT COSTAL" with Occupancy as Seasonal/DP1/Full Repair Cost
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as IL | SelectObject
      | State |
      | IL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test IL         |
      | basicinformationapage.riskStreet       | 900 S Bishop St |
      | basicinformationapage.riskUnitAPTLOT   |               1 |
      | basicinformationapage.riskCity         | Chicago         |
      | basicinformationapage.riskZipcode      |           60607 |
      | basicinformationapage.insuredDOB       | 02/02/1993      |
    And wait for the page to load | waitForPageLoad
    Then Select Occupancy value |  selectDropdownvalue
      | ObjectName                      | Value    |
      | basicinformationapage.occupancy | Seasonal |
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
      | ObjectName                                   | Value            |
      | basicinformationapage.dwellingLossSettlement | Full Repair Cost |
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
    Then Click on policy to go to Policy Page   |  userClicksonButton
      | ObjectName                 | Value                |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  clickonlinktext
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state IL with riskaddress "NOT COSTAL" with Occupancy as Rental/DP1/Full Repair Cost
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as IL | SelectObject
      | State |
      | IL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test IL         |
      | basicinformationapage.riskStreet       | 900 S Bishop St |
      | basicinformationapage.riskUnitAPTLOT   |               1 |
      | basicinformationapage.riskCity         | Chicago         |
      | basicinformationapage.riskZipcode      |           60607 |
      | basicinformationapage.insuredDOB       | 02/02/1993      |
    And wait for the page to load | waitForPageLoad
    Then Select Occupancy value |  selectDropdownvalue
      | ObjectName                      | Value  |
      | basicinformationapage.occupancy | Rental |
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
      | ObjectName                                   | Value            |
      | basicinformationapage.dwellingLossSettlement | Full Repair Cost |
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
    Then Click on policy to go to Policy Page   |  userClicksonButton
      | ObjectName                 | Value                |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  clickonlinktext
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state IL with riskaddress "NOT COSTAL" with Occupancy as Vacant/DP1/Full Repair Cost
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as IL | SelectObject
      | State |
      | IL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test IL         |
      | basicinformationapage.riskStreet       | 900 S Bishop St |
      | basicinformationapage.riskUnitAPTLOT   |               1 |
      | basicinformationapage.riskCity         | Chicago         |
      | basicinformationapage.riskZipcode      |           60607 |
      | basicinformationapage.insuredDOB       | 02/02/1993      |
    And wait for the page to load | waitForPageLoad
    Then Select Occupancy value |  selectDropdownvalue
      | ObjectName                      | Value  |
      | basicinformationapage.occupancy | Vacant |
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
      | ObjectName                                   | Value            |
      | basicinformationapage.dwellingLossSettlement | Full Repair Cost |
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
    Then Click on policy to go to Policy Page   |  userClicksonButton
      | ObjectName                 | Value                |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  clickonlinktext
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state IL with riskaddress "NOT COSTAL" with Occupancy as Not A Residence/DP1/Full Repair Cost
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as IL | SelectObject
      | State |
      | IL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test IL         |
      | basicinformationapage.riskStreet       | 900 S Bishop St |
      | basicinformationapage.riskUnitAPTLOT   |               1 |
      | basicinformationapage.riskCity         | Chicago         |
      | basicinformationapage.riskZipcode      |           60607 |
      | basicinformationapage.insuredDOB       | 02/02/1993      |
    And wait for the page to load | waitForPageLoad
    Then Select Occupancy value |  selectDropdownvalue
      | ObjectName                      | Value           |
      | basicinformationapage.occupancy | Not A Residence |
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
      | ObjectName                                   | Value            |
      | basicinformationapage.dwellingLossSettlement | Full Repair Cost |
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
    Then Click on policy to go to Policy Page   |  userClicksonButton
      | ObjectName                 | Value                |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Verify if the Policypage is displaying  |  clickonlinktext
    And wait for the page to load | waitForPageLoad
    Then Click on Exit policy button   |  userClicksonButton
      | ObjectName            |
      | policyPage.exitbutton |
