Feature: remove product from cart
  As a user
  I want to remove products from the cart
  So that I can update my selection

  Scenario: Remove a product from the cart
    Given User is on the login page
    And User logs in with username and password
    When I go to the cart page
    And I click Remove for the product
    Then I click OK on confirmation popup
