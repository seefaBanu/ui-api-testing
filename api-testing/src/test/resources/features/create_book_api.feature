
Feature: Create Book API Testing

  Scenario: User tries to create a book
    Given user is authenticated
    When user sends a POST request to "/api/books" with the following data:
      | title   | Mocking Bird |
      | author | Lovers lee|
    Then the response for creating book api status code should be 201

  Scenario: User tries to create a book with invalid data
    Given user is authenticated
    When user sends a POST request to "/api/books" with invalid data:
      | title   |  Mocking pet |
      | author | Author4|
    Then the response for creating book api status code should be 400

    