Feature: Set Availability for Weekly Hours

  Background:
    Given I choose Availability tab from Bottom
    When I am on weekly hours tab
    Then I choose to make Changes

  Scenario: Schedule Availability for Monday
    Given I click add icon for Monday
    When I set Start time
    And I set End time
    And I set this timings
    Then I submit for approval


    Scenario: Delete Availability for Tuesday
      Given I click delete icon for Tuesday
      Then I submit for approval

