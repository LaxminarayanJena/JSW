package stepdefination;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.MyOrderPages;
import pages.OrderSummaryPage;

public class OrderSummaryPageSteps {

	OrderSummaryPage order = new OrderSummaryPage(DriverFactory.getDriver());
	public String Orderno;
	public String tax;

	@Then("verify Order number,Order total,Payment received,Delivery type\\(delivery,pickup),Pending payment")
	public void verify_order_number_order_total_payment_received_delivery_type_delivery_pickup_pending_payment()
			throws InterruptedException {
		String deliveryType = order.validateOrderDetails();
		assertThat(deliveryType.contains("Delivery"));
	}

	@Then("verify  NEFT\\/RTGS ,Beneficiary name,Account Number,IFSC Code")
	public void verify_neft_rtgs_beneficiary_name_account_number_ifsc_code() throws InterruptedException {
		order.validateNetBankingAndNeft();

	}

	@Then("verify Your order is awaiting payment status")
	public void verify_your_order_is_awaiting_payment_status() throws InterruptedException {
		assertThat(order.validateOrderAwaitingMessage().contains("Your order is awaiting payment"));
	}

	@Then("user can minimise  item details and billing adress")
	public void user_can_minimise_item_details_and_billing_adress() throws InterruptedException {

		order.validateMinimiseOfItemDetails();
	}

	@Then("verify netbanking is disabled")
	public void verify_netbanking_is_disabled() throws InterruptedException {

		order.validateNetBankingDisabled();
	}

	@When("user click on view details and can see coupon got applied")
	public void user_click_on_view_details() throws InterruptedException {

		order.viewDetails();

	}

	@Then("Verifying item details")
	public void verifying_item_details() throws InterruptedException {
		order.viewItemDetails();
	}

	@Then("Verifying delivery days")
	public void verifying_delivery_days() throws InterruptedException {
		order.validateDeliveryDays();
	}

	@Then("Verifying shipping and billing and delivery adresss")
	public void verifying_shipping_and_billing_and_delivery_adresss() throws InterruptedException {
		order.validateShippingAndBilling();
	}

	@Then("^user can see order number in url instead of order id$")
	public void user_can_see_order_number_in_url_instead_of_order_id() throws Throwable {
		order.validateOrderNoinURL();
	}

	@Then("^Verifying payment status as Pending$")
	public void verifying_payment_status_as_partial() throws Throwable {
		String pymntStatus = order.validatePaymentStatus();
		assertThat(pymntStatus.contentEquals("Pending"));
	}

	@And("^user logins to cloud scheduler$")
	public void user_logins_to_cloud_scheduler() throws Throwable {
		order.loginToCloudScheduler();
	}

	@And("^run process customer balance batch query$")
	public void run_process_customer_balance_batch_query() throws Throwable {
		order.runBatchQuery();
	}

	@Then("^navigate to orders and the order$")
	public void navigate_to_orders_and_the_order() throws Throwable {
		order.navigateToOrder();
	}

	@And("^verify Your order payment is successful message$")
	public void verify_your_order_payment_is_successful_message() throws Throwable {
		order.validateSucessfulMsg();
	}

	@And("^payment status is full$")
	public void payment_status_is_full() throws Throwable {
		String pymntStatus = order.validatePaymentStatus();
		assertThat(pymntStatus.contentEquals("Full"));
	}
	
	@When("user is able to navigate to ordersumamryPage")
	public void user_is_able_to_navigate_to_ordersumamry_page() {
		order.validateOrderSummary();
	    
	}

}
