Feature: Add product to cart
  As a user
  I want to add products to the cart 
  So that I can purchase them later

  Scenario: Add a single product to the cart
    Given I am on the homepage
    When I search for "T-Shirt"
    And I select the first product
    And I select size "M" and color "Blue"
    And I click "Add to Cart"
    Then success message should be "You added Radiant Tee to your shopping cart."