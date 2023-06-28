@GuestUser @sanityExe 
Feature: Guest User feature

  Background: User opens website
    Given user is on home page

  Scenario: Verify different elements in homepage for guest user
    Then Verify the Login button is displaying in the Home Page Header
    Then Verify the action of Login button
    Then Verify the Register Button is displaying in Home Page header.
    Then Verify the action of Register button
    Then Verify the JSW logo is appearing in the Header Section
    Then Verify Search Bar is displayed with search icon
    #    Then Verify Language Indicator is displayed
    # Then Verify the Cart Icon displayed
    Then Verify "Steel by Categories" section available in the Header
    Then Verify that "Connect with Us" is available on the header section
    Then Verify that Header Section is displayed for Registered User
    Then Verify the JSW logo is appearing in the Header Section
    Then Verify the banners are displayed on the JSW Home Page
    Then Verify the banners displaying in the home Page for Registered User.
    Then Verify all the header available in the footer section
    Then Verify all the header available in the footer section after user logs in to the application
    Then Verify for sub links are available under General category
    Then Verify all the social media logos are available
    Then Verify for help line number is present in footer section
