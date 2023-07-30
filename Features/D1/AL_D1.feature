#Author: vdaru@thspecialty.com
Feature: BasicInformationPage_D1.feature

  @BasicInformationPage
  Scenario: Verify valid agent is successfully able start a quote in state ALABAMA with riskaddress "NOT COSTAL" with Occupancy as Owner
    Given Internal Agent Login to RPM successfully
      | URL | groupId | userName | password  |
      | red | TS0A00  | vdaru    | 1Password |
    And waitForPageLoad
    Then Select State
      | State |
      | AL    |
    And waitForPageLoad
    Then Click on Radiobutton with BusinessOwnedasDefault_NO

