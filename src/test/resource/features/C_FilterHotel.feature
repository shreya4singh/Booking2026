@filterhotel
Feature: Filter Hotels

Scenario: Apply 5 star filter 

Given user is on booking website
When user enters city
And user selects dates
And user clicks search
Then hotel list should display
When user applies 5 star filter 
Then filtered hotel list should display