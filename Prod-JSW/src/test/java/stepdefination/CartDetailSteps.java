package stepdefination;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartDetailPage;
import pages.HomePage;
import pages.MyOrderPages;
import pages.PDPDiscountPage;
import pages.PDPRegisteredUserPage;
import pages.PDPpage;
import pages.Paymentpage;

public class CartDetailSteps {
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	PDPDiscountPage pdpdispage = new PDPDiscountPage(DriverFactory.getDriver());
	Paymentpage pmtpage = new Paymentpage(DriverFactory.getDriver());
	CartDetailPage cartdpage = new CartDetailPage(DriverFactory.getDriver());
	MyOrderPages myOrder = new MyOrderPages(DriverFactory.getDriver());
	PDPRegisteredUserPage pdp = new PDPRegisteredUserPage(DriverFactory.getDriver());
	PDPRegisteredUserPage pdpreguser = new PDPRegisteredUserPage(DriverFactory.getDriver());

	@When("user click on Cart icon on homepage")
	public void user_click_on_cart_icon_on_homepage() {
		cartdpage.clickCart();
	}

	@When("user click on Terms&condition on cart detail page")
	public void user_click_on_terms_condition_on_cart_detail_page() {
		cartdpage.validateTandC();
		cartdpage.clickTandC();

	}

	@Then("Verify Terms&condition page is displayed with some text")
	public void Verify_terms_condition_page_is_displayed_with_some_text() {
		cartdpage.validateTandCpage();

	}

	@When("user clicks on OK cart")
	public void user_clicks_on_ok_cart() throws InterruptedException {
		pdpdispage.validateitemAddedinCart();
	}

	@Then("Verify {string} is displayed below Proceed to pay button")
	public void verify_is_displayed_below_proceed_to_pay_button(String string) {
		cartdpage.validateTechSpec();

	}

	@When("user click on pickup checkbox")
	public void user_click_on_pickup_checkbox() throws InterruptedException {
		cartdpage.clickCheckbox();
	}

	@Then("verify delivery is by {int}-{int} days")
	public void verify_delivery_is_by_days(Integer int1, Integer int2) {
		cartdpage.validateDeliveryDate();
	}
	// Discount

	@When("user is on cart page")
	public void user_is_on_cart_page() throws InterruptedException {
		Thread.sleep(5000);
		cartdpage.clickCart();
		cartdpage.validateCartPage();
		Thread.sleep(2000);
	}

	@Then("user is able to apply STEEL250 coupon code")
	public void user_is_able_to_apply_steel250_coupon_code() throws InterruptedException {
		cartdpage.applySteel250();
		Thread.sleep(2000);
	}

	@When("user is removed products from cart line")
	public void user_is_removed_products_from_cart_line() throws InterruptedException {
		myOrder.couponsCount();
		Thread.sleep(2000);
		cartdpage.removeProduct();
	}

	@Then("User shall see modified pricing of the cart")
	public void user_shall_see_modified_pricing_of_the_cart() {
		cartdpage.priceverification();
	}

	@Then("Applied coupons remain active if applicable to the modified cart context")
	public void applied_coupons_remain_active_if_applicable_to_the_modified_cart_context() throws InterruptedException {
		cartdpage.validateAppliedCoupons();
	}

	@Then("Applied coupons remain in active if applicable to the modified cart context")
	public void applied_coupons_remain_in_active_if_applicable_to_the_modified_cart_context()
			throws InterruptedException {
		cartdpage.validateAppliedCoupons();
	}

	@Then("Count of applied coupons remains the same")
	public void count_of_applied_coupons_remains_the_same() {
		myOrder.couponsCount();
	}

	@When("user is on second product detail page of Steel item")
	public void user_is_on_second_product_detail_page_of_Steel_item() throws InterruptedException {
		pdp.HRSteelDetails01();
	}

	@When("user is removed Steel products from cart line")
	public void user_is_removed_steel_products_from_cart_line() throws InterruptedException {
		myOrder.couponsCount();
		Thread.sleep(2000);
		cartdpage.removeHRInCart();
	}

	@Then("Applied coupons remain active after removed if applicable to the modified cart context")
	public void applied_coupons_remain_active_after_removed_if_applicable_to_the_modified_cart_context() {
		cartdpage.validateAppliedCoupons();
	}

	@When("user is removed HR products from cart line")
	public void user_is_removed_hr_products_from_cart_line() throws InterruptedException {
		myOrder.couponsCount();
		Thread.sleep(2000);
		cartdpage.removeHRInCart();
	}
	
	@When("user click on change address to thrissur")
	public void user_click_on_change_address_to_thrissur() {
		cartdpage.changeAddress(1);
	   
	}
	
	@When("user click on change address to chandigarh")
	public void user_click_on_change_address_to_chandigarh() {
		cartdpage.changeAddress(0);
	   
	}
	@When("user click on change address to chennai")
	public void user_click_on_change_address_to_chennai() {
		cartdpage.changeAddress(2);
	   
	}
	
	@And("select for delivery")
	public void select_for_delivery() throws InterruptedException {
		cartdpage.selectDelivery();
	   
	}
	
	@And("verify tax matches in mc and UI")
    public void verify_tax_matches_in_mc_and_ui() throws Throwable {
       
    }
	
	 @Then("^verify 9% CGST and 9% SGST is displayed$")
	    public void verify_9_cgst_and_9_sgst_is_displayed() throws Throwable {
		 cartdpage.verifyCgstSgst();
	       
	    }



	@When("^user clicks Welding electordes from Welding Consummables Navigation Menu$")
	public void user_clicks_welding_electordes_from_welding_consummables_navigation_menu() throws Throwable {
		homePage.selectWeldingElectrodes();
	}

	@Then("^verify freight charges are displayed$")
	public void verify_freight_charges_are_displayed() throws Throwable {
		String deliverychargeText=cartdpage.verifydeliveryCharges();
		Assert.assertEquals("Delivery charges (incl. of all taxes)", deliverychargeText);
	}

	@And("user is on product detail page of Welding electordes item")
	public void user_is_on_product_detail_page_of_welding_electordes_item() throws Throwable {
		pdpreguser.WeldingElectrodeDetails() ;
	}

	@And("^verify subtotal is equal to sum of price,tax and freight charges$")
	public void verify_subtotal_is_equal_to_sum_of_pricetax_and_freight_charges() throws Throwable {
		cartdpage.verifysubTotal();
	}

	@When("^user clicks Welding wire from Welding Consummables Navigation Menu$")
	public void user_clicks_welding_wire_from_welding_consummables_navigation_menu() throws Throwable {
		homePage.selectWeldingWire();
	}

	@And("^user is on product detail page of Welding wire item$")
	public void user_is_on_product_detail_page_of_welding_wire_item() throws Throwable {
		pdpreguser.WeldingWireDetails() ;
	}
	@Then("verify bill To in cart section")
	public void verify_bill_to_in_cart_section() {
		cartdpage.verifyBillTo();
	   
	}
	@Then("verify Ship to in cart section")
	public void verify_ship_to_in_cart_section() {
		cartdpage.verifyshipTo();
	   
	}

}
