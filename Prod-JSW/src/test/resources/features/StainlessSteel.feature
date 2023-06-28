@sanityExe @demo @StainlessSteel @Testua
Feature: Stainless Steel feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "pradeep.mani99@gmail.com" and  "Admin@123"
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

  Scenario: Check for ClearFilter is  working properly in stainless Steel PLP
    When user clicks on Stainless Steel Navigation Menu
    Then Stainless Steel Products are displayed
    And user click on grade in filter
    And click on clearFilter
    Then all products to be displayed
