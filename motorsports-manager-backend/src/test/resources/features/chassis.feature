Feature: chassis

  Scenario: retrieve chassis
    When I retrieve "/api/chassis"
    Then I should receive:
    """
    [
      {
        "name": "pretty",
        "color": "red"
      },
      {
        "name": "strong",
        "color": "yellow"
      }
    ]
    """