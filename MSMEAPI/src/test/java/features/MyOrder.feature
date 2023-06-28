@MyOrder
Feature: Validating MyOrderAPI

 @validateMyOrder
  Scenario: Validate MyOrder
    Given user calls "validatemyOrderAPI" with "Get" http request for "validateGST"
    Then validate that the "validatemyOrderAPI"  call response is success with status code "200"
    And validate the "validatemyOrderAPI" response time is less than "8000" ms
    And validate the "validatemyOrderAPI" payload structure has "pendingPaymentOrders"