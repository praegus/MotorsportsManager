Feature: OpenApi

  Scenario: retrieve openapi specs
    When I retrieve "/specs.yml"
    Then I should receive a response containing:
    """
    title: Motorsports Manager
    version: 1.0.0
    description: The ultimate gaming experience
    """