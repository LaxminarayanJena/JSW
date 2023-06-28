package stepdefination;

import factory.DriverFactory;
import pages.HomePage;
import pages.MyRequirementsPage;
import pages.ProductPage;
import pages.RegistrationPage;
import io.cucumber.java.en.Then;

public class MyRequirementsSteps {

	MyRequirementsPage MyRequirementspage = new MyRequirementsPage(DriverFactory.getDriver());
	@Then("user clicks on myrequirement tab")
	public void user_clicks_on_myrequirement_tab() {
		MyRequirementspage.clickMyrequirementTab();
	}

	@Then("verify Requirements ID is getting displayed")
	public void verify_requirements_id_is_getting_displayed() {
		MyRequirementspage .verifyRequirementsID();
	}
	
	@Then("validate product details")
	public void validate_product_details() {
		MyRequirementspage.validateProductDetails(); 
	}
	
	@Then("validate Total quantity")
	public void validate_total_quantity() {
		MyRequirementspage.validateTotalQuantity();
	}


}
