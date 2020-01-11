Feature: Application greets

  Background:
    * url baseUrl

  Scenario: Greets the world
    Given path '/hi'
    When method GET
    Then status 200
    And match $ == 'Hello World'