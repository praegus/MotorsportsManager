Feature: profile

  Scenario: create a valid new profile
    When I create "/profile" with:
    """
    {
      "name": "Johan"
    }
    """
    Then I should receive a response with status code 201
    And I should receive the http location header with path "/profile/johan"

  Scenario Outline: profile names need to be unique while ignoring casing
    Given profile "<existingProfile>" already exists
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

  Scenario Outline: profile names need to have a length between 1 and 10 alpha numeric characters
    When I create "/profile" with:
  """
  {
    "name": "<profileName>"
  }
  """
    Then I should receive a response with status code 400
    And I should receive the error message <errorMessage>

    Examples:
      | profileName          | errorMessage                             |
      |                      | [name]: must match "^[a-zA-Z0-9]{1,10}$" |
      | :-)                  | [name]: must match "^[a-zA-Z0-9]{1,10}$" |
      | Dezenaamisveeltelang | [name]: must match "^[a-zA-Z0-9]{1,10}$" |




