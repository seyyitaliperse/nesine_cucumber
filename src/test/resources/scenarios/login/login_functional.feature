@login&logout
Feature: Nesine login & logout
  - User should be able to log in system
  - User should not be able to log in with invalid credentials.

  @smoke
  Scenario: User should be able to log in system
    Given user is on the nesine login page
    When user log in nesine dashboard
    Then user verifies that logged in successfully

  Scenario: User should not be able to log in with invalid credentials
    Given user is on the nesine login page
    When user attempts to log in with invalid credentials
    And user should see an invalid credential dialog error details
