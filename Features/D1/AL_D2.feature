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
      | AL    |
    And Select Business Owned as NO - default |  selectRadiobutton
      | ObjectName                              |
      | basicinformationapage.businessOwnerdYES |
