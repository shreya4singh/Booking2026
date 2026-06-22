@selectdates
Feature: Select Dates

Scenario: Select checkin and checkout dates
  Given user is on booking website
  When user enters city
  And user selects dates
  And user clicks search
  Then hotel list should display