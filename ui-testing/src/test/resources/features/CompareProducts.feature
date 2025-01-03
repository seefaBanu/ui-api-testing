@compare
Feature: Product Comparison Functionality
  As a user
  I want to be able to add products to a comparison list
  So that I can compare the features of different products

  Scenario: Add a product to the comparison list from the product detail page
    Given I am on the homepage for comparison
    When I search for "T-Shirt" for comparison
    And I select the "first" product for comparison
    When I click the "Add to Compare" link
    Then I should see a success message indicating that product was added to compare list
    And the product should be added to the compare products list and count 1
    When  I select the "second" product for comparison
    When I click the "Add to Compare" link
    Then I should see a success message indicating that product was added to compare list
    And the product should be added to the compare products list and count 2
    When I click the compare button
    Then I should see  the comparison list