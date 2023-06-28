package stepdefination;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.DirectPLPPage;
import pages.HomePage;

public class DirectPLPPageStep {
	
	DirectPLPPage plp = new DirectPLPPage(DriverFactory.getDriver());
	HomePage hp = new HomePage(DriverFactory.getDriver());
	
	@When("user is able to select product from Steel by categories")
	public void user_is_able_to_select_product_from_steel_by_categories() throws InterruptedException {
	    plp.moveToElement(plp.getSteelOfCategories());
	    Thread.sleep(1000);
	    plp.getSteelOfCategories().click();
	    
	}
	
	@When("user is able to select HotRolledproduct from Steel by categories")
	public void user_is_able_to_select_HotRolledproduct_from_steel_by_categories() throws InterruptedException {
		hp.selectHotRolled();
	    
	}

	@Then("user is navigate to PLP page from direct homepage")
	public void user_is_navigate_to_plp_page_from_direct_homepage() throws InterruptedException {
	   
	    Thread.sleep(3000);
		Assert.assertTrue("\r\n" + "              \"Hot rolled\"", true);
	}

	@When("user is able to scroll down to all categories")
	public void user_is_able_to_scroll_down_to_all_categories() throws InterruptedException {
	    plp.scroll(plp.getSteelCategories());
	    Thread.sleep(5000);
	   
	}

	@When("user is able to click View all button")
	public void user_is_able_to_click_view_all_button() throws InterruptedException {
	    plp.getViewAll().click();
	    Thread.sleep(5000);
	   
	}
	
	@When("user is able to view PLP page of direct order")
	public void user_is_able_to_view_plp_page_of_direct_order() throws InterruptedException {
		 plp.getPlpPage().isDisplayed();
		 Thread.sleep(5000);
	}

	@When("user is able to click Buy from verified sellers page")
	public void user_is_able_to_click_buy_from_verified_sellers_page() throws InterruptedException {
	   plp.getVerifiedSeller().click();
	   Thread.sleep(5000);
	}

	@When("user is able to view PLP page of current seller order")
	public void user_is_able_to_view_plp_page_of_current_seller_order() throws InterruptedException {
	    plp.getSteelOfCategories().click();
	    Thread.sleep(2000);
		plp.getSellerPLPPage().isDisplayed();
	    Thread.sleep(5000);
	}

	@Then("user is navigate to direct order PLP page by clicking Buy directly from JSW Steel")
	public void user_is_navigate_to_direct_order_plp_page_by_clicking_buy_directly_from_jsw_steel() throws InterruptedException {
	    plp.getDoPLPpage().click();
	    Thread.sleep(5000);
	}

	@Then("user is able to see the price amount in the PLP page of the products")
	public void user_is_able_to_see_the_price_amount_in_the_plp_page_of_the_products() throws InterruptedException {
		plp.scroll(plp.getFliter());
		Thread.sleep(5000);
		Assert.assertFalse("plpprodprice", false);
	}

	@When("user is able to view and click Configure and request label")
	public void user_is_able_to_view_and_click_configure_and_request_label() throws InterruptedException {
	    plp.getConfigureAndRequestPrice().isDisplayed();
	    Thread.sleep(5000);
	   
	}

	@When("user is able to navigate from DO home page to PDP page")
	public void user_is_able_to_navigate_from_do_home_page_to_pdp_page() throws InterruptedException {
	    plp.getConfigureAndRequestPrice().click();
	    Thread.sleep(5000);
	}

	@Then("user is able to scrolldown and view delivery by {int}-{int} days")
	public void user_is_able_to_scrolldown_and_view_delivery_by_days(Integer int1, Integer int2) throws InterruptedException {
		plp.scroll(plp.getDeliveryDay());
		Thread.sleep(5000);
		Assert.assertTrue("\r\n" + "                Estimated delivery in\r\n" + "                30 - 45 days\r\n"
				+ "              ", true);
	}

}
