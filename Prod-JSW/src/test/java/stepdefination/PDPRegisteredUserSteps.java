package stepdefination;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import pages.HomePage;
import pages.PDPRegisteredUserPage;
import pages.PDPpage;
import pages.ProductPage;

public class PDPRegisteredUserSteps {
	PDPRegisteredUserPage pdpreguser = new PDPRegisteredUserPage(DriverFactory.getDriver());
	PDPpage pdppage = new PDPpage(DriverFactory.getDriver());
	ProductPage p = new ProductPage(DriverFactory.getDriver());
	HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Given("user is logged in as registered user")
	public void user_is_logged_in_as_registered_user() {
		pdpreguser.validateLogin();

	}

	@Given("user is on product detail page of hotrolled item")
	public void user_is_on_product_detail_page_of_hotrolled_item() throws InterruptedException {
		// pdpreguser.validatesearchwithcategoryreguser();
		pdpreguser.selectProductreguser();

	}

	@Given("user is on product detail page of colored item")
	public void user_is_on_product_detail_page_of_colored_item() throws InterruptedException {
		// pdpreguser.validatesearchwithcategoryreguser();
		pdpreguser.selectProductreguser();

	}

	@When("user clicks on Add To Cart button available in the right side of the webpage")
	public void user_clicks_on_add_to_cart_button_available_in_the_right_side_of_the_webpage()
			throws InterruptedException {

		// pdpreguser.selectThicknessWidthLength();
		// pdpreguser.clickQuantity();
		pdpreguser.clickAddtoCart();

	}

	@When("user clicks on Add To Cart button available")
	public void user_clicks_on_add_to_cart_button_available() throws InterruptedException {

		pdpreguser.clickQuantity();
		pdpreguser.clickAddtoCart();

	}

	@Then("verify that the product should be added in the cart")
	public void verify_that_the_product_should_be_added_in_the_cart() throws InterruptedException {
		Thread.sleep(2000);
		pdpreguser.validateAddedtoCart();

	}

	@Given("user select wire rod")
	public void user_select_wire_rod() {
		pdpreguser.selectWireRod();
		pdpreguser.selectProductreguserwirerod();

	}

	@Then("verify the product dimension should be diameter")
	public void verify_the_product_dimension_should_be_diameter() {
		pdpreguser.validateDiameter();
	}

	@When("user selects the product attributes")
	public void user_selects_the_product_attributes() throws InterruptedException {
		pdpreguser.selectDimensionreguser();
	}

	@When("user click on quantity button")
	public void user_click_on_quantity_button() {
		pdpreguser.clickQuantity();
	}

	@Then("verify user can see the Price details inclusive of Taxes")
	public void verify_user_can_see_the_price_details_inclusive_of_taxes() {

		pdpreguser.validateTotalPrice();

	}

	@When("user enters invalid Custom Length {string} and  submits custom length")
	public void user_enters_invalid_custom_length_and_submits_custom_length(String string) throws InterruptedException {

		pdppage.CustomLength("80000");
	}

	@Then("Please select thickness and width before submitting error message to be displayed")
	public void please_select_thickness_and_width_before_submitting_error_message_to_be_displayed() {

		pdppage.validateCustomLengthErrorMessage();
		Assert.assertEquals("Please select thickness and width before submitting",
				pdppage.validateCustomLengthErrorMessage());
	}

	@When("user enters less than minimum  Custom Length {string} and  submits custom length")
	public void user_enters_less_than_minimum_custom_length_and_submits_custom_length(String string)
			throws InterruptedException {
		pdpreguser.selectDimensionHRPO();
		Thread.sleep(1000);
		pdppage.CustomLengthwithlength(string);
		Thread.sleep(2000);
	}

	@When("user enters less than minimum  Custom Length {string} and  submits custom length for HR")
	public void user_enters_less_than_minimum_custom_length_and_submits_custom_length_for_HR(String string)
			throws InterruptedException {
		pdpreguser.selectDimensionHR();
		Thread.sleep(1000);
		pdppage.CustomLengthwithlength(string);
		Thread.sleep(2000);
	}

