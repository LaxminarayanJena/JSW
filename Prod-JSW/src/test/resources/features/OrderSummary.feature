@OrderSummary
Feature: Order Summary page feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "distramyatest@gmail.com" and  "Ramya@123"
    And user clicks on signin
    Then user homepage is displayed
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now

  Scenario: Verifying order details Order number,Order total,Payment received,Delivery typedelivery,pickup,Pending payment
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then verify Order number,Order total,Payment received,Delivery type(delivery,pickup),Pending payment

  Scenario: Verifying NEFT/RTGS ,Beneficiary name,Account Number,IFSC Code order is awaiting payment status
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then verify  NEFT/RTGS ,Beneficiary name,Account Number,IFSC Code
    And verify Your order is awaiting payment status

  Scenario: Verifying minimisation of item details and billing adress
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then user can minimise  item details and billing adress

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
    Then verify netbanking is disabled

    Examples: 
      | productQuanity |
      |             11 |

  #Scenario Outline: Verifying coupons
    #When cart is empty or not
    #When user clicks HR from Steel Navigation Menu
    #When user selects Steel product
    #Given user is on product detail page of Steel item
    #And user wait for sometime
    #When user click on Buy Now
    #And user click on apply coupon
    #Then List of coupons to be displayed
    #And user enters the "<coupon>" manually and click on apply
    #Then coupon is applied and price gets updated
    #And user closes coupon overlay
    #And price gets updated
    #And user click on proceed to pay on cart detail page and navigate to ordersummary page
    #Then user click on view details and can see coupon got applied
#
    #Examples: 
      #| coupon       |
      #| DIGITALORDER |

  Scenario: Verifying item details
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then Verifying item details

  Scenario: Verifying delivery days
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then Verifying delivery days

  Scenario: Verifying shipping and billing and delivery adresss
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then Verifying shipping and billing and delivery adresss

  Scenario: order id to ordernum in url
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then user can see order number in url instead of order id

  Scenario: Veifying user can make netbanking payment for amount less than ₹10,00,000
    And user click on proceed to pay on cart detail page
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page
  #Scenario: Verifying NEFT Payment
    #And user click on proceed to pay on cart detail page and navigate to ordersummary page
    #Then Verifying payment status as partial
    #And user logins to cloud scheduler
    #And run process customer balance batch query
    #Then navigate to orders and the order
    #And verify Your order payment is successful message
    #And payment status is full
