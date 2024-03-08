@products @all @tests

Feature: Saucedemo - Products Tests

  Scenario: Remove any product

    Given I access the Saucedemo Login Page
    When I enter a username standard_user
    And I enter a password secret_sauce
    And I click on the Login button
    And I should be Logged in and the Header should present the message Swag Labs

    And I click in Add To Cart button in first product
    Then The Remove button is displayed

    #Verificar que o click on remove do produto está a dar erro
    And I click in button to remove from product screen
 #   Then The Shopping_cart_badge should not be displayed
