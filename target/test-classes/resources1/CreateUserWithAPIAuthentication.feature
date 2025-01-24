@smoke
Feature: Create a new user and process authentication

  Scenario Outline: NewUser cration with authnetican
    Given User has requested to hit an application url
    And user passes a paylaod with all required credentials
    When the user is going to hit url "<endpoint>"
    Then the user will be able to validate response code and the body

    Examples: 
      | endpoint        |
      | public/v2/users |
