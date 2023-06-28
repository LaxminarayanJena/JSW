@PLP
Feature: Validating Product Listing Page API

  @validatePLP
  Scenario Outline: Valid Product Listing Page
    Given user calls "plpAPI" with "Get" http request with queryParam "<Param>" and "<categoryId>"
    Then validate that the "plpAPI"  call response is success with status code "200"
    And validate the "plpAPI" response time is less than "4000" ms
    And validate the "plpAPI" payload structure has "<ValidationMsg>"

    Examples: 
      | Param      | categoryId                           | ValidationMsg     |
      | categoryId | 61235c5d-2455-4456-a6b0-dd0bc7f806fd | Metals and Alloys |

  Scenario: Verify Filter Section in PLP
    Given user calls "plpFilterAPI" with "Post" http request for "plpFilter"
    Then validate that the "plpFilterAPI"  call response is success with status code "200"
    And validate the "plpFilterAPI" response time is less than "8500" ms
    And validate the "plpFilterAPI" payload structure has "JSW Steel HRPO Coils IS 2062:2011 E250A"
