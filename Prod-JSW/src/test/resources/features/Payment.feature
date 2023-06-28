@demo @Payment
Feature: Payment and Cart Scenarios for single and multiple product

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "distramyatest@gmail.com" and  "Ramya@123"
    And user clicks on signin
    Then user homepage is displayed

  Scenario: Single Product-User navigate to payment page
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

  Scenario: Multiple Product  Product-User navigate to payment page
    #When cart is empty or not
    #When user clicks Welding electordes from Welding Consummables Navigation Menu
    #When user selects WeldingElectrode product
    #And user is on product detail page of Welding electordes item
    When cart is empty or not
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Cold rolled from Steel Menu
    And user click on product name of Cold rolled product displayed on the page
    And user is on ColdRolled Product page
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
  #@neftdisabled @sanityExe
  #Scenario: Verify  NEFT Payment is disabled for product that is added to cart in payment screen
    #When cart is empty or not
    #When user clicks Welding electordes from Welding Consummables Navigation Menu
    #When user selects WeldingElectrode product
    #And user is on product detail page of Welding electordes item
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
    #Then verify neftbanking is disabled
    #When user enter UTR and validate it
      #| A12345678901234556 |
    #And user click on confirm payment
    #Then verify payment success message is displayed
