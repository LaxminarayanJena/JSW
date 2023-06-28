@PDPRegisteredUser
Feature: Product Detail Page feature for Registered User

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "distramyatest@gmail.com" and  "Ramya@123"
    And user clicks on signin
    Then user homepage is displayed

  Scenario: verify user able to view message on thickness section
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    #Given user is on product detail page of Steel item
    Then user is able to view the message in the thickness section

  Scenario: verify product quantity should be updated in the cart icon.
    When cart is empty or not
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Cold rolled from Steel Menu
    And user click on product name of Cold rolled product displayed on the page
    And user is on ColdRolled Product page
    When user clicks on Add To Cart button available in the right side of the webpage
    Then verify that the product should be added in the cart

  #  Scenario: verify the product dimension should be diameter for wire rod
  #    When user enter "wire rod" in search bar
  #    And user click on search button
  #    Given user is on product detail page
  #    Then verify the product dimension should be diameter
  #
  #  Scenario: verify user can see the Price details inclusive of Taxes
  #    When user enter "colour" in search bar
  #    And user click on search button
  #    Given user is on product detail page of colored item
  #    When user selects the product attributes
  #    When user click on quantity button
  #    Then verify user can see the Price details inclusive of Taxes
  #@check
  #Scenario: For HR verify "Please select thickness and width before submitting error message"
  #When user enter "Hot Rolled Sheet" in search bar
  #And user click on search button
  #Then Breadcrump should display Steel by categories>Hot Rolled(HR)
  #Given user is on product detail page
  #When user enters invalid Custom Length "8000" and  submits custom length
  #Then Please select thickness and width before submitting error message to be displayed
  #
  #  Scenario: For HRPO verify "Please select thickness and width before submitting error message"
  #    When user enter "HRPO sheets" in search bar
  #    And user click on search button
  #    Given user is on product detail page
  #    When user enters invalid Custom Length "8000" and  submits custom length
  #    Then Please select thickness and width before submitting error message to be displayed
  #
  #  Scenario Outline: Verify invalid length error message value for custom length for HRPO is 249mm and maximum is 3601
  #    When user enter "<search>" in search bar
  #    And user click on search button
  #    Given user is on product detail page
  #    When user enters less than minimum  Custom Length "<customlength>" and  submits custom length
  #    Then invalid custom length error message to be displayed with length
  #
  #    Examples:
  #      | customlength | search      |
  #      |          249 | HRPO sheets |
  #      |         3601 | HRPO sheets |
  #
  #  Scenario Outline: Verify valid length error message value for custom length for HRO sheets is 250mm and maximum is 3600
  #    When user enter "<search>" in search bar
  #    And user click on search button
  #    Given user is on product detail page
  #    When user enters less than minimum  Custom Length "<customlength>" and  submits custom length
  #    Then invalid custom length error message should not be displayed
  #
  #    Examples:
  #      | customlength | search      |
  #      |          250 | HRPO sheets |
  #      |         3600 | HRPO sheets |
  #
  #  Scenario Outline: Verify invalid length error message value for custom length for HR is 249mm and maximum is 6301
  #    When user enter "<search>" in search bar
  #    And user click on search button
  #    Given user is on product detail page
  #    When user enters less than minimum  Custom Length "<customlength>" and  submits custom length for HR
  #    Then invalid custom length error message to be displayed with length
  #
  #    Examples:
  #      | customlength | search    |
  #      |          249 | HR sheets |
  #      |         6301 | HR sheets |
  #
  #  Scenario Outline: Verify valid length error message value for custom length for HR is 250mm and maximum is 6300
  #    When cart is empty or not
  #    When user enter "<search>" in search bar
  #    And user click on search button
  #    Given user is on product detail page
  #    When user enters less than minimum  Custom Length "<customlength>" and  submits custom length for HR
  #    Then invalid custom length error message should not be displayed
  #    When user clicks on Add To Cart button available
  #    Then verify that the product should be added in the cart
  #
  #    Examples:
  #      | customlength | search    |
  #      |          252 | HR sheets |
  #      |         6300 | HR sheets |
  #
  @dealpill
  Scenario: Verify dimensions are selected as per deal selected and viceversa
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    # Given user is on product detail page of Steel item
    And deal is visible
    When user click on deal
    #Then verify lowest price seller is displayed
    # Then verify best price is displayed on right side
    Then verify dimensions are selected
    When user select dimensions same as deal
    Then deal pill gets clicked

  @ctl
  Scenario: Verify customer length watermark for all the products
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click the customer length of the selected product
    #When user click the customer length of the selected product
    Then validate the customer length example value in the input field

  @MOQSteel @sanityExe
  Scenario: Verify MOQ for  Steel Product
    When cart is empty or not
    Then user navigate to Home page
    When user is on Steel Menu on header section
    And user is able to select Cold rolled from Steel Menu
    And user click on product name of Cold rolled product displayed on the page
    And user is on ColdRolled Product page
    And user add quantity and validate MOQ messages
      | quantity | MOQMessage                                                           |
      |        1 | Add a quantity equal to or above the Minimum Order Quantity of 3.0MT |
      #|      4000 | The maximum available quantity for your selection is 68.0MT          |
      | 10000000 | Please enter quantity below 9999 MT                                  |
    And validate add to cart button is disabled

  @ResetSelection
  Scenario: Check the Behaviour of ResetSelection button
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    And click on ResetSelection button
    Then validate add to cart button is disabled

  @ctl1
  Scenario Outline: Verify invalid length error message value for custom length
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click the customer length of the selected product
    When user enters invalid Custom Length "<customlength>" and  submits custom length for HR
    Then invalid custom length error message should not be displayed with entered length
    Then validate the customer length error message displayed

    Examples: 
      | customlength | search    |
      |          249 | HR sheets |
      |         6301 | HR sheets |

  @ctl
  Scenario: Verify customer length watermark for all the products
    When cart is empty or not
    When user clicks HR from Steel Navigation Menu
    When user selects Steel product
    Given user is on product detail page of Steel item
    When user click the customer length of the selected product
    When user click the customer length of the selected product
    Then validate the customer length example value in the input field
  #@Cement 
  #Scenario: Verify cement product can be added to cart
    #When cart is empty or not
    #Then user navigate to Home page
    #When user click Cement Menu on header section
    #And user click on product name of Cement product displayed on the page
    #And user is on Cement Product page
    #When user clicks on Add To Cart button available in the right side of the webpage
    #Then verify that the product should be added in the cart
  #@WireCoil 
  #Scenario: Verify WireRod product can be added to cart
    #When cart is empty or not
    #Then user navigate to Home page
    #When user is on Steel Menu on header section
    #And user is able to select Wire rods from Steel Menu
    #And user click on product name of Wire product displayed on the page
    #And user is on Wire Product page
    #When user clicks on Add To Cart button available in the right side of the webpage
    #Then verify that the product should be added in the cart
