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

