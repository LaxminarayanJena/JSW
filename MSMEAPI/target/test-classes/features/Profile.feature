@Profile
Feature: Validating MyProfile API

  @validateMyProfile
  Scenario: Validate MyProfileAPI
    Given user calls "profileAPI" with "Get" http request for "validateprofile"
    Then validate that the "profileAPI"  call response is success with status code "200"
    And validate the "profileAPI" response time is less than "4000" ms
    And validate the "profileAPI" payload structure has "firstName"

  @updateProfile
  Scenario: Validate UpdateProfileAPI
    Given user calls "updateprofileAPI" with "Post" http request for "updateProfile"
    Then validate that the "updateprofileAPI"  call response is success with status code "200"
    And validate the "updateprofileAPI" response time is less than "8000" ms
    And validate the "updateprofileAPI" payload structure has "Your profile is updated successfully"

  @validateV2Api
  Scenario: Validate MyProfileAPI
    Given user calls "customerAPI" with "Get" http request for "validateprofile"
    Then validate that the "customerAPI"  call response is success with status code "200"
    And validate the "customerAPI" response time is less than "4000" ms
    And validate the "customerAPI" payload structure has "firstName"
