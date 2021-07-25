Feature: post request
  Scenario: send a post request to create a user and verify the user
    Given send post request using the api "https://reqres.in/api/users"
    Then verify statusCode
    And verify server in header
    And verify the user

