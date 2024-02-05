@login @all @tests
Feature: Saucedemo - Login Page Tests

  Background:
    Given I access the Saucedemo Login Page

  Scenario: Validate Successful Login
    When I enter a username standard_user
    And I enter a password secret_sauce
    And I click on the Login button
    Then I should be Logged in and the Header should present the message Swag Labs

  Scenario: Validate Successful Login and then Log Out
    When I enter a username standard_user
    And I enter a password secret_sauce
    And I click on the Login button
    And I should be Logged in and the Header should present the message Swag Labs
    And Click in Burger menu to expand the sidebar menu
    And Click in LogOut
    Then The user must be logged out

  Scenario Outline: Validate - Unsuccessful Login
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
