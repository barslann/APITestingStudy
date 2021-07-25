Feature: test all reqres.in apis
#    Scenario Outline: validate single user
#        Given send get request using the reqres api "<api>"
#        Then verify the single user's firstName "<firstName>"
#        Examples: test data
#        |api|firstName|
#        |users/2 | Janet|
        
        
        Scenario: validate users
            Given send get request using the api "users?page=2"
            Then verify some users









