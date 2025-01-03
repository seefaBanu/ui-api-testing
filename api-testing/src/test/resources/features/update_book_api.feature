Feature: Update Book API Testing

  Scenario: Admin updates the Book with valid data
    Given admin is authenticated
    When "admin" sends a PUT request to "/api/books/1" with the following valid data:
      | id  | 1 |
      | title   | heart break  |
      | author | Banu  |
    Then the response status code for Updating Book API should be 200

  Scenario: Admin updates the book with missing mandatory fields
    Given admin is authenticated
    When "admin" sends a PUT request to "/api/books/1" with the following valid data:
      | id  | 1 |
      | title  |  empty string |
      | author | aysha  |
    Then the response status code for Updating Book API should be 400

  Scenario: Admin updates the book with non-existing ID
    Given admin is authenticated
    When "admin" sends a PUT request to "/api/books/999" with the following valid data:
      | id  | 999 |
      | title   | roses  |
      |  author | ulfath  |
    Then the response status code for Updating Book API should be 404
    And the response body for Update Book API should be "Book not found"

  Scenario: User updates the Book with valid data
    Given user is authenticated
    When "user" sends a PUT request to "/api/books/1" with the following valid data:
      | id  | 1 |
      | title   | mountains echoed  |
      |  author | kalid hosainee   |
    Then the response status code for Updating Book API should be 403
    And the response body for Update Book API should be "User is not permitted"

  @204078E
  Scenario: User tries to updates the Book with mismatch IDs
    Given user is authenticated
    When "user" sends a PUT request to "/api/books/1" with the following valid data:
      | id  | 2 |
      | title   | Other half  |
      |  author | Neya P   |
    Then the response status code for Updating Book API should be 400
    And the response body for Update Book API should be "Book id is not matched"
