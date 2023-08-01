#Author: vdaru@thspecialty.com
Feature: BasicInformationPage_D1.feature

  Background: 
    Given Internal Agent login successfully  | rpmLogin
      | URL |
      | red |

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able create a policy in state ALABAMA with riskaddress "NOT COSTAL" with Occupancy as Owner
    Given When Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    Then Select State as Alabama | SelectObject
      | State |
      | OH    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                             |
      | basicinformationapage.businessOwnerdNO |
    And wait for the page to load | waitForPageLoad
    Then Enter Insured Details Firstname/ LastName/ Adress/ zipcode/ Date of birth |  userEntersText
      | ObjectName                             | Value           |
      | basicinformationapage.insuredfirstname | Test            |
      | basicinformationapage.insuredlastName  | Test OH         |
      | basicinformationapage.riskStreet       | 123 Main Street |
      | basicinformationapage.riskUnitAPTLOT   |              41 |
      | basicinformationapage.riskCity         | Cincinnati      |
      | basicinformationapage.riskZipcode      |           45241 |
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
    And Verify if page is loaded successfully by validationg Object displaying | verifyObjectIsPresent
      | ObjectName                      |
      | basicinformationapage.yearBuilt |
