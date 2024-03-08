@login @all @tests
Feature: Saucedemo - Login Page Tests


  Scenario Outline: Validate - Unsuccessful Login
    Given I access the Saucedemo Login Page
    When I enter a username <username>
    And I enter a password <password>
    And I click on the Login button
    Then I should be presented with the following login validation message <loginValidationMessage>

    Examples:
      | username        | password      | loginValidationMessage                                                        |
      | NonExistent     | secret_sauce  | Epic sadface: Username and password do not match any user in this service     |
      | standard_user   |               | Epic sadface: Password is required                                            |
      | standard_user   | WrongPassword | Epic sadface: Username and password do not match any user in this service     |
      | locked_out_user | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                           |
      |                 | secret_sauce  | Epic sadface: Username is required                                            |
