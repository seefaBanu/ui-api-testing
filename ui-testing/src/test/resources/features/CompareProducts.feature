Feature: Product Comparison Functionality

  As a customer
  I want to be able to add products to a comparison list
  So that I can compare the features of different products

  Scenario: Add a product to the comparison list from the product detail page
    Given I am on the homepage
    When I search for "T-Shirt"
    And I select the first product
    And I select size "M" and color "Blue"
    And I click "Add to Cart"
    Then the cart should show "1" item
    When I navigate to the product detail page
    When I click the "Add to Compare" link
    Then I should see a success message indicating that product was added to compare list
    And the product should be added to the compare products list


  Scenario: Add multiple products to the comparison list
    Given I am on the homepage
    When I search for "Short"
    And I select the first product
    And I click the "Add to Compare" link
    Then I should see a success message indicating that product was added to compare list
    And the product should be added to the compare products list
    When I search for "Hoodie"
    And I select the first product
    And I click the "Add to Compare" link
    Then I should see a success message indicating that product was added to compare list
    And the product should be added to the compare products list
    When I go to the compare product page
    Then I should see "2" products in the comparison list