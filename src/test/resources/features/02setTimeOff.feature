Feature: set Time off

  Scenario: I set off Timings
    Given I choose Availability tab from Bottom
    And I am on time off tab
    When I make a new Request
    And I select a date
    Then I submit for approval
