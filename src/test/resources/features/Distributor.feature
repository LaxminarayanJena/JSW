#@Distributor
#Feature: Distributor page feature
#
    #Background: User opens website
    #Given user is on home page
    #When user clicks on login button
    #When user click  on login by email
    #When user enters logins with username with "ramya1347@gmail.com" and  "Ramya@678"
    #And user clicks on signin
    #Then user homepage is displayed
    #When user clicks on profile menu
    #And selects distributors submenu
#
  #Scenario Outline: verify the user is able to land on distributor page
    #When user clicks on add button and user selects distributor and clicks on confirm
    #Then distributor should be added to the category
#
  #Scenario Outline: verify the user is able to edit distributor
    #When user clicks on edit button and user change distributor and clicks on confirm
    #Then distributor should get changed
#
  #Scenario Outline: verify the user is able to delete distributor
    #When user clicks on remove button and pop up should be displayed and clicks on confirm
    #Then user distributor should get deleted
