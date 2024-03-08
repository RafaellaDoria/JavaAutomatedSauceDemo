@login @all @tests
Feature: Saucedemo - Login Page Tests

Scenario: Validate Successful Login and then Log Out

  Given I access the Saucedemo Login Page
  When I enter a username standard_user
  And I enter a password secret_sauce
  And I click on the Login button
  And I should be Logged in and the Header should present the message Swag Labs
  And Click in Burger menu to expand the sidebar menu
  And Click in LogOut
  Then The user must be logged out