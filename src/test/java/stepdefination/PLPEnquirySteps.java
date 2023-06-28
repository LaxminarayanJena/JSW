package stepdefination;

import org.junit.Assert;
import pages.HomePage;
import pages.PLPEnquiryPage;
import pages.ProductLandingPage;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PLPEnquirySteps {

	ProductLandingPage productlandingpage = new ProductLandingPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	PLPEnquiryPage plpenquirypage = new PLPEnquiryPage(DriverFactory.getDriver());

	@Then("Below message should be displyed on enquiry form banner {string}“Can’t find what you are looking for? Tell us your specific requirements. Your query will be sent to JSW plant for the right price and we will get back to you\"")
	public void below_message_should_be_displyed_on_enquiry_form_banner_can_t_find_what_you_are_looking_for_tell_us_your_specific_requirements_your_query_will_be_sent_to_jsw_plant_for_the_right_price_and_we_will_get_back_to_you(
			String string) {
		plpenquirypage.validateEnquiryBanner();
		plpenquirypage.validateTextonbanner();

	}

	@Then("Pop-up should be displayed to fill user's information")
	public void pop_up_should_be_displayed_to_fill_user_s_information() {
           plpenquirypage.validatePopUp();
	}

	@Then("Verify Enquiry banner is displayed only once after {int} products if more than {int} products are displayed")
	public void verify_enquiry_banner_is_displayed_only_once_after_products_if_more_than_products_are_displayed(
			Integer int1, Integer int2) {
      plpenquirypage.validateBannerAfter3();
	}

	@Then("Verify text displayed on enquiry banner")
	public void verify_text_displayed_on_enquiry_banner() {
		plpenquirypage.validateTextonbanner();
	}

	@Then("Verify {string} button is displayed")
	public void verify_button_is_displayed(String string) {
		plpenquirypage.validateEnquireButton();

	}

	@When("user click on enquiry button")
	public void user_click_on_enquiry_button() {
		plpenquirypage.clickonEnquireNow();
	}

	@Then("verify search result is not found")
	public void verify_search_result_is_not_found() {
		plpenquirypage.searchNotFound();
	}

	@Then("verify enquiry banner is displayed")
	public void verify_enquiry_banner_is_displayed() {
		plpenquirypage.validateEnquiryBanner();
	}

	@When("user clicks on {string} button on enquiry banner")
	public void user_clicks_on_button_on_enquiry_banner(String string) {
		plpenquirypage.clickonEnquireNow();
	}
    
	//reg user
	@Then("Verify enquiry form pop up is displayed")
	public void verify_enquiry_form_pop_up_is_displayed() {
		plpenquirypage.validatereguserpopup();
	}
   
	//guest user
	@Then("verify user is on enquiry form pop up")
	public void verify_user_is_on_enquiry_form_pop_up() {
		plpenquirypage.enquiryFormPopup();
	}

	@Then("verify login button is displayed on pop up")
	public void verify_login_button_is_displayed_on_pop_up() {
		plpenquirypage.verifyLoginButton();

	}

	@When("user clicks on login button in enquiry screen")
	public void user_clicks_on_login_button_in_enquiry_screen() throws InterruptedException {
		Thread.sleep(4000);
		plpenquirypage.clickLoginButton();
	}

	@Then("user is redirected to login form")
	public void user_is_redirected_to_login_form() {
		plpenquirypage.validateLoginPage();
	}

	@When("user clicks on registration button in enquiry screen")
	public void user_clicks_on_registration_button_in_enquiry_screen() throws InterruptedException {
		Thread.sleep(4000);
		plpenquirypage.clickRegistrationButton();
	}

	@Then("verify registration button is displayed on pop up")
	public void verify_registration_button_is_displayed_on_pop_up() throws InterruptedException {
		Thread.sleep(4000);
		plpenquirypage.validateRegistrationButton();
	}

	@Then("user is redirected to registration form")
	public void user_is_redirected_to_registration_form() {
		plpenquirypage.validateRegistrationPage();
	}

	@When("user enter name , mobileno and emailid on Enquiry form")
	public void user_enter_name_mobileno_and_emailid_on_enquiry_form() {
		plpenquirypage.enterNameMobileEmail();
	}

	@When("user click on Proceed button")
	public void user_click_on_proceed_button() {
		plpenquirypage.clickProceedenabled();
	}

	@Then("verify product details pop up open with all subcategories")
	public void verify_product_details_pop_up_open_with_all_subcategories() {
		plpenquirypage.validateProductDetailSubCategories();
	}

	@When("user fill in enquiry form details related to requirement , grade ,thickness ,length etc")
	public void user_fill_in_enquiry_form_details_related_to_requirement_grade_thickness_length_etc() {
		plpenquirypage.enterProductDetails();
	}

	@When("user clicks on Send Enquiry button")
	public void user_clicks_on_send_enquiry_button() throws InterruptedException {
		plpenquirypage.clickSendEnquiryButton();
		Thread.sleep(6000);
	}

	@Then("verify message is displayed as Below message should be displayed {string}")
	public void verify_message_is_displayed_as_below_message_should_be_displayed(String string) {
		// Assert.assertFalse(true);
		String thankmessage = plpenquirypage.verifyThanksMessage();

		Assert.assertEquals(
				"Your query has been submitted. One of the JSW representative will contact you within 24 hours",
				thankmessage);

	}

	@Then("verify query id got generated")
	public void verify_query_id_got_generated() throws InterruptedException {
		Thread.sleep(20000);
		 plpenquirypage.validateEnquiryID();
	}

	@Then("verify query id got generated for guest user")
	public void verify_query_id_got_generated_for_guest_user() throws InterruptedException {
		Thread.sleep(20000);
          plpenquirypage.validateEnquiryID();
	}

	@Given("user is on product detail pop up")
	public void user_is_on_product_detail_pop_up() {
		plpenquirypage.validateProductDetailSubCategories();
	}

	@When("user is on enquiry form")
	public void user_is_on_enquiry_form() {
		plpenquirypage.enquiryFormPopup();
	}

	@When("user enter invalid emailid on Enquiry form")
	public void user_enter_invalid_emailid_on_enquiry_form() {
		plpenquirypage.enterInvalidEmail();
	}

	
	@When("user enter invalid name like numbers on Enquiry form")
	public void user_enter_invalid_name_like_numbers_on_enquiry_form() {
		plpenquirypage.enterInvalidName();
	}

	@When("user enter invalid phone number like alphabets on Enquiry form")
	public void user_enter_invalid_phone_number_like_alphabets_on_enquiry_form() {
		Assert.assertTrue(plpenquirypage.enterInvalidPhoneNumber());
	}

	
	  @Then("verify user not to allowed to enter alphabets") public void
	  verify_user_not_to_allowed_to_enter_alphabets() {
	  Assert.assertTrue(plpenquirypage.enterInvalidPhoneNumber());
	  
	  }
	 

	@When("user does not enter values in name, phone number in enquiry form")
	public void user_does_not_enter_values_in_name_phone_number_in_enquiry_form() {
		Assert.assertTrue(plpenquirypage.enterBlankPhone());
		Assert.assertTrue(plpenquirypage.enterBlankName());

	}

	@Then("verify proceed button is disabled")
	public void verify_proceed_button_is_disabled() throws InterruptedException {
		

		Thread.sleep(5000);
		Assert.assertEquals(false, plpenquirypage.disableProceed());

	}

	@When("user select category from {string}")
	public void user_select_category_from(String string) throws InterruptedException {
		
		plpenquirypage.selectCategory();
		
		
		
	}

	

}
