@Checkout
Feature: Proceed to Checkout and Place Order
  As a  user
  I want to add products to the cart
  and proceed to checkout
  So that I can place an order without an account, but I must create an account to complete the purchase.


  Scenario: User proceeds to checkout
    Given User is on the login page
    And User logs in with username and password
    When I navigate to the shopping cart page
    And I click on the Proceed to Checkout button
    Then I should be redirected to the checkout page
    And I should click next and redirected to payment page
    And I click place order
    And The order should be placed successfully