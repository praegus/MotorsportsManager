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

  Scenario Outline: profile names need to be unique while ignoring casing
    When I create "/profile" with:
  """
  {
    "name": "<existingProfile>"
  }
  """
    And I create "/profile" with:
  """
  {
    "name": "<newProfile>"
  }
  """
    Then I should receive a response with status code 409

    Examples:
      | existingProfile | newProfile |
      | BestaatAl       | BestaatAl  |
      | Cased           | cased      |
