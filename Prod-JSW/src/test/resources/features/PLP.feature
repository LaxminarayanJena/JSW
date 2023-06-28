@PLP
Feature: Verification of PLP functionality feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "distramyatest@gmail.com" and  "Ramya@123"
    And user clicks on signin
    Then user homepage is displayed

  Scenario: Check navigation of PLP page
    When user click Steel Menu on header section
    And user is able to view Steel products on PLP page

  Scenario: Display BreadCrumb for Steel
    When user click Steel Menu on header section
    And user is able to view Steel products on PLP page
    Then Breadcrump should display HOME > Metals and Alloys > Steel

  Scenario: Display BreadCrumb for HR
    When user is able to select Hot Rolled from Steel Menu
    Then Breadcrump should display HOME > Metals and Alloys > Steel > HR

  Scenario: Display BreadCrumb for CR
    When user is able to select Cold Rolled from Steel Menu
    Then Breadcrump should display HOME > Metals and Alloys > Steel > CR

  Scenario: Check BreadCrumb hyperlink is working fine
    When user is able to select Hot Rolled from Steel Menu
    Then Breadcrump should display HOME > Metals and Alloys > Steel
    When user  click on Metal and Alloys hyper link in breadcrumb"
    Then product page should navigate to Metalm and Alloy

  Scenario: Check BreadCrumb hyperlink is working fine
    When user is able to select Hot Rolled from Steel Menu
    Then Breadcrump should display HOME > Metals and Alloys > Steel
    When user  click on home hyper link in breadcrumb"
    Then product page should navigate to home page

  Scenario: Check for Categories tabs are available for HR
    When user is able to view subcategory of Steel Menu on header section
    Then Catgories Tabs should be available with Hot Rolled,Cold Rolled,Wire Rod,TMT(Not for R1),Coated,Colour coated,Alloy Steel(Not for R1)"

  Scenario: Check JSW brand selection of Filters
    When user is able to select Hot Rolled from Steel Menu
    Then user is select Grade at Filter section
    Then Reset link should be available above the filters section

  Scenario: Products are displaying After filters removed
    When user is able to select Hot Rolled from Steel Menu
    Then user is select Grade at Filter section
    When user is able to view on Reset Hyper link CTA

  Scenario: Check for Total product found count is displaying for the Steel products
    When user is able to select Hot Rolled from Steel Menu
    Then check Found "count(*)" total product number of Steel products displayed

  Scenario: Check for Reset Hyperlink availability on page
    When user is on Steel Menu on header section
    And user is able to select Hot Rolled from Steel Menu
    Then user is select 2062:2011 from Grade at Filter section
    When user  click on Reset Hyper link
    Then All the filters should be removed All the products should display and no filters has to be selected"

  Scenario: Check applied Filters are shown above the products
    When user is on Steel Menu on header section
    And user is able to select Hot Rolled from Steel Menu
    Then user is select 2062:2011 from Grade at Filter section
    Then Filters applied should be shown above the Products display applied filters should display with cross button"

  Scenario: Check for Reset CTA enabled if filters applied more than 2 filters
    When user is on Steel Menu on header section
    And user is able to select Hot Rolled from Steel Menu
    Then user is select JSW Steel from Brand at Filter section
    Then user is select 2062:2011 from Grade at Filter section
    Then Filters applied should be shown above the Products display
    Then all the applied filters should display
    Then clear all hyper link must be available after selection of more than 2 filters

  Scenario: Check Clear all hyper link is clickable and clears the applied filters
    When user is on Steel Menu on header section
    And user is able to select Hot Rolled from Steel Menu
    Then user is select JSW Steel from Brand at Filter section
    Then user is select 2062:2011 from Grade at Filter section
    Then user is select the Thickness - Min and Max values
    And check clear hyper link is displayed on Thickness section
    And click Clear huper link

  Scenario: Check Clear all hyper link is clickable and clears the applied filters
    When user is on Steel Menu on header section
    And user is able to select Hot Rolled from Steel Menu
    Then user is select JSW Steel from Brand at Filter section
    Then user is select 2062:2011 from Grade at Filter section
    Then user is select the Thickness - Min and Max values
    And click on clear all hyper link
    And all the applied filters should be removed
    And all the products should display"

  Scenario: Remove atlest one applied filter and check displayed products
    When user is on Steel Menu on header section
    And user is able to select Hot Rolled from Steel Menu
    Then user is select JSW Steel from Brand at Filter section
    Then user is select 2062:2011 from Grade at Filter section
    Then user is select the Thickness - Min and Max values
    Then Filters applied should be shown above the Products display
    And After removing filter Thickness remaining filters products should display

  Scenario: cancel/close all filters shown above the prodcts
    When user is on Steel Menu on header section
    And user is able to select Hot Rolled from Steel Menu
    Then user is select JSW Steel from Brand at Filter section
    Then user is select 2062:2011 from Grade at Filter section
    Then user is select the Thickness - Min and Max values
    Then Filters applied should be shown above the Products display
    And user click on cross mark for all filters shown
    And all the applied filters should be removed
    And all the products should display

  Scenario: Filter Section for HR Category
    When user is on Steel Menu on header section
    And user is able to select Hot rolled from Steel Menu
    Then Filter sections are Brand, Grade, Thickness,Width and Length

  Scenario: Filter Section for CR Category
    When user is on Steel Menu on header section
    And user is able to select Cold rolled from Steel Menu
    Then Filter sections are Brand, Grade, Thickness,Width and Length

  Scenario: Filter Section for WR Category
    When user is on Steel Menu on header section
    And user is able to select Wire rods from Steel Menu
    Then Filter sections are Brand, Grade, Diameter

  Scenario: Filer Section for coated Category
    When user is on Steel Menu on header section
    And user is able to select Coated from Steel Menu
    Then Filter sections are Brand, Grade, Thickness,Width and Length

  Scenario: Filer Section for Colour Coated Category
    When user is on Steel Menu on header section
    And user is able to select Colour coated from Steel Menu
    Then Filter sections are Brand, Grade, Thickness,Width and Length

  Scenario: Products Display for Category HR
    When user is on Steel Menu on header section
    And user is able to select Hot rolled coil from Steel Menu
    Then Hot Rolled coil Related products will display

  Scenario: Check product name format should be "Brand  grade subgrade"
    When user is on Steel Menu on header section
    And user is able to select Hot rolled sheets from Steel Menu
    And product name should be for Hot Rolled Sheet is "JSW Steel Hot Rolled Sheets IS 2062:2011 E250A"

  Scenario: check Product name is clickable and page navigates to PDP page
    When user is on Steel Menu on header section
    And user is able to select Cold rolled sheets from Steel Menu
    And user click on product name displayed on the page
    Then page navigates to PDP page

  Scenario: Check price range is shown for each product
    When user is on Steel Menu on header section
    And user is able to select Cold rolled sheets from Steel Menu
    Then product price range should be display
    And Rupee symbol should be display at before every price

  Scenario: Check for Delivery is mentioned with estimated days
    When user is on Steel Menu on header section
    And user is able to select Cold rolled sheets from Steel Menu
    Then Delivery in should display with days range ie Delivery in 2-5 days

  Scenario: check for Grade section in filters are displayed as selected products with Hot rolled
    When user is on Steel Menu on header section
    And user is able to select Hot rolled from Steel Menu
    Then Grade for Hot Rolled are dispalyed 2062:2011, 3502:2004

  Scenario: check for Gade section in filters are displayed as selected products with Cold rolled
    When user is on Steel Menu on header section
    And user is able to select Cold rolled from Steel Menu
    Then Grade for Cold Rolled are dispalyed 1079:2017, 513 (Part1):2016, 5062:2011, 10748:2004

  Scenario: Check for Coating grade products are displayed after filters applied
    When user is on Steel Menu on header section
    And user is able to select Coated from Steel Menu
    Then Filter with Coating Grade to be displayed

  Scenario: Check for selected color products are displayed after filters applied
    When user is on Steel Menu on header section
    And user is able to select Colour coated from Steel Menu
    Then Filter with Color to be displayed

  Scenario: Check navigation of PLP page for TMT
    When user click TMT Menu on header section
    And user is able to view TMT Steel products on PLP page

  Scenario: Display BreadCrumb for Construction Steel
    When user click TMT Menu on header section
    And user is able to view TMT Steel products on PLP page
    Then Breadcrump should display HOME > Construction materials > TMT

  Scenario: Check BreadCrumb hyperlink is working fine
    When user click TMT Menu on header section
    And user is able to view TMT Steel products on PLP page
    Then Breadcrump should display HOME > Construction materials > TMT
    When user click on Construction materials hyper link in breadcrumb
    Then product page should navigate to Construction materials

  Scenario: Filer Section for TMT Category
    When user click TMT Menu on header section
    Then Filter sections are Brand, Grade and Diameter

  Scenario: Check product name format should be "Brand  grade subgrade"
    When user click TMT Menu on header section
    And product name should be for TMT Steel is "JSW Neosteel Fe55D TMT Rebar"

  Scenario: check Product name is clickable and page navigates to PDP page
    When user click TMT Menu on header section
    And user click on product name of TMT Steel product displayed on the page
    Then page navigates to PDP page

  Scenario: Check price range is shown for each product
    When user click TMT Menu on header section
    Then product price range should be display for TMT
    And Rupee symbol should be display at before every price

  Scenario: Check for Delivery is mentioned with estimated days
    When user click TMT Menu on header section
    Then Delivery in should display with days range ie Delivery in 2-5 days

  Scenario: Check JSW brand selection of Filters
    When user click TMT Menu on header section
    Then user is select JSW Brand at Filter section for TMT
    Then Reset link should be available above the filters section for TMT

  Scenario: Products are displaying After filters removed
    When user click TMT Menu on header section
    Then user is select Grade at Filter section for TMT
    When user is able to view on Reset Hyper link CTA

  Scenario: Check for Reset Hyperlink availability on page
    When user click TMT Menu on header section
    Then user is select JSW Steel from Brand at Filter section
    Then user is select IS 1786:2008 Fe 550D from Grade at Filter section for TMT
    When user  click on Reset Hyper link
    Then All the filters should be removed and products should display and no filters has to be selected"

  Scenario: Check applied Filters are shown above the products
    When user click TMT Menu on header section
    Then user is select JSW Steel from Brand at Filter section
    Then user is select IS 1786:2008 Fe 550D from Grade at Filter section for TMT
    Then Filters applied should be shown above the Products display applied filters should display with cross button"

  Scenario: Check for Reset CTA enabled if filters applied more than 2 filters
    When user click TMT Menu on header section
    Then user is select JSW Steel from Brand at Filter section
    Then user is select Grade at Filter section for TMT
    Then Filters applied should be shown above the Products display
    Then all the applied filters should display
    When user  click on Reset Hyper link

  Scenario: Check Clear all hyper link is clickable and clears the applied filters
    When user click TMT Menu on header section
    Then user is select JSW Steel from Brand at Filter section
    Then user is select Grade at Filter section for TMT
    Then user is select the Diameter - Min and Max values for TMT
    And check clear hyper link is displayed on Diameter section for TMT
    And click Clear huper link

  Scenario: Remove atlest one applied filter and check displayed products
    When user click TMT Menu on header section
    Then user is select JSW Steel from Brand at Filter section
    Then user is select Grade at Filter section for TMT
    Then user is select the Diameter - Min and Max values for TMT
    Then Filters applied should be shown above the Products display
    And After removing filter Diamter remaining filters products should display

  Scenario: cancel/close all filters shown above the prodcts
    When user click TMT Menu on header section
    Then user is select JSW Steel from Brand at Filter section
    Then user is select IS 1786:2008 Fe 550D from Grade at Filter section for TMT
    Then user is select the Diameter - Min and Max values for TMT
    Then Filters applied should be shown above the Products display
    And user click on cross mark for all filters shown
    And all the applied filters should be removed for TMT
    And all the products should display for TMT
