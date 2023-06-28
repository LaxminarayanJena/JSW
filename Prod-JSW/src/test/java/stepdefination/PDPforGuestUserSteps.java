package stepdefination;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.openqa.selenium.By;

import pages.HomePage;
import pages.PDPpage;
import pages.PLPEnquiryPage;
import pages.ProductLandingPage;

public class PDPforGuestUserSteps {
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	PDPpage pdppage = new PDPpage(DriverFactory.getDriver());
	

	@Given("user is on PLP page")
	public void user_is_on_plp_page() {
		pdppage.validatePLPPage();
	}

	@When("user search with category")
	public void user_search_with_category() throws InterruptedException {
		pdppage.validatesearchwithcategory();
	}

	@When("user select any product example HR")
	public void user_select_any_product_example_hr() {
		// pdppage.clickvalidateAnyProduct();
		pdppage.selectProduct();
	}

	@Then("user is redirected to PDP Page")
	public void user_is_redirected_to_pdp_page() {
		pdppage.validatepdppage();
	}

	@Then("Breadcrump is displayed on top left corner of the page")
	public void breadcrump_is_displayed_on_top_left_corner_of_the_page() {
		pdppage.validateBreadCrumb();
	}

	@Then("verify user is on PDP page")
	public void verify_user_is_on_pdp_page() {
		pdppage.validatepdppage();
	}

	@Then("Verify primary and optional images are displayed")
	public void verify_primary_and_optional_images_are_displayed() {
		pdppage.validatePrimaryandOptional();
	}

	@When("user click on optional image")
	public void user_click_on_optional_image() {
		pdppage.clickOptionalImage();
	}

	@Then("verify product details are displayed as Chemical composition,Mechanical composition,Tolerance properties, Any others")
	public void verify_product_details_are_displayed_as_chemical_composition_mechanical_composition_tolerance_properties_any_others() {
		pdppage.validateChemicalMechanical();
	}

	@Then("verify User should directed to the PDP page.")
	public void verify_user_should_directed_to_the_pdp_page() {
		pdppage.validatepdppage();
	}

	@Then("verify user is directed to PDP page")
	public void verify_user_is_directed_to_pdp_page() {
		pdppage.validatepdppage();
	}

	@When("user Select thickness,width , height and Minimum Quantity.")
	public void user_select_thickness_width_height_and_minimum_quantity() throws InterruptedException {

		pdppage.selectDimension();
	}

	@When("user select dimensions and specific quantity.")
	public void user_select_dimensions_and_specific_quantity() throws InterruptedException {
		pdppage.selectDimension();
	}

	@When("user click on the add to cart button.")
	public void user_click_on_the_add_to_cart_button() {
		pdppage.clickAddtoCart();

	}

	@Then("verify User should redirect to the login page")
	public void verify_user_should_redirect_to_the_login_page() {
		pdppage.validateLogInPage();
	}

	@When("user click on the Buy Now button")
	public void user_click_on_the_buy_now_button() {
		pdppage.clickBuyNow();
	}

	@Then("User is redirected to the PDP page.")
	public void user_is_redirected_to_the_pdp_page() {
		pdppage.validatepdppage();
	}

	@Then("verify the delivery \\/ETD is displayed at the bottom of the specific quantity.")
	public void verify_the_delivery_etd_is_displayed_at_the_bottom_of_the_specific_quantity() {
		pdppage.validateEstimateDelivery();
	}

	@Then("verify the price range is displayed in right side of the page in the form of ht Rupees\\/Metric. {int}-{int},{int} Rupees\\/Metric Ton")
	public void verify_the_price_range_is_displayed_in_right_side_of_the_page_in_the_form_of_ht_rupees_metric_rupees_metric_ton(
			Integer int1, Integer int2, Integer int3) {
		pdppage.validatePrice();
	}

	@Then("verify the login and Register option is displayed in right side of the page above the add to cart button.")
	public void verify_the_login_and_register_option_is_displayed_in_right_side_of_the_page_above_the_add_to_cart_button() {
		pdppage.validateLoginRegister();
	}

