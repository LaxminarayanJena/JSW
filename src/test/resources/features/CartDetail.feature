@cart
Feature: Cart Detail Page feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "ramyatestuserssr@gmail.com" and  "Ramya@678"
    And user clicks on signin
    Then user homepage is displayed

  Scenario: Verify terms and condition page is displayed
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR Sheet series from Steel Categories Menu
    When user selects HR Stainless Steel product
    Given user is on product detail page of Stainless Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user click on Cart icon on homepage
    And user click on Terms&condition on cart detail page
    Then Verify Terms&condition page is displayed with some text

  Scenario: Verify "Technical Specification" below proceed to pay button
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR Sheet series from Steel Categories Menu
    When user selects HR Stainless Steel product
    Given user is on product detail page of Stainless Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user click on Cart icon on homepage
    Then Verify "Technical Specification" is displayed below Proceed to pay button

  Scenario: Verify order placed successfully after pickup checkbox
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

  Scenario: Verify Delivery by 2-5 days
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR Sheet series from Steel Categories Menu
    When user selects HR Stainless Steel product
    Given user is on product detail page of Stainless Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    Then verify Cart icon would appear with 1
    When user click on Cart icon on homepage
    Then verify delivery is by 2-5 days

  @cart
  Scenario: Verify selfpickup
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    #Then HR Products are displayed
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click on Buy Now
    And user click on selfpickup
    Then Pickup address will be available msg to be displayed
    And user click on proceed to pay on cart detail page
    And user select bank name to transfer from the drop down on payment page
    Then verify bank is selected
    And User click on PayNow
    Then User navigates to RazorPay Page
    And User click on success button
    Then verify after successful payment page navigates to ORDER summary page
    Then order sucessfully placed message should be displayed

  @weldingelectrodes
  Scenario: Verify delivery charges calculated for welding electrodes
    When cart is empty or not
    When user clicks Welding electordes from Welding Consummables Navigation Menu
    When user selects WeldingElectrode product
    And user is on product detail page of Welding electordes item
    #And user clicks on switch quantity
    And user click on Buy Now
    Then verify freight charges are displayed
    And verify subtotal is equal to sum of price,tax and freight charges

  #@weldingFlux @cart
  #Scenario: Verify delivery charges calculated for welding Flux
    #When cart is empty or not
    #When user clicks Welding flux from Welding Consummables Navigation Menu
    #When user selects WeldingFlux product
    #And user is on product detail page of Welding Flux item
    #And user click on Buy Now
    #Then verify freight charges are displayed
    #And verify subtotal is equal to sum of price,tax and freight charges

  @BillTo
  Scenario: Verify bill To and ShipTo in cart section
    When cart is empty or not
    Then user navigate to Home page
    When user click Cement Menu on header section
    And user click on product name of Cement product displayed on the page
    And user is on Cement Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    Then verify delivery is by 2-5 days
    And verify bill To in cart section
    And verify Ship to in cart section
