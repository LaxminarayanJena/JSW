@OrderSummary
Feature: Order Summary page feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "ramyatestuserssr@gmail.com" and  "Ramya@678"
    And user clicks on signin
    Then user homepage is displayed
    When cart is empty or not

  Scenario: Verifying order details Order number,Order total,Payment received,Delivery typedelivery,pickup,Pending payment
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then verify Order number,Order total,Payment received,Delivery type(delivery,pickup),Pending payment

  Scenario: Verifying NEFT/RTGS ,Beneficiary name,Account Number,IFSC Code order is awaiting payment status
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then verify  NEFT/RTGS ,Beneficiary name,Account Number,IFSC Code
    And verify Your order is awaiting payment status

  Scenario: Verifying minimisation of item details and billing adress
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then user can minimise  item details and billing adress

  Scenario: Verifying netbanking is disabled for order more than 10 lakhs
    When user is on Steel Menu on header section
    And user is able to select Wire rods from Steel Menu
    And user click on product name of Wire product displayed on the page
    And user is on Wire Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then verify netbanking is disabled

  Scenario Outline: Validate  netbanking is disabled for order more than 10 lakhs
    When cart is empty or not
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Colour coated from Steel Menu
    And user selects Colour coated product
    And user is on product detail page of colour coated product and add quantiy with quantity "<productQuanity>"
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    And user clicks on ReviewAndPay
    Then verify netbanking is disabled

    Examples: 
      | productQuanity |
      |             14 |

  Scenario Outline: Verifying coupons
    When user click Cement Menu on header section
    And user click on product name of Cement product displayed on the page
    And user is on Cement Product page
    When user click on Buy Now
    And user click on apply coupon
    Then List of coupons to be displayed
    And user enters the "<coupon>" manually and click on apply
    Then coupon is applied and price gets updated
    And user closes coupon overlay
    And price gets updated
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    When user click on view details and can see coupon got applied

    Examples: 
      | coupon  |
      | CEMENT5 |

  Scenario: Verifying item details
    When user click Cement Menu on header section
    And user click on product name of Cement product displayed on the page
    And user is on Cement Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then Verifying item details

  Scenario: Verifying delivery days
    When user click Cement Menu on header section
    And user click on product name of Cement product displayed on the page
    And user is on Cement Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then Verifying delivery days

  Scenario Outline: Veifying user can make netbanking payment for amount less than ₹10,00,000
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Colour coated from Steel Menu
    And user selects Colour coated product
    And user is on product detail page of colour coated product and add quantiy with quantity "<productQuanity>"
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    When user click on pickup checkbox
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

    Examples: 
      | productQuanity |
      |              5 |

  Scenario: Verifying shipping and billing and delivery adresss
    When user click Cement Menu on header section
    And user click on product name of Cement product displayed on the page
    And user is on Cement Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then Verifying shipping and billing and delivery adresss

  Scenario: order id to ordernum in url
    When user click Cement Menu on header section
    And user click on product name of Cement product displayed on the page
    And user is on Cement Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then Verifying delivery days
    Then user can see order number in url instead of order id
