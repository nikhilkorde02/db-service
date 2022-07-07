Feature: Sample API Test
Scenario: Run a sample GEt API

  Given url 'http://localhost:8300/rest/db/Nikhil';
  When method GET
  Then status 200
