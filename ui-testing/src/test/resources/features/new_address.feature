Feature: Add a new address
  As a user
  I want to add new address
  So that I can use them later

  Scenario: User add new address
      Given I logged in as a user
      When I click menu toggle
      And I go to the MyAccount
      And click address book
      And click new address button
      And filled the fields in new address page
      And I click "save button"
      Then The successful message should be "You saved the address"