	@When("user select the login\\/register button")
	public void user_select_the_login_register_button() {
		pdppage.clickLogin();

	}

	@Then("verify user is redirected to login\\/register page.")
	public void verify_user_is_redirected_to_login_register_page() {

		pdppage.validateLogin();

	}

	@When("user click on search bar")
	public void user_click_on_search_bar() {
		pdppage.clickSearchBar();
	}

	@When("user enter product keyword on search bar")
	public void user_enter_product_keyword_on_search_bar() {
		pdppage.enterProductKeyword();
	}

	@Then("user id landed on product listing page")
	public void user_id_landed_on_product_listing_page() {
		pdppage.validateProductListingPage();
	}

	@When("user select a product")
	public void user_select_a_product() {
		pdppage.selectProduct();

	}

	@Then("verify user land on product detail page")
	public void verify_user_land_on_product_detail_page() {
		pdppage.validatepdppage();

	}

	@Then("verify breadcrumb is available on product detail page")
	public void verify_breadcrumb_is_available_on_product_detail_page() {
		pdppage.validateBreadCrumbPDP();
	}

	@When("user click on catalog hierarchy link shown in the breadcrumb")
	public void user_click_on_catalog_hierarchy_link_shown_in_the_breadcrumb() {
		pdppage.validateCatalogBreadcrumb();

	}

	@Then("Verify user should navigate by clicking catalog hierarchy in the breadcrumb")
	public void verify_user_should_navigate_by_clicking_catalog_hierarchy_in_the_breadcrumb() {

	}

	@Given("user is on product detail page")
	public void user_is_on_product_detail_page() {
		pdppage.selectProduct();
		pdppage.validatepdppage();
	}

	@Then("verify the primary image of the product is visible on the left side of the screen")
	public void verify_the_primary_image_of_the_product_is_visible_on_the_left_side_of_the_screen() {
		pdppage.validatePrimaryandOptional();
	}

	@Then("verify the images of the products are visible just below the primary image")
	public void verify_the_images_of_the_products_are_visible_just_below_the_primary_image() {
		pdppage.validatePrimaryandOptional();
	}

	@When("user click on the other images of the products")
	public void user_click_on_the_other_images_of_the_products() {
		pdppage.clickOptionalImage();
	}

	@Then("verify the other images are maximized")
	public void verify_the_other_images_are_maximized() {
		pdppage.optionalMaximize();
	}

	@Then("verify the product details are displayed in table below the product overview as Chemical composition Mechanical composition,Tolerance properties,Any others")
	public void verify_the_product_details_are_displayed_in_table_below_the_product_overview_as_chemical_composition_mechanical_composition_tolerance_properties_any_others() {
		pdppage.validateChemicalMechanical();
	}

	@Then("verify user able to purchase the product on the basis of selected input.")
	public void verify_user_able_to_purchase_the_product_on_the_basis_of_selected_input() {

	}
	
	
//Guest
	
	@When("user select any product")
	public void user_selects_any_product() {
		pdppage.scrollDown();
		pdppage.clickproductCard();
	}
	

	@When("user select the dimensions and specific quantity.")
	public void user_select_the_dimensions_and_specific_quantity() throws InterruptedException {
		pdppage.selectDimension();
		Thread.sleep(2000);
	}

	@When("User clicks on Add to cart button")
	public void user_clicks_on_Add_to_cart_button() throws InterruptedException {
		pdppage.clickAddtoCart();
		Thread.sleep(2000);
	}
	@Then("User click on close button")
	public void user_click_on_close_button() {
	   pdppage.clickClose();
	}
	
		
	@Then("verify that User should redirect to the login page")
	public void verify_that_user_should_redirect_to_the_login_page() {
		pdppage.validatetheLogInPage();
	}

	
	@Then("user is able to view the message in the thickness section")
	public void user_is_able_to_view_the_message_in_the_thickness_section() throws InterruptedException {
		pdppage.validateMessage();
		Thread.sleep(1000);
	}
}