@MyOrder
Feature: MyOrder page feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "ramyatestuserssr@gmail.com" and  "Ramya@678"
    And user clicks on signin
    Then user homepage is displayed

  Scenario: Verify the message displayed in Order History page
    Given user is able to view Myorders CTA
    When user is able to click the Myorders CTA
    And user is navigate to MyOrder page
    And user is able to view My orders header

  #Then user is able to verify the message displayed on the Filter icon
  #Scenario: Verify the Status filter option is working
  #When user is able to click the MyOrder CTA
  #Then user is able to click Filter icon on MyOrder page
  #Then user is able to verify the filter pop-up displayed
  #When user is able select the any one status from the status dropdown menu
  #Then user is able click Apply CTA
  #Then user is able to view the applied filter option below the My orders
  #Scenario: Verify the pre-defined duration filter option is working
  #When user is able to click the MyOrder CTA
  #Then user is able to click Filter icon on MyOrder page
  #Then user is able to verify the filter pop-up displayed
  #When user is able to select the duration of ordered products to be filtered
  #Then user is able click Apply CTA
  #Then user is able to view the applied filter option below the My orders
  #Scenario: Verify the custom date range filter option is working
  #When user is able to click the MyOrder CTA
  #Then user is able to click Filter icon on MyOrder page
  #Then user is able to verify the filter pop-up displayed
  #When user is able select the custom date range of ordered products to be displayed
  #Then user is able click Apply CTA
  #Then user is able to view the applied filter option below the My orders
  #Scenario: Verify the all the Filter options are working
  #When user is able to click the MyOrder CTA
  #Then user is able to click Filter icon on MyOrder page
  #Then user is able to verify the filter pop-up displayed
  #When user is able select the any one status from the status dropdown menu
  #When user is able to select the pre-defined duration range of ordered products to be filtered
  #When user is able select the custom date range of ordered products to be displayed
  #Then user is able click Apply CTA
  #Then user is able to view the applied filter option below the My orders
  #Scenario: Verify the clear all CTA is working
  #When user is able to click the MyOrder CTA
  #Then user is able to click Filter icon on MyOrder page
  #Then user is able to verify the filter pop-up displayed
  #When user is able select the any one status from the status dropdown menu
  #When user is able to select the pre-defined duration range of ordered products to be filtered
  #When user is able select the custom date range of ordered products to be displayed
  #Then user is able click Apply CTA
  #Then user is able to view the applied filter option below the My orders
  #Then user is able to view Clear all CTA and clickable
  #Then user is verify that applied filters are cleared
  #@orderTest
  #Scenario: Verify the reset all the selected options in the filter popup window
  #When user is able to click the MyOrder CTA
  #Then user is able to click Filter icon on MyOrder page
  #Then user is able to verify the filter pop-up displayed
  #When user is able select the any one status from the status dropdown menu
  #When user is able to select the duration of ordered products to be filtered
  #When user is able select the custom date range of ordered products to be displayed
  #Then user is able to click Reset CTA to clear the selected filter option
  @ViewDetails
  Scenario: verify user view the view details button
    When user is able to click my order button
    And count list of orders
    And user is able to click view details button
    And user is able to navigate to ordersumamryPage

  #And user is able to click view price breakup button to view detailed cost list of the ordered product
  #Then user is again click the  view price breakup button to close
  # @NeedHelp
  # Scenario: Verify user view need help button
  #   When user is able to click my order
  #   And user is able click need help button
  #   Then user is able to navigate to need help page
  #@BuyAgain
  #Scenario: Verify user Buyagain the product
  #When user is able to click my order in home page
  #And user is able to scroll down and click buy again which was shown in the ordered product
  #And user is able to choose requirement details and select
  #And user is able to click add to cart
  #And user is able to click ok button in the pop of the add to cart button
  #And user is able to click cart icon
  #And user is able to scroll down and click proceed to pay button
  #And user is able to choose bank in the list
  #And user is able to click pay now button
  #Then user navigate to RayzorPay page
  #And User is able to click on success button
  #Then verify after successful payment navigates to ORDER summary page
  #Then user verify your order is confirmed message
  #@CancelOrder
  #Scenario: Verify user able to cancel the order
  #When cart is empty or not
  #When user clicks HR from Steel Navigation Menu
  # Then HR Products are displayed
  #When user selects Steel product
  #Given user is on product detail page of Steel item
  #And user wait for sometime
  #When user click on Buy Now
  #And user click on proceed to pay on cart detail page
  #And user select bank name to transfer from the drop down on payment page
  #Then verify bank is selected
  #And User click on PayNow
  #Then User navigates to RazorPay Page
  #And User click on success button
  #Then verify after successful payment page navigates to ORDER summary page
  #Then order sucessfully placed message should be displayed
  #And user is able to click canel order button
  #And user is able to click My order button on home page
  #And user is able to click cancel button in my order page
  #And user is able to write remark
  #And user is able to click cancelorder button
  #Then user is able to view cancelled message
  @ReviewAndPay
  Scenario Outline: Verify In my order page, user can review and pay and navigates to payment page
    When cart is empty or not
    Then user navigate to Home page
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR Sheet series from Steel Categories Menu
    When user selects HR Stainless Steel product
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
      |             15 |

  @EnhancedOrder
  Scenario: Verify user is able to verify enhanced orderpage
    Given user is able to view Myorders CTA
    When user is able to click the Myorders CTA
    And user is navigate to MyOrder page
    #Then user is able to view Orders awaiting payment header
    And user is able to view My orders header
    And verify active,delivered and cancelled tab
    And count list of orders
