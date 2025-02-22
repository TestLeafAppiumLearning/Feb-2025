Feature: Login scenarios

  Scenario: Positive
    When I enter the username as "rajkumar@testleaf.com"
    And I enter the password as "Leaf@123"
    And I click the login button
    Then Verify Home page is displayed

  Scenario: Negative
    When I enter the username as "lokesh"
    And I enter the password as "Leaf@123"
    And I click the login button
    Then Verify Login page is displayed