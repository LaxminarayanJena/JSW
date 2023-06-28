package stepdefination;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PDPDiscountPage;
import pages.PDPRegisteredUserPage;
import pages.PDPpage;
import pages.ProductLandingPage;

public class PDPwithDiscountSteps {

	PDPDiscountPage pdpdispage = new PDPDiscountPage(DriverFactory.getDriver());
	ProductLandingPage productlandingpage = new ProductLandingPage(DriverFactory.getDriver());
	PDPRegisteredUserPage pdpreguser = new PDPRegisteredUserPage(DriverFactory.getDriver());

	@Then("Breadcrump should display Steel by categories>Colour Coated")
	public void breadcrump_should_display_steel_by_categories_colour_coated() throws InterruptedException {
		Thread.sleep(5000);
		pdpdispage.ValidatebreadcrumbColourCoated();
	}

	@When("user is on product detail page of colored product")
	public void user_is_on_product_detail_page_of_colored_product() throws InterruptedException {
		Thread.sleep(2000);
		pdpdispage.selectProduct();
	}

	@When("user enter quantity as 3MT")
	public void user_enter_quantity_as_3mt() throws InterruptedException {
		pdpdispage.selectDimensionreguser();
		pdpdispage.enterQuantity3();
		pdpreguser.clickQuantity();
	}

	@When("user enter quantity as 2MT")
	public void user_enter_quantity_as_2mt() throws InterruptedException {
		pdpdispage.selectDimensionreguser();
		pdpdispage.enterQuantity2();
		pdpreguser.clickQuantity();
	}

	@Then("verify price would be displayed")
	public void verify_price_would_be_displayed() throws InterruptedException {
		Thread.sleep(3000);
		pdpdispage.validatePrice();

	}

	@When("user add an item to cart")
	public void user_add_an_item_to_cart() throws InterruptedException {
		pdpreguser.clickAddtoCart();
		pdpdispage.validateitemAddedinCart();
	}

	@Then("verify Cart icon would appear with {int}")
	public void verify_cart_icon_would_appear_with(Integer int1) {
		pdpdispage.validateCartIcon1();
	}

	@When("user click on cart icon with {int}")
	public void user_click_on_cart_icon_with(Integer int1) {
		pdpdispage.clickCartIcon1();
	}

	@When("user click view offers on cart detail page")
	public void user_click_view_offers_on_cart_detail_page() {
		pdpdispage.clickViewOffers();
	}

	@When("user enter the coupon code on apply coupon dialog")
	public void user_enter_the_coupon_code_on_apply_coupon_dialog() {
		pdpdispage.enterCouponCode();
	}

	@When("user click on apply")
	public void user_click_on_apply() throws InterruptedException {
		pdpdispage.clickApplyButton();
	}

	@When("user click on apply for expired coupon")
	public void user_click_on_apply_for_expired_coupon() throws InterruptedException {
		pdpdispage.clickApplyButton2();
	}

	@When("user enter the limit breached coupon code on apply coupon dialog")
	public void user_enter_the_limit_breached_coupon_code_on_apply_coupon_dialog() {
		pdpdispage.enterBreachedCouponCode();
	}

	@When("user click on apply for limit breached coupon")
	public void user_click_on_apply_for_limit_breached_coupon() throws InterruptedException {
		pdpdispage.clickApplyButton2();
	}

	@Then("verify coupon would be applied")
	public void verify_coupon_would_be_applied() {
		// pdpdispage.validateCouponApplied();
		// price with coupon is picked up from final price in website using xpath
		// price without coupon is calculated
		double actualpricewithoutcoupon2000 = pdpdispage.validatePriceBeforeCoupon2000();
		// double actualpricewithoutcoupon = pdpdispage.validatePriceBeforeCoupon();
		// System.out.println("Actual price without coupon"+ actualpricewithoutcoupon );
		double expectedpricewithcoupon = pdpdispage.priceAftercoupon();
		double carttotal = pdpdispage.cartTotal();
		double actualpricewithcoupon;

		if (carttotal <= 500000.00) {
			if ((carttotal > 300000.00))
				actualpricewithcoupon = actualpricewithoutcoupon2000 - 2000 - (2000 * 0.18);
			else
				actualpricewithcoupon = pdpdispage.validatePriceBeforeCoupon() - 500 - (500 * 0.18);
		} else {
			actualpricewithcoupon = pdpdispage.validatePriceBeforeCoupon() - (0.05 * carttotal)
					- (0.05 * 0.18 * carttotal);
			// actualpricewithcoupon= actualpricewithoutcoupon-2000-(2000*0.18);
		}
		double delta = 1e-01;
		System.out.println("expectedpricewithcoupon" + expectedpricewithcoupon);
		System.out.println("actual with coupon" + actualpricewithcoupon);
		Assert.assertEquals(expectedpricewithcoupon, actualpricewithcoupon, delta);

		// pdpdispage.priceAftercoupon();
	}

	@Then("verify the discounted price would be shown as {string} tag")
	public void verify_the_discounted_price_would_be_shown_as_tag(String string) {
		pdpdispage.validateSellerPromo();
	}

	@When("user enter dimension")
	public void user_enter_dimension() throws InterruptedException {
		pdpdispage.selectDimensionreguser();
		pdpdispage.enterQuantity5();
		pdpreguser.clickQuantity();
	}

	@Then("verify the cart value is more than 5L")
	public void verify_the_cart_value_is_more_than_5l() {

		Assert.assertTrue(pdpdispage.validatePrice());

	}

