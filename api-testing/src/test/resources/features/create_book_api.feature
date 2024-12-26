Feature: Create Book API Testing

  Scenario: User tries to create a book
    Given user is authenticated
    When user sends a POST request to "/api/books" with the following data:
      | title   | Book24 |
      | Author | Author10|
    Then the response for creating book api status code should be 201

  Scenario: User tries to create a book with invalid data
    Given user is authenticated
    When user sends a POST request to "/api/books" with invalid data:
      | title   |   |
      | Author | Authore|
    Then the response for creating book api status code should be 400

  Scenario: Un Authenticated Request to create book
    Given user is not authenticated
    When un authenticated POST request to "/api/books" with the following data:
      | title | Science |
      | author | Author2 |
    Then the response for creating book api status code should be 401

  Scenario: User creates a book with an empty author and title
    Given user is authenticated
    When user sends a POST request to "/api/books" with the following data:
      | title | |
      | author | |
    Then the response for creating book api status code should be 400

  Scenario: User creates a book with a duplicate title
    Given user is authenticated
    When user sends a POST request to "/api/books" with the following data:
      | title | Book24 |
      | author | Author5 |
    Then the response for creating book api status code should be 208

  Scenario: User creates a book with additional parameter
    Given user is authenticated
    When user sends a POST request to "/api/books" with the following data:
      | title | History |
      | author | 12345 |
      | genre | novels |
    Then the response for creating book api status code should be 400

