@Ledger
Feature: Validating LedgerAPI

  @validateLedger
  Scenario: Validate LedgerAPI
    Given user calls "ledgerAPI" with "Get" http request for "validateLedger"
    Then validate that the "ledgerAPI"  call response is success with status code "200"
    And validate the "ledgerAPI" response time is less than "4000" ms
    And validate the "ledgerAPI" payload structure has "balanceAmount"

  @validateLedger
  Scenario: Validate LedgerAPI Transaction Download
    Given user calls "ledgerTransactionDownloadAPI" with "Get" http request for "TransactionDownload"
    Then validate that the "ledgerTransactionDownloadAPI"  call response is success with status code "200"
    And validate the "ledgerTransactionDownloadAPI" response time is less than "4000" ms
    And validate the "ledgerTransactionDownloadAPI" payload structure has "Incoming payment"


@validateBlockedAmountAPI
  Scenario: Validate LedgerBlockedAPI
    Given user calls "ledgerBlockedAmountAPI" with "Get" http request for "TransactionDownload"
    Then validate that the "ledgerBlockedAmountAPI"  call response is success with status code "200"
    And validate the "ledgerBlockedAmountAPI" response time is less than "4000" ms
    And validate the "ledgerBlockedAmountAPI" payload structure has "centAmount"


@validateBlockedAmountDetailsAPI
  Scenario: Validate LedgerBlockedAPIDetails
    Given user calls "ledgerBlockedAmountDetailsAPI" with "Get" http request for "TransactionDownload"
    Then validate that the "ledgerBlockedAmountDetailsAPI"  call response is success with status code "200"
    And validate the "ledgerBlockedAmountDetailsAPI" response time is less than "4000" ms
    And validate the "ledgerBlockedAmountDetailsAPI" payload structure has "blockedAmount"


 @validateLedger
  Scenario Outline: Valid Email ledger statement
    Given user calls "ledgerEmailStatementAPI" with "Post" http request with queryParam "<Param>" and "<Email>"
    Then validate that the "ledgerEmailStatementAPI"  call response is success with status code "200"
    And validate the "ledgerEmailStatementAPI" response time is less than "4000" ms
    And validate the "ledgerEmailStatementAPI" payload structure has "<ValidationMsg>"

    Examples: 
      | Param | Email                     | ValidationMsg                           |
      | email | jena.narayan224@gmail.com | Email Send to jena.narayan224@gmail.com |
