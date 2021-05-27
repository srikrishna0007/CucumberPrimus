@tag
Feature: Verify AdminLogin
   @tag1
  Scenario: Validate Login Module
    Given I want to lauch url in a browser
    When I enter valid username
    And I enter valid password
    When I Click on login button
    Then Verify text in Url
    Then I close Browser
@tag2
 Scenario Outline: validate Login with multiple data
   Given user launch url "<Browser>"
    When user enter valid "<Username>"
   And user enter valid Pass "<Password>"
   When user click on login button
  Then user verify text in url
  Then user verify close Browser
  Examples:
  |Browser|Username|Password|
  |chrome|Admin|Qedge123!@#| 
  |firefox|Admin|Qedge123!@#| 
  |firefox|Admin|Qedge!@#| 
  |chrome|test|Qedge123!@#| 
  |chrome|Admin|Qedge123!@#|  