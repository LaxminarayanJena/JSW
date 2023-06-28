#va_IYQmzJQHLDMvoB
#https://dashboard.razorpay.com/app/smartcollect/virtualaccounts?count=25&id=va_IYQmzJQHLDMvoB
#username: jsw.one@jsw.in
#password: Jsw@1234
@sanityExe @demo @steel
Feature: Steel feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "ramyatestuserssr@gmail.com" and  "Ramya@678"
    And user clicks on signin
    Then user homepage is displayed

  Scenario: Verify Hot rolled, cold rolled ,wire rods,coated,colour coated is displayed in homepage in  steel section
    And Hot rolled, cold rolled ,wire rods,coated,colour coated is displayed in homepage in  steel section
    When user clicks on Hot rolled  then coils ,sheet is displayed

  Scenario: User navigates to  Steel PLP Page
    When user clicks on Steel Navigation Menu
    Then Steel Products are displayed
    And Breadcrump should display Home > Metals and Alloys > Steel

  Scenario: Check BreadCrumb hyperlink is working fine
    When user clicks on Steel Navigation Menu
    Then Steel Products are displayed
    And Breadcrump should display Home > Metals and Alloys > Steel
    When user clicks on home hyper link in breadcrumb
    Then product page should navigate to home page"

  Scenario: check pagination icon is present on the page
    When user clicks on Steel Navigation Menu
    Then products should display in grid view  and product count should be displayed

  Scenario: Check for selected Diameter products are displayed after filters applied
    When user clicks on Steel Navigation Menu
    Then Steel Products are displayed
    Then Filter with Thickness ,Width and Length to be displayed

  Scenario: Check for Filter applied and cancelled tags are working properly
    When user clicks on Steel Navigation Menu
    Then Steel Products are displayed
    And user click on grade in SteelPLPfilter
    And click on cancel grade from tags
    Then After cancelling the cancelled tag should be eliminated from the tags and products should display accordingly

  Scenario: Check for Reset is  working properly in  Steel PLP
    When user clicks on Steel Navigation Menu
    Then Steel Products are displayed
    And user click on grade in SteelPLPfilter
    And click on reset
    Then all products to be displayed

  Scenario: Verify Buy Now button and net banking with an order placed unsuccessfully
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    #Then HR Products are displayed
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now
    And user click on proceed to pay on cart detail page
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page
    Then User click on failure button
    Then verify payment pending message is displayed
    Then user is able to see Make payment CTA on order summary page

  @steelnetbanking
  Scenario: Verify Buy Now button and net banking with an order placed successfully
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    #Then HR Products are displayed
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now
    And user click on proceed to pay on cart detail page
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page
    And User click on success button
    Then verify after successful payment page navigates to ORDER summary page
    Then order sucessfully placed message should be displayed

  #@neft
  #Scenario: Verify user is able to add steel and stainless steel from same seller and do a NEFT payment
  #When cart is empty or not
  #Then user navigate to Home page
  #When user clicks HR Sheet series from Steel Categories Menu
  #When user selects HR Stainless Steel product
  #Given user is on product detail page of Stainless Steel item
  #When user clicks on Add To Cart button available in the right side of the webpage
  #Then verify that the product should be added in the cart
  #Then verify Cart icon would appear with 1
  #When user clicks HR from Steel Navigation Menu
  #When user selects Steel product
  #Given user is on product detail page of Steel item
  #When user clicks on Add To Cart button available in the right side of the webpage
  #Then verify that the product should be added in the cart
  #When user click on Cart icon on homepage
  #When user click on pickup checkbox
  #And user click on proceed to pay on cart detail page
  #Then verify netbanking is disabled
  #And user click on proceed and confirm later
  #Then verify payment pending message is displayed
  #Then user is able to see Make payment CTA on order summary page
  @samesellerNetBanking
  Scenario: Verify user is able to add steel and stainless steel from same seller and do a net banking with confirmation payment
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR Sheet series from Steel Categories Menu
    When user selects HR Stainless Steel product
    Given user is on product detail page of Stainless Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on proceed to pay on cart detail page
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page
    And User click on success button
    Then verify after successful payment page navigates to ORDER summary page
    Then order sucessfully placed message should be displayed

  @PaymentMultiSeller
  Scenario: Verify user is able to add products from multi seller and proceed to payment page
    When cart is empty or not
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Wire rods from Steel Menu
    And user click on product name of Wire product displayed on the page
    And user is on Wire Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    #Then verify seller name
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on proceed to pay on cart detail page
    #Then verify netbanking is disabled
    #When user enter UTR and validate it
      #| A12345678901234556 |
    #And user click on confirm payment
    #Then verify payment success message is displayed
