@MH
Feature: Loading MH pincode

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "TestReg0122@gmail.com" and  "Ramya@678"
    And user clicks on signin
    Then user homepage is displayed

  @MH1
  Scenario: Verify add the address with the Maharashra pincode and make it as default address
    When user click on the profile menu
    Then Dropdown should be lsited
    When user click on the profile submmenu
    Then Profile page  should be lsited
    And user clicks on addresses
    Then user is able to click Add a new address CTA
    Then user is able to enter Company name, Pincode, Address, City and State
    Then user is able to make this address as a default address

  @MH2
  Scenario: Verify product is displayed in home and PLP page
    When user click on the profile menu
    Then Dropdown should be lsited
    When user click on the profile submmenu
    Then Profile page  should be lsited
    And user clicks on addresses
    When user is able check the default address is in MH pincode
    Then Verify the JSW logo is appearing in the Header Section
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    And user wait for sometime
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
