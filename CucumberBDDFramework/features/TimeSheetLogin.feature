Feature: TimeSheet Application

  @UATTesting
  Scenario: Login to TimeSheet Application
  
    Given Launch TimeSheet Application
    When Enter UserName and Password
    Then verify home Page
    Then click on Employee details
    Then click on admin link
    Then click on logout
