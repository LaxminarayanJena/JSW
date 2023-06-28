package stepdefination;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DistributorPage;

public class DistributorPageSteps {

	private DistributorPage distributorpage = new DistributorPage(DriverFactory.getDriver());

	@When("user clicks on profile menu")
	public void user_clicks_on_profile_name() throws InterruptedException {
		distributorpage.clickMyProfileButton();
	}

	@When("selects distributors submenu")
	public void user_clicks_on_distributors() throws InterruptedException {
		distributorpage.clickdistributor();
	}
	
	@When("user clicks on add button and user selects distributor and clicks on confirm")
	public void user_clicks_on_add_button() throws InterruptedException {
		distributorpage.adddistributor();
	}
	
	@Then("distributor should be added to the category")
	public void distributor_to_be_displayed() throws InterruptedException {
		Assert.assertTrue(distributorpage.validateadddistributor());
	}

	
	@When("user clicks on edit button and user change distributor and clicks on confirm")
	public void user_clicks_on_edit_button() throws InterruptedException {
	   distributorpage.editdistributor();
	}
	@Then("distributor should get changed")
	public void distributor_should_get_changed() throws InterruptedException {
		Assert.assertTrue(distributorpage.validateeditdistributor());
	}

	@When("user clicks on remove button and pop up should be displayed and clicks on confirm")
	public void user_clicks_on_remove_button_and_pop_up_should_be_displayed_and_clicks_on_confirm() throws InterruptedException {
	   distributorpage.removedistributor();
	}
	@Then("user distributor should get deleted")
	public void distributor_should_get_deleted() throws InterruptedException {
		System.out.println("User is deleted");
	}

}