	@When("user add the product to cart")
	public void user_add_the_product_to_cart() throws InterruptedException {
		pdpreguser.clickAddtoCart();
		pdpdispage.validateitemAddedinCart();
	}

	@Then("verify discounted price would be shown as {string} tag")
	public void verify_discounted_price_would_be_shown_as_tag(String string) {
		pdpdispage.validatePlatformPromo();
	}

	@Then("verfiy {int},000rs would be discounted from the total price")
	public void verfiy_000rs_would_be_discounted_from_the_total_price(Integer int1) {
		Assert.assertTrue(pdpdispage.validateAmountdiscount(int1));
	}

	@Then("verify the cart value is more than 1L")
	public void verify_the_cart_value_is_more_than_1l() {
		Assert.assertTrue(pdpdispage.validatePrice1L());
	}

	@Then("verify {int},000rs would be discounted from the total price")
	public void verify_000rs_would_be_discounted_from_the_total_price(Integer int1) {
		pdpdispage.validateAmountdiscount(int1);
	}

	@Then("Cart icon would appear with {int}")
	public void cart_icon_would_appear_with(Integer int1) {
		pdpdispage.validateCartIcon1();
	}

	@Then("verify discounted price would be shown {string}")
	public void verify_discounted_price_would_be_shown(String string) {
		pdpdispage.validatePlatformPromo();
	}

	@Then("verify Platform discount coupon would be applied")
	public void verify_platform_discount_coupon_would_be_applied() {
		pdpdispage.validatePlatformPromo();
	}

	@When("user enter the expire coupon code on apply coupon dialog")
	public void user_enter_the_expire_coupon_code_on_apply_coupon_dialog() {
		pdpdispage.enterExpireCoupon();
	}

	@Then("verify product deleted from cart")
	public void verify_product_deleted_from_cart() throws InterruptedException {

		pdpdispage.deleteProductfromCart();
	}

	@Then("verify Error message should be displayed as {string}")
	public void verify_error_message_should_be_displayed_as(String string) throws InterruptedException {

		pdpdispage.validateCouponCodeError();
	}

	@Then("verify the cart value is more than 2L")
	public void verify_the_cart_value_is_more_than_2l() {
		Assert.assertTrue(pdpdispage.validatePrice2L());
	}

	@When("user enter the flat XValue2000 value coupon code on apply coupon dialog")
	public void user_enter_the_flat_x_value2000_value_coupon_code_on_apply_coupon_dialog() {
		pdpdispage.enterCouponCode2000();
	}

	@When("user click on apply coupon")
	public void user_click_on_apply_coupon() {
		pdpdispage.clickApplyCouponButton();

	}

	@Then("List of coupons to be displayed")
	public void list_of_coupons_to_be_displayed() {

		pdpdispage.CouponList();

	}

	@Then("user enters the {string} manually and click on apply")
	public void user_enters_the_manually_and_click_on_apply(String couponCode) throws InterruptedException {
		pdpdispage.enterTheCouponCode(couponCode);
		pdpdispage.clickApplyButton2();

	}

	@Then("coupon is applied and price gets updated")
	public void coupon_is_applied_and_price_gets_updated() {

		pdpdispage.validateCouponAppplied();

	}

	@Then("close the coupon window box")
	public void close_the_coupon_windowbox() {

		pdpdispage.closeCouponDialog();

	}

	@Then("remove button is displayed")
	public void remove_button_is_displayed() {
		pdpdispage.validateremoveButton();

	}

	@Then("user click on remove button")
	public void user_click_on_remove_button() {
		pdpdispage.clickremoveButton();
	}

	@Then("user closes coupon overlay")
	public void user_closes_coupon_overlay() {
		pdpdispage.closeCouponDialog();
	}

	@Then("price gets updated")
	public void price_gets_updated() {

	}

	@Given("user clicks on See more")
	public void user_clicks_on_see_more() {
		pdpdispage.clickSeeMoreButton();
	}

	@Then("list of other coupons also displayed")
	public void list_of_other_coupons_also_displayed() {

		pdpdispage.SeeMoreCouponsonPDPPage();

	}

	@Then("old price is strikethrough and new price amount is displayed in both Price section and cart line")
	public void old_price_is_strikethrough_and_new_price_amount_is_displayed_in_both_price_section_and_cart_line() {

	}

	@Then("user clicks on view coupons in order page then applied coupon to be displayed")
	public void user_clicks_on_view_coupons_in_order_page_then_applied_coupon_to_be_displayed() {
		pdpdispage.verifyViewCoupons();
	}

	@Then("user clicks on Know more")
	public void user_clicks_on_know_more() throws InterruptedException {
		pdpreguser.clickDigitalorderKnowMore();
		Thread.sleep(1500);
	}

	@Then("user is able to view details of the coupon code")
	public void user_is_able_to_view_details_of_the_coupon_code() {
		pdpreguser.couponDetails();

	}

	@Given("user is able to view Coupons section on PDP page")
	public void user_is_able_to_view_coupons_section_on_pdp_page() throws InterruptedException {
		pdpdispage.verifyDiscountSection();

	}

	@Then("user is able to view details of the list of coupon code")
	public void user_is_able_to_view_details_of_the_list_of_coupon_code() throws InterruptedException {
		pdpdispage.listCouponCode();

	}

	@Then("user is able to verify the coupons code displayed as Caps")
	public void user_is_able_to_verify_the_coupons_code_displayed_as_caps() throws InterruptedException {
		pdpdispage.verifyCouponCasing();
		Thread.sleep(1500);
	}

}
