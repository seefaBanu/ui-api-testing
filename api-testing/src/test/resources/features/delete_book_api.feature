Feature: Delete Book API Testing

  Background:
    Given admin is authenticated
    And user is authenticated

  # Scenario: Admin successfully deletes a book
  Scenario: Admin deletes a book with a valid ID
    When admin sends a DELETE request to "/api/books/{id}" with ID 2
    Then the response status code should be 200
    And the response should indicate book deletion with message "Book deleted successfully"
    And the response body should not contain details of deleted book with ID 2

  # Scenario: Admin tries to delete a book with an invalid ID
  Scenario: Admin deletes a book with an invalid ID
    When admin sends a DELETE request to "/api/books/{id}" with ID 9999
    Then the response status code should be 404
    And the response should indicate book deletion with message "Book not found"

  # Scenario: Unauthorized user tries to delete a book
  Scenario: User tries to delete a book with a valid ID
    When user sends a DELETE request to "/api/books/{id}" with ID 2
    Then the response status code for unauthorized access should be 403
    And the response should indicate unauthorized access with message "You are not authorized to delete books"

  # Scenario: Unauthorized user tries to delete a book with an invalid ID
  Scenario: User tries to delete a book with an invalid ID
    When user sends a DELETE request to "/api/books/{id}" with ID 9999
    Then the response status code for unauthorized access should be 403
    And the response should indicate unauthorized access with message "You are not authorized to delete books"
