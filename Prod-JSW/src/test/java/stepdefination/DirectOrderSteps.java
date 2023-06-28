package stepdefination;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DirectOrderPage;
import pages.Forgotpasswordpage;
import pages.PDPDiscountPage;
import pages.Paymentpage;

public class DirectOrderSteps {
	DirectOrderPage doppage = new DirectOrderPage(DriverFactory.getDriver());
	PDPDiscountPage pdpdispage = new PDPDiscountPage(DriverFactory.getDriver());
	private Forgotpasswordpage forgotpassword = new Forgotpasswordpage(DriverFactory.getDriver());
	Paymentpage pmtpage = new Paymentpage(DriverFactory.getDriver());
	public String Orderno;
	public String paymentId;
	public String orderId;
	public String paymentStatus;
	public String paymentStatus2;

	@Then("Buy from verified sellers is displayed")
	public void buy_from_verified_sellers_is_displayed() {
		doppage.validateBuyFromVerified();
	}

	@Then("click on buy directly from jsw steel")
	public void click_on_buy_directly_from_jsw_steel() {
		doppage.clickonJswSteel();
	}

	@When("user login to google cloud")
	public void user_login_to_google_cloud() {
		doppage.goToGoogleCloud();
	}

	@When("user click on upload files")
	public void user_click_on_upload_files() throws AWTException, InterruptedException {
		doppage.uploadFile();
	}

	@When("login to google cloud with gmail {string}")
	public void login_to_google_cloud_with_gmail(String Email) throws InterruptedException {
		forgotpassword.enterGmail(Email);
		forgotpassword.clickNext();
	}

	@When("login to google cloud with password {string}")
	public void login_to_google_cloud_with_password(String Password) {
		forgotpassword.enterPassword(Password);
	}

	@Then("click gmail next button")
	public void click_gmail_next_button() throws InterruptedException {
		forgotpassword.clickpasswordNext();
	}

	@When("user click on Buy from verified sellers")
	public void user_click_on_buy_from_verified_sellers() {
		doppage.clickBuyFromVerified();
	}

	@Then("verify Buy directly from JSWsteel is displayed")
	public void verify_buy_directly_from_js_wsteel_is_displayed() {
		doppage.validateDirectlyfromJSW();
	}

	@When("user click on Buy directly from JSWsteel")
	public void user_click_on_buy_directly_from_js_wsteel() {
		doppage.clickDirectlyfromJSW();
	}

	@Then("verify My requirements are displayed on top")
	public void verify_my_requirements_are_displayed_on_top() throws InterruptedException {
		Thread.sleep(3000);
		doppage.validateMyRequirements();
	}

	@When("user click on make payment and confirms payment successful")
	public void user_click_on_make_payment_and_confirms_payment_successful() throws InterruptedException {
		doppage.clickmakePayment();
		Thread.sleep(12000);
		doppage.clickConfirmPayment();
		doppage.validatePaymentSuccessful();
		Thread.sleep(5000);
	}

	@Then("verify Proceed to Pay is displayed on top")
	public void verify_proceed_to_pay_is_dispalyed_on_top() {
		doppage.validateProceedtoPaytop();
	}

	@Then("verify Request Price is displayed on rightside")
	public void verify_request_price_is_displayed_on_rightside() {
		doppage.validateRequestPrice();
	}

	@When("user enter dimension for product")
	public void user_enter_dimension_for_product() throws InterruptedException {
		pdpdispage.selectDimensionreguser();
		doppage.enterQuantity50();
		doppage.clickQuantity();

	}

	@When("user enter quantity and dimensions for the product")
	public void user_enter_quantity_and_dimensions_for_the_product() throws InterruptedException {
		pmtpage.selectDimensionreguser2();
		doppage.enterQuantity50();
		doppage.clickQuantity();
	}

	@When("user click Request Price")
	public void user_click_request_price() throws InterruptedException {
		Thread.sleep(10000);
		doppage.clickRequestPrice();
	}

	@Then("verify View requirements cart is displayed")
	public void verify_view_requirements_list_is_displayed() throws InterruptedException {
		Thread.sleep(4000);
		doppage.validateViewRequirementList();
	}

	@When("user click View requirements list")
	public void user_click_view_requirements_list() {
		doppage.clickViewRequirementsList();
	}

	@Then("verify Request for price is displayed")
	public void verify_request_for_price_is_displayed() throws InterruptedException {
		Thread.sleep(3000);
		doppage.validateRequestforPrice();
	}

	@Then("verify Requirement list is displayed")
	public void verify_requirement_list_is_displayed() {
		doppage.validateRequirementTab();
	}

	@When("user click on Request for price")
	public void user_click_on_request_for_price() throws InterruptedException {
		doppage.clickRequestforPrice();
		Thread.sleep(10000);
	}

	@Then("verify Message {string} is displayed.")
	public void verify_message_is_displayed(String string) throws InterruptedException {
		Thread.sleep(3000);
		doppage.validateMessage();
	}

	@When("Requirement is present then remove it")
	public void requirement_is_present_then_remove_it() throws Exception {

		if (doppage.isElementPresent())

		{
			doppage.clickRemoveButton();
		}

	}

	@When("user click on cart on top and then Requirements tab")
	public void user_click_on_cart_on_top_and_then_requirements_tab() throws InterruptedException {
		// doppage.clickMyRequirements();
		Thread.sleep(5000);
		doppage.clickCartLogo();
		doppage.validateRequirementTab();
		doppage.clickRequirementTab();

	}

	@Then("verify no product in requirement list")
	public void verify_no_product_in_requirement_list() throws Exception {
		boolean a = doppage.validateEmptyRequirement();
		Assert.assertEquals(a, true);

	}

	@When("user click on remove button on the product")
	public void user_click_on_remove_button_on_the_product() throws Exception {
		doppage.clickRemoveButton();
	}

	@Then("verify delivery date is displayed from {int}-{int} days")
	public void verify_delivery_date_is_displayed_from_days(Integer int1, Integer int2) throws InterruptedException {
		Thread.sleep(2000);
		String deliverydateText = doppage.validateDeliveryDate();
		Assert.assertEquals(deliverydateText, "Delivery in 30 - 45 days");
		Thread.sleep(3000);

	}

	@Then("user is able to view Add to requirement cart")
	public void validateAddToRequirementCart() {
		doppage.validateAddToRequirementCart();
	}

	@Then("user click on Add to requirement cart")
	public void clickonAddTorequirementCart() {
		doppage.clickAddToRequirementCart();
	}
	
	@Then("user click on ViewRequirement")
	public void clickonViewequirementCart() {
		doppage.clickViewRequirementCart();
	}

	@When("user enter dimension and quantity")
	public void user_enter_dimension_and_quantity() throws InterruptedException {
		doppage.enterHRDimension();

		doppage.clickQuantity();

	}

	@When("homepage refreshes")
	public void homepage_refreshes() throws InterruptedException {

		if (!(doppage.isElementPresent2()))

		{
			doppage.refreshHomepage();
		}

	}

	@When("user click on cart on top")
	public void user_click_on_cart_on_top() throws InterruptedException {
		doppage.clickCartLogo();

	}

	@When("user click on Mycart and then Proceed to pay")
	public void user_click_on_Mycart_and_then_Proceed_to_Pay() throws InterruptedException {
		doppage.clickMyCart();
		Thread.sleep(2000);
		doppage.clickProceedtoPay();
		Thread.sleep(3000);
	}

	@When("user clicks on My order and select order details like orderid")
	public void user_clicks_on_my_order_and_select_order_details_like_orderid() throws InterruptedException {

		doppage.clickMyOrder();
		Thread.sleep(5000);
		doppage.clickViewOrderDetails();
		Thread.sleep(3000);
		Orderno = doppage.getOrderNo();
		paymentStatus = doppage.getpaymentStatus();
		Thread.sleep(5000);
		orderId = doppage.getOrderID();

	}

	@When("user clicks on My order and select order details")
	public void user_clicks_on_my_order_and_select_order_details() throws InterruptedException {

		doppage.clickMyOrder();
		Thread.sleep(5000);
		doppage.clickViewOrderDetails();
		Thread.sleep(3000);
		Orderno = doppage.getOrderNo();
		paymentStatus2 = doppage.getpaymentStatus();
		Thread.sleep(5000);
		orderId = doppage.getOrderID();

	}

	@When("user login to merchant centre username with {string} and  {string}")
	public void user_login_to_merchant_centre_username_with_and(String Email, String Password)
			throws InterruptedException {
		doppage.gotoMerchantCentre();
		Thread.sleep(3000);
		doppage.loginMerchantCentre(Email, Password);
		Thread.sleep(10000);

	}

	@And("^user changes the environment$")
	public void user_changes_the_environment() throws Throwable {
		doppage.changeEnvironment();
	}

	@When("user click on order and search orderno")
	public void user_click_on_order_and_search_orderno() throws InterruptedException {
		doppage.clickOrder();
		if (doppage.isElementPresentpopup()) {
			doppage.checkPopup();
		}

		Thread.sleep(2000);
		doppage.enterOrdernoSearchBox(Orderno);

	}

	@When("capture paymentid from payment tab in order")
	public void capture_paymentid_from_payment_tab_in_order() throws InterruptedException {
		paymentId = doppage.getPaymentId();
	}

	@When("paste paymentid in Transaction Excel")
	public void paste_paymentid_in_transaction_excel() throws IOException, AWTException {
		doppage.sendPaymentIdTransExcel(paymentId);
	}

	@When("login to Transaction URL")
	public void login_to_transaction_url() throws AWTException {
		doppage.gotoGoogleCloudforTransaction();

	}

	@When("user upload transaction file")
	public void user_upload_transaction_file() throws AWTException, InterruptedException {
		doppage.uploadTransactionfile();
	}

	@When("user upload payment file")
	public void user_upload_payment_file() throws AWTException, InterruptedException {
		doppage.uploadPaymentfile();

	}

	@When("paste paymentid and orderid in payment Excel")
	public void paste_paymentid_and_orderid_in_payment_excel() throws IOException {
		doppage.sendPaymentidOrderidPaymentExcel(orderId, paymentId);
	}

	@When("Login to Payment URL")
	public void Login_to_payment_url() {
		doppage.gotoGoogleCloudforPayment();

	}

	@Then("Verify Payment status")
	public void verify_payment_status() {
		Assert.assertEquals(paymentStatus2, "Advance received");

	}

}
