Feature: Get Book Requests

  @204078E
  Scenario: Admin GET all books
    Given admin is authenticated
    When admin sends a GET request to "/api/books"
    Then The response status code for GET Books API should be 200
    And the response should contain a list of books

  @204078E
  Scenario: User GET all books
    Given user is authenticated
    When user sends a GET request to "/api/books"
    Then The response status code for GET Books API should be 200
    And the response should contain a list of books

  @204078E
  Scenario: GET books with invalid query parameters
    Given admin is authenticated
    When admin sends a GET request to "/api/books?sort=invalid"
    Then The response status code for GET Books API should be 400
