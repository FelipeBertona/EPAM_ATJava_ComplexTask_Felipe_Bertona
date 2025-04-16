Feature: Sauce Demo Login Tests
  In order to validate the login functionality
  As a test automation engineer
  I want to verify the different login scenarios on SauceDemo

  Background:
    Given I navigate to "https://www.saucedemo.com/"

  @UC2
  Scenario: Test Login form with missing password
    # Enter values then clear only the password field to trigger the missing password error.
    When I enter "sampleUser" into the username field
    And I enter "samplePassword" into the password field
    And I clear the password field
    And I click the login button
    Then I should see the error message "Epic sadface: Password is required"