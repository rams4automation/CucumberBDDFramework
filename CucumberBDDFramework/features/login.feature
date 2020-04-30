Feature: Employee TimeSheet

  @Smoke
  Scenario Outline: Title of your scenario outline
    Given Launch Employee TimeSheet
    When Enter "<UserName>" and "<Password>"
    Then Logout Employee timesheet

    Examples: 
      | UserName | Password |
      | admin    | admin    |
      | admin    | admin    |
      | admin    | admin    |
      | admin    | admin    |
