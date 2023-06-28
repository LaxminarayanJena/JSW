package pages;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectHomePage {

private WebDriver driver;

	String futureTitle = "The future of MSMEs in India: an exploration";
	String transportTitle = "The transport sector & logistics: why automation is the need of the hour";
	String schemeTitle = "The PLI scheme: specialty steel gets special incentives";



	@FindBy(xpath = "//a[contains(text(),'Steel')]")
	private WebElement steelCategories;
	@FindBy(xpath = "//span[text()='Buy from verified sellers']")
	private WebElement distributorHomePage;
	@FindBy(xpath = "//*[@id=\'product\']/div[76]/span[17]/span")
	private WebElement distributorDeliveryTime;
	@FindBy(xpath = "//span[text()='Buy directly from ']")
	private WebElement directHomePage;
	@FindBy(xpath = "//img[@alt='JSW One MSME']")
	private WebElement homePage;
//	@FindBy(xpath = "//a[@class='links nuxt-link-exact-active nuxt-link-active']")
	@FindBy(xpath = "//a[text()='My requirements']")
	private WebElement 	requirements;
	@FindBy(xpath = "//a[@id='__BVID__1023___BV_tab_button__']")
	private WebElement Mycart;
	@FindBy(xpath = "//h2[text()='All Categories']")
	private WebElement allCategories;
	@FindBy(xpath = "(//span[text()='Configure & request price'])[1]")
	private WebElement price;
	@FindBy(className = "deliveryschedule")
	private WebElement deliveryTime;
	@FindBy(xpath = "//div[@class='prodduct-list-inner-container']")
	private WebElement PLP;
	@FindBy(xpath = "(//span[text()='Configure & request price'])[1]")
	private WebElement configure;
	@FindBy(xpath = "//span[text()='Request for price']")
	private WebElement requestPrice;
	@FindBy(xpath = "//div[@class='blog-container-out']")
	private WebElement blogsArticles;
	@FindBy(xpath =  "(//button[contains(text(),'Read now')])[1]")
	private WebElement readFuture;
	@FindBy(xpath =  "(//button[contains(text(),'Read now')])[2]")
	private WebElement readTransport;
	@FindBy(xpath =  "(//button[contains(text(),'Read now')])[3]")
	private WebElement readScheme;
	@FindBy(xpath = "//a[@class='btn view-all-articles-btn btn-outline-primary']")
	private WebElement viewMoreArticle;
//	@FindBy(xpath = "//div[@class='col-sm-12 col-md-8 col-12']")
	@FindBy(xpath = "//span[text()='The future of MSMEs in India: an exploration']")
	private WebElement future;
	@FindBy(linkText = "The transport sector & logistics: why automation is the need of the hour")
	private WebElement transport;
	@FindBy(linkText = "The PLI scheme: specialty steel gets special incentives")
	private WebElement scheme;
	@FindBy(xpath = "//div[@class='container container container--fluid']")
	private WebElement blogsPage;
//	@FindBy(xpath = "//div[@class='custum-details']")
	@FindBy(xpath = "//*[@id=\'__layout\']/div/div[2]/div[3]/div[2]/div[2]/a")
	private WebElement enquiryScroll;
	public WebElement getConfigure() {
		return configure;
	}

	public WebElement getRequestPrice() {
		return requestPrice;
	}

	@FindBy(className = "custum-details")
	private WebElement enquiry;
	@FindBy(className = "how-direct-works")
	private WebElement workFlowBanner;
	@FindBy(xpath = "(//button[contains(text(),'View all')])[1]")
	private WebElement viewAll;
	
	
	
	public void scroll(WebElement element) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", element);
		return;
	}
		
	public DirectHomePage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public void futurePage() {
		driver.switchTo().defaultContent();
		return;
	}
	public void directBannerPage() {
		driver.findElement((By) directHomePage).isDisplayed();
		return;
	}
	
	public void distributorBannerPage() {
		driver.findElement((By) distributorHomePage).isDisplayed();
		return;
	}
	
	public void prices() {
		driver.findElement((By) price).isDisplayed();
		return;
	}
	
	public void impWaitSec(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		return;
	}
	
	public void workflow() {
		driver.findElement((By) workFlowBanner).isDisplayed();
		return;
	}
	
	public void closeCurrentPage() {
		driver.close();
		return;
	}

	public WebElement getSteelCategories() {
		return steelCategories;
	}

	public WebElement getDistributorHomePage() {
		return distributorHomePage;
	}

	public WebElement getDistributorDeliveryTime() {
		return distributorDeliveryTime;
	}

	public WebElement getDirectHomePage() {
		return directHomePage;
	}

	public WebElement getHomePage() {
		return homePage;
	}

	public WebElement getRequirements() {
		return requirements;
	}

	public WebElement getMycart() {
		return Mycart;
	}

	public WebElement getAllCategories() {
		return allCategories;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getDeliveryTime() {
		return deliveryTime;
	}

	public WebElement getPLP() {
		return PLP;
	}

	public WebElement getBlogsArticles() {
		return blogsArticles;
	}

	public WebElement getReadFuture() {
		return readFuture;
	}

	public WebElement getReadTransport() {
		return readTransport;
	}
	
	public String getFutureTitle() {
		return futureTitle;
	}

	public String getTransportTitle() {
		return transportTitle;
	}

	public String getSchemeTitle() {
		return schemeTitle;
	}

	public WebElement getReadScheme() {
		return readScheme;
	}

	public WebElement getViewMoreArticle() {
		return viewMoreArticle;
	}

	public WebElement getFuture() {
		return future;
	}

	public WebElement getTransport() {
		return transport;
	}

	public WebElement getScheme() {
		return scheme;
	}

	public WebElement getBlogsPage() {
		return blogsPage;
	}

	public WebElement getEnquiryScroll() {
		return enquiryScroll;
	}

	public WebElement getEnquiry() {
		return enquiry;
	}

	public WebElement getWorkFlowBanner() {
		return workFlowBanner;
	}

	public WebElement getViewAll() {
		return viewAll;
	}
	
		
}
