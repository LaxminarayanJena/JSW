@OMS  @Dashboard
Feature: Verify Dashboard

  Scenario: Verify User has log in to ERP
    Given user login to ERP
    Then validate 8 tabs User should see 8 tabs Dashboard,Order Details,Incoming Payments, Ledger,User Management,Finance Payout,Credit Limit,Credit Order

  Scenario: Verify seller filter in the dashboard
    Given user login to ERP
    When the user selects the "Seller" option from the filters at the top
    And the user types a partial seller name
    Then the seller name should auto-populate based on the input
    When the user clicks on submit
    Then all the displayed rows should correspond to the seller searched for

  Scenario: Verify  ops spoc filter in the dashboard
    Given user login to ERP
    And the user selects an Ops Spoc from the checkbox options
    When the user clicks on submit
    Then all the displayed rows should correspond to the Ops Spoc searched for

  Scenario: Verify Reset Button for filters
    Given user login to ERP
    And the user applies filters on seller, delivery state, and ops spoc and performs a search
    And the user clicks on submit
    When the user clicks on the reset button
    Then the applied filters should be reset and user should be able to see data from different seller, state, and ops spoc
    And verify total line items is 50

  Scenario: Open Orders Today Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Open orders" Today tab
    Then the orders that have an order creation date today should appear in today's bucket
    And the count should match with the pagination after clicking

  Scenario: Open Orders 1-3 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Open orders" 1-3 tab
    And the count should match with the pagination after clicking

  Scenario: Shipment Due 1-3 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Shipments due" 1-3 tab
    And the count should match with the pagination after clicking

  Scenario: Shipment Due Today Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Shipments due" Today tab
    And the count should match with the pagination after clicking

  Scenario: Open Orders 4-7 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Open orders" 4-7 days tab
    And the count should match with the pagination after clicking

  Scenario: Open Orders 1 Week+ Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Open orders" 1week+ tab
    And the count should match with the pagination after clicking

  Scenario: Shipment Due 4-7 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Shipments due" 4-7 days tab
    And the count should match with the pagination after clicking

  Scenario: Shipment Due 1 Week+ Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Shipments due" 1week+ tab
    And the count should match with the pagination after clicking

  Scenario: Payout Due Today Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Payout due" Today tab
    And the count should match with the pagination after clicking

  Scenario: Payout Due 1-3 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Payout due" 1-3 tab
    And the count should match with the pagination after clicking

  Scenario: Payout Due 4-7 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Payout due" 4-7 days tab
    And the count should match with the pagination after clicking

  Scenario: Payout Due 1 Week+ Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Payout due" 1week+ tab
    And the count should match with the pagination after clicking

  Scenario: Confirmation Pending Today Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Confirmation pending" Today tab
    And the count should match with the pagination after clicking

  Scenario: Confirmation Pending 1-3 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Confirmation pending" 1-3 tab
    And the count should match with the pagination after clicking

  Scenario: Confirmation Pending 4-7 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Confirmation pending" 4-7 days tab
    And the count should match with the pagination after clicking

  Scenario: Confirmation Pending 1 Week+ Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Confirmation pending" 1week+ tab
    And the count should match with the pagination after clicking

  Scenario: Follow Up Today Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Follow ups" Today tab
    And the count should match with the pagination after clicking

  Scenario: Follow Up 1-3 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Follow ups" 1-3 tab
    And the count should match with the pagination after clicking

  Scenario: Follow Up 4-7 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Follow ups" 4-7 days tab
    And the count should match with the pagination after clicking

  Scenario: Follow Up 1 Week+ Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Follow ups" 1week+ tab
    And the count should match with the pagination after clicking

  Scenario: Refund Today Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Refunds" Today tab
    And the count should match with the pagination after clicking

  Scenario: Refund 1-3 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Refunds" 1-3 tab
    And the count should match with the pagination after clicking

  Scenario: Refund 4-7 Days Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Refunds" 4-7 days tab
    And the count should match with the pagination after clicking

  Scenario: Refund 1 Week+ Bucket Verification
    Given user login to ERP
    When the user goes to the dashboard and clicks on the "Refunds" 1week+ tab
    And the count should match with the pagination after clicking
