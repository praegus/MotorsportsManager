Feature: profiles

  @DirtiesProfiles
  Scenario: create a valid new profile
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
      "name": "Johan"
    }
    """

  @DirtiesProfiles
  Scenario Outline: profile names need to be unique while ignoring casing
    Given profile "<existingProfile>" already exists
    And I create "/profiles" with:
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
    When I create "/profiles" with:
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

  @DirtiesProfiles
  Scenario Outline: get an existing profile
    Given profile "<existingProfile>" already exists
    When I retrieve "/profiles/<existingProfile>"
    Then I should receive a response with status code 200
    And I should receive a response containing:
    """
    {
      "name": "<existingProfile>"
    }
    """
    Examples:
      | existingProfile |
      | Gettum          |
      | notfound        |

  Scenario: get an unknown profile
    When I retrieve "/profiles/notfound"
    Then I should receive a response with status code 404
    And I should receive a response containing:
    """
    {
      "type": "profile-not-found",
      "title": "Profile not found",
      "status": 404,
      "detail": "Profile not found",
      "instance": null
    }
    """

  @DirtiesProfiles
  Scenario: get all profiles
    Given profile "pro" already exists
    And profile "propro" already exists
    When I retrieve "/profiles"
    Then I should receive a response with status code 200
    And I should receive a response containing:
    """
    [
    {
      "name": "pro"
    },
    {
      "name": "propro"
    }
    ]
    """
