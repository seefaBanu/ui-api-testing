@Checkout
Feature: Proceed to Checkout and Place Order without an Account
  As a guest user
  I want to add products to the cart
  and proceed to checkout
  So that I can place an order without an account, but I must create an account to complete the purchase.


  Scenario: User proceeds to checkout
    Given I logged in as a user
    And I have a product in the cart
    When I navigate to the shopping cart page
    And I click on the Proceed to Checkout button
    Then I should be redirected to the checkout page
    And I should be able to enter my shipping details
    And I should be redirected to payment page
    And I click place order
    And The order should be placed successfully


#  Scenario: User add new address
#    Given I logged in as a user
#    And I am on the homepage
#    When I click to the "Test User"
#    And I click to the MyAccount
#    Then I should be redirected to the MyAccount page
#    And I should be able to enter my shipping details
#    And I should be redirected to payment page
#    And I click place order
#    And The order should be placed successfully






#
##  Scenario: User reaches the order summary and is prompted to create an account
##    Given I have entered my shipping information
##    When I click on the "Place Order" button
##    Then I should see a prompt to create an account or log in
##    And I should not be able to place the order without an account
##
##  Scenario: User creates an account and completes the order
##    Given I am on the "Create an Account" page
##    When I enter valid registration details
##    And I click on the "Create Account" button
##    Then I should be logged in and redirected to the order summary page
##    And I should see an order confirmation message with my order details
##
##  Scenario: User fails to create an account with invalid details
##    Given I am on the "Create an Account" page
##    When I enter invalid registration details
##    And I click on the "Create Account" button
##    Then I should see error messages indicating the invalid fields
##    And I should not be able to create the account
##
##  Scenario: User places an order after logging in
##    Given I am logged in with a valid account
##    When I click on the "Place Order" button
##    Then I should be redirected to the order confirmation page
##    And I should see my order details and a confirmation message
