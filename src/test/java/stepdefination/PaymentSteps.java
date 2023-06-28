package stepdefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PDPRegisteredUserPage;
import pages.Paymentpage;
import io.cucumber.datatable.DataTable;

public class PaymentSteps {
	Paymentpage pmtpage = new Paymentpage(DriverFactory.getDriver());
	PDPRegisteredUserPage pdpreguser = new PDPRegisteredUserPage(DriverFactory.getDriver());

	@When("cart is empty or not")
	public void cart_is_empty_or_not() throws Exception {
		if (pmtpage.isElementPresent())

		{

			pmtpage.deleteProductfromCart();
		}
	}

	@When("user click on Buy Now")
	public void user_click_on_buy_now() throws InterruptedException {

		Thread.sleep(3000);
		pmtpage.clickBuyNow();
	}
	
	

    @And("^user click on selfpickup$")
    public void user_click_on_selfpickup() throws Throwable {
    	pmtpage.clickSelfPickup();
    }
    
    @Then("^Pickup address will be available msg to be displayed$")
    public void pickup_from_to_be_displayed() throws Throwable {
    	pmtpage.verifyPickupFrom();
        
    }
    
    @When("user click on proceed to pay on cart detail page and navigate to ordersummary page")
	public void user_click_on_proceed_to_pay_on_cart_detail_pageand_navigate_to_ordersummarypag() throws InterruptedException {
		pmtpage.validatecartdetailpage();
		Thread.sleep(3000);
		pmtpage.scroll();
		pmtpage.clickproceedtopay();
		
	}


	@When("user click on proceed to pay on cart detail page")
	public void user_click_on_proceed_to_pay_on_cart_detail_page() throws InterruptedException {
		pmtpage.validatecartdetailpage();
		Thread.sleep(3000);
		pmtpage.scroll();
		pmtpage.clickproceedtopay();
		pmtpage.clickpayViaNetBanking();
		Thread.sleep(5000);
	}

	@When("user enter quantity as 30MT")
	public void user_enter_quantity_as_30mt() throws InterruptedException {

		pmtpage.selectDimension();

		pmtpage.enterQuantity30();
		pdpreguser.clickQuantity();
	}

	@When("user is on product detail page of hot rolled product")
	public void user_is_on_product_detail_page_of_hot_rolled_product() throws InterruptedException {
		pmtpage.selectProduct();
	}

	@When("user select bank name to transfer from the drop down on payment page")
	public void user_select_bank_name_to_transfer_from_the_drop_down_on_payment_page() throws InterruptedException {
		pmtpage.validateBankList();
		pmtpage.clickBankList();
	}
	
	@And("^user select \"([^\"]*)\" to transfer from the drop down on payment page$")
    public void user_select_something_to_transfer_from_the_drop_down_on_payment_page(String bank) throws Throwable {
		pmtpage.clickSelectedBank(bank);
		//pmtpage.clickBankList();
    }

	@When("user select bank name to transfer from the drop down")
	public void user_select_bank_name_to_transfer_from_the_drop_down() throws InterruptedException {
		// pmtpage.validateBankList();
		pmtpage.clickBankList();
	}

	@Then("verify bank is selected")
	public void verify_bank_is_selected() throws InterruptedException {
		// pmtpage.validateBankSelected();
		pmtpage.selectBankNew();
	}
	

    @Then("^verify \"([^\"]*)\" is selected$")
    public void verify_something_is_selected(String bank) throws Throwable {
    	pmtpage.selectBankNew(bank);
    }

	@When("user click on {string} on cart detail page")
	public void user_click_on_on_cart_detail_page(String string) {

	}

	@Then("User click on PayNow")
	public void user_click_on_pay_now() throws InterruptedException {

		pmtpage.clickPayNow();
		//Thread.sleep(11000);
	}

	@Then("User navigates to RazorPay Page")
	public void user_navigates_to_razor_pay_page() throws InterruptedException {
		pmtpage.validateRazorpayPage();
	}

	@Then("User click on success button")
	public void user_click_on_success_button() throws InterruptedException {

		pmtpage.clickPaymentSucess();
		Thread.sleep(16000);

	}

	@Then("User click on failure button")
	public void user_click_on_failure_button() throws InterruptedException {
		pmtpage.clickPaymentFailure();
		Thread.sleep(16000);
	}

	@Then("order sucessfully placed message should be displayed")
	public void order_sucessfully_placed_message_should_be_displayed() {
		pmtpage.validateOrderSuccessfulmsg();
	}

	@Then("Verify user navigates to payment gateway page")
	public void verify_user_navigates_to_payment_gateway_page() {

	}

	@Then("verify error message should be displayed on unsuccessful payment")
	public void verify_error_message_should_be_displayed_on_unsuccessful_payment() throws InterruptedException {
		Thread.sleep(2000);
		pmtpage.validateunsuccessfulmsg();
	}

	@Then("verify after successful payment page navigates to ORDER summary page")
	public void verify_after_successful_payment_page_navigates_to_order_summary_page() {
		pmtpage.validateOrderSuccessfulmsg();
	}

	@When("user enter quantity and dimensions")
	public void user_enter_quantity_and_dimensions() throws InterruptedException {
		pmtpage.selectDimensionreguser2();
		pmtpage.enterQuantity30();
		pdpreguser.clickQuantity();
	}

	@When("user enter quantity and dimensions as 3MT")
	public void user_enter_quantity_and_dimensions_as_3MT() throws InterruptedException {
		pmtpage.selectDimensionreguser2();
		pmtpage.enterQuantity3();
		pdpreguser.clickQuantity();
	}

	@When("user enter UTR and validate UTR")
	public void user_enter_UTR_and_validate_UTR(DataTable UTRnumbernew) throws InterruptedException {

		List<Map<String, String>> data = UTRnumbernew.asMaps(String.class, String.class);
		for (Map<String, String> form : data) {

			String UTR = form.get("UTR");
			System.out.println("UTR :" + UTR);
			pmtpage.enterUTR(UTR);
			Thread.sleep(5000);

			String errorMessage = form.get("Error Message");
			String actualErrorMessage = pmtpage.validateConfirmPayment2(UTR);
			System.out.println("Actual Error Message :" + actualErrorMessage);
			System.out.println("Table Error" + errorMessage);
			Assert.assertTrue(actualErrorMessage.contains(errorMessage));

		}

	}

	@When("user enter UTR and validate it")
	public void user_enter_UTR_and_validate_it(DataTable UTRnumber) throws InterruptedException {

		List<String> data = UTRnumber.column(0);

		for (String newdata : data) {

			pmtpage.enterUTR((newdata));
			Thread.sleep(5000);
			pmtpage.validateConfirmPayment(newdata);

		}
	}

	@When("user click on confirm payment")
	public void user_click_on_confirm_payment() throws InterruptedException {

		//pmtpage.clickConfirmPayment();
		//Thread.sleep(15000);
	}

	@Then("verify neftbanking is disabled")
	public void verify_neftbanking_is_disabled() throws InterruptedException {
		//pmtpage.validateNetBanking();
		pmtpage.validateNeftBanking();
	}

	@Then("verify payment success message is displayed")
	public void verify_payment_success_message_is_displayed() {

		pmtpage.validateNEFTSuccessMessage();
	}

	@Then("click on Proceed to Pay on payment page")
	public void click_on_payment_to_pay_on_payment_page() throws InterruptedException {
		Thread.sleep(3000);
		pmtpage.clickProceedToPayPMTPage();
		Thread.sleep(3000);

	}
	
	
	@When("user logout of the account")
	public void user_logout_of_the_account() throws InterruptedException
	{
		
	pmtpage.clickLogOut();	
	}
	@When("check cart is empty")
	public void check_cart_is_empty() throws Exception {
		if (pmtpage.isElementPresentcart())

		{

			pmtpage.deleteProductfromCartdo();
		}
	}
	
	@When("user click on proceed and confirm later")
	public void user_click_on_proceed_and_confirm_later() {
	    pmtpage.clickConfirmLater();
	}

	@Then("verify payment pending message is displayed")
	public void verify_payment_pending_message_is_displayed() {
		pmtpage.validatePaymentPendingmsg();
	}

	@Then("user is able to see Make payment CTA on order summary page")
	public void user_is_able_to_see_make_payment_cta_on_order_summary_page() {
	   pmtpage.validateMakePayment();
	}
	
	
	@When("user clicks on netBanking")
	public void user_clicks_on_net_banking() throws InterruptedException {
		pmtpage.clickpayViaNetBanking();
	}
	
}
