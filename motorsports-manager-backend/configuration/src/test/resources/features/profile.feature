Feature: profile

  Scenario: create a new profile
    When I create "/profile" with:
    """
    {
      "name": "Johan"
    }
    """
    Then I should receive a response with status code 201
    And I should receive the http location header with path "/profile/johan"

  Scenario: create a duplicate profile with same cased name
    When I create "/profile" with:
    """
    {
      "name": "BestaatAl"
    }
    """
    And I create "/profile" with:
    """
    {
      "name": "BestaatAl"
    }
    """
    Then I should receive a response with status code 409


  Scenario: create a duplicate profile with same differently cased name
    When I create "/profile" with:
    """
    {
      "name": "Cased"
    }
    """
    And I create "/profile" with:
    """
    {
      "name": "cased"
    }
    """
    Then I should receive a response with status code 409
