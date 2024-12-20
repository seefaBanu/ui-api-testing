Feature: Book API Testing

  Scenario: Admin retrieves all books
    Given admin is authenticated
    When admin sends a GET request to "/api/books"
    Then the response status code should be 200
    And the response should contain a list of books

  Scenario: User retrieves a specific book
    Given user is authenticated
    When user sends a GET request to "/api/books/1"
    Then the response status code should be 200
    And the response should contain book details