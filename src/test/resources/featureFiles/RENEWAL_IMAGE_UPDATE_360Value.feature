#Author: vdaru@thspecialty.com
Feature: AL_DP1.feature

  Background: 
    Given Internal Agent login successfully  | rpmLogin
      | URL |
      | red |

  #- Trigger point : (All D3/H3 Policies with RC)
  #
  #1) Get the policies from excel
  #2) Login to RPM - go to Home Page
  #3) Search for the Policy --- Y0000000000(example)
  #4) Verify if Renewal Image is created,
  #-  if yes Enter the policy
  #-  if No move on to next policy
  #5) When you open the policy (Renewal Term) land on Policy page
  #6) Capture values of Premium_Value and Coverage_A
  #7) now, hit the update button and wait to load page
  #8) Once  the page is loaded, capture new Premium (as Premium_updated  and Coverage_A_Updated)
  #9) Hit Rate Button and wait to load page
  #10) Now compaire Premium_Value vs Premium_updated and also Coverage_A vs Coverage_A_Updated
  #- if Premium_Value is less then Premium_updated or and Coverage_A is less then Coverage_A_Updated the NOTIFY UNDERWRITER
  #and exit the policy
  #11) When compaired Premium_Value vs Premium_updated and also Coverage_A vs Coverage_A_Updated and if Premium_Value is not-less then Premium_updated or and Coverage_A is not-less then Coverage_A_Updated
  #- Hit Submit changes button
  #12) In the new Window - Enter date
  #13) if applicable = Is this company ini change select as yes
  #14) if "Company inititated "
  #13) select dropdown Change Reason = Updated Coverage Selections
  #14) verify the premium change = should be equal to (Premium_updated - Premium)
  #15) Hit Submit and exit the policy
  #16) continue to all the policies listed in the excel.
  @UW_UPDATE_RENEWAL_360Value
  Scenario: This Scenario will update 360 value for renewal Image in RPM.
    Given Internal Agent is logged in to RPM home page | verify next page title
      | pageTitle                                          |
      | RPM –  Tower Hill Insurance – Tower Hill Insurance |
    And wait for the page to load | waitForPageLoad
    Then Enter policy number to Search From Excel | getPolicyNumbersFromExcel
    And wait for the page to load | waitForPageLoad
     Then Enter policy number to Search <storedPolicyNumber> | userEntersPolicyNumberEXCEL
      | ObjectName                     | Value      |
      | homepage.searchforpolicynumber | <storedPolicyNumber> |
   
