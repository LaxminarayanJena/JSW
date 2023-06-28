@demo @sanityExe @MyProfile
Feature: Profile page feature

  Background: User opens website
    Given user is on home page
    When user clicks on login button
    When user click  on login by email
    When user enters logins with username with "profiletesthyd@gmail.com" and  "Admin@123"
    And user clicks on signin
    Then user homepage is displayed

  Scenario: Verify the user able to save profile details
    When user click on the profile menu
    Then Dropdown should be lsited
    When user click on the profile submmenu
    Then Profile page  should be lsited
    When user clicks on text box  clear the data and add the new designation
    Then Profile should be added with new designation
    When user clicks on text box  clear the data and add the new Udyam Number
    Then Profile should be added with new Udyam Number
    When user  click the Beneficiary name
    Then Copy icon is populated
    When user click the Account number
    Then Account Copy icon is populated
    When user  click the IFSC
    Then IFSC Copy icon is populated
    When user select the industrial sector
    When user select the industrial sector
    #Then interest area should be selected
    When user click the Save button
    Then Profile details should be saved

  Scenario: Verify the user is able to edit existing billing address
    When user click on the profile menu
    Then Dropdown should be lsited
    When user click on the profile submmenu
    Then Profile page  should be lsited
    And user clicks on addresses
    And user clicks on edit billing address
    And edit company adress

  Scenario: Verify the user able to add shipping and billing address
    When user click on the profile menu
    Then Dropdown should be lsited
    When user click on the profile submmenu
    Then Profile page  should be lsited
    And user clicks on addresses
    When user adds a new adresses and fill all details and save it
    Then addrees is displayed in shipping address column
    And address is mentioned in manage address column
    And user can delete existing shipping addresses