	@Then("invalid custom length error message to be displayed")
	public void invalid_custom_length_error_message_to_be_displayed() {
		pdppage.validateCustomLengthErrorMessage();
		Assert.assertEquals("Invalid length. Please enter standard length", pdppage.validateCustomLengthErrorMessage());

	}

	@Then("invalid custom length error message to be displayed with length")
	public void invalid_custom_length_error_message_to_be_displayed_with_length() {
		pdppage.validateCustomLengthErrorMessage2();
		Assert.assertEquals("Invalid length. Please enter standard length",
				pdppage.validateCustomLengthErrorMessage2());

	}

	@Then("invalid custom length error message should not be displayed")
	public void invalid_custom_length_error_message_should_not_be_displayed() {
		// Assert.assertFalse(pdppage.validateCustomLtErrorMessage());

	}

	@Given("user is on product detail page of cold rolled sheets")
	public void user_is_on_product_detail_page_of_cold_rolled_sheets() throws InterruptedException {
		pdpreguser.selectProductcoldrolled();
	}

	@Given("deal is visible")
	public void deal_is_visible() throws InterruptedException {
		Thread.sleep(2000);
		pdpreguser.validateDealPill();
	}

	@When("user click on deal")
	public void user_click_on_deal() {
		pdpreguser.clickDealPill();
	}

	@Then("verify lowest price seller is displayed")
	public void verify_lowest_price_seller_is_displayed() throws InterruptedException {
		Thread.sleep(2000);
		pdpreguser.validateLowestPriceSeller();

	}

	@Then("verify best price is displayed on right side")
	public void verify_best_price_is_displayed_on_right_side() {
		pdpreguser.validateBestPrice();
	}

	@Then("verify dimensions are selected")
	public void verify_dimensions_are_selected() {
		Assert.assertEquals(true, pdpreguser.checkDimensionSelected());

	}

	@When("user select dimensions same as deal")
	public void user_select_dimensions_same_as_deal() throws InterruptedException {
		pdpreguser.selectDimensionDeal();
	}

	@Then("deal pill gets clicked")
	public void deal_pill_gets_clicked() {
		pdpreguser.validatedealPillclicked();
	}

	@Given("user is on product detail page of Stainless Steel item")
	public void user_is_on_product_detail_page_of_stainless_steel_item() throws InterruptedException {
		pdpreguser.stainlessSteelDetails();

	}

	@Given("user is on product detail page of Stainless Steel item and add dimensions")
	public void user_is_on_product_detail_page_of_stainless_steel_itemand_add_dimensions() throws InterruptedException {
		pdpreguser.stainlessSteelDetailsDimensions();

	}

	@Then("user add quantity and validate MOQ messages")
	public void user_add_quantity(DataTable Moq) throws InterruptedException {

		List<Map<String, String>> data = Moq.asMaps(String.class, String.class);
		for (Map<String, String> form : data) {

			String quantity = form.get("quantity");
			pdpreguser.stainlessSteelDetailsAddquantity(quantity);

			String moqMsg = form.get("MOQMessage");
			String actualErrorMessage = pdpreguser.MOQErrorMessage();
			System.out.println("Expected MOQ Message " + moqMsg);
			System.out.println("Actual MOQ Message" + actualErrorMessage);
			Assert.assertTrue(actualErrorMessage.contains(moqMsg));
			Thread.sleep(1000);

		}

	}

	@Given("user is on product detail page of Steel item")
	public void user_is_on_product_detail_page_of_steel_item() throws InterruptedException {
		pdpreguser.SteelDetails();

	}

	@Given("user is on product detail page of DirectOrderSteel item")
	public void user_is_on_product_detail_page_of_DirectOrdersteel_item() throws InterruptedException {
		pdpreguser.DirectOrderSteelDetails();

	}

	@And("^user is on Cement Product page$")
	public void user_is_on_cement_product_page() throws Throwable {
		pdpreguser.CementDetails();
	}

	@And("^user is on Wire Product page$")
	public void user_is_on_wire_product_page() throws Throwable {
		pdpreguser.WireDetails();
	}

	@And("^user is on ColdRolled Product page$")
	public void user_is_on_ColdRolled_product_page() throws Throwable {
		pdpreguser.ColdRolledDetails();
	}

	@Given("user is on product detail page of CR Coil item")
	public void user_is_on_product_detail_page_of_CRCoilsteel_item() throws InterruptedException {
		pdpreguser.CRCoilSteelDetails();

	}

	@Then("verify seller name")
	public void verify_seller_name() throws InterruptedException {
		pdpreguser.sellerName();

	}

	@Given("user is on product detail page of Steel item for DirectOrder")
	public void user_is_on_product_detail_page_of_steel_itemDirectOrder() throws InterruptedException {
		pdpreguser.DirectOrderSteelDetails();

	}

	@When("user is on product detail page of Steel item and add dimensions")
	public void user_is_on_productdetail_pageofSteelitemand_add_dimensionsm() throws InterruptedException {
		pdpreguser.SteelDetailsDimension();

	}

	@Given("validate add to cart button is disabled")
	public void validate_add_to_cartbuttondisabled() throws InterruptedException {

		Assert.assertFalse(pdpreguser.validateAddToCartisDisabled());

	}

	@Given("user is on product detail page of HRPO item")
	public void user_is_on_product_detail_page_of_hrpo_item() throws InterruptedException {
		pdpreguser.HRPODetails();

	}

	@Given("user is on product detail page of HR Sheet item")
	public void user_is_on_product_detail_page_of_HRSheet_item() throws InterruptedException {
		pdpreguser.HRSteelDetails();

	}

	@Then("click on ResetSelection button")
	public void click_on_ResetSelectionbutton() throws InterruptedException {

		pdpreguser.clickResetSelection();

	}

	@When("user enters invalid Custom Length {string} and  submits custom length for HR")
	public void user_enters_invalid_custom_length_and_submits_custom_length_for_HR(String string)
			throws InterruptedException {
		pdpreguser.CTLafterentered(string);
		Thread.sleep(2000);
	}

	@Then("invalid custom length error message should not be displayed with entered length")
	public void invalid_custom_length_error_message_should_not_be_displayed_with_entered_length()
			throws InterruptedException {

	}

	// customerLength

	@When("user select hot\\/cold sheet products")
	public void user_select_hot_cold_sheet_products() throws InterruptedException {
		p.selectHotRolledSheet();

	}

	@Then("user select the dimension of the selected product")
	public void user_select_the_dimension_of_the_selected_product() throws InterruptedException {
		p.SheetDimension();

	}

	@When("user click the customer length of the selected product")
	public void user_click_the_customer_length_of_the_selected_product() throws InterruptedException {
		p.clickCustomerLength();

	}

	@Then("validate the customer length example value in the input field")
	public void validate_the_customer_length_example_value_in_the_input_field() throws InterruptedException {
		p.validateCTL();
	}

	@Then("validate the customer length error message displayed")
	public void validate_the_customer_length_error_message_displayed() {
		pdpreguser.validateErrorMessage();
	}

	@When("user is on TMT Product page")
	public void user_is_on_tmt_product_page() throws InterruptedException {
		pdpreguser.TMTDetails();
	}

	@When("Straight, bent button is visible")
	public void straight_bent_button_is_visible() throws InterruptedException {
		pdpreguser.verifyTMTStraightBent();
	}

	@When("user click Cement Menu on header section")
	public void user_click_cement_menu_on_header_section() throws InterruptedException {
		homePage.validateCement();
	}
	
	@Given("^user is on product detail page of Steel item and enters \"([^\"]*)\"$")
    public void user_is_on_product_detail_page_of_steel_item_and_enters_something(String quantity) throws Throwable {
		 pdpreguser.SteelDetails(quantity);
    }

}