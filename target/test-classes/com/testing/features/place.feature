Feature: Validating Place API's

Scenario: Verify if place is being successfully added using addPlaceAPI
Given Add place API payload
When user calls "addPlaceAPI" with Post http Request
Then the API call is sucess with status code 200
And  "status" in response body is "OK"
And "scope" in response body is "APP"