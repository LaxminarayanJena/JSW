package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectPLPPage {
	
	private WebDriver driver;

	@FindBy(xpath = "//a[@class='nav-link-jsw nav-active-link-jsw']")
	private WebElement steelOfCategories;
	@FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
	private WebElement hotRolled;
	@FindBy(xpath = "//h2[text()='Steel']")
	private WebElement steel;
	@FindBy(xpath = "//button[@class='btn view-all btn-outline-primary primary']")
	private WebElement viewAll;
	@FindBy(xpath = "//div[@class='prodduct-list-inner-container']")
	private WebElement plpPage;
	@FindBy(xpath = "//span[text()='Buy from verified sellers']")
	private WebElement verifiedSeller;
	@FindBy(xpath = "//div[@class='prodduct-list-inner-container']")
	private WebElement sellerPLPPage;
	@FindBy(xpath = "//span[text()='Buy directly from ']")
	private WebElement doPLPpage;
	@FindBy(xpath = "//div[@class='filter-label']")
	private WebElement fliter;
	@FindBy(xpath = "(//span[text()='Configure & request price'])[1]")
	private WebElement configureAndRequestPrice;
	@FindBy(xpath = "(//span[@class='deliveryschedule'])[1]")
	private WebElement deliveryDay;
	
	
	
	public DirectPLPPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public void scroll(WebElement element) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", element);
		return;
	}
	
	public void moveToElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		return;
	}


	public WebElement getSteelOfCategories() {
		return steelOfCategories;
	}


	public WebElement getHotRolled() {
		return hotRolled;
	}


	public WebElement getSteelCategories() {
		return steel;
	}


	public WebElement getViewAll() {
		return viewAll;
	}


	public WebElement getPlpPage() {
		return plpPage;
	}


	public WebElement getVerifiedSeller() {
		return verifiedSeller;
	}


	public WebElement getSellerPLPPage() {
		return sellerPLPPage;
	}


	public WebElement getDoPLPpage() {
		return doPLPpage;
	}


	public WebElement getFliter() {
		return fliter;
	}

	public WebElement getConfigureAndRequestPrice() {
		return configureAndRequestPrice;
	}


	public WebElement getDeliveryDay() {
		return deliveryDay;
	}
	

	
	
}
