Feature: Sauce Demo Login Tests
  In order to validate the login functionality
  As a test automation engineer
  I want to verify the different login scenarios on SauceDemo

  Background:
    Given I navigate to "https://www.saucedemo.com/"

  @UC3
  Scenario Outline: Test Login form with valid credentials
    # Enter valid credentials from the accepted list and validate the dashboard title.
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