Feature: Get Book By ID API Testing

  Scenario: User retrieves a specific book
    Given user is authenticated
    When user sends a GET request to "/api/books/1"
    Then the response status code should be 200
    And the response should contain book details


  Scenario: User attempts to retrieve a non-existent book
    Given user is authenticated
    When user sends a GET request to "/api/books/999"
    Then the response status code should be 404
    And the response should contain an error message
