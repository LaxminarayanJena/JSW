@functional @HomePage @demo @sanityExe 
Feature: Home page feature

 Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "distramyatest@gmail.com" and  "Ramya@123"
    And user clicks on signin
    Then user homepage is displayed
 
  Scenario: Verify different elements in homepage
    Then Verify the JSW logo is appearing in the Header Section
    Then Verify Search Bar is displayed with search icon
    #    Then Verify Language Indicator is displayed
    Then Verify the Cart Icon displayed
    Then Verify "Steel by Categories" section available in the Header
    Then Verify that "Connect with Us" is available on the header section
    Then Verify that Header Section is displayed for Registered User
    Then Verify the JSW logo is appearing in the Header Section
    Then Verify the My Profile section link is appearing with users first name
    Then Verify that the My Profile section Link is displaying ^ icon when the drop down is clicked
    Then Verify the action of Logout Link in My Profile drop down
    Then Verify the banners are displayed on the JSW Home Page
    Then Verify the banners displaying in the home Page for Registered User.
    Then Verify all the header available in the footer section
    Then Verify all the header available in the footer section after user logs in to the application
    Then Verify for sub links are available under General category
    Then Verify all the social media logos are available
    Then Verify for help line number is present in footer section

  @Header 
  Scenario: Verify Header section elements
    Then Verify the JSW logo is appearing in the Header Section
    Then Verify Search Bar is displayed with search icon
    Then Verify User name is displayed in the Header Section
    Then Verify the My Profile section link is appearing with users first name
    Then Verify that the My Profile section Link is displaying ^ icon when the drop down is clicked
    Then Verify the action of Logout Link in My Profile drop down
    Then Verify Myorders is displayed in the Header Section
    #Then Verify Cart Icon displayed
    Then Verify "Steel" Category tree is displayed
    Then Verify "Stainless Steel" Category tree is displayed
    Then verify "Construction Material" category tree is displayed in Header section
    Then Verify "Help & support" is displayed in Header section
   # Then Verify user is navigate to "Help" page and back to home page
    Then Verify "About us" is displayed in header Section
    Then Verify user is able to view "Manage address" and navigate to address section in Profile page
    Then Verify that "Connect with Us" is available on the header section
    Then Verify user is navigate to "Help" page by clicking "Help & support" CTA
    Then Verify user is able to view toggled CTA on Header section

  @Homepageverification
  Scenario: Verification of Home page
    When user is able to view Steel category section
    And user is able to view Hot rolled coil products
    Then user is able to view View all CTA on Steel section
    When user is able to view Stainless Steel category section
    And user is able to view Hot rolled Sheet with series 200 subcategory products
    Then user is able to view View all CTA in Stainless Steel section
    When user is able to view blog and article section
    Then user is able to view View all in Blog section
    Then verify article banners are displayed
    Then user is able to view video section
    Then user is able to view work flow section

  @Footer
  Scenario: Verify footer elements
    When user verify the footer section headers
    Then Verify JSW logo is appearing in the Footer section
    Then Verify all the header available in the footer section
    Then Verify for sub links are available under General category
    Then Verify for sub links are available under Legal category
    Then Verify for help line number is present in footer section
    Then Verify for support email address is present in footer section

 # Scenario: Verify enquiry form
 #   Then Verify the mandatory fields in Enquiry Section for Registered Users
 #   Then Verify the submit button is enabled only once all the mandatory fields entered
 #   Then Verify the action on wrong data entered
 #   Then Verify the validation of the fields
 #   Then Verify the Enquiry Headings, and labels in Enquiry Section for Registered user.
 #   Then Verify For logged in user on Enquiry form Name, mobile number and email id should be pre-populated.
 #   Then Verify that the Enquiry section available in the JSW Home Page for Registered User
 #   Then Verify the Enquiry form banner displayed on the Home Page
 #   Then Verify the Enquiry form banner displayed on the Home Page for registered User
 #   Then Verify that "Thanks Popup" is displaying based on the successful submission of enquiry form
  #  Then Verify Query id is generated once query is submitted by the registered user.
