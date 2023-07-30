 #Author: vdaru@thspecialty.com
   Feature: HomePage.feature
 
 Scenario: Ths states validation
    Given User Launch Browser 
    Given User opens url "https://oasis.red.thig.com/"
    When User enters groupID,userName, password
      | groupId | userName | password  |
      | TS0A00  | vdaru    | 1Password |
    And waitForPageLoad
    Then Click on Personal Line Portal button
    And waitForPageLoad
    Then disconnetPage
    And waitForPageLoad
    And verify Message/update Dialog box displaying.
    And waitForPageLoad
    Then Verify all states to display under quotes


    