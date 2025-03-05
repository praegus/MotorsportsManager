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
    When I retrieve "/profiles/johan"
    And I should receive:
    """
    {
      "name": "Johan",
      "seasonRegistrations": [
          {
              "name": "2024-2025",
              "racingClass": "GO_KART",
              "accountBalance": 10000,
              "vehicle": {
                  "wheels": "STOCK",
                  "engine": "STOCK",
                  "chassis": "STOCK"
              },
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