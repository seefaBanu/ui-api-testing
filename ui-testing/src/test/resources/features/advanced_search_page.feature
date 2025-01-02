#Feature: Advanced Search for Products
#  As a user
#  I want to search for products using advanced filters
#  So that I can find specific products efficiently
#
#  Scenario: Search for a product using advanced search filters
#    Given I am on the homepage
#    When I click on "Advanced Search"
#    And I am redirected to the "Advanced Search" page
#    And I fill in the following fields:
#      | Product Name       | Radiant Tee   |
#      | SKU                | WS12        |
#      | Description        | Comfortable   |
#      | Short Description  | Casual Wear   |
#      | Price From          | 25  |
#      | Price to            | 40  |
#    And I click the "Search" button
#    Then go to the "Catalog Advanced Search" page
#    Then I should see a message "Search results displayed successfully."


Feature: Advanced Search for Products
  As a user
  I want to search for products using advanced filters
  So that I can find specific products efficiently

  Scenario: Search for a product using advanced search filters
    Given I am on the homepage
    When I go to the Advanced Search Page
    And I fill in the following fields:
      | Product Name       | Radiant Tee   |
      | SKU                | WS12        |
      | Description        | empty |
      | Short Description  | empty   |
      | Price From          | 20  |
      | Price to            | 40  |
    And I click the Search button
    Then succeeded message should be "1 item were found using the following search criteria"