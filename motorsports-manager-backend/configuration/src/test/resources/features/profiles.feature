Feature: profiles

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

  Scenario Outline: profile names need to be unique while ignoring casing
    Given profile "<existingProfile>" already exists
    And I create "/profiles" with:
    """
    {
      "name": "<newProfile>"
    }
    """
    Then I should receive a response with status code 409
    And I should receive a response containing:
    """
    {
      "type": "duplicated-profile",
      "title": "Duplicated profile",
      "status": 409,
      "detail": "Profile with name '<newProfile>' already exists",
      "errors": []
    }
    """

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
    Then I should receive:
    """
    {
      "type": "${json-unit.ignore}",
      "title": "${json-unit.ignore}",
      "status": 400,
      "detail": "${json-unit.ignore}",
      "errors": [
        {
          "field": "name",
          "error": "<errorMessage>"
        }
      ]
    }
    """

    Examples:
      | profileName          | errorMessage                  |
      |                      | size must be between 1 and 10 |
      | :-)                  | must match \"^[a-zA-Z0-9]*$\" |
      | Dezenaamisveeltelang | size must be between 1 and 10 |

  Scenario Outline: get an existing profile
    Given profile "<existingProfile>" already exists
    When I retrieve "/profiles/<existingProfile>"
    Then I should receive a response with status code 200
    And I should receive a response containing:
    """
    {
      "name": "<existingProfile>",
      "seasonRegistrations": []
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
      "detail": "Profile with name 'notfound' not found",
      "errors": []
    }
    """

  Scenario: get all profiles
    Given profile "pro" already exists
    And profile "propro" already exists
    When I retrieve "/profiles"
    Then I should receive a response with status code 200
    And I should receive a response containing:
    """
    [
    {
      "name": "pro",
      "seasonRegistrations": []
    },
    {
      "name": "propro",
      "seasonRegistrations": []
    }
    ]
    """
