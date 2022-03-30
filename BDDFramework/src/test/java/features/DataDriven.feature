Feature: DataDriven Testing
#Background keyword is used to execute preconditions 
#Background will be execute for every scenario
#It will work for both scenario and scenario outline
  Background: 
    #Given launch "chrome" browser-> taken care by Hook class
    And Enter url "http://localhost:8888"
    And In login page enter username "admin" and password "admin"
    And click on login
    When Home page is displayed click on create organization


@SmokeTest
  Scenario: Already user in Home page and want create new organization with mandatory fileds
    And click on create new organization Image icon
    And enter organization name as "Google"
    Then Validate whether organization is created with name "Google"

@RegressionTest
  Scenario Outline: I want create multiple organization with organization name and industry type
    And click on create new organization Image icon
    And enter organization name "<organizationName>"
    And From dropdown select industry type as "<IndustryType>"
    Then validate the organization name "<organizationName>" and dropdown "<IndustryType>"

    Examples: 
      | organizationName | IndustryType  |
      | Amazon           | Technology    |
      | Mintra           | Manufacturing |
      | Google           | Engineering   |

@End2End 
  Scenario: Read data from data table
    When I want to read data from below table
      | Java       | Programming langauge |
      | Python     | Interpretor          |
      | JavaScript | Scripting langauge   |
