@login @all @tests
Feature: Saucedemo - Login Page Tests


  Scenario: Validate Successful Login
    Given I access the Saucedemo Login Page
    When I enter a username standard_user
    And I enter a password secret_sauce
    And I click on the Login button
    Then I should be Logged in and the Header should present the message Swag Labs