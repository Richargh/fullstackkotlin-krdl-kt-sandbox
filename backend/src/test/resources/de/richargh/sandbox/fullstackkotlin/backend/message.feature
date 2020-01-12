Feature: Application can message

  Background:
    * url baseUrl

  Scenario: Greets the world
    Given path '/message'
    And request { user: 'Sillie', content: 'silly me' }
    When method POST
    Then status 200
    And match response == { Sup: 'silly me' }