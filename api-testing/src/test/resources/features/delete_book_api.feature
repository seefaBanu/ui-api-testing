Feature: Delete Book API Testing



  # Scenario: Admin successfully deletes a book
  Scenario: Admin deletes a book with a valid ID
    Given admin is authenticated
    When admin sends a DELETE request to "/api/books/{id}" with ID 2
    Then the response status code should be 200

  # Scenario: Admin tries to delete a book with an invalid ID
  Scenario: Admin deletes a book with an invalid ID
    Given admin is authenticated
    When admin sends a DELETE request to "/api/books/{id}" with ID 9999
    Then the response status code should be 404
    And the response should indicate book deletion with message "Book not found"

      # Scenario: Admin tries to delete a book with an incorrect ID
  Scenario: Admin deletes a book with an incorrect ID
    Given admin is authenticated
    When admin sends a DELETE request to "/api/books/{id}" with ID "ab"
    Then the response status code should be 400


  # Scenario: Unauthorized user tries to delete a book
  Scenario: User tries to delete a book
    Given user is authenticated
    When user sends a DELETE request to "/api/books/{id}" with ID 2
    Then the response status code for unauthorized access should be 403
    And the response should indicate book deletion with message "User is not permitted"

