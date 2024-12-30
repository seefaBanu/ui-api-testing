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

  Scenario: Invalid ID Test
    Given the endpoint "/api/books/abc"
    When a GET request is sent
    Then the response status code should be 400
    And the response body should contain an error message "Invalid input"

  Scenario: Without Authentication Test
    Given the endpoint "/api/books/1"
    And no authentication header is provided
    When a GET request is sent
    Then the response status code should be 401
    And the response body should contain an error message "Authentication required"
