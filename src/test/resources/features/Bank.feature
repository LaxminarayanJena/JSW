#va_IYQmzJQHLDMvoB
#https://dashboard.razorpay.com/app/smartcollect/virtualaccounts?count=25&id=va_IYQmzJQHLDMvoB
#username: jsw.one@jsw.in
#password: Jsw@1234
#@sanityExe @demo @steel
#Feature: Steel feature
#
  #Background: User opens website
    #Given user is on home page
    #When user clicks on login button
    #When user click  on login by email
    #When user enters logins with username with "pradeep.mani99@gmail.com" and  "Admin@123"
    #And user clicks on signin
    #Then user homepage is displayed
#
  #@PaymentGateway
  #Scenario Outline: Verify payment gateway for '<bank>' net banking with quantity '<quantity>' and place order successfully
    #When cart is empty or not
    #When user clicks HR from Steel Navigation Menu
    #Then HR Products are displayed
    #When user selects Steel product
    #Given user is on product detail page of Steel item and enters "<quantity>"
    #And user wait for sometime
      #When user clicks on Add To Cart button available in the right side of the webpage
    #Then verify that the product should be added in the cart
    #When user click on Cart icon on homepage
    #When user click on pickup checkbox
    #And user click on proceed to pay on cart detail page
    #And user select "<bank>" to transfer from the drop down on payment page
    #Then verify "<bank>" is selected
    #And User click on PayNow
    #Then User navigates to RazorPay Page
    #And User click on success button
    #Then verify after successful payment page navigates to ORDER summary page
    #Then order sucessfully placed message should be displayed
#
    #Examples: 
      #| quantity | bank                           |
      #|      500 | Axis Bank - Corporate Banking  |
      #|       60 | Axis Bank - Corporate Banking  |
      #|      500 | HDFC Bank                      |
      #|       60 | HDFC Bank                      |
      #|      500 | State Bank of India            |
      #|       60 | State Bank of India            |
      #|      500 | ICICI Bank - Corporate Banking |
      #|       60 | ICICI Bank - Corporate Banking |
      #|      500 | HSBC                           |
      #|       60 | HSBC                           |
      #|      500 | Central Bank of India          |
      #|       60 | Central Bank of India          |
      #|      500 | Federal Bank                   |
      #|       60 | Federal Bank                   |
      #|      500 | ICICI Bank                     |
      #|       60 | ICICI Bank                     |
