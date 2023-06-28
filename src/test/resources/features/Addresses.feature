@Addresses
Feature: User can Change, edit, remove & add delivery address

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "ramyatestuserssr3@gmail.com" and  "Ramya@678"
    And user clicks on signin
    Then user homepage is displayed

  Scenario: User can add address
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    #When user click on pickup checkbox
    And user click on change address
    And user click on Add new Address
    And user fill address information and save changes
    And user click on change address
    And user click on remove address

  Scenario: User can change deliver address and deliver here
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    And user click on change address
    And user click on Add new Address
    And user fill address information and save changes
    And user click on change address
    And user click on newlycreated address
    And user click on Deliver here
    And user click on change address
    And user click on remove address

  Scenario: User can edit address
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on change address
    And user click on Add new Address
    And user fill address information and save changes
    And user click on change address
    And user click on edit address and update address information details
    And user click on change address
    And user click on remove address

  Scenario: User can remove address
    When cart is empty or not
    Then user navigate to Home page
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart
    When user click on Cart icon on homepage
    When user click on pickup checkbox
    And user click on change address
    And user click on Add new Address
    And user fill address information and save changes
    And user click on change address
    And user click on remove address
