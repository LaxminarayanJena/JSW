package com.jswone.msme.oms.stepdefination;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;


import org.junit.Assert;

import com.jswone.msme.oms.factory.DriverFactory;
import com.jswone.msme.oms.pages.CCPPage;
import com.jswone.msme.oms.pages.DashboardPage;
import com.jswone.msme.oms.pages.OrderPage;
import com.jswone.msme.oms.util.ElementUtil;
import com.jswone.msme.oms.util.Database.LedgerBalance;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Order {

	private OrderPage orderPage = new OrderPage(DriverFactory.getDriver());
	private CCPPage cppPage = new CCPPage(DriverFactory.getDriver());
	private DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());


	@When("user navigates to orders details page using cpp order")
	public void user_navigates_to_orders_details_page_using_cpp_order() throws InterruptedException, IOException {
		//orderPage.goToOMS();
		dashboardPage.goToOMS();
		cppPage.goToCCPOrderinERP();
	}
	@When("user navigates to orders details page using cpp order without loggingin")
	public void user_navigates_to_orders_details_page_using_cpp_orderwithoutlogginin() throws InterruptedException, IOException {
		cppPage.goToCCPOrderinERP();
	}
	
	@When("user navigates to erp")
	public void user_navigates_to_erps() throws InterruptedException, IOException {
		//orderPage.goToOMS();
		dashboardPage.goToOMS();
	}
	
	@When("user navigates to incoming payments")
	public void user_navigates_to_incomingPayment() throws InterruptedException, IOException {
		orderPage.goToIncomingPayments();
	}

	@When("the user's ledger amount is {int}")
	public void the_user_s_ledger_amount_is(Integer int1) {
		LedgerBalance lb = new LedgerBalance();
		String lgerblance = lb.extractLedgerBalance("ee");
		System.out.println(lgerblance);

	}

	@When("the user's ledger amount is {string}")
	public void the_user_s_ledger_amount_is_for(String lgerbalance) {
		LedgerBalance lb = new LedgerBalance();
		String lgerblance = lb.extractLedgerBalance(lgerbalance);
		System.out.println(lgerblance);

		double balance = Double.parseDouble(lgerblance);

		if (balance == 0.0) {
			System.out.println("The ledger balance is equal to 0.");
		} else {
			System.out.println("The ledger balance is not equal to 0.");
		}

		assertEquals(lgerblance, "0.0000000000");
	}

	@When("update the ledger amount to {string}")
	public void update_the_ledger_amount_to(String ldgrAmount) throws InterruptedException {
		LedgerBalance lb = new LedgerBalance();
		lb.updateLedgerBalance(ldgrAmount);
	}

	
	
	@Then("the following details should be displayed on the ORDER DETAILS PAGE IN ERP for {string}")
	public void the_following_details_should_be_displayed_on_the_order_details_page_in_erp_for(String jsonValue, io.cucumber.datatable.DataTable dataTable) throws IOException {
		//cppPage.validateOrderValueFromV2API();
		//cppPage.validateV2OrderDetailsAPIContract(jsonValue);
	}


	@Then("the order status is marked as {string} in ERP")
	public void the_order_status_is_marked_as_in_erp(String orderStatusValue) {
		orderPage.selectOrderStatus(orderStatusValue);
	}

	@When("they hover over the Source Seller in the SKU Level")
	public void they_hover_over_the_source_seller_in_the_sku_level() {
		orderPage.hoversourceSeller();
	}

	@Then("the user should be able to view the details of the Source Seller, including GSTIN, Mobile number, Email-ID, and address")
	public void the_user_should_be_able_to_view_the_details_of_the_source_seller_including_gstin_mobile_number_email_id_and_address() {
		orderPage.viewSellerDetails();
	}
	
	
	
	@Given("user create a payment request through curl of neft value {string}")
	public void user_create_a_payment_request_through_curl_of_neft_value(String amt) {
		orderPage.untaggedPaymentThroughCurl(amt);
	}


	
	@And("creates a untagged payment")
	public void create_a_untagged_payment() throws InterruptedException {
		orderPage.untaggedPayment();
	}
	
	@Then("the order in the CCP portal is marked as Declined in the My Order Page")
	public void the_order_in_the_ccp_portal_is_marked_as_declined_in_the_my_order_page() {
	  
	}
	@Then("the order status in ERP is updated to Declined")
	public void the_order_status_in_erp_is_updated_to_declined() {
	 
	}
	@When("the payment is received against the order")
	public void the_payment_is_received_against_the_order() {
	  
	}
	@Then("a refund process should be initiated to refund the payment amount to the customer's ledger")
	public void a_refund_process_should_be_initiated_to_refund_the_payment_amount_to_the_customer_s_ledger() throws InterruptedException {
		ElementUtil.delay();
		LedgerBalance lb = new LedgerBalance();
		String lgerblance = lb.extractLedgerBalance("ee");
		System.out.println("final ledger balance"+lgerblance);
		Assert.assertNotNull(lgerblance);
		
	}
	
	@Then("the payment state should be Full in the ERP order details")
	public void the_payment_state_should_be_full_in_the_erp_order_details() {
		String paymnetStatus=orderPage.validatePaymentStatus();
		Assert.assertEquals(paymnetStatus, "Full");
		
	}
	
	
	
	




}
