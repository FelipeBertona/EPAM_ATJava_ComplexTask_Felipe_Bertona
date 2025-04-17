Feature: Sauce Demo Login Tests
  In order to validate the login functionality
  As a test automation engineer
  I want to verify the different login scenarios on SauceDemo

  Background:
    Given I navigate to "https://www.saucedemo.com/"

  @UC1
  Scenario: Test Login form with empty credentials
    When I enter "sampleUser" into the username field
    And I enter "samplePassword" into the password field
    And I clear both the username and password fields
    And I click the login button
    Then I should see the error message "Epic sadface: Username is required"

  @UC2
  Scenario: Test Login form with missing password
    When I enter "sampleUser" into the username field
    And I enter "samplePassword" into the password field
    And I clear the password field
    And I click the login button
    Then I should see the error message "Epic sadface: Password is required"

  @UC3
  Scenario Outline: Test Login form with valid credentials
    When I enter "<username>" into the username field
    And I enter "<password>" into the password field
    And I click the login button
    Then I should see the title "Swag Labs"

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |