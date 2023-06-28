@DirectPLP @demo
Feature: Direct PLP page navigation

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "hari5465@yopmail.com" and  "Hari5465#"
    And user clicks on signin
    Then user homepage is displayed

  @PLPPage
  Scenario: Verify to navigate from Direct Homepage to PLP page
    When user is able to select HotRolledproduct from Steel by categories
    Then user is navigate to PLP page from direct homepage

  @PLPFormat
  Scenario: Verify PLP page is in correct format
    When user is able to scroll down to all categories
    And user is able to click View all button
    And user is able to view PLP page of direct order
    And user is able to click Buy from verified sellers page
    And user is able to view PLP page of current seller order
    Then user is navigate to direct order PLP page by clicking Buy directly from JSW Steel

  @PriceView
  Scenario: Verify price of the product can't show in the PLP page
    When user is able to select HotRolledproduct from Steel by categories
    Then user is navigate to PLP page from direct homepage
    Then user is able to see the price amount in the PLP page of the products

  @PDPPage
  Scenario: Verify user navigate to PDP page
    When user is able to scroll down to all categories
    And user is able to view and click Configure and request label
    And user is able to navigate from DO home page to PDP page

  @DeliveryDay
  Scenario: Verify user able to view delivery day by 30-45 days of each product
    When user is able to scroll down to all categories
    And user is able to click View all button
    Then user is able to scrolldown and view delivery by 30-45 days
