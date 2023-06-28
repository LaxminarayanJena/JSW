package stepdefination;

import org.testng.Assert;

import factory.DriverFactory;
import pages.BlogsPage;
import pages.HomePage;
import pages.ProductPage;
import pages.RegistrationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlogPageSteps {

	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	ProductPage productpage = new ProductPage(DriverFactory.getDriver());
	RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());
	private BlogsPage blogPage = new BlogsPage(DriverFactory.getDriver());

	@When("user clicks on Blogs in header menu")
	public void user_clicks_on_blogs_in_header_menu() throws InterruptedException {
		homePage.clickOnBlogs();

	}

	@Then("user is able to navigate to blog page through homepage")
	public void user_is_able_to_navigate_to_blog_page_through_homepage() {
		String title = blogPage.validateBlogPageisDisplayed();
		Assert.assertEquals(title, "Steel, Welding Consumables, TMT , Cement Blogs | JSW One MSME Blog");

	}

	@Then("user is able to see All, Business,Sustainaibilty,Technology,News,Product in header")
	public void user_is_able_to_see_all_business_sustainaibilty_technology_news_product_in_header() {
		blogPage.validateHeader();
	}

	@Then("user click on a section like product")
	public void user_click_on_a_section_like_product() throws InterruptedException {
		blogPage.clickonProduct();
	}

	@Then("recent blogs is displayed")
	public void recent_blogs_is_displayed() {
		blogPage.validaterecentBlogs();
	}

	@Then("pagination is displayed in blogs")
	public void pagination_displayed() {
		blogPage.validatePagination();
	}

}
