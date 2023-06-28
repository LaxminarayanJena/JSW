package stepdefination;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CommercePage;

public class CommerceToolsPageSteps {

	private CommercePage commercePage = new CommercePage(DriverFactory.getDriver());

	@When("user click on addproduct")
	public void user_click_on_product() throws InterruptedException {

		commercePage.addProduct();
	}

	@Given("user search product")
	public void user_search_product() throws InterruptedException {
		commercePage.searchProduct();
	}

	@Given("user clicks on product")
	public void user_clicks_on_product() throws InterruptedException {
		commercePage.clickProduct();
	}
	
	@Given("clicks on acceptcookies")
	public void clicks_on_acceptcookies() throws InterruptedException {
		commercePage.clickacceptCookies();
	}

	@Given("clicks on next")
	public void clicks_on_next() throws InterruptedException {
		commercePage.clickNext();
	}
	
	@Given("clicks on save")
	public void clicks_on_save() throws InterruptedException {
		commercePage.clickSave();
	}
	
	@Given("enters {string}")
	public void enters(String productName) {
		commercePage.entersProductName(productName);
	  
	}
	
	@Given("clicks on AddVariant with {string}")
	public void clicks_on_add_variant_with(String productName) throws InterruptedException {
		commercePage.clickAddVariant(productName);
	   
	}






}
