Feature: Orders and Returns Functionality

  Scenario: Access Orders and Returns page from Home page
    Given I am on the Home page
    When I click on the "Orders and Returns" link
    Then I should be redirected to the Orders and Returns page

  Scenario: Submit Orders and Returns form with valid data
    Given I am on the Orders and Returns page
    When I enter "123456" into the "Order ID" field
    And I enter "Doe" into the "Billing Last Name" field
    And I select "Email" as the search method
    And I enter "testuser123test@gmail.com" into the "Email" field
    And I click the "Continue" button
    Then I should see the order details page

  Scenario: Submit Orders and Returns form with missing required fields
    Given I am on the Orders and Returns page
    When I leave the "Order ID" field empty
    And I enter "Doe" into the "Billing Last Name" field
    And I select "Email" as the search method
    And I enter "testuser123test@gmail.com" into the "Email" field
    And I click the "Continue" button
    Then I should see an error message indicating that "Order ID" is a required field

  Scenario: Submit Orders and Returns form with invalid data
    Given I am on the Orders and Returns page
    When I enter "invalid" into the "Order ID" field
    And I enter "Unknown" into the "Billing Last Name" field
    And I select "Email" as the search method
    And I enter "testuser123test@gmail.com" into the "Email" field
    And I click the "Continue" button
    Then I should see a message indicating that no order was found with the provided information
