Feature: As a focused tester, I should be able to strike out completed reminders, so that I can see my accomplishment

  @complete-single
 Scenario: Completing a single reminder task
     Given user is on create reminder landing page
     When user creates a reminder "Write TestCases"
     Then user should see "Write TestCases" added to the reminder list
     And user should see a total of 1 reminders added to the list
     And user sees the active count to be "1"
     When user strikes out "Write TestCases"
     Then user sees the active count to be "0"

  @complete-multiple
   Scenario: Completing multiple reminder tasks
     Given user is on create reminder landing page
     When user creates a reminder "Write TestCases"
     And user creates a reminder "Review TestCases"
     And user creates a reminder "Automate TestCases"
     Then user should see a total of 3 reminders added to the list
     And user sees the active count to be "3"

     When user strikes out "Review TestCases"
     And user strikes out "Automate TestCases"
     Then user sees the active count to be "1"