Feature: end to end state test
  Scenario: end to end
    Given send post request to create a state
    And send a get request to ensure that state is created
    And send a put request to update the state
    And send a delete request to delete the state
    And send a get request again to make sure the state is deleted
