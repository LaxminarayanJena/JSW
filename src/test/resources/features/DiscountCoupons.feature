@DiscountCoupon
Feature: NewCoupons-Product Detail Page with discount

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "ramyatestuserssr@gmail.com" and  "Ramya@678"
    And user clicks on signin
    Then user homepage is displayed

  Scenario Outline: Check for coupon code can be  entered manually
    # Check for coupon code can be  entered manually and can be removed also in coupons overlay
    When cart is empty or not
    Then user navigate to Home page
    When user click Cement Menu on header section
    And user click on product name of Cement product displayed on the page
    And user is on Cement Product page
    When user click on Buy Now
    And user click on apply coupon
    Then List of coupons to be displayed
    And user enters the "<coupon>" manually and click on apply
    Then coupon is applied and price gets updated
    # And remove button is displayed
    # And user click on remove button
    And user closes coupon overlay
    And price gets updated
    And user click on proceed to pay on cart detail page

    Examples: 
      | coupon  |
      | CEMENT5 |

  @Couponsection 
  Scenario: Check Discount section displayed on PDP page
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    Then HR Products are displayed
    When user selects Steel product
    Given user is on product detail page of Steel item
    And user is able to view Coupons section on PDP page
    Then user is able to view details of the list of coupon code
    Then user is able to verify the coupons code displayed as Caps

  @Knowmore 
  Scenario: Check Discount coupons view on PDP page and able to know more about coupon description by clicking know more
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    Then HR Products are displayed
    When user selects Steel product
    Given user is on product detail page of Steel item
    And user clicks on Know more
    Then user is able to view details of the coupon code

  #Scenario: Check Discount coupons view on PDP page and able to view more about coupon description by clicking know more
  #  When cart is empty or not
  # When user clicks HR from Steel Navigation Menu
  # Then HR Products are displayed
  #When user selects Steel product
  #Given user is on product detail page of Steel item
  #And user clicks on See more
  #Then list of other coupons also displayed
  Scenario Outline: Check for old price is strikethrough and new price amount is displayed in both Price section and cart line
    When cart is empty or not
    Then user navigate to Home page
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
    And old price is strikethrough and new price amount is displayed in both Price section and cart line

    Examples: 
      | coupon  |
      | CEMENT5 |

  @sanityExe @coupon
  Scenario Outline: Verify In my order page, the applied coupons are able to view after the order placed
    When cart is empty or not
    Then user navigate to Home page
    When user click Cement Menu on header section
    And user click on product name of Cement product displayed on the page
    And user is on Cement Product page
    When user click on Buy Now
    And user click on apply coupon
    Then List of coupons to be displayed
    And user enters the "<coupon>" manually and click on apply
    Then coupon is applied and price gets updated
    And user closes coupon overlay
    And user click on proceed to pay on cart detail page
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page
    And User click on success button
    Then verify after successful payment page navigates to ORDER summary page
    Then order sucessfully placed message should be displayed
    And user clicks on view coupons in order page then applied coupon to be displayed

    Examples: 
      | coupon  |
      | CEMENT5 |

  Scenario Outline: Verify add product in cart line and price will be update and coupons remain active
    When cart is empty or not
    Then user navigate to Home page
    When user click Cement Menu on header section
    And user click on product name of Cement product displayed on the page
    And user is on Cement Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user click on Cart icon on homepage
    And user click on apply coupon
    Then List of coupons to be displayed
    And user enters the "<coupon>" manually and click on apply
    Then coupon is applied and price gets updated
    And close the coupon window box
    Then user navigate to Home page
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    And user wait for sometime
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    Then User shall see modified pricing of the cart
    And Applied coupons remain in active if applicable to the modified cart context
    And Applied coupons remain active after removed if applicable to the modified cart context
    And Count of applied coupons remains the same

    Examples: 
      | coupon  |
      | CEMENT5 |

  #  @RetainOfferwithupdatecoupons
  #  Scenario: Verify remove product in cart line and price will be update
  #    When user is on cart page
  #    And user click on apply coupon
  #    Then List of coupons to be displayed
  #    And user is able to apply STEEL250 coupon code
  #    Then coupon is applied and price gets updated
  #    When user is removed products from cart line
  #    Then User shall see modified pricing of the cart
  #    And Applied coupons remain in active if applicable to the modified cart context
  

  Scenario Outline: Verify remove product in cart line and price will be update and coupons remain active
    When cart is empty or not
    Then user navigate to Home page
    When user click Cement Menu on header section
    And user click on product name of Cement product displayed on the page
    And user is on Cement Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    And user wait for sometime
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    And user click on apply coupon
    Then List of coupons to be displayed
    And user enters the "<coupon>" manually and click on apply
    Then coupon is applied and price gets updated
    When user is removed Steel products from cart line
    Then User shall see modified pricing of the cart
    And Applied coupons remain in active if applicable to the modified cart context

    Examples: 
      | coupon  |
      | CEMENT5 |
