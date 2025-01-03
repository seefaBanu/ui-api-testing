Feature: Get Book By ID API Testing

  Scenario: User retrieves a specific book
    Given user is authenticated
    When user sends a GET Book by ID request to "/api/books/1"
    Then the response status code for GET book by ID API should be 200
    And the response should contain book details

  Scenario: Admin retrieves a specific book
    Given admin is authenticated
    When admin sends a GET Book by ID request to "/api/books/1"
    Then the response status code for GET book by ID API should be 200
    And the response should contain book details

  Scenario: Admin attempts to retrieve a non-existent book
    Given admin is authenticated
    When admin sends a GET Book by ID request to "/api/books/999"
    Then the response status code for GET book by ID API should be 404
    And the response should indicate book retrieve with message "Book not found"

  Scenario: Invalid ID Test
    Given admin is authenticated
    When admin sends a GET Book by ID request to "/api/books/abc"
    Then the response status code for GET book by ID API should be 400