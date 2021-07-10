Feature: first get request
  Scenario: send a get request and verify the response
    Given send get request using the api "https://restful-booker.herokuapp.com/booking/3"
    Then verify firstName
    And verify lastname

#  Scenario Outline: send a get request and verify the response
#    Given send get request using the api "<endpoint>"
#    Then verify firstName
#    And verify lastname
#    Examples: api
#    |endpoint|
#    | https://restful-booker.herokuapp.com/booking/3|
#    |https://restful-booker.herokuapp.com/booking/4 |



