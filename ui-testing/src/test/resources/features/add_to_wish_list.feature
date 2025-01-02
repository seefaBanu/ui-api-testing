Feature: Add product to wish list
  As a user
  I want to add products to the wish list
  So that I can purchase them later

  Scenario: Add a product to the wish list
    Given I am on the homepage
    When I search for "T-Shirt"
    And I select the first product
    And I click the Add to Wish List
    Then A success message should be "Breathe-Easy Tank has been added to your Wish List. Click here to continue shopping.."