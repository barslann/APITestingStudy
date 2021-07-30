Feature: delete request
  Scenario: send a delete request and verify the response
    Given send delete request using the api "https://reqres.in/api/users/2"
    And statusCode must be 204
