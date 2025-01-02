Feature: Create Book API Testing

  Scenario: User tries to create a book
    Given user is authenticated
    When user sends a POST request to "/api/books" with the following data:
      | title   | Book17599a  |
      | Author | Author9|
    Then the response status code should be 201
    And the response should contain a "A new resource was created successfully"

  Scenario: User tries to create a book with invalid data
    Given user is authenticated
    When user sends a POST request to "/api/books" with invalid data:
      | title   |   |
      | Author | Authore|
    Then the response status code should be 400


