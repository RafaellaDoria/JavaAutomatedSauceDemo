@product @all @tests
Feature: Saucedemo - Cart Page Tests

  Scenario: Filter Products By Desc
    Given I access the Saucedemo Login Page
    When I enter a username standard_user
    And I enter a password secret_sauce
    And I click on the Login button
    And I should be Logged in and the Header should present the message Swag Labs

    And Select "desc" option to filter
    Then The order of the name is ascending
