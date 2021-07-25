Feature: test some users
  Scenario: validate users
    Given send get request using  "users?page=2"
    Then verify users