@DirectOrderPDP
Feature: Direct Order for PDP feature for registered user

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "shalin.shah@royalcyber.com" and  "Test@1234"
    And user clicks on signin
    Then user homepage is displayed

  Scenario: Verify Buy from verified sellers is displayed on rightside of the page
    Given user is on home page
    Then Buy from verified sellers is displayed
    When user click on Buy from verified sellers
    Then verify Buy directly from JSWsteel is displayed
    When user click on Buy directly from JSWsteel
    Then Buy from verified sellers is displayed

  @sanityExe
  Scenario: Verify Request for Price is submitted successfully
    When Buy from verified sellers is displayed
    When cart is empty or not
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Wire rods from Steel Menu
    And user click on product name of Wire product displayed on the page
    And user is on Wire Product page
    And user is able to click Add to requirement cart
    And user is able to click View requirement cart
    Then verify View requirements list is displayed
    When user click Request Price
    Then verify Message "Your Pricing request has been submitted. Our support team will reach out to you within 24hrs." is displayed.

  Scenario: Delivery 30-45 days is displayed
    When Buy from verified sellers is displayed
    When cart is empty or not
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Wire rods from Steel Menu
    And user click on product name of Wire product displayed on the page
    And user is on Wire Product page
    And user is able to click Add to requirement cart
    And user is able to click View requirement cart
    Then verify View requirements list is displayed
    Then verify delivery date is displayed from 30-45 days

  Scenario: Verify multiple products added before Request for price
    Then user navigate to Home page
    When Buy from verified sellers is displayed
    When cart is empty or not
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Wire rods from Steel Menu
    And user click on product name of Wire product displayed on the page
    And user is on Wire Product page
    And user is able to click Add to requirement cart
    And user is able to click View requirement cart
    Then verify View requirements list is displayed
    When user click Request Price
    And user is able to select Wire rods from Steel Menu
    Then user select wire rod product in PLP page
    Then user select the dimensions of selected wire rod product for directorder user
    And user is able to click Add to requirement cart
    And user is able to click View requirement cart
    Then verify View requirements list is displayed
    When user click Request Price
    Then verify Message "Your Pricing request has been submitted. Our support team will reach out to you within 24hrs." is displayed.

  Scenario: Verify product is added to cart
    #When cart is empty or not
    When Buy from verified sellers is displayed
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy from verified sellers
    Then verify Buy directly from JSWsteel is displayed
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart

  Scenario: Verify user is able to remove product from requirement
    When Buy from verified sellers is displayed
    When cart is empty or not
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Wire rods from Steel Menu
    And user click on product name of Wire product displayed on the page
    And user is on Wire Product page
    And user is able to click Add to requirement cart
    And user is able to click View requirement cart
    Then verify View requirements list is displayed
    Then verify delivery date is displayed from 30-45 days
    When user click on remove button on the product
    Then verify no product in requirement list

  @DirectneftPaymentMultiSeller
  Scenario Outline: Verify multiple products from different seller added before Request for price
    When Buy from verified sellers is displayed
    When cart is empty or not
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Wire rods from Steel Menu
    And user click on product name of Wire product displayed on the page
    And user is on Wire Product page
    And user is able to click Add to requirement cart
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item for DirectOrder
    And user is able to click Add to requirement cart
    And user is able to click View requirement cart
    Then verify View requirements list is displayed
    When user click Request Price
    Then verify Message "Your Pricing request has been submitted. Our support team will reach out to you within 24hrs." is displayed.

  #@DirectPDP
  #Scenario Outline: Verify Confirm payment is made successfully
  #When Buy from verified sellers is displayed
  #When user clicks HR from Steel Navigation Menu
  #When user selects Steel product
  #Given user is on product detail page of Steel item for DirectOrder
  #Then verify Request Price is displayed on rightside
  #When user click Request Price
  #Then verify View requirements list is displayed
  #When user click View requirements list
  #Then verify Request for price is displayed
  #Then verify Requirement list is displayed
  #When user click on Request for price
  #Then verify Message "Your Pricing request has been submitted. Our support team will reach out to you within 24hrs." is displayed.
  # When user login to google cloud
  #And login to google cloud with gmail "<Gmail>"
  #And login to google cloud with password "<Password>"
  #And click gmail next button
  #And user click on upload files
  #When user is on home page
  #When homepage refreshes
  #And user click on cart on top
  #And user click on proceed to pay on cart detail page
  #And user select bank name to transfer from the drop down on payment page
  #Then verify bank is selected
  #And User click on PayNow
  #Then User navigates to RazorPay Page
  #And User click on success button
  #Then verify after successful payment page navigates to ORDER summary page
  #Then order sucessfully placed message should be displayed
  #
  #Examples:
  #| Gmail             | Password   |
  #| qatestuser@jsw.in | Admin@123$ |
  #
  #@Advance
  #Scenario Outline: Verify Payment status to be changed to "Advance recieved"
  #When Buy from verified sellers is displayed
  #Then user navigate to Home page
  #When user login to google cloud
  #And login to google cloud with gmail "<Gmail>"
  #And login to google cloud with password "<Password>"
  #And click gmail next button
  #And user click on upload files
  #And user is on home page
  #And homepage refreshes
  #And user click on cart on top
  #And user click on Mycart and then Proceed to pay
  #When user click on Cart icon on homepage
  #When user click on pickup checkbox
  #And user click on proceed to pay on cart detail page
  #And user click on confirm payment
  #And user clicks on My order and select order details like orderid
  #And user login to merchant centre username with "v_laxminarayan.jena@jsw.in" and  "123Tmnas$"
  #And user click on order and search orderno
  #And capture paymentid from payment tab in order
  #And paste paymentid in Transaction Excel
  #And login to Transaction URL
  #And user upload transaction file
  #And paste paymentid and orderid in payment Excel
  #And Login to Payment URL
  #And user upload payment file
  #And user is on home page
  #And homepage refreshes
  #And user clicks on My order and select order details
  #Then Verify Payment status
  #
  #Examples:
  #| Email             | Password   | Gmail             |
  #| qatestuser@jsw.in | Admin@123$ | qatestuser@jsw.in |
  #@DirectPaymentHistory
  #Scenario: Verify payment history for Direct order
  #When user is able to click my order button
  #And user is able to click view details button for DO
  #And user is able to view Order summary page
  #Then user is able to view Payment received section
  #When user is able to click Payment history dropdown CTA
  #Then user is able to view Direct order payment status
  
  Scenario: Verify my orders for Direct order
    When user click on Buy from verified sellers
    Then verify Buy directly from JSWsteel is displayed
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now
    And user click on proceed to pay on cart detail page
    And user wait for sometime
    When user is able to click my order button
    And user clicks on ReviewAndPay
    Given user is able to view Myorders CTA
    When user is able to click the Myorders CTA
    And user is navigate to MyOrder page
    #Then user is able to view Orders awaiting payment header
    And user is able to view My orders header
    And verify active,delivered and cancelled tab
    And count list of orders
