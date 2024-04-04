Feature: teams

  Scenario: create a team
    When I create "/teams" with:
    """
    {
      "name": "Fin",
      "slogan": "For Cheese!"
    }
    """
    When I retrieve "/teams"
    Then I should receive:
    """
    [
      {
        "name": "Fin",
        "slogan": "For Cheese!"
      }
    ]
    """