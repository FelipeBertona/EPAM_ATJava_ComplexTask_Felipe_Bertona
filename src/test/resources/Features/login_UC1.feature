Feature: Sauce Demo Login Tests
  In order to validate the login functionality
  As a test automation engineer
  I want to verify the different login scenarios on SauceDemo

  Background:
    Given I navigate to "https://www.saucedemo.com/"

  @UC1
  Scenario: Test Login form with empty credentials
    # Enter some credentials first then clear both fields before attempting to login.
    When I enter "sampleUser" into the username field
    And I enter "samplePassword" into the password field
    And I clear both the username and password fields
    And I click the login button
    Then I should see the error message "Epic sadface: Username is required"