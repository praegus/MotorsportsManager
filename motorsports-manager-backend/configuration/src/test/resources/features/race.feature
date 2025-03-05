Feature: race

  Scenario: start a race
    # dit deel straks via de service aanroepen
    Given I create "/profiles" with:
    """
    {
      "name": "Johan"
    }
    """
    When I create "/races/TUTORIAL"
    Then I should receive a response with status code 204
    When I retrieve "/profiles/Johan"
    And Json should contain these values:
    """
    {
      "seasonRegistrations": [
          {
              "accountBalance": 10000,
              "currentPosition":3,
              "trackInfo": [
                  {
                      "name": "TUTORIAL",
                      "status": "COMPLETED",
                      "prizeMoney": 10000
                  },
                  {
                      "name": "WINDY_ROAD",
                      "status": "UPCOMING"
                  }
              ]
          }
      ]
  }
    """