Feature: race

  Scenario: start a race
    # dit deel straks via de service aanroepen
    When I create "/profiles" with:
    """
    {
      "name": "Johan"
    }
    """
    Then I should receive a response with status code 201
    And I should receive the http location header with path "/profiles/johan"
    And I should receive a response containing:
    """
    {
      "name": "Johan",
      "seasonRegistrations": [
        {
            "name": "2024-2025",
            "racingClass": "GO_KART",
            "accountBalance": 0,
            "vehicle": {
                "wheels": "STOCK",
                "engine": "STOCK",
                "chassis": "STOCK"
            },
            "trackInfo": [
                {
                    "name": "TUTORIAL",
                    "status": "UPCOMING"
                }
            ]
        }
      ]
    }
    """
#  Given profile "Johan" is created
    When I create "/races/TUTORIAL"
    Then I should receive a response with status code 204