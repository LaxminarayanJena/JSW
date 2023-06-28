@Notification
Feature: Validating Notification API

  @smsNotifcation
  Scenario Outline: SMS Verification
    When user calls "notificationRegistrationsmsAPI" with "Post" http request with "<PhoneNo>"
    Then the API call is success with status code 200
    And validate the payload structure
    And validate the response time is less than 500 ms

    Examples: 
      | PhoneNo    |
      | 8095424663 |
      | 9090909090 |

  Scenario Outline: Email Verification
    When user calls "notificationEmailAPI" with "Post" http request with "<Email>" for emailverification
    Then the API call is success with status code 200
    And validate the response time is less than 500 ms

    Examples: 
      | Email                      |
      | v_laxminarayan.jena@jsw.in |
