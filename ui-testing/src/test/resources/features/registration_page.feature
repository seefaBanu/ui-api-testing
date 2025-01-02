Feature: register new user
  As a user
  I want to register
  So that I can login

  Scenario: Create a new account to register
    Given I am on the homepage
    When I go to Create an Account page
    And I fill in the registration form with valid details
      | first_name  | last_name      | email                  | password       | confirm_password |
      | James       | anderson       | dynamic_email          | Password123!   | Password123!      |
    And I click Create an Account Button
    Then successfully created new account message should be "Thank you for registering with Main Website Store."

