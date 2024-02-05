@checkout @all @tests
Feature: Saucedemo - Cart Page Tests

  Scenario: Add any product - All inputs inserted - Successfull
    Given I access the Saucedemo Login Page
    When I enter a username standard_user
    And I enter a password secret_sauce
    And I click on the Login button
    And I should be Logged in and the Header should present the message Swag Labs

    And The Shopping_cart_badge should not be displayed
    And I click in Add To Cart button in first product
    And I click in Cart Icon
    And I click on Checkout button
    And I insert first name input
    And I insert last name input
    And I insert postal code
    And I click on continue button
    And I click on finish button
    Then The informations of completed checkout are displayed