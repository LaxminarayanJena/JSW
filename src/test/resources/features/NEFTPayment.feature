#va_IYQmzJQHLDMvoB
#https://dashboard.razorpay.com/app/smartcollect/virtualaccounts/va_Kggxdou5jdlMKw
#username: jsw.one@jsw.in
#password: Jsw@1234
@NeftPayment
Feature: NeftPayment

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "ravitest1@gmail.com" and  "123Tmnas*"
    And user clicks on signin
    Then user homepage is displayed
    When cart is empty or not

  
  Scenario Outline: Verifying NEFT Payment
    Then user navigate to Home page
     When user is on Steel Menu on header section
    And user is able to select Wire rods from Steel Menu
    And user click on product name of Wire product displayed on the page
    And user is on Wire Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on proceed to pay on cart detail page and navigate to ordersummary page
    Then verify Order number,Order total,Payment received,Delivery type(delivery,pickup),Pending payment
    Then user can see order number in url instead of order id
    Then Verifying payment status as Full
    #And user logins to cloud scheduler
    #And login to google cloud with gmail "<Gmail>"
    #And login to google cloud with password "<Password>"
    #And click gmail next button
    #And run process customer balance batch query
    #Then navigate to orders and the order
    #And verify Your order payment is successful message
    #And payment status is full
#
    #Examples: 
      #| Gmail             | Password   |
      #| qatestuser@jsw.in | Admin@123$ |
