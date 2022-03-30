Feature: Login feature

@SmokeTest
Scenario: As a user I want to login to application with valid credentials
Given I will launch browser
And I will enter the url
When login page is displayed I will enter  username and password
And I will click on login 
Then I will validate whether home page is displayed or not

@RegressionTest 
Scenario: As a user I will enter invalid username and password for login
Given I will launch browser
And I will enter the url
When login page is displayed enter invalid username and password
And I will click on login 
Then Validate error message is displayed or not




