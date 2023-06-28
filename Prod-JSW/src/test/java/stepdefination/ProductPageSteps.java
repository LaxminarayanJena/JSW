package stepdefination;

import org.junit.Assert;

import pages.LoginPage;
import pages.PDPRegisteredUserPage;
import pages.ProductPage;
import factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps {

	ProductPage productpage = new ProductPage(DriverFactory.getDriver());
	PDPRegisteredUserPage pdp = new PDPRegisteredUserPage(DriverFactory.getDriver());


	@Then("user click on hot rolled sheet")
	public void user_click_on_hot_rolled_sheet() throws InterruptedException {

		Thread.sleep(6000);
		productpage.clickOnHotRolledSheets();
	}

	@Then("user click on product from listing page")
	public void user_click_on_product_from_listing_page() throws InterruptedException {

		Thread.sleep(5000);
		productpage.clickOnproductfromListingPage();

	}

	@Then("user select wire rod product in PLP page")
	public void user_select_wire_rod_produc_in_PLP_page() throws InterruptedException
	{
		pdp.selectWireRodProduct();
	}
	  
	@Then("user select the dimensions of selected wire rod product")
	public void user_select_the_dimensions_of_selected_wire_rod_product() throws InterruptedException
	{
		pdp.selectWRDimensions();
	}
	
	@Then("user select the dimensions of selected wire rod product for directorder user")
	public void user_select_the_dimensions_of_selected_wire_rod_productfordirectorderuser() throws InterruptedException
	{
		pdp.selectWRDimensionsForDirectOrderUser();
	}
}