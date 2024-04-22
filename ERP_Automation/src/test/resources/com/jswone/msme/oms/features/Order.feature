# use vpn
@OMS 
Feature: Verify order creation and erp order details

  Background: User opens website
    Given update the ledger amount to "0.0000"

  Scenario: Verify Straight Through Order Created with Full Net-Banking Payment
    Given a user is logged in the CCP Portal and has added products into the cart
    When they create a straight through order
    And they pay the full amount via net-banking
    And the payment is completed, making it 100% advance
    And user navigates to orders details page using cpp order
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "V2OrderDetails"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Full                                                                                                                                                                                                                                                                                |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, and total order amount                                                                                                                                                                   |

  @sanity 
  Scenario: Verify Straight Through Order Created with Partial Ledger Payment and Rest via Net-Banking
    Given update the ledger amount to "100000.0000"
    Given a user is logged in the CCP Portal and has added products into the cart
    When they create a straight through order
    And they pay an amount via ledger (deducted against the order) and the rest via net-banking
    And the ledger contains a certain amount
    And a new payment object is created from Merchant Center and paid via net-banking
    And the payment is completed, making it 100% advance
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "V2OrderDetails"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Full                                                                                                                                                                                                                                                                                |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, and total order amount                                                                                                                                                                   |
@OrderStatus 
  Scenario: Verify Straight Through Order Created with Partial Ledger Payment and Rest Paid via NEFT
    Given update the ledger amount to "28000"
    Given user create a payment request through curl of neft value "43200000"
    And user navigates to erp
    And user navigates to incoming payments
    And creates a untagged payment
    Given a user is logged in the CCP Portal and has added products into the cart
    When they create a straight through order using ledger balance
    And the payment is completed, making it 100% advance
    And user navigates to orders details page using cpp order without loggingin
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "V2OrderDetails"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Partial                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

@OrderStatus 
  Scenario: Verify Straight Through Order Created with 100% Payment from Ledger (NEFT/RTGS)
    Given update the ledger amount to "680000"
    Given a user is logged in the CCP Portal and has added products into the cart
    When they create a straight through order using ledger balance
    And the payment is completed, making it 100% advance
    And user navigates to orders details page using cpp order
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "V2OrderDetails"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Partial                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

@Order
  Scenario: Verify SLC Order Created with 100% Payment via Net-Banking
    Given user login to SF
    When user navigates to AccountPage
    When they create an SLC Order
    Given a user is logged in the CCP Portal
    When they create a straight through order
    And they pay the full amount via net-banking
    And the payment is completed, making it 100% advance
    And user navigates to orders details page using cpp order
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "SLC Order"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Full                                                                                                                                                                                                                                                                                |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

  Scenario: Verify SLC Order Created with 100% Advance Payment via NEFT
    Given user create a payment request through curl of neft value "43200000"
    And user navigates to erp
    And user navigates to incoming payments
    And creates a untagged payment
    Given user login to SF
    When user navigates to AccountPage
    When they create an SLC Order
    Given a user is logged in the CCP Portal
    When they create a straight through order using ledger balance
    And the payment is completed, making it 100% advance
    And user navigates to orders details page using cpp order without loggingin
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "SLC Order Created with 100% Advance Payment via NEFT"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Pending                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

  @Test
  Scenario: Verify SLC Order Created with 10% Advance Payment via Net-banking
    Given user login to SF
    When user navigates to AccountPage
    When they create an SLC Order
    When they create a straight through order
    And they pay the full amount via net-banking
    Given a user is logged in the CCP Portal
    And they pay the full amount via net-banking
    And the payment is completed, making it 100% advance
    And user navigates to orders details page using cpp order
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "V2OrderDetails"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Pending                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

  Scenario: Verify SLC Order Created with 10% Advance Payment via Net-banking and 90% Payment via NEFT
    Given user create a payment request through curl of neft value "14200000"
    And user navigates to erp
    And user navigates to incoming payments
    And creates a untagged payment
    Given user login to SF
    When user navigates to AccountPage
    When they create an SLC Order
    Given a user is logged in the CCP Portal
    When they create a straight through order
    And they pay the full amount via net-banking
    And the payment is completed, making it 100% advance
    And user navigates to orders details page using cpp order without loggingin
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "V2OrderDetails"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Pending                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

  Scenario: Verify SLC Order Created with 10% Advance Payment via Ledger (NEFT) and 90% Payment via NEFT
    Given update the ledger amount to "30000"
    Given user create a payment request through curl of neft value "64200000"
    And user navigates to erp
    And user navigates to incoming payments
    And creates a untagged payment
    Given user login to SF
    When user navigates to AccountPage
    When they create an SLC Order
    Given a user is logged in the CCP Portal
    When they create a straight through order using ledger balance
    And the payment is completed, making it 100% advance
    And user navigates to orders details page using cpp order without loggingin
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "SLC Order Created with 10% Advance Payment via Ledger (NEFT) and 90% Payment via NEFT"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Pending                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

  Scenario: Verify SLO Order Created with 100% Advance Payment via Net-banking
    Given user login to SF
    When user navigates to AccountPage
    When they create a SLO Order
    And create order and extract orderno from SF
    And user is logged in the CCP Portal using SFEmail
    And user navigates to orderpage in CCP using SFOrder
    And click on PayVianetBanking
    And they pay the full amount via net-banking
    And the payment is completed, making it 100% advance
    And user navigates to ERP orders details page using SF order
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "SLO Order Created with 100% Advance Payment via Net-banking"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Pending                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

  Scenario: Verify SLO Order Created with 10% Advance Payment via Net-banking and 90% via Net-banking
    Given user login to SF
    When user navigates to AccountPage
    When they create a SLO Order
    And create order and extract orderno from SF
    And user is logged in the CCP Portal using SFEmail
    And user navigates to orderpage in CCP using SFOrder
    And click on PayVianetBanking
    And they pay the full amount via net-banking
    And the payment is completed, making it 100% advance
    And user navigates to ERP orders details page using SF order
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "SLO Order Created with 100% Advance Payment via Net-banking"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Pending                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

  @SLO
  Scenario: Verify SLO Order Created with 10% Advance Payment via Net-banking and 90% via NEFT
    Given user create a payment request through curl of neft value "18200000"
    Given user login to SF
    When user navigates to AccountPage
    When they create a SLO Order
    And create order and extract orderno from SF
    And user is logged in the CCP Portal using SFEmail
    And user navigates to orderpage in CCP using SFOrder
    And click on PayVianetBanking
    And they pay the full amount via net-banking
    And the payment is completed, making it 100% advance
    And user navigates to ERP orders details page using SF order
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "SLO Order Created with 10% Advance Payment via Net-banking and 90% via NEFT"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Pending                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

  Scenario: Verify SLO Order Created with 10% Advance Payment via Ledger(NEFT) and 90% Payment via NEFT
    Given update the ledger amount to "28000"
    Given user create a payment request through curl of neft value "43200000"
    And user navigates to erp
    And user navigates to incoming payments
    And creates a untagged payment
    Given a user is logged in the CCP Portal and has added products into the cart
    When they create a straight through order using ledger balance
    And the payment is completed, making it 100% advance
    And user navigates to orders details page using cpp order without loggingin
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for " 10% Advance Payment via Ledger(NEFT) and 90% Payment via NEFT"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Pending                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

  Scenario: Verify SLO Order Created with 10% Advance Payment via Ledger(NEFT) and 90% Payment via Net-banking
    Given user create a payment request through curl of neft value "3200000"
    #32000
    And user navigates to erp
    And user navigates to incoming payments
    And creates a untagged payment
    Given a user is logged in the CCP Portal and has added products into the cart
    When they create a straight through order
    And they pay the full amount via net-banking
    And the payment is completed, making it 100% advance
    And user navigates to orders details page using cpp order without loggingin
    Then the following details should be displayed on the ORDER DETAILS PAGE IN ERP for "10% Advance Payment via Ledger(NEFT) and 90% Payment via Net-banking"
      | Field               | Description                                                                                                                                                                                                                                                                         |
      | Buyer Order Number  | A unique order number created                                                                                                                                                                                                                                                       |
      | Order Date          | The order creation date                                                                                                                                                                                                                                                             |
      | Buyer               | Company name or Person's name, including GSTIN, Mobile, Email, shipping address, and billing address                                                                                                                                                                                |
      | Payment status      | Pending                                                                                                                                                                                                                                                                             |
      | Payment Type        | Cash and Carry                                                                                                                                                                                                                                                                      |
      | Business Unit       | MFG (Straight through and distributed Order)                                                                                                                                                                                                                                        |
      | Mode of Order       | Portal-Self (Straight through)                                                                                                                                                                                                                                                      |
      | Delivery Type       | Delivery and Self-Pickup                                                                                                                                                                                                                                                            |
      | Order Status        | Placed (for Order already created)                                                                                                                                                                                                                                                  |
      | Seller Order Number | A uniquely created seller order number                                                                                                                                                                                                                                              |
      | Seller Order status | Confirmation Pending                                                                                                                                                                                                                                                                |
      | SKU Details         | Details of the ordered SKU including SKU name, purchase ID, Variant MM-ID, delivery status, seller name, quantity ordered, quantity shipped, discounted price, order value, delivered value, service cost, shipment number, short-closed quantity, cancelled quantity, and cashback |
      | Action              | Update button to redirect to the order list page                                                                                                                                                                                                                                    |
      | ORDER SUMMARY       | Summary of the order, including total price, tax, freight charges, GST on freight charges, total order amount, positive tolerance amount, total paid amount, and pending amount                                                                                                     |

  @sourceseller
  Scenario: View Source Seller Details in Order Detail Page
    Given user login to SF
    When user navigates to AccountPage
    When they create an SLC Order
    And create order and extract orderno from SF
    And user navigates to ERP orders details page using SF order
    And they hover over the Source Seller in the SKU Level
    Then the user should be able to view the details of the Source Seller, including GSTIN, Mobile number, Email-ID, and address

  @cancelled
  Scenario: Order Cancellation with Reason in ERP
    Given user login to SF
    When user navigates to AccountPage
    When they create an SLC Order
    And create order and extract orderno from SF
    And user navigates to ERP orders details page using SF order
    Then the order status is marked as "Cancelled" in ERP
    When the payment is received against the order
    Then a refund process should be initiated to refund the payment amount to the customer's ledger

  @declined
  Scenario: Order is marked as Declined from Salesforce
    Given user login to SF
    When user navigates to AccountPage
    When they create an SLC Order
    And create order and extract orderno from SF
    And user navigates to ERP orders details page using SF order
    Then the order status is marked as "Declined" in ERP
    And the order in the CCP portal is marked as Declined in the My Order Page
    And the order status in ERP is updated to Declined
    When the payment is received against the order
    Then a refund process should be initiated to refund the payment amount to the customer's ledger
