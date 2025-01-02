@Wishlist
Feature: Add product to wish list
  As a user
  I want to add products to the wish list
  So that I can purchase them later

  Scenario: Add a product to the wish list
    Given User is on the login page
    And User logs in with username and password
    When I search for "T-Shirt"
    And I select the second product
    And I click the Add to Wish List
    Then A success message should be "Radiant Tee has been added to your Wish List. Click here to continue shopping."