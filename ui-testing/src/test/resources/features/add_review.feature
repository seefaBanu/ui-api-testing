@AddReview
Feature: Add review to a product
  As a user
  I want to add review to the products

  Scenario: Add review to a product
    Given User is on the login page
    And User logs in with username and password
    When I search for "T-Shirt"
    And I select the first product
    And User clicks on the "Add Your Review" button
    And User fills out the review form with nickname "Jhon", summary "Great product", and review text "I love the quality and design of this T-shirt!"
    And User submits the review
    Then The review is successfully submitted and a success message is displayed