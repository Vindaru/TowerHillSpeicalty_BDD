#Author: vdaru@thspecialty.com
Feature: PolicyPage.feature

  Background: 
    Given Internal Agent login successfully  | rpmLogin
      | URL |
      | UAT |

#X016996935
  @DP1_OWNER_ACV @Priority2
  Scenario: Verify valid agent is successfully able create a policy in state ALABAMA with riskaddress "NOT COSTAL" with Occupancy as Owner/DP1/ACV
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    And wait for the page to load | waitForPageLoad
    Then Enter policy number to Search <storedPolicyNumber> | userEntersPolicyNumber
      | ObjectName                     | Value      |
      | homepage.searchforpolicynumber | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    Then Click on submitSearchbutton   |  userClicksonButton
      | ObjectName                  |
      | homepage.submitSearchbutton |
    And wait for the page to load | waitForPageLoad
    Then Click on policy to go to Policy Page   |  clickonlinktext
      | ObjectName                 | Value      |
      | homepage.clicktoOpenPolicy | <storedPolicyNumber> |
    And wait for the page to load | waitForPageLoad
    And wait for the page to load | waitForPageLoad
    Then Enter Todaydate for effectivedate | userEntersText
      | ObjectName               | Value   |
      | policyPage.effectiveDate | <today> |
    And wait for the page to load | waitForPageLoad
    Then Enter Roof Year  | userEntersText
      | ObjectName          | Value |
      | policyPage.roofYear |  2010 |
    And wait for the page to load | waitForPageLoad
    Then Enter Squarefoot  | userEntersText
      | ObjectName            | Value |
      | policyPage.squareFoot |  1000 |
    And wait for the page to load | waitForPageLoad
    Then Select Dwelling Loss Set roofingMaterialtlement  | selectDropdownvalue
      | ObjectName                 | Value          |
      | policyPage.roofingMaterial | Tar and Gravel |
    And wait for the page to load | waitForPageLoad
    Then Select constructionType  | selectDropdownvalue
      | ObjectName                  | Value |
      | policyPage.constructionType | Frame |
    And wait for the page to load | waitForPageLoad
    Then Select numberOfStories  | selectDropdownvalue
      | ObjectName                 | Value |
      | policyPage.numberOfStories |     1 |
    And wait for the page to load | waitForPageLoad
    Then Select roofShape  | selectDropdownvalue
      | ObjectName           | Value |
      | policyPage.roofShape | Gable |
    And wait for the page to load | waitForPageLoad
    Then Select roofShape  | selectDropdownvalue
      | ObjectName             | Value          |
      | policyPage.rowTownHome | Does not apply |
    And wait for the page to load | waitForPageLoad
    And Select newPurchas as NO |  selectRadiobutton
      | ObjectName                |
      | policyPage.newPurchase_No |
    And wait for the page to load | waitForPageLoad
    Then Enter Todaydate for priorPolicyExpirationDate | userEntersText
      | ObjectName                           | Value   |
      | policyPage.priorPolicyExpirationDate | <today> |
    And wait for the page to load | waitForPageLoad
    Then Select foundationType | selectDropdownvalue
      | ObjectName                | Value                 |
      | policyPage.foundationType | Closed in Crawl Space |
    And wait for the page to load | waitForPageLoad
    And Select seplementHeat as Yes |  selectRadiobutton
      | ObjectName                   |
      | policyPage.seplementHeat_Yes |
    And wait for the page to load | waitForPageLoad
    Then Enter Dwelling coverage value |  enterCoveragesAfterValidation
      | ObjectName               | Value  |
      | policyPage.dwelling_covA | 259887 |
    And wait for the page to load | waitForPageLoad
    Then Enter otherStructures coverage value |  enterCoveragesAfterValidation
      | ObjectName                      | Value |
      | policyPage.otherStructures_covB | 30000 |
    And wait for the page to load | waitForPageLoad
    Then Enter otherStructures coverage value |  enterCoveragesAfterValidation
      | ObjectName                         | Value |
      | policyPage.personalProperties_covC | 70000 |
    And wait for the page to load | waitForPageLoad
