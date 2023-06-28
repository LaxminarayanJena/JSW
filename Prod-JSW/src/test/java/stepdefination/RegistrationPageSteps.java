package stepdefination;

import org.junit.Assert;

import factory.DriverFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationPageSteps {

	private RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Given("user is on home page")
	public void user_is_on_home_page() throws InterruptedException {
		DriverFactory.getDriver().get("https://www.jswonemsme.com/");
		registrationPage.closeRegPopup();
	}

	@When("user clicks on loginButton")
	public void user_clicks_on_loginButton() throws InterruptedException {
		registrationPage.clickLoginButton();

	}

	@When("user enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String uname, String pwd) throws InterruptedException {

		registrationPage.Login(uname, pwd);
		Thread.sleep(5000);

	}

	@When("user clicks on register button")
	public void user_clicks_on_register_button() throws InterruptedException {
		registrationPage.clickRegisterButton();

	}
	@When("user clicks on register button in blogsPage")
	public void user_clicks_on_register_buttonBlogs() throws InterruptedException {
		registrationPage.clickRegisterButtonBlogs();

	}

	@When("user enters username with {string}")
	public void user_enters_username_with(String name) throws InterruptedException {
		registrationPage.enterUserName(name);
	}

	@When("user enters mobile with {string}")
	public void user_enters_mobile_with(String mobileno) throws InterruptedException {
		registrationPage.enterMobileNo(mobileno);
		Thread.sleep(1000);
	}

	@When("user enters gstno with {string}")
	public void user_enters_gstno_with(String gst) throws InterruptedException {
		registrationPage.enterGSTNo(gst);
	}

	@When("user enters companymailid with {string}")
	public void user_enters_companymailid_with(String companyid) throws InterruptedException {
		registrationPage.entercompanyMailId(companyid);
		Thread.sleep(10000);
	}

	@When("click on termsandcondition")
	public void click_on_termsandcondition() {
		registrationPage.clickAgreeTerms();

	}

	@When("click on next button")
	public void click_on_next_button() throws InterruptedException {
		registrationPage.clickNextButton();
		Thread.sleep(2000);
	}

	@Then("Guest User Navigates to Password creation page")
	public void guest_user_navigates_to_password_creation_page() {
		Assert.assertTrue(registrationPage.validateuserpassword());
	}

	@When("click on new password  {string}")
	public void click_on_new_password(String userpwd) {
		registrationPage.enteruserpassword(userpwd);

	}

	@When("click on confirm password {string}")
	public void click_on_confirm_password(String cnfpwd) {
		registrationPage.enterConfirmPassword(cnfpwd);
	}

	@When("click on create account")
	public void click_on_create_account() throws InterruptedException {
		registrationPage.clickcreateAccount();
		Thread.sleep(20000);

	}

	@Then("Thankyou page is displayed")
	public void thankyou_page_is_displayed() throws InterruptedException {
		Assert.assertTrue(registrationPage.validateThankYouPage());

	}

	@When("user enters already registered gstno with {string}")
	public void user_enters_already_registered_gstno_with(String gst) {
		registrationPage.enterGSTNo(gst);
	}

	@Then("invalid GST no message is displayed")
	public void invalid_gst_no_message_is_displayed() throws InterruptedException {
		Thread.sleep(6000);
		System.out.print(registrationPage.getErrorMessage());

	}

	@When("user enters username {string} with {int} characters")
	public void user_enters_username_with_characters(String name, Integer int1) throws InterruptedException {
		registrationPage.enterUserName(name);
		Thread.sleep(2000);
	}

	@Then("validation error for character restriction to be displayed")
	public void validation_error_for_character_restriction_to_be_displayed() {
		String errorMsg = registrationPage.getCharacterRestrictionErrorMessage();
		Assert.assertTrue(errorMsg.contains("You can enter"));
	}

	@Then("next button is disabled")
	public void next_button_is_disabled() throws InterruptedException {

		Assert.assertFalse(registrationPage.validatenextButton());

	}

	@When("user enters existing  companymailid with {string}")
	public void user_enters_existing_companymailid_with(String companyid) {
		registrationPage.entercompanyMailId(companyid);
	}

	@Then("email validation error to be displayed")
	public void email_validation_error_to_be_displayed() {
		System.out.print(registrationPage.getEmailErrorMessage());
	}

	@When("user enters companymailid with more than {int} characters with {string}")
	public void user_enters_companymailid_with_more_than_characters_with(Integer int1, String companyid) {
		registrationPage.entercompanyMailId(companyid);
	}

	@When("user enters companymailid  without @ {string}")
	public void user_enters_companymailid_without(String companyid) {
		registrationPage.entercompanyMailId(companyid);
	}

	@When("user click on login hyper link")
	public void user_click_on_login_hyper_link() throws InterruptedException {

		registrationPage.clickLoginButtonOnRegPopup();
		Thread.sleep(2000);
	}

	@Then("login screen is displayed")
	public void login_screen_is_displayed() throws InterruptedException {
		Assert.assertTrue(registrationPage.validateloginPage());
	}

	@Then("proceed to home is displayed")
	public void proceed_to_home_is_displayed() {
		Assert.assertTrue(registrationPage.validateThankYouPage());
	}

	@Then("registration screen is displayed")
	public void registration_screen_is_displayed() throws InterruptedException {
		Assert.assertTrue(registrationPage.validateRegistationPopup());
	}

	@Then("password error messaage to be displayed")
	public void password_error_messaage_to_be_displayed() throws InterruptedException {
		Thread.sleep(2000);
		System.out.print(registrationPage.getPasswordErrorMessage());
	}

	@Then("password do not match error messaage to be displayed")
	public void password_do_not_match_error_messaage_to_be_displayed() {
		System.out.print(registrationPage.getPasswordDoNotMatchErrorMessage());
	}

	@Then("validate gstdetails")
	public void validate_gstdetails() throws InterruptedException {
		Thread.sleep(2000);
		registrationPage.getGstCompanyDetails();
	}

}
