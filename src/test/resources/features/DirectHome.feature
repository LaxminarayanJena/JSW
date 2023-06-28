@DirectHome
Feature: Direct home page feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "shalin.shah@royalcyber.com" and  "Test@1234"
    And user clicks on signin
    Then user homepage is displayed

  @DirectPage
  Scenario: Verify the user is navigate to distributor page and direct page
    When user is able to click Buy from verified sellers button below the cart
    And user is able to navigate to verified seller page
    And user is able to click Buy directly from JSW Steel button
    Then user is able to navigate to direct order page

  @Header
  Scenario: Verify Header section elements
    Then Verify the JSW logo is appearing in the Header Section
    Then Verify Search Bar is displayed with search icon
    Then Verify User name is displayed in the Header Section
    Then Verify the My Profile section link is appearing with users first name
    Then Verify that the My Profile section Link is displaying ^ icon when the drop down is clicked
    Then Verify the action of Logout Link in My Profile drop down
    Then Verify Myorders is displayed in the Header Section
    Then Verify Cart Icon displayed
    Then Verify "Steel" Category tree is displayed
    # Then Verify "Help & support" is displayed in Header section
    # Then Verify user is navigate to "Help" page and back to home page
    # Then Verify "About us" is displayed in header Section
    Then Verify user is able to view "Manage address" and navigate to address section in Profile page
    Then Verify that "Connect with Us" is available on the header section
    Then Verify user is navigate to "Help" page by clicking "Help & support" CTA
    Then Verify user is able to view toggled CTA on Header section

  #@RequirementPage
  #	Scenario: Verify the user navigate to Requirement page
  #	When user is able to click My requirements header visible above the Buy from verified sellers
  #	Then user is able navigate to direct home page
  @Categories
  Scenario: User is verify the view categories section
    When user is able to scroll down to categories section
    And user is able to view All Categories on home page
    When user is able to click view all button in All categories section
    And user is able to navigate to PLP page
    Then user is able to navigate to direct home page from PLP page
    And user is able to navigate PDP page by clicking Configure and request
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
    And user is able to view request price button
    And user is able to veify and validate Configure and request price on the All categories section

  @Blogs
  Scenario: Verify user is able navigate blog & article page
    When user is able to navigate blog by clicking Read now
    And user is able to view blog & and article page
    Then user is able to naviage from Blog & article page to direct home page
    And user is able to click View all articles to navigate Blogs & article page
    Then user navigate from Blog page to Home page

  @MyOrdersDirectUser
  Scenario: Verify user is able navigate MyOrders page
    Given user is able to view Myorders CTA
    When user is able to click the Myorders CTA
    And user is navigate to MyOrder page
    #Then user is able to view Orders awaiting payment header
    And user is able to view My orders header
    And verify active,delivered and cancelled tab
    And count list of orders
    And verify Order placed
    And verify Bill to,Ship to
    And verify Order number
    And verify Payment details
    And verify Item details
    And verify Order Status
    And verify clicking on View details navigates to order summaryPage
