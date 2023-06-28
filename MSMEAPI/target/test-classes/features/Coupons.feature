@Coupons
Feature: Validating CouponAPI

  @validateCoupon
  Scenario Outline: Valid product with valid and invalid coupon
    Given user calls "addToCartAPI" with "Post" http request for "addToCart"
    Then validate that the "addToCartAPI"  call response is success with status code "200"
    And validate the "addToCartAPI" response time is less than "8000" ms
    And validate the "addToCartAPI" payload structure has "orderCartSummary"
    Given user calls "validateCouponAPI" with "Post" http request with queryParam "<Param>" and "<CouponValue>"
    Then validate that the "validateCouponAPI"  call response is success with status code "200"
    And validate the "validateCouponAPI" response time is less than "4000" ms
    And validate the "validateCouponAPI" payload structure has "<ValidationMsg>"
    And user calls "clearCartAPI" with "Post" http request for "addToCart"
    Then validate that the "clearCartAPI"  call response is success with status code "201"
    And validate the "clearCartAPI" response time is less than "4000" ms
    And validate the "clearCartAPI" payload structure has "customerData"

    #And wait for sometime
    Examples: 
      | Param        | CouponValue | ValidationMsg                    |
      | discountCode | CEMENT5     | Coupon applied successfully      |
      | discountCode | CEMENT51    | Please enter a valid coupon code |

  @RemoveCoupon
  Scenario Outline: Valid remove coupon
    Given user calls "addToCartAPI" with "Post" http request for "addToCart"
    Then validate that the "addToCartAPI"  call response is success with status code "200"
    And validate the "addToCartAPI" response time is less than "8000" ms
    And validate the "addToCartAPI" payload structure has "orderCartSummary"
    Given user calls "validateCouponAPI" with "Post" http request with queryParam "<Param>" and "<CouponValue>"
    Then validate that the "validateCouponAPI"  call response is success with status code "200"
    And validate the "validateCouponAPI" response time is less than "4000" ms
    And validate the "validateCouponAPI" payload structure has "<ValidationMsg>"
    Given user calls "removeCouponAPI" with "Post" http request with queryParam "<Param>" and "<CouponValue>"
    Then validate that the "removeCouponAPI"  call response is success with status code "200"
    And validate the "removeCouponAPI" response time is less than "4000" ms
    And validate the "removeCouponAPI" payload structure has "<RemoveCouponValidationMsg>"
    And user calls "clearCartAPI" with "Post" http request for "addToCart"
    Then validate that the "clearCartAPI"  call response is success with status code "201"
    And validate the "clearCartAPI" response time is less than "4000" ms
    And validate the "clearCartAPI" payload structure has "customerData"

    Examples: 
      | Param        | CouponValue | ValidationMsg               | RemoveCouponValidationMsg |
      | discountCode | CEMENT5     | Coupon applied successfully | CEMENT5 removed           |
