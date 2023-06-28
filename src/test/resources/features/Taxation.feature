@Taxation
Feature: Tax calculation on Order summary & My Order pages

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
     When user enters logins with username with "ramyatestuserssr1@gmail.com" and  "Ramya@678"
    And user clicks on signin
    Then user homepage is displayed


  Scenario: Verify Tax calculation when shipping adress is chennai
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    And user clicks on ReviewAndPay
    And user clicks on netBanking
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page
    And User click on success button
    Then verify after successful payment page navigates to ORDER summary page
    Then order sucessfully placed message should be displayed
    And gets the order details
    And user login to merchant centre username with "v_laxminarayan.jena@jsw.in" and  "123Tmnas$"
    And user click on order and search orderno in mc
    Then verify 9% CGST and 9% SGST is displayed
    And verify tax matches in mc and UI
    

  Scenario: Verify Tax calculation when shipping adress is chandigarh
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now
    And user click on change address to chandigarh
    And select for delivery
     And user click on proceed to pay on cart detail page and navigate to ordersummary page
    And user clicks on ReviewAndPay
    And user clicks on netBanking
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page
    And User click on success button
    Then verify after successful payment page navigates to ORDER summary page
    Then order sucessfully placed message should be displayed
    And gets the order details
    And user login to merchant centre username with "v_laxminarayan.jena@jsw.in" and  "123Tmnas$"
    And user click on order and search orderno in mc
    Then verify 9% CGST and 9% SGST is displayed
    And verify tax matches in mc and UI

  @thrissur
  Scenario: Verify tax components when shipping adress is thrissur
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now
    And user click on change address to thrissur
    And select for delivery
     And user click on proceed to pay on cart detail page and navigate to ordersummary page
    And user clicks on ReviewAndPay
    And user clicks on netBanking
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page
    And User click on success button
    Then verify after successful payment page navigates to ORDER summary page
    Then order sucessfully placed message should be displayed
    And gets the order details
    And user login to merchant centre username with "v_laxminarayan.jena@jsw.in" and  "123Tmnas$"
    And user click on order and search orderno in mc
    Then verify 9% CGST and 9% SGST is displayed
    And verify tax matches in mc and UI
