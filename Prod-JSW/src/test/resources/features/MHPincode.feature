@MH
Feature: Loading MH pincode

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "distramyatesttwo@gmail.com" and  "Ramya@123"
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
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Cold rolled from Steel Menu
    And user click on product name of Cold rolled product displayed on the page
    And user is on ColdRolled Product page
