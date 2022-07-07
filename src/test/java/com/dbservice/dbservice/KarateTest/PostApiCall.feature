Feature: Post Api call
  Background:
    * configure ssl = true
  Scenario: Test post api call
    Given path 'http://localhost:8304/rest/db/add';
    And request {"userName":"NIKHIL","quotes":["RIL"]}
    When method POST
    Then status 200
#    And match response !=null