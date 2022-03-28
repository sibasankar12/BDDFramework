Feature: DataDriven Testing

Scenario: As a user I want create new organization with mandatory fileds
Given launch "chrome" browser
And Enter url "http://localhost:8888" 
And In login page enter username "admin" and password "admin"
And click on login
When Home page is displayed click on create organization
And click on create new organization Image icon
And enter organization name as "Google"
Then Validate whether organization is created with name "Google"
