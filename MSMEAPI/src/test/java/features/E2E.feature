@E2E
Feature: EndToEnd Regression Scenario

  Scenario: Verify EndToEndScenario
    Given user calls "addToCartAPI" with "Post" http request for "addToCart"
    Then validate that the "addToCartAPI"  call response is success with status code "200"
    And validate the "addToCartAPI" response time is less than "8500" ms
    And validate the "addToCartAPI" payload structure has "orderCartSummary"
    And user calls "cartSizeAPI" with "Get" http request for "addToCart"
    Then validate that the "cartSizeAPI"  call response is success with status code "200"
    And validate the "cartSizeAPI" response time is less than "4000" ms
    And validate the "cartSizeAPI" payload structure has "lineItemCount"
    And user calls "createOrderAPI" with "Post" http request for "createOrder"
    And validate the "createOrderAPI" payload structure has "paymentLink"
    And extract the orderno
    Given user calls "orderSummaryAPI" with "Get" http request with pathParam "<orderNum>"
    Then validate that the "orderSummaryAPI"  call response is success with status code "200"
    And validate the "orderSummaryAPI" response time is less than "5000" ms
    # And validate the "orderSummaryAPI" payload structure has "pendingPaymentOrders"
    Given user calls "orderAPI" with "Get" http request with pathParam "<orderNum>"
    Then validate that the "orderAPI"  call response is success with status code "200"
    Given user calls "bankAPI" with "Get" http request for "validatebank"
    Then validate that the "bankAPI"  call response is success with status code "200"
    And validate the "bankAPI" response time is less than "5000" ms
    And validate the "bankAPI" payload structure has "Bank of Maharashtra"
    Given user calls "paymentSummaryAPI" with "Get" http request with pathParam "<orderNum>"
    Then validate that the "paymentSummaryAPI"  call response is success with status code "200"
    And validate the "paymentSummaryAPI" response time is less than "5000" ms
    And validate the "paymentSummaryAPI" payload structure has "paymentLink"
    And extract the ctorderId
    Given user calls "razorPayOrderAPI" with "Post" http request with pathParam for "<ctorderId>"
  Then validate that the "razorPayOrderAPI"  call response is success with status code "200"
    And validate the "razorPayOrderAPI" response time is less than "5500" ms
    And validate the "razorPayOrderAPI" payload structure has "Razorpay Order created successfully"