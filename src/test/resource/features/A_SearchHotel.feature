@searchhotel
Feature: Search Hotel

Scenario: Search Hotel Successfully
  Given user is on booking website
  When user enters city
  And user clicks search
  Then hotel list should display