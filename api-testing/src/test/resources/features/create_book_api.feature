Feature: Create Book API Testing

  Scenario: User creates a book with valid data
    Given user is authenticated
    When "user" sends a POST request to "/api/books" with valid data:
      | title   | Mocking Bird |
      | author | Harpers lee|
    Then the response status code for Create Book API should be 201

  Scenario: User creates a book without title
    Given user is authenticated
    When user sends a POST request to "/api/books" without mandatory field
      | author | Rawling|
    Then the response status code for Create Book API should be 400
    And the response body for Create Book API should be "Mandatory parameters should not be null"

  Scenario: User creates a book without author
    Given user is authenticated
    When user sends a POST request to "/api/books" without mandatory field
      | title | Winged Dreams|
    Then the response status code for Create Book API should be 400
    And the response body for Create Book API should be "Mandatory parameters should not be null"

  Scenario: Admin creates a book without author
    Given admin is authenticated
    When "admin" sends a POST request to "/api/books" with valid data:
      | title   | The Kite Runner |
      | author | Khalid |
    Then the response status code for Create Book API should be 201


    