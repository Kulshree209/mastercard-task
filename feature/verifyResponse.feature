#Author: kulshree.patil@gmail.com
#Keywords Summary : Verify API response
#Feature: RESTAssuredVerification
#Scenario: I want to use this feature to validate API response

@feature1
Feature: RESTAssuredVerification
I want to use this feature to validate API response

@Test1
Scenario: Validating API response
	Given I want to verify the response of API
	Then I will get API response in JSON format
	And I am providing the status 'available' and petname 'doggie'
	#And I am providing the status <status> and petname 'doggie'
  Then I am calculating the pets 'doggie' with 'available' status
     
#Examples:  
       # | status 	 |
       # | available	|   