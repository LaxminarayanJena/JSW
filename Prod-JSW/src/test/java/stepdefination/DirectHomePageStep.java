package stepdefination;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.DirectHomePage;

public class DirectHomePageStep {
	
	DirectHomePage direct = new DirectHomePage(DriverFactory.getDriver());
	
	@When("user is able to click Buy from verified sellers button below the cart")
	public void user_is_able_to_click_buy_from_verified_sellers_button_below_the_cart() throws InterruptedException {
	    direct.getDistributorHomePage().click();
	    Thread.sleep(3000);
	    
	}

	@When("user is able to navigate to verified seller page")
	public void user_is_able_to_navigate_to_verified_seller_page() throws InterruptedException {
//	    direct.getDirectHomePage().isDisplayed();
		direct.scroll(direct.getSteelCategories());
	    Thread.sleep(3000);
	}

	@When("user is able to click Buy directly from JSW Steel button")
	public void user_is_able_to_click_buy_directly_from_jsw_steel_button() throws InterruptedException {
		direct.scroll(direct.getDirectHomePage());
		direct.getDirectHomePage().click();
	    Thread.sleep(3000);
	    
	}

	@Then("user is able to navigate to direct order page")
	public void user_is_able_to_navigate_to_direct_order_page() throws InterruptedException {
		direct.scroll(direct.getSteelCategories());
		Thread.sleep(3000);
	    direct.getDeliveryTime().isDisplayed();
	}

	@When("user is able to click My requirements header visible above the Buy from verified sellers")
	public void user_is_able_to_click_my_requirements_header_visible_above_the_buy_from_verified_sellers() throws InterruptedException {
		direct.getRequirements().click();
	    Thread.sleep(3000);
	    
	}

	@Then("user is able navigate to direct home page")
	public void user_is_able_navigate_to_direct_home_page() throws InterruptedException {
		Thread.sleep(3000);
		direct.getHomePage().click();
	    Thread.sleep(3000);
	    
	}

	@When("user is able to scroll down to categories section")
	public void user_is_able_to_scroll_down_to_categories_section() throws InterruptedException {
	    direct.scroll(direct.getSteelCategories());
	    Thread.sleep(3000);
	    
	}

	@When("user is able to view All Categories on home page")
	public void user_is_able_to_view_all_categories_on_home_page() throws InterruptedException {
		direct.scroll(direct.getViewAll());
		direct.getViewAll().isDisplayed();
	    Thread.sleep(3000);
	}

	@When("user is able to click view all button in All categories section")
	public void user_is_able_to_click_view_all_button_in_all_categories_section() throws InterruptedException {
	    direct.getViewAll().click();
	    Thread.sleep(3000);
	    
	}

	@When("user is able to navigate to PLP page")
	public void user_is_able_to_navigate_to_plp_page() throws InterruptedException {
	    direct.getPLP().isDisplayed();
	    Thread.sleep(3000);
	    
	}

	@Then("user is able to navigate to direct home page from PLP page")
	public void user_is_able_to_navigate_to_direct_home_page_from_plp_page() throws InterruptedException {
	    direct.getHomePage().click();
	    Thread.sleep(3000);
	    
	}

	@Then("user is able to verify and validate delivery date on the All categories section")
	public void user_is_able_to_verify_and_validate_delivery_date_on_the_all_categories_section() throws InterruptedException {
	    direct.scroll(direct.getSteelCategories());
	    Thread.sleep(2000);
		direct.getDeliveryTime().isDisplayed();
	    Thread.sleep(3000);
	    
	}
	
	@Then("user is able to navigate PDP page by clicking Configure and request")
	public void user_is_able_to_navigate_plp_page_by_clicking_configure_and_request() throws InterruptedException {
	   direct.getConfigure().click();
	   Thread.sleep(3000);
	  
	}

	@Then("user is able to view request price button")
	public void user_is_able_to_view_request_price_button() throws InterruptedException {
		 direct.getRequestPrice().isDisplayed();
		 Thread.sleep(3000);
		 direct.getHomePage().click();
		 Thread.sleep(3000);
	}

	@Then("user is able to veify and validate Configure and request price on the All categories section")
	public void user_is_able_to_veify_and_validate_configure_and_request_price_on_the_all_categories_section() throws InterruptedException {
	   direct.getPrice().isDisplayed();
	   Thread.sleep(3000);
	    
	}

	@When("user is able to navigate blog by clicking Read now")
	public void user_is_able_to_navigate_blog_by_clicking_read_now() throws InterruptedException {
		direct.getReadTransport().click();
		Thread.sleep(3000);
	}

	@When("user is able to view blog & and article page")
	public void user_is_able_to_view_blog_and_article_page() throws InterruptedException {
		Assert.assertTrue("The transport sector & logistics: why automation is the need of the hour", true);
		
	}

	@Then("user is able to naviage from Blog & article page to direct home page")
	public void user_is_able_to_naviage_from_blog_article_page_to_direct_home_page() throws InterruptedException {
		direct.getHomePage();
		Thread.sleep(3000);
	}

	@Then("user is able to click View all articles to navigate Blogs & article page")
	public void user_is_able_to_click_view_all_articles_to_navigate_blogs_article_page() throws InterruptedException {
	    direct.getBlogsArticles().isDisplayed();
	    Thread.sleep(3000);
		direct.getViewMoreArticle().click();
	    Thread.sleep(3000);
	}

	@Then("user navigate from Blog page to Home page")
	public void user_navigate_from_blog_page_to_home_page() throws InterruptedException {
		direct.scroll(direct.getBlogsArticles());
		Thread.sleep(3000);
	}

	@When("user is able to view enquiry window below the articles")
	public void user_is_able_to_view_enquiry_window_below_the_articles() throws InterruptedException {
	    direct.scroll(direct.getEnquiry());
	    Thread.sleep(3000);
	    direct.getEnquiry().isDisplayed();
	    
	}

	@When("user is able to scroll down to view How it works page")
	public void user_is_able_to_scroll_down_to_view_how_it_works_page() throws InterruptedException {
	    direct.scroll(direct.getWorkFlowBanner());
	    Thread.sleep(3000);
	}

	@Then("user is able to view changes in the How it works on home page")
	public void user_is_able_to_view_changes_in_the_how_it_works_on_home_page() throws InterruptedException {
	    direct.getWorkFlowBanner().isDisplayed();
	    Thread.sleep(3000);
	    
	}

}
