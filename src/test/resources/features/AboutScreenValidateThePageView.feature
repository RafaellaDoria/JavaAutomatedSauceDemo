@about @all @tests
Feature: Saucedemo - About screen

  Scenario: Validate the about screen - View all page
    Given I access the Saucedemo Login Page
    When I enter a username standard_user
    And I enter a password secret_sauce
    And I click on the Login button
    And I should be Logged in and the Header should present the message Swag Labs

    And I click on burger menu
    And I go to the About Screen
    Then I can see the sauce labs image
#    And I can see the Website and mobile title
