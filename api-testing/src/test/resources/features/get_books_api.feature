Feature: Get Book API Testing

  Scenario: Admin retrieves all books
    Given admin is authenticated
    When admin sends a GET request to "/api/books"
    Then the response status code should be 200
    And the response should contain a list of books
    And the response should contain book details

  Scenario: User retrieves all books
    Given user is authenticated
    When user sends a GET request to "/api/books"
    Then the response status code should be 200
    And the response should contain a list of books
    And the response should contain book details

  Scenario: Retrieve books when no books exist
    Given admin is authenticated
    When admin sends a GET request to "/api/books"
    Then the response status code should be 200
    And the response should indicate no books exist

  Scenario: Retrieve books with invalid query parameters
    Given admin is authenticated
    When admin sends a GET request to "/api/books?sort=title"
    Then the response status code should be 400
    And the response should contain an error message "Invalid query parameter"
