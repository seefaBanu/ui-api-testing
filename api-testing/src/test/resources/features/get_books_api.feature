Feature: Get Book Requests

  # Scenario: Admin successfully retrieves all books
  Scenario: Admin GET all books
    Given admin is authenticated
    When admin sends a GET request to "/api/books"
    Then The response status code for GET Books API should be 200
    And the response should contain a list of books

  # Scenario: User successfully retrieves all books
  Scenario: User GET all books
    Given user is authenticated
    When user sends a GET request to "/api/books"
    Then The response status code for GET Books API should be 200
    And the response should contain a list of books

  # Scenario: GET books when no books exist
  Scenario: GET books when no books exist
    Given admin is authenticated
    When admin sends a GET request to "/api/books"
    Then The response status code for GET Books API should be 200
    And the response should indicate no books available

  # Scenario: GET books with invalid query parameters
  Scenario: GET books with invalid query parameters
    Given admin is authenticated
    When admin sends a GET request to "/api/books?sort=invalid"
    Then The response status code for GET Books API should be 400
