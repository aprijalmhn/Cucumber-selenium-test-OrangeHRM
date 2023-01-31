@Test
Feature: Login test
  @Test1
  Scenario: Login success on web
    Given Open web url "http://employee.sdcillsy.my.id/"
    And Input username "Admin" and password "s3Kol4HQA!*"
    When Click login button
    Then Should success login and redirected to homepage

  @Test2
  Scenario Outline: Add User on in menu PIM
    Given Login web "<url>"
    And Click menu PIM and Add button
    And Input first name "<first_name>", middle name "<middle_name>" and last name "<last_name>"
    When Click textfield Create Login Details
    And Input username "<username>" password "<password>" and confirm password "<confirm_password>"
    And Click save button
    Then Should success add user and redirected to PIM page
  Examples:
   |url |first_name|middle_name|last_name|username|password|confirm_password|
   |http://employee.sdcillsy.my.id/ |Bolang|Bocah|Petualang|Bolang3|Bolang31*|Bolang31*|

  @Test3
  Scenario: Punch in Punch out and logout on web
    Given Login web url "http://employee.sdcillsy.my.id/"
    And Click icon time
    When Click In button
    Then Should succes punch in
    And Click Out button
    Then Should succes punch out
    And Click menu account or profile picture
    When  Click menu logout
    Then Should succes logout


