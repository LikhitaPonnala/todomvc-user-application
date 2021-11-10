Feature: As a busy tester, I should be able to create reminders, so that I can plan my day and not forget key tasks

  @single-reminder
  Scenario: Creating single reminder task
     Given user is on create reminder landing page
     When user creates a reminder "Write TestCases"
     Then user should see "Write TestCases" added to the reminder list
     And user should see a total of 1 reminders added to the list

  @multiple-reminders
  Scenario: Creating multiple reminder tasks
    Given user is on create reminder landing page
    When user creates a reminder "Write TestCases"
    And user creates a reminder "Review TestCases"
    And user creates a reminder "Automate TestCases"
    And user creates a reminder "Run Automated scripts"
    Then user should see a total of 4 reminders added to the list

  @multiple-datatable
  Scenario: Creating multiple reminders with datatables
    Given user is on create reminder landing page
    When user creates following reminders
    | Review TestScenario 1	|
    | Review TestScenario 2 |
    | Review TestScenario 3 |
    | Review TestScenario 4 |
    | Review TestScenario 5 |
    Then user should see a total of 5 reminders added to the list

  @multiple-example
  Scenario Outline: Creating multiple reminders with examples
    Given user is on create reminder landing page
    When user creates a reminder "<Reminder>"
    Then user should see "<Reminder>" added to the reminder list
    Then user should see a total of <Count> reminders added to the list

    Examples:
    | Reminder    			| Count |
    | Review TestScenario 1	|	1	|
    | Review TestScenario 2 |	1	|
    | Review TestScenario 3 |	1	|
    | Review TestScenario 4 |	1	|
    | Review TestScenario 5 |	1	|


  @refresh
  Scenario: Verifying reminders are maintained in list, even on browser refresh
    Given user is on create reminder landing page
    When user creates following reminders
    | TestCase 1 |
    | TestCase 2 |
    | TestCase 3 |
    | TestCase 4 |
    | TestCase 5 |
    Then user should see a total of 5 reminders added to the list
    When user refreshes the reminder landing page
    Then user should see a total of 5 reminders added to the list
