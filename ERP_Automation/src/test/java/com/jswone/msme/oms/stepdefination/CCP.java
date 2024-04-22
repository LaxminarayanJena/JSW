package com.jswone.msme.oms.stepdefination;

import java.awt.AWTException;
import java.io.IOException;

import com.jswone.msme.oms.factory.DriverFactory;
import com.jswone.msme.oms.pages.CCPPage;
import com.jswone.msme.oms.pages.SFPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CCP {
	private CCPPage cppPage = new CCPPage(DriverFactory.getDriver());
	private SFPage sfPage = new SFPage(DriverFactory.getDriver());

	@When("user is logged in the CCP Portal using SFEmail")
	public void user_is_logged_in_the_ccp_portal() throws InterruptedException, IOException {
		cppPage.goToCCP("sfccpemail");
	}

	@Given("a user is logged in the CCP Portal and has added products into the cart")
	public void a_user_is_logged_in_the_ccp_portal_and_has_added_products_into_the_cart()
			throws InterruptedException, IOException, AWTException {

		cppPage.goToCCP("ccpemail");
		cppPage.addProduct();
	}
	
	@Given("a user is logged in the CCP Portal")
	public void a_user_is_logged_in_the_ccp_portal()
			throws InterruptedException, IOException, AWTException {

		cppPage.goToCCP("ccpemail");
	}
	
	
	


	@Given("they create a straight through order")
	public void they_create_a_straight_through_order() throws InterruptedException {
		cppPage.createOrder();
	}
	
	@Given("they create a straight through order using ledger balance")
	public void they_create_a_straight_through_orderusingLedgerBalance() throws InterruptedException {
		cppPage.createOrderUsingLedgerBalance() ;
	}

	@When("they pay the full amount via net-banking")
	public void they_pay_the_full_amount_via_net_banking() throws InterruptedException {
		cppPage.payUsingNetBanking();

	}

	@When("click on PayVianetBanking")
	public void payvia_net_banking() throws InterruptedException {
		cppPage.clickPayViaNetBanking();

	}

	@When("the payment is completed, making it {int}% advance")
	public void the_payment_is_completed_making_it_advance(Integer int1) throws InterruptedException {
		cppPage.validateOrderSuccessfulmsg();
	}

	@When("they pay an amount via ledger \\(deducted against the order) and the rest via net-banking")
	public void they_pay_an_amount_via_ledger_deducted_against_the_order_and_the_rest_via_net_banking() throws InterruptedException {
		cppPage.payUsingNetBanking();
	}

	@When("the ledger contains a certain amount")
	public void the_ledger_contains_a_certain_amount() {

	}

	@When("a new payment object is created from Merchant Center and paid via net-banking")
	public void a_new_payment_object_is_created_from_merchant_center_and_paid_via_net_banking() {

	}

	

}
