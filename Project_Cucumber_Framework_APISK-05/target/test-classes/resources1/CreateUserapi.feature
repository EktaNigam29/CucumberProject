@sanity
Feature: Creation of new user with all payload details

  Scenario Outline: Creation of a new user for a demo site
    Given user has requested to it an appliaction URL
    And user will pass the payload with all needed details
    When the user will hit the specific "<endpoint1>"
    Then we are going to validate the status code as specific "<statuscode>"

    Examples: 
      | endpoint1  | statuscode |
      | api/users |        201 |
