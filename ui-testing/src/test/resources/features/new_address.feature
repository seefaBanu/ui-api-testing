@NewAddress
Feature: Add a new address
  As a user
  I want to add a new address
  So that I can use them later

  Scenario: User adds a new address
    Given User is on the login page
    And User logs in with username and password
    When I click menu toggle
    And I go to the MyAccount
    And click address book
    And click new address button
    And I fill in the new address details:
      | Field            | Test               |
      | First Name       | User                |
      | Last Name        | Doe                 |
      | Company          | Test Company Ltd    |
      | Phone Number     | 1234567890          |
      | Street Address   | 123 Test Street     |
      | City             | Test City           |
      | State            | New York            |
      | Post Code        | 12345               |
      | Country          | United States       |
    And I click the save address
    Then The success message should be "You saved the address."
