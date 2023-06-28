package stepdefination;

import static org.fest.assertions.api.Assertions.*;

import org.junit.Assert;

import factory.DriverFactory;
import pages.HomePage;
import pages.ProductPage;
import pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	ProductPage productpage = new ProductPage(DriverFactory.getDriver());
	RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());

	@Then("Verify the JSW logo is appearing in the Header Section")
	public void verify_the_jsw_logo_is_appearing_in_the_header_section() {
		Assert.assertTrue(homePage.validateJSWLogo());

	}

	@When("user selects Hot Rolled products")
	public void user_selects_colour_coated_products() throws InterruptedException {
		homePage.selectHotRolledProduct();
	}

	@Then("Verify Search Bar is displayed with search icon")
	public void verify_search_bar_is_displayed_with_search_icon() {
		Assert.assertTrue(homePage.validateSearch());
	}

	@Then("Verify Language Indicator is displayed")
	public void verify_language_indicator_is_displayed() {
		Assert.assertTrue(homePage.validateLanguageIndicator());
	}

	@Then("Verify the Cart Icon displayed")
	public void verify_the_cart_icon_displayed() {
		Assert.assertTrue(homePage.validateCartIcon());
	}

	@Then("Verify the Cart link action")
	public void verify_the_cart_link_action() throws InterruptedException {
		String myCartText = homePage.clickonCart().validateMyCart();
		System.out.println("myCartText = " + myCartText);

	}

	@Then("Verify the address not displaying for the guest user")
	public void verify_the_address_not_displaying_for_the_guest_user() {

		System.out.print(homePage.getAddress());
		assertThat(homePage.getAddress()).doesNotContain("OBASAMUDRAM");

	}

	@Then("Verify the Login button is displaying in the Home Page Header")
	public void verify_the_login_button_is_displaying_in_the_home_page_header() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(registrationPage.validateLoginButton());
	}

	@Then("Verify the action of Login button")
	public void verify_the_action_of_login_button() throws InterruptedException {
		Assert.assertTrue(registrationPage.validateLoginButton());
	}

	@Then("Verify the Register Button is displaying in Home Page header.")
	public void verify_the_register_button_is_displaying_in_home_page_header() throws InterruptedException {
		Assert.assertTrue(registrationPage.validateRegisterButton());
	}

	@Then("Verify the action of Register button")
	public void verify_the_action_of_register_button() {
		Assert.assertTrue(registrationPage.validateRegisterButton());
	}

	@Then("Verify {string} section available in the Header")
	public void verify_section_available_in_the_header(String string) {

	}

	@Then("Verify that {string} is available on the header section")
	public void verify_that_is_available_on_the_header_section(String string) {
		Assert.assertTrue(homePage.validateConnectWithUs());
	}

	@Then("Verify the contents of the {string} drop down section")
	public void verify_the_contents_of_the_drop_down_section(String string) {

	}

	@Then("Verify that Header Section is displayed for Registered User")
	public void verify_that_header_section_is_displayed_for_registered_user() {

	}

	@Then("Verify the My Profile section link is appearing with users first name")
	public void verify_the_my_profile_section_link_is_appearing_with_users_first_name() throws InterruptedException {

	}

	@Then("Verify that the My Profile section Link is displaying ^ icon when the drop down is clicked")
	public void verify_that_the_my_profile_section_link_is_displaying_icon_when_the_drop_down_is_clicked() {

	}

	@Then("Verify the action of Logout Link in My Profile drop down")
	public void verify_the_action_of_logout_link_in_my_profile_drop_down() {

	}

	@Then("Verify the map icon displayed along with the address")
	public void verify_the_map_icon_displayed_along_with_the_address() {
		Assert.assertTrue(homePage.validatemapIcon());
	}

	@Then("Verify the mandatory fields in Enquiry Section for Guest Users")
	public void verify_the_mandatory_fields_in_enquiry_section_for_guest_users() {

	}

	@Then("Verify the mandatory fields in Enquiry Section for Registered Users")
	public void verify_the_mandatory_fields_in_enquiry_section_for_registered_users() {

	}

	@Then("Verify the submit button is enabled only once all the mandatory fields entered")
	public void verify_the_submit_button_is_enabled_only_once_all_the_mandatory_fields_entered() {

	}

	@Then("Verify Query id is generated once query is submitted by the guest user.")
	public void verify_query_id_is_generated_once_query_is_submitted_by_the_guest_user() throws InterruptedException {
		homePage.clickonHomePageLogo();
		homePage.scrollDown();
		homePage.enterEnquiryFormDetails();
		homePage.validatequeryId();
	}

	@Then("Verify Query id is generated once query is submitted by the registered user.")
	public void verify_query_id_is_generated_once_query_is_submitted_by_the_registered_user()
			throws InterruptedException {
		homePage.scrollDown();
		homePage.enterEnquiryFormDetails();
		homePage.validatequeryId();
	}

	@Then("Verify the action on wrong data entered")
	public void verify_the_action_on_wrong_data_entered() {

	}

	@Then("Verify the validation of the fields")
	public void verify_the_validation_of_the_fields() {

	}

	@Then("Verify For logged in user on Enquiry form Name, mobile number and email id should be pre-populated.")
	public void verify_for_logged_in_user_on_enquiry_form_name_mobile_number_and_email_id_should_be_pre_populated()
			throws InterruptedException {
		homePage.extractEnquiryFormDetails();
	}

	@Then("Verify that {string} is displaying based on the successful submission of enquiry form")
	public void verify_that_is_displaying_based_on_the_successful_submission_of_enquiry_form(String string) {

	}

	@Then("Verify the banners are displayed on the JSW Home Page")
	public void verify_the_banners_are_displayed_on_the_jsw_home_page() throws InterruptedException {
		homePage.clickonHomePageLogo();
		Thread.sleep(2500);
		System.out.println("No of banner images " + homePage.validateSliderContainerImages());
	}

	@Then("Verify the Enquiry form banner displayed on the Home Page")
	public void verify_the_enquiry_form_banner_displayed_on_the_home_page() {

	}

	@Then("Verify the banners displaying in the home Page for Registered User.")
	public void verify_the_banners_displaying_in_the_home_page_for_registered_user() throws InterruptedException {
		homePage.clickonHomePageLogo();
		Thread.sleep(2500);
		System.out.println("No of slider images " + homePage.validateSliderContainerImages());
	}

	@Then("Verify the Enquiry form banner displayed on the Home Page for registered User")
	public void verify_the_enquiry_form_banner_displayed_on_the_home_page_for_registered_user() {

	}

	@Then("Verify all the header available in the footer section")
	public void verify_all_the_header_available_in_the_footer_section() {

	}

	@Then("Verify all the header available in the footer section after user logs in to the application")
	public void verify_all_the_header_available_in_the_footer_section_after_user_logs_in_to_the_application() {
		int footerItemCount = homePage.validatefooterContainer();
		Assert.assertEquals(footerItemCount, 17);
		System.out.println(footerItemCount);
	}

	@Then("Verify for sub links are available under General category")
	public void verify_for_sub_links_are_available_under_general_category() {

	}

	@Then("Verify all the social media logos are available")
	public void verify_all_the_social_media_logos_are_available() {
		Assert.assertTrue(homePage.validateSociaMediaLogos());
	}

	@Then("Verify for help line number is present in footer section")
	public void verify_for_help_line_number_is_present_in_footer_section() {
		Assert.assertTrue(homePage.validatehelpLineNumber());
	}

	@Then("Hot rolled sheets Hot rolled coils Cold rolled sheets Cold rolled coils is displayed in homepage in stainless steel section")
	public void hot_rolled_sheets_hot_rolled_coils_cold_rolled_sheets_cold_rolled_coils_is_displayed_in_homepage_in_stainless_steel_section() {
		Assert.assertTrue(homePage.validateHotRolledSheetsInHomePage());
	}

	@Then("Hot rolled, cold rolled ,wire rods,coated,colour coated is displayed in homepage in  steel section")
	public void hot_rolled_cold_rolled_wire_rods_coated_colour_coated_is_displayed_in_homepage_in_steel_section() {
		Assert.assertTrue(homePage.validateHotrolledInHomePage());
	}

	@When("user clicks on Hot Rolled Sheets Series {int} Series {int} Series {int} is displayed")
	public void user_clicks_on_hot_rolled_sheets_series_series_series_is_displayed(Integer int1, Integer int2,
			Integer int3) {
		Assert.assertTrue(homePage.validateSeries200InHomePage());
	}

	@When("user clicks on Hot rolled  then coils ,sheet is displayed")
	public void user_clicks_on_hot_rolled_then_coils_sheet_is_displayed() {
		Assert.assertTrue(homePage.validateCoilsInHomePage());
	}

	@When("user clicks on Stainless Steel Navigation Menu")
	public void user_clicks_on_stainless_steel_navigation_menu() throws InterruptedException {
		homePage.clickonStainlessSteelMenu();
	}

	@When("user clicks on Steel Navigation Menu")
	public void user_clicks_on_steel_navigation_menu() throws InterruptedException {
		homePage.clickonSteelMenu();
	}

	@When("user clicks on homePage Logo And navigates to homepage")
	public void user_clicks_on_home_page_logo_and_navigates_to_homepage() {

	}
	// Header

	@Then("Verify User name is displayed in the Header Section")
	public void verify_user_name_is_displayed_in_the_header_section() throws InterruptedException {
		Assert.assertTrue(homePage.validateUserName());
		homePage.myProfile();
		homePage.clickonHomePageLogo();

	}

	@Then("Verify Myorders is displayed in the Header Section")
	public void verify_myorders_is_displayed_in_the_header_section() throws InterruptedException {
		Assert.assertTrue(homePage.validateMyorder());
		homePage.clickMyorder();
		Thread.sleep(5000);
		homePage.clickonHomePageLogo();
	}

	@Then("Verify Cart Icon displayed")
	public void verify_cart_icon_displayed() throws InterruptedException {
		Assert.assertTrue(homePage.validateCartIcon());
		Thread.sleep(2000);
		homePage.clickonCart();
		Thread.sleep(5000);
		homePage.clickonHomePageLogo();

	}

	@Then("Verify {string} Category tree is displayed")
	public void verify_category_tree_is_displayed(String string) throws InterruptedException {
		homePage.subSteelTree();

	}

	@Then("verify {string} category tree is displayed in Header section")
	public void verify_category_tree_is_displayed_in_header_section(String string) throws InterruptedException {
		homePage.subSSTree();

	}

	@Then("Verify {string} is displayed in Header section")
	public void verify_is_displayed_in_header_section(String string) throws InterruptedException {
		homePage.subConstructionTree();

	}

	@Then("Verify user is navigate to {string} page and back to home page")
	public void verify_user_is_navigate_to_page_and_back_to_home_page(String string) throws InterruptedException {

		homePage.clickHelp();
		Thread.sleep(3000);
		homePage.clickonHomePageLogo();

	}

	@Then("Verify {string} is displayed in header Section")
	public void verify_is_displayed_in_header_section1(String string) throws InterruptedException {
		// Assert.assertTrue(homePage.validateAboutUs());
		homePage.clickAboutUs();
		Thread.sleep(5000);
		homePage.clickonHomePageLogo();
	}

	@Then("Verify user is able to view {string} and navigate to address section in Profile page")
	public void verify_user_is_able_to_view_and_navigate_to_address_section_in_profile_page(String string) {
		homePage.validateAddress();
	}

	@Then("Verify user is navigate to {string} page by clicking {string} CTA")
	public void verify_user_is_navigate_to_page_by_clicking_cta(String string, String string2)
			throws InterruptedException {
		Assert.assertTrue(homePage.validateConnectWithUs());
		homePage.clickConnect();
		Thread.sleep(2000);
		homePage.clickonHomePageLogo();

	}

	@Then("Verify user is able to view toggled CTA on Header section")
	public void verify_user_is_able_to_view_toggled_cta_on_header_section() {
		homePage.validateToggled();

	}

	// Footer

	@When("user verify the footer section headers")
	public void user_verify_the_footer_section_headers() {
		homePage.scroll();
		Assert.assertTrue(homePage.validateFooter());
		homePage.validatefooterContainer();

	}

	@Then("Verify JSW logo is appearing in the Footer section")
	public void verify_jsw_logo_is_appearing_in_the_footer_section() {
		homePage.socialogo();

	}

	@Then("Verify for sub links are available under Legal category")
	public void verify_for_sub_links_are_available_under_legal_category() {

	}

	@Then("Verify for support email address is present in footer section")
	public void verify_for_support_email_address_is_present_in_footer_section() {
		homePage.validateEmailID();
	}

	// Homepage verification

	@When("user is able to view Steel category section")
	public void user_is_able_to_view_steel_category_section() {
		homePage.SteelSection();

	}

	@When("user is able to view Hot rolled coil products")
	public void user_is_able_to_view_hot_rolled_coil_products() throws InterruptedException {
		homePage.validateHotRolledSteel();
		Thread.sleep(2000);

	}

	@Then("user is able to view View all CTA on Steel section")
	public void user_is_able_to_view_view_all_cta_on_steel_section() throws InterruptedException {
		homePage.validateViewAllSteel();
		Thread.sleep(2000);
		homePage.ClickSteelViewAll();
		Thread.sleep(2000);
		homePage.clickonHomePageLogo();

	}

	@When("user is able to view Stainless Steel category section")
	public void user_is_able_to_view_stainless_steel_category_section() {
		homePage.SSSection();

	}

	@When("user is able to view Hot rolled Sheet with series {int} subcategory products")
	public void user_is_able_to_view_hot_rolled_sheet_with_series_subcategory_products(Integer int1) {
		homePage.validateHotRolledSheet();

	}

	@Then("user is able to view View all CTA in Stainless Steel section")
	public void user_is_able_to_view_view_all_cta_in_stainless_steel_section() throws InterruptedException {
		Assert.assertTrue(homePage.validateSSViewall());
		homePage.SSClickViewAll();
		homePage.clickonHomePageLogo();

	}

	@When("user is able to view blog and article section")
	public void user_is_able_to_view_blog_and_article_section() {
		Assert.assertTrue(homePage.validateblogs());

	}

	@Then("user is able to view View all in Blog section")
	public void user_is_able_to_view_view_all_in_blog_section() {
		Assert.assertTrue(homePage.validateBlogsViewall());

	}

	@Then("verify article banners are displayed")
	public void verify_article_banners_are_displayed() throws InterruptedException {
		Thread.sleep(2000);
		homePage.blogsList();

	}

	@Then("user is able to view video section")
	public void user_is_able_to_view_video_section() throws InterruptedException {
		homePage.validatevideoSection();
		Assert.assertTrue(homePage.validatevideoSection());
		Thread.sleep(2000);

	}

	@Then("user is able to view work flow section")
	public void user_is_able_to_view_work_flow_section() {
		homePage.validateworkFLow();
		// Assert.assertTrue(homePage.validateworkbanner());

	}

	@When("user clicks HR from Steel Navigation Menu")
	public void user_clicks_hr_from_steel_navigation_menu() throws InterruptedException {
		homePage.selectHotRolledProduct();
	}

	@Then("user navigate to Home page")
	public void user_navigate_to_home_page() throws InterruptedException {
		homePage.clickonHomePageLogo();
	}

	@And("^user refresh the page$")
	public void user_refresh_the_page() throws Throwable {
		homePage.refreshPage();
	}

	@And("^user wait for sometime$")
	public void user_wait_for_sometime() throws Throwable {
		Thread.sleep(6000);
	}

}
