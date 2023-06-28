@SLO
Feature: Validating SLOAPI

  @SLO
  Scenario: Verify SLO api is working 
    Given user calls "SLOAPI" with "Post" http request for "slo"
    Then validate that the "SLOAPI"  call response is success with status code "200"
    And validate the "SLOAPI" response time is less than "10000" ms
    And validate the "SLOAPI" payload structure has "orderNumber"
