@DirectUser
Feature: Validating DirectUserAPI

  @DirectUserLogin
  Scenario: Verify valid Direct User login
    Given user calls "directUserloginAPI" with "Post" http request for "directOrder"
    Then validate that the "directUserloginAPI"  call response is success with status code "200"
    And validate the "directUserloginAPI" response time is less than "8500" ms
    And validate the "directUserloginAPI" payload structure has "jwtToken"

  @MyRequirements
  Scenario: Verify valid MyRequirements
    Given user calls "directUserloginAPI" with "Post" http request for "directOrder"
    Then validate that the "directUserloginAPI"  call response is success with status code "200"
    And validate the "directUserloginAPI" response time is less than "8500" ms
    And validate the "directUserloginAPI" payload structure has "jwtToken"
    And extract the jwtToken
    And user calls "myrequirementsAPI" with "Get" http request for "myrequirements" with header
    Then validate that the "myrequirementsAPI"  call response is success with status code "200"
    And validate the "myrequirementsAPI" response time is less than "4000" ms
    And validate the "myrequirementsAPI" payload structure has "requirementId"

  @AddToRequirementCart
  Scenario: Verify AddToRequirementCart
    Given user calls "plantSelectorAPI" with "Post" http request for "PlantSelector"
    Then validate that the "plantSelectorAPI"  call response is success with status code "200"
    And validate the "plantSelectorAPI" response time is less than "4500" ms
    And validate the "plantSelectorAPI" payload structure has "channelId"
    And extract the channelId
    And user calls "addToCartAPI" with "Post" http request for "AddToRequirementCart"
    Then validate that the "addToCartAPI"  call response is success with status code "200"
    And validate the "addToCartAPI" response time is less than "4000" ms
    And validate the "addToCartAPI" payload structure has "DIRECT"

  @RequestForPrice
  Scenario: Verify RequestForPrice
    Given user calls "plantSelectorAPI" with "Post" http request for "PlantSelector"
    Then validate that the "plantSelectorAPI"  call response is success with status code "200"
    And validate the "plantSelectorAPI" response time is less than "4500" ms
    And validate the "plantSelectorAPI" payload structure has "channelId"
    And extract the channelId
    And user calls "addToCartAPI" with "Post" http request for "AddToRequirementCart"
    Then validate that the "addToCartAPI"  call response is success with status code "200"
    And validate the "addToCartAPI" response time is less than "4000" ms
    And validate the "addToCartAPI" payload structure has "DIRECT"
    And user calls "requestForPriceAPI" with "Get" http request for "directUser"
    Then validate that the "requestForPriceAPI"  call response is success with status code "200"
    And validate the "requestForPriceAPI" response time is less than "4000" ms
    And validate the "requestForPriceAPI" payload structure has "id"
