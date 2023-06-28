@cart
Feature: Validating ProductAPI

  @TMT
  Scenario: Verify ADD to cart api is working for TMT product
    Given user calls "addToCartAPI" with "Post" http request for "addToCart"
    Then validate that the "addToCartAPI"  call response is success with status code "200"
    And validate the "addToCartAPI" response time is less than "8000" ms
    And validate the "addToCartAPI" payload structure has "orderCartSummary"
    And user calls "clearCartAPI" with "Post" http request for "addToCart"
    Then validate that the "clearCartAPI"  call response is success with status code "201"
    And validate the "clearCartAPI" response time is less than "4000" ms
    And validate the "clearCartAPI" payload structure has "customerData"
