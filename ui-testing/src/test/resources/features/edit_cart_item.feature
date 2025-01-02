Feature: Edit an item on cart
  As a user
  I want to edit an item that already added to cart


  Scenario: Edit an item on cart
    Given I am on the homepage
    When I go to the cart page
    And I click edit icon of the added item "Radiant Tee"
    And I edit size "L" and color "Orange"
    And I click "Update Cart"
    Then success message for update should be "Radiant Tee was updated in your shopping cart."