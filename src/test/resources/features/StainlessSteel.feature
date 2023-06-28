@sanityExe @demo @TestStainless
Feature: Stainless Steel feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "ramyatestuserssr@gmail.com" and  "Ramya@678"
    And user clicks on signin
    Then user homepage is displayed

  Scenario: Verify Hot rolled sheets Hot rolled coils Cold rolled sheets Cold rolled coils is displayed in homepage in stainless steel section
    And Hot rolled sheets Hot rolled coils Cold rolled sheets Cold rolled coils is displayed in homepage in stainless steel section
    When user clicks on Hot Rolled Sheets Series 200 Series 300 Series 400 is displayed

  Scenario: User navigates to Stainless Steel PLP Page
    When user clicks on Stainless Steel Navigation Menu
    Then Stainless Steel Products are displayed
    And Breadcrump should display Home > Metals and Alloys > Stainless Steel

  Scenario: Check BreadCrumb hyperlink is working fine
    When user clicks on Stainless Steel Navigation Menu
    Then Stainless Steel Products are displayed
    And Breadcrump should display Home > Metals and Alloys > Stainless Steel
    When user clicks on home hyper link in breadcrumb
    Then product page should navigate to home page"

  Scenario: check pagination icon is present on the page
    When user clicks on Stainless Steel Navigation Menu
    Then products should display in grid view  and product count should be displayed

  Scenario: Check for selected Diameter products are displayed after filters applied
    When user clicks on Stainless Steel Navigation Menu
    Then Stainless Steel Products are displayed
    Then Filter with Thickness ,Width and Length to be displayed

  Scenario: Check for Filter applied and cancelled tags are working properly
    When user clicks on Stainless Steel Navigation Menu
    Then Stainless Steel Products are displayed
    And user click on grade in filter
    And click on cancel grade from tags
    Then After cancelling the cancelled tag should be eliminated from the tags and products should display accordingly

  Scenario: Check for Reset is  working properly in stainless Steel PLP
    When user clicks on Stainless Steel Navigation Menu
    Then Stainless Steel Products are displayed
    And user click on grade in filter
    And click on reset
    Then all products to be displayed

  @StainlessSteel
  Scenario: Verify order placed successfully after adding a stainless product to cart
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR Sheet series from Steel Categories Menu
    When user selects HR Stainless Steel product
    Given user is on product detail page of Stainless Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
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

  Scenario: Verify user is able to add steel and stainless steel from same seller
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
    #Then verify netbanking is disabled
    #When user enter UTR and validate it
      #| A12345678901234556 |
    #And user click on confirm payment
    #Then verify payment success message is displayed
