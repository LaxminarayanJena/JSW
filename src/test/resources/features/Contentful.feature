@Contentful
Feature: Product Creation

  Background: User opens website
    Given user login to merchant centre username with "v_laxminarayan.jena@jsw.in" and  "123Tmnas$"

  Scenario Outline: Add Product in CT
    Given user click on addproduct
    And user search product
    And user clicks on product
    And clicks on acceptcookies
    And clicks on next
    And enters "<productname>"
    And clicks on next
    And clicks on AddVariant with "<productname>"
    And clicks on next
    And clicks on save

    Examples: 
      | productname      |
      | TMTSteelQAAuto4  |