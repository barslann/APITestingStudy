Feature: put request
  Scenario: send a put request and verify the response
    Given send put request using the api "https://reqres.in/api/users/2"
    And verify updated user firstName
    And verify updated user job
    And verify update request statusCode
