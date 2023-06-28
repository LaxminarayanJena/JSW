#1)change 1st scenario data-change mobile no,email and gstin otherwise it will throw error
@Registration
Feature: Registration page feature

  Background: User opens website
    Given user is on home page
    When user clicks on register button

  @sanityExe @Registration1
  Scenario Outline: Validate Registration with success message and proceed to home button is displayed
    When user enters username with "<username>"
    And user enters mobile with "<mobileno>"
    And user enters gstno with "<GSTIN>"
    And user enters companymailid with "<companyemail>"
    And click on termsandcondition
    And click on next button
    And click on new password  "<password>"
    And click on confirm password "<password>"
    And click on create account
    Then Thankyou page is displayed
    Then proceed to home is displayed

    Examples: 
      | username | mobileno   | GSTIN           | companyemail          | password  |
      | ramya    | 9791098217 | 29AWZPR8874L1ZV | ramyatestuserssr1@gmail.com | Ramya@678 |

  Scenario Outline: Validate  user is able to enter the user details and can proceed to password creation page
    When user enters username with "<username>"
    And user enters mobile with "<mobileno>"
    And user enters gstno with "<GSTIN>"
    And user enters companymailid with "<companyemail>"
    And click on termsandcondition
    And click on next button
    Then Guest User Navigates to Password creation page

    Examples: 
      | username | mobileno   | GSTIN           | companyemail       | password  |
      | ramya    | 9001000234 | 01ABHFA9731E1ZT | camya901@gmail.com | Ramya@678 |

  Scenario Outline: verify the error message is displaying if user enters Registered GSTIN Number
    When user enters username with "<username>"
    And user enters mobile with "<mobileno>"
    And user enters already registered gstno with "<GSTIN>"
    And user enters companymailid with "<companyemail>"
    Then invalid GST no message is displayed

    Examples: 
      | username | mobileno   | GSTIN           | companyemail        |
      | ramya    | 7000000234 | 22AAIAS3118C1Z1 | xzzya1347@gmail.com |

  Scenario Outline: Validate the error message is displaying if we enters more than 30 characters for full name
    When user enters username "<username>" with 31 characters
    Then validation error for character restriction to be displayed
    And user enters mobile with "<mobileno>"

    Examples: 
      | username                              | mobileno   |
      | Chinnaswami Muthuswami Venugopal Iyer | 8006510206 |

  Scenario Outline: Validate the proceed button is disabled if the user name is blank
    When user enters username with "<username>"
    And user enters mobile with "<mobileno>"
    And user enters gstno with "<GSTIN>"
    And user enters companymailid with "<companyemail>"
    And click on termsandcondition
    Then next button is disabled

    Examples: 
      | username | mobileno   | GSTIN           | companyemail       | password  |
      |          | 8006510107 | 33AVBPV0934G1ZQ | ramya207@gmail.com | Ramya@678 |

  Scenario Outline: verify ther user enters existing email-id then error message will be displayed
    When user enters username with "<username>"
    And user enters existing  companymailid with "<companyemail>"
    And user enters mobile with "<mobileno>"
    Then login popup is displayed

    #Then email validation error to be displayed
    Examples: 
      | username | mobileno   | companyemail        | password  |
      | ramya    | 7006500108 | xamy00060@gmail.com | Ramya@678 |

  Scenario Outline: Verify the user enters more than 80 characters for email then proper error message will be displayed
    When user enters username with "<username>"
    And user enters companymailid with more than 80 characters with "<companyemail>"
    And user enters mobile with "<mobileno>"
    Then validation error for character restriction to be displayed

    Examples: 
      | username | mobileno   | companyemail                                                                                                 | password  |
      | ramya    | 8006510108 | ramya12345678901123456789012345676787653ewsqazxerfdehyurhfhfhfhfhyr65hkgi89ihjgyut6789hgbmnbjhj201@gmail.com | Ramya@678 |

  Scenario Outline: Validate the error message is displaying if user enters email id without @
    When user enters username with "<username>"
    And user enters companymailid  without @ "<companyemail>"
    And user enters mobile with "<mobileno>"
    Then email validation error to be displayed

    Examples: 
      | username | mobileno   | companyemail |
      | ramya    | 8728765410 | abcgmail.com |

  Scenario: Validate user navigates to login page if user clicks on login link
    When user click on login hyper link
    Then login screen is displayed

  Scenario Outline: Validate error message for incorrect password
    When user enters username with "<username>"
    And user enters mobile with "<mobileno>"
    And user enters gstno with "<GSTIN>"
    And user enters companymailid with "<companyemail>"
    And click on termsandcondition
    And click on next button
    And click on new password  "<password>"
    And click on create account
    Then password error messaage to be displayed

    Examples: 
      | username | mobileno   | GSTIN           | companyemail        | password |
      | ramya    | 8890349912 | 33ALMPA3620R1Z0 | ramya3913@gmail.com | as       |

  Scenario Outline: Validate error message for unmatched password
    Given user is on home page
    When user clicks on register button
    And user enters username with "<username>"
    And user enters mobile with "<mobileno>"
    And user enters gstno with "<GSTIN>"
    And user enters companymailid with "<companyemail>"
    And click on termsandcondition
    And click on next button
    And click on new password  "<password1>"
    And click on confirm password "<password2>"
    And click on create account
    Then password do not match error messaage to be displayed

    Examples: 
      | username | mobileno   | GSTIN           | companyemail       | password1 | password1 |
      | ramya    | 8086511002 | 33ALMPA3620R1Z0 | ramya452@gmail.com | asWDNDG@1 | asWE@dff  |

  Scenario Outline: Validate GSTIN owner name along with bill to address and bill to pin code should be displayed on the screen below the 'Enter GSTIN' field as per the wireframe.
    When user enters username with "<username>"
    And user enters mobile with "<mobileno>"
    And user enters gstno with "<GSTIN>"
    And user enters companymailid with "<companyemail>"
    Then validate gstdetails

    Examples: 
      | username | mobileno   | GSTIN           | companyemail        | password  |
      | ramya    | 8996900002 | 21AAHCK4824E1ZX | rabya5352@gmail.com | Ramya@678 |

  Scenario Outline: Validate verify ther user enters existing phone number then login screen is displayed
    When user enters username with "<username>"
    And user enters mobile with "<mobileno>"
    And user enters gstno with "<GSTIN>"
    Then login screen is displayed

    Examples: 
      | username | mobileno   | GSTIN           | companyemail        | password  |
      | ramya    | 7000000014 | 32AAIAS3118C1Z0 | bamya9347@gmail.com | Ramya@678 |
