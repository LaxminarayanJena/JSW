package stepdefination;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Forgotpasswordpage;
import pages.RegistrationPage;

public class ForgotpasswordSteps {

	private Forgotpasswordpage forgotpassword = new Forgotpasswordpage(DriverFactory.getDriver());

	@When("user clicks on proceed")
	public void user_clicks_on_proceed() throws InterruptedException {
		forgotpassword.clickproceed();
	}

	@Then("Enter email field will be displayed")
	public void enter_email_field_will_be_displayed() {

	}

	@When("user enters email id with Email {string}")
	public void user_enters_email_id_with_Email_and(String Email) throws InterruptedException {
		forgotpassword.forgotpassword(Email);
		Thread.sleep(2000);
	}

	@Then("user clicks on submit")
	public void user_clicks_on_submit() throws InterruptedException {
		forgotpassword.Submit();
	}

	@Then("verify the confirmation message")
	public void verify_the_confirmation_message() throws InterruptedException {
		Thread.sleep(4000);
		String expectedConfirmationmessage = forgotpassword.verifyText();
		Assert.assertEquals("Password reset link has been sent to your registered email address",
				expectedConfirmationmessage);
	}

	@Then("click ok")
	public void click_on_Okay() throws InterruptedException {
		forgotpassword.clickokay();
		Thread.sleep(3000);
	}

	@Then("verify the Error message")
	public void verify_the_Error_message() throws InterruptedException {
		String expectedErrorConfirmationmessage = forgotpassword.verifyErrorText();
		Assert.assertEquals("Kindly register yourself to proceed further for JSW One journey",
				expectedErrorConfirmationmessage);

		forgotpassword.verifyErrorText();

	}

	@Then("verify wrong email error")
	public void verify_wrong_email_error() throws InterruptedException {
		String expectedError = forgotpassword.verifyEmail();
		Assert.assertEquals("You have entered a wrong email address", expectedError);
		forgotpassword.verifyEmail();
	}

	@Then("login to gmail with gmail {string}")

	public void login_login_to_email(String Email) throws InterruptedException {
		DriverFactory.getDriver().get("https://tinyurl.com/yc3hcw7h");

		Thread.sleep(5000);

		forgotpassword.enterGmail(Email);
		forgotpassword.clickNext();

	}

	@Then("login to gmail with password {string}")
	public void login_to_gmail_with_password(String Password) {
		forgotpassword.enterPassword(Password);
	}

	@Then("click gmail next")
	public void click_gmail_next() throws InterruptedException {
		forgotpassword.clickpasswordNext();
		forgotpassword.clickinboxFirstrecord();
		forgotpassword.clickRestLink();

	}

	@Then("User Enters new password {string}")
	public void User_Enters_new_password(String NewPassword) throws InterruptedException {
		forgotpassword.newPassword(NewPassword);

	}

	@Then("user clicks on clicksubmit")
	public void User_clicks_on_clicksubmit() throws InterruptedException {
		forgotpassword.clickSubmit();
	}

	@Then("User Enters confirm password {string}")
	public void User_Enters_confirm_password(String confirmPassword) {
		forgotpassword.confirmPassword(confirmPassword);
	}

	@Then("verify the password got changed {string}")
	public void verify_the_password_got_changed(String passwordConfirmationText) throws InterruptedException {
		String expectedPasswordConfirmationText = forgotpassword.verifypasswordConfirmationText();

		Assert.assertEquals("You have successfully reset your password", expectedPasswordConfirmationText);
		forgotpassword.verifypasswordConfirmationText();

	}
}
