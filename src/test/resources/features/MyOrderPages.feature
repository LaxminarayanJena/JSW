@MyOrder
Feature: MyOrder page feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "testprod6@gmail.com" and  "Ramya@678"
    And user clicks on signin
    Then user homepage is displayed


  Scenario: Verify my orders UI
    Given user is able to view Myorders CTA
    When user is able to click the Myorders CTA
    And user is navigate to MyOrder page
    Then user is able to view Orders awaiting payment header
    And user is able to view All orders header


  @ViewDetails 
  Scenario: verify user view the view details in order
    When user is able to click my order button
    And user is able to click view details button
    And user is able to click view price breakup button to view detailed cost list of the ordered product
    Then user is again click the  view price breakup button to close

  @ViewCoupons 
  Scenario Outline: Verify In my order page, user can review and pay and navigates to payment page
   When user is able to click my order button
    And user clicks on ReviewAndPay
    And user clicks on netBanking
    And user click on proceed to pay on cart detail page
    And user select bank name to transfer from the drop down on payment page
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page
   
    
    Examples: 
      | coupon       |
      | DIGITALORDER |
