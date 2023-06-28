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
    And user is able to view My orders header

  @ViewDetails
  Scenario: verify user view the view details button
    When user is able to click my order button
    And count list of orders
    And user is able to click view details button
    And user is able to navigate to ordersumamryPage

  @ReviewAndPay
  Scenario Outline: Verify In my order page, user can review and pay and navigates to payment page
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item and enters "<productQuanity>"
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    And user wait for sometime
    When user is able to click my order button
    And user is able to click view details button
    And user clicks on ReviewAndPay
    And user clicks on netBanking
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page

    Examples: 
      | productQuanity |
      |             29 |

  @EnhancedOrder
  Scenario: Verify user is able to verify enhanced orderpage
    Given user is able to view Myorders CTA
    When user is able to click the Myorders CTA
    And user is navigate to MyOrder page
    #Then user is able to view Orders awaiting payment header
    And user is able to view My orders header
    And verify active,delivered and cancelled tab
    And count list of orders
