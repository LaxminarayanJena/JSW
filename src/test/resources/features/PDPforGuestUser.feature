@PDPGuest
Feature: Product Detail Page feature for Guest User

  Background: User opens website
    Given user is on home page

  Scenario: verify Breadcrump on top left corner of the page
    When user is able to select Hot Rolled from Steel Menu
    And user refresh the page
    Then Breadcrump should display HOME > Metals and Alloys > Steel > HR

  Scenario: Verify primary and optional images are displayed
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Then verify user is on PDP page
    Then Verify primary and optional images are displayed

  Scenario: verify user able to view message on thickness section
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Then user is able to view the message in the thickness section

  Scenario: Verify product details are displayed
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Then verify product details are displayed as Chemical composition,Mechanical composition,Tolerance properties, Any others

  Scenario: verify user able to purchase after selected input
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    Then verify user able to purchase the product on the basis of selected input.

  Scenario: verify User should redirect to the login page on clicking add to cart button
    When user clicks HR from Steel Navigation Menu
    And user refresh the page
    When user selects Steel product
    Given user is on product detail page of Steel item
    #And user click on the add to cart button.
    Then verify User should redirect to the login page

  Scenario: verify User should redirect to the login page on clicking buy now button
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    # And user click on the Buy Now button
    Then verify User should redirect to the login page

  #  Scenario: verify the delivary /ETD is displayed at the bottom
  #    And user select any product example HR
  #    Then User is redirected to the PDP page.
  #    Then verify the delivery /ETD is displayed at the bottom of the specific quantity.
  Scenario: verify the price range is displayed in right side of the page
    When user clicks HR from Steel Navigation Menu
    And user refresh the page
    When user selects Steel product
    Given user is on product detail page of Steel item
    Then verify the price range is displayed in right side of the page in the form of ht Rupees/Metric. 8000-10,000 Rupees/Metric Ton

  Scenario: verify user is redirected to login/register page
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Then verify the login and Register option is displayed in right side of the page above the add to cart button.
    When user select the login/register button
    Then verify user is redirected to login/register page.

  Scenario: Verify user navigate by clicking catalog hierarchy in the breadcrumb
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Then verify user land on product detail page
    Then verify breadcrumb is available on product detail page
    When user click on catalog hierarchy link shown in the breadcrumb
    Then Verify user should navigate by clicking catalog hierarchy in the breadcrumb

  #Scenario: Verify the Enabled button Design for 'add to cart' & 'Buy now'
    #When user clicks HR from Steel Navigation Menu
    #When user selects Steel product
    #Given user is on product detail page of Steel item
    #And User click on close button
    #And User clicks on Add to cart button
    #And User click on close button
    #And user click on Buy Now
    #Then verify that User should redirect to the login page

  Scenario: Verify the Disabled button Design for 'add to cart' & 'Buy now'
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    And User click on close button
    And User clicks on Add to cart button
    And User click on close button
    And user click on Buy Now
    And User click on close button
    And click on ResetSelection button
    Then validate add to cart button is disabled
#  Scenario: verify the other images are maximized
#    Given user is on product detail page
#    Then verify the primary image of the product is visible on the left side of the screen
#    Then verify the images of the products are visible just below the primary image
#    When user click on the other images of the products
#    Then verify the other images are maximized
