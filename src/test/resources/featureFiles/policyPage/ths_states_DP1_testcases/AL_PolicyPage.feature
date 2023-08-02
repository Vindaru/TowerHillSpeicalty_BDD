#Author: vdaru@thspecialty.com
Feature: PolicyPage.feature

  Background: 
    Given Internal Agent login successfully  | rpmLogin
      | URL |
      | red |

  @DP1_OWNER_ACV @Priority2
  Scenario: Verify valid agent is successfully able create a policy in state ALABAMA with riskaddress "NOT COSTAL" with Occupancy as Owner/DP1/ACV
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
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

 
