@cart
Feature: Validating CartAPI

  @AddToCart
  Scenario: Verify ADD to cart api is working for Cement product
    Given user calls "clearCartAPI" with "Post" http request for "addToCart"
    Then validate that the "clearCartAPI"  call response is success with status code "201"
    And validate the "clearCartAPI" response time is less than "4000" ms
    And validate the "clearCartAPI" payload structure has "customerData"
    Given user calls "addToCartAPI" with "Post" http request for "addToCart"
    Then validate that the "addToCartAPI"  call response is success with status code "200"
    And validate the "addToCartAPI" response time is less than "8000" ms
    And validate the "addToCartAPI" payload structure has "orderCartSummary"
    And user calls "clearCartAPI" with "Post" http request for "addToCart"
    Then validate that the "clearCartAPI"  call response is success with status code "201"
    And validate the "clearCartAPI" response time is less than "4000" ms
    And validate the "clearCartAPI" payload structure has "customerData"
    

  @CartSize
  Scenario: Verify cartSize api is working for Cement product
    Given user calls "addToCartAPI" with "Post" http request for "addToCart"
    Then validate that the "addToCartAPI"  call response is success with status code "200"
    And validate the "addToCartAPI" response time is less than "8000" ms
    And validate the "addToCartAPI" payload structure has "orderCartSummary"
    And user calls "cartSizeAPI" with "Get" http request for "addToCart"
    Then validate that the "cartSizeAPI"  call response is success with status code "200"
    And validate the "cartSizeAPI" response time is less than "4000" ms
    And validate the "cartSizeAPI" payload structure has "lineItemCount"
     And user calls "clearCartAPI" with "Post" http request for "addToCart"
    Then validate that the "clearCartAPI"  call response is success with status code "201"
    And validate the "clearCartAPI" response time is less than "4000" ms
    And validate the "clearCartAPI" payload structure has "customerData"
    

  @ClearCart
  Scenario: Verify Clear cart api is working
    Given user calls "addToCartAPI" with "Post" http request for "addToCart"
    Then validate that the "addToCartAPI"  call response is success with status code "200"
    And validate the "addToCartAPI" response time is less than "8000" ms
    And validate the "addToCartAPI" payload structure has "orderCartSummary"
    And user calls "clearCartAPI" with "Post" http request for "addToCart"
    Then validate that the "clearCartAPI"  call response is success with status code "201"
    And validate the "clearCartAPI" response time is less than "4000" ms
    And validate the "clearCartAPI" payload structure has "customerData"

  @RemoveCart
  Scenario: Verify Remove cart api is working
    Given user calls "addToCartAPI" with "Post" http request for "addToCart"
    Then validate that the "addToCartAPI"  call response is success with status code "200"
    And validate the "addToCartAPI" response time is less than "8000" ms
    And validate the "addToCartAPI" payload structure has "orderCartSummary"
    And user calls "cartSumamryAPI" with "Get" http request for "cartSumamryAPI"
    Then validate that the "cartSumamryAPI"  call response is success with status code "200"
    And validate the "cartSumamryAPI" response time is less than "4000" ms
    And validate the "cartSumamryAPI" payload structure has "ctLineItemId"
    And extract the ctLineItemId
    And user calls "removeCartItemAPI" with "Post" http request with queryParam for "itemId"
    Then validate that the "removeCartItemAPI"  call response is success with status code "200"
    And validate the "removeCartItemAPI" response time is less than "4000" ms
    And validate the "removeCartItemAPI" payload structure has "orderCartSummary"
    
    
