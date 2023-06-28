@blogs
Feature: Blog feature

  Background: User opens website
    Given user is on home page
    #When user clicks on login button
    #When user click  on login by email
    #When user enters logins with username with "distramyatest@gmail.com" and  "Ramya@123"
    #And user clicks on signin
    #Then user homepage is displayed

  Scenario: Verify user is able to navigate to blog page through homepage
    When user clicks on Blogs in header menu
    Then user is able to navigate to blog page through homepage

  Scenario: Verify header section and pagination in blogs
    When user clicks on Blogs in header menu
    Then user is able to navigate to blog page through homepage
    And user is able to see All, Business,Sustainaibilty,Technology,News,Product in header
    And pagination is displayed in blogs

  Scenario: Verify recent blogs section
    When user clicks on Blogs in header menu
    Then user is able to navigate to blog page through homepage
    And user click on a section like product
    Then recent blogs is displayed


  Scenario Outline: Verify registration in blogs
    When user clicks on Blogs in header menu
    Then user is able to navigate to blog page through homepage
    When user clicks on register button in blogsPage
    When user enters username with "<username>"
    And user enters mobile with "<mobileno>"
    And user enters gstno with "<GSTIN>"

    Examples: 
      | username | mobileno   | GSTIN           | companyemail        | password  |
      | ramya    | 7000000014 | 32AAIAS3118C1Z0 | bamya9347@gmail.com | Ramya@678 |

  Scenario: Verify login in blogs section
    When user clicks on Blogs in header menu
    Then user is able to navigate to blog page through homepage
    When user clicks on login button in blogsPage
    When user click  on login by email
