@OrdersAndReturn
Feature: Orders and Returns Functionality

  Scenario: Access Orders and Returns page from Home page
    Given I am on the Home page
    When I click on the "Orders and Returns" link
    And I should be redirected to the Orders and Returns page
    And I enter "000034243" into the "Order ID" field
    And I enter "User" into the "Billing Last Name" field
    And I enter "testuser123test@gmail.com" into the "Email" field
    And I click the "Continue" button
    Then I should see the order details page
    And Order details should be shown for order id "000034243"