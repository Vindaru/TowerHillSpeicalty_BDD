#Author: vdaru@thspecialty.com
Feature: HomePage.feature

  Scenario: verify Message/Update Dialog box on home page at login
    Given User Launch Browser
    When User opens url "https://oasis.red.thig.com/"
    Then User enters groupID,userName, password
      | groupId | userName | password  |
      | TS0A00  | vdaru    | 1Password |
    And waitForPageLoad
    Then Click on Personal Line Portal button
    And waitForPageLoad
    Then verify if disconnet session page is displaying "RPM – Tower Hill Insurance Group - Disconnect Session – Tower Hill Insurance"
   And waitForPageLoad
    And verify Message/update Dialog box displaying.

  Scenario: verify AgencyOverride on home page
    Given User Launch Browser
    When User opens url "https://oasis.red.thig.com/"
    Then User enters groupID,userName, password
      | groupId | userName | password  |
      | TS0A00  | vdaru    | 1Password |
    And waitForPageLoad
    Then Click on Personal Line Portal button
    And waitForPageLoad
    Then verify if disconnet session page is displaying "RPM – Tower Hill Insurance Group - Disconnect Session – Tower Hill Insurance"
    And waitForPageLoad
    And verify Message/update Dialog box displaying.
    And verify AgencyOverride.

 Scenario: perform Search operation on Homepage
    Given User Launch Browser 
    Given User opens url "https://oasis.red.thig.com/"
    Then User enters groupID,userName, password
      | groupId | userName | password  |
      | TS0A00  | vdaru    | 1Password |
    And waitForPageLoad
    Then Click on Personal Line Portal button
    And waitForPageLoad
    Then disconnetPage
    And waitForPageLoad
    And verify Message/update Dialog box displaying.
    And waitForPageLoad
    Then perform Search functionality
    And ExitPolicy