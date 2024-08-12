Feature: chassis

  Scenario: retrieve chassis
    When I retrieve "/chassis"
    Then I should receive:
    """
    [
      {
        "name": "STOCK"
      }
    ]
    """