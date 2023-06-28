package pages;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PDPpage {
	private WebDriver driver;

	private By enquiryBanner = By.xpath("//img[@class='bg2']");
	private By steelbycategory = By.xpath("//ul[@class='main-categories-first-child-menu']/parent::div/child::a");
	private By menu = By.xpath("//ul[@class='main-categories-first-child-menu']/child::li");
	private By secondmenu = By.xpath("//ul[@class='main-categories-second-child-menu']/child::li/child::a");
	private By productdetails = By.xpath("//div[@id='product']");
	private By dimensions = By.xpath("//div[@class='dimension-txt']");
	private By breadcrumbcatalog = By.xpath("//div[@class='breadcrumb-out with-pdp']//child::span[3]");
	private By breadcrumb = By.xpath("//div[@class='breadcrumb-out with-plp']");
	private By breadcrumbPDP = By.xpath("//div[@class='breadcrumb-out with-pdp']");
	private By primaryimage = By.xpath("//img[@class='big-image']");
	private By optionalimage = By.xpath("//img[@class=\"mt-20 prod-img1-radius\"]");
	private By grade = By.xpath("//span[@class='anchor']");
	private By composition = By.xpath("//div[contains(@class,'desktop-tabs')]");
	private By alldimensions = By.xpath("//button[@class='list-group-item list-group-item-action in-active']");
	private By buynow = By.xpath("//button[@class='btn btn-primary radius-10 w-100']");
	private By loginpage = By.xpath("//button[@id='login-via-otp']");
	private By etdelivery = By.xpath("//div[@class='est-del']");
	private By addtocart = By.xpath("//*[@id='product-add-to-cart']");
	private By price = By.xpath("//div[@class='prod-price-main box d-none d-md-block']");
	private By loginbutton = By.xpath("//span[text()='Login']");
	private By registerbutton = By.xpath("//span[text()='Login']/following-sibling::span");
	private By nextbutton = By.xpath("//button[@class='register-button']");
	private By searchbar = By.xpath("//input[@id='SearchText']");
	private By searchbutton = By.xpath("//i[@class='search-icon1']");
	private By productselect = By.xpath("//a[@class='prod-plpimage1name']");
	private By maximizeimage = By.xpath("//img[contains(@src,'HRsheet2') and @class='prod-img prod-img-radius']");
	private By two = By.xpath("//li[@class='product-list'][1]");
//	private By customLength = By.xpath("//div[8]/div[2]/ul[1]/button[1]");
	private By customLength=By.xpath("//div[@class='dimension-size'and contains(text(),'Thickness')]/parent::div/parent::div/div[9]//following-sibling::div[1]/ul/button");
private By customLength2= By.xpath("//div[@class='dimension-size'and contains(text(),'Width')]/parent::div/following-sibling::div/div[2]/ul/button");
	//	private By customLengthTextBox = By.xpath("//div[8]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	private By customLengthTextBox= By.xpath("//div[@class='dimension-size'and contains(text(),'Thickness')]/parent::div/following-sibling::div[2]/div[2]/div/div/div/div/div/input");
private By customLengthTextBox2= By.xpath("//div[@class='dimension-size'and contains(text(),'Width')]/parent::div/following-sibling::div[1]/div/div/div/div/div/div/input");
	//private By submitcustomLength = By.xpath("//div[8]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/img[1]");
	private By submitcustomLength = By.xpath("//div[@class='dimension-size'and contains(text(),'Thickness')]/ancestor::div/div[9]//following-sibling::div[1]/div/div/div/div/button");
	private By submitcustomLength2 = By.xpath("//div[@class='dimension-size'and contains(text(),'Width')]/ancestor::div/div[9]//following-sibling::div[1]/div/div/div/div/div/button");
	
	private By customLengthErrorMessage = By.xpath("//div[@class='dimension-size'and contains(text(),'Thickness')]/ancestor::div/div[9]//following-sibling::div[1]/div/div/div[2]");
    private By customLengthErrorMessage2= By.xpath("//div[@class='dimension-size'and contains(text(),'Width')]/ancestor::div/div[9]//following-sibling::div[1]/div/div/div[1]/div/div[2]");
	// private By activetab = By.xpath("//div[contains(@class,'tabActive') ]");
	
 //NewPDPGuest
    
    private By viewAll = By.xpath("//button[@class='btn view-all btn-outline-primary primary']");
	private By productCard = By.xpath("//*[@id=\'product\']/div/div[1]");
	private By thickness = By.xpath("//buton[contains(text(),'4')]");
	private By width = By.xpath("//button[contains(text(),'1250')]");
	private By length = By.xpath("//button[contains(text(),'2500')]");
	private By quantity = By.xpath("//div[@class='input-group quantity-input-box specify-qty-out']");
	private By closebutton = By.xpath("//button[@class='btn modal-close btn-secondary']");    
    
	private By message = By.xpath("//div[@class='select-msg']/child::span");
    
    
    public PDPpage(WebDriver driver) {
		this.driver = driver;
	}

	public void validatePLPPage() {
		driver.findElement(enquiryBanner).isDisplayed();
	}

	public void validatesearchwithcategory() {
		driver.findElement(steelbycategory).click();
		driver.findElements(menu).get(0).click();
		driver.findElements(secondmenu).get(0).click();

	}

	public boolean validatepdppage() {
		return driver.findElement(dimensions).isDisplayed();
	}

	public boolean validateBreadCrumb() {
			return driver.findElement(breadcrumb).isDisplayed();
	}
	public boolean validateBreadCrumbPDP() {
		return driver.findElement(breadcrumbPDP).isDisplayed();
}


	public void validatePrimaryandOptional() {
		driver.findElement(primaryimage).isDisplayed();
//		driver.findElement(optionalimage).isDisplayed();

	}

	public void clickOptionalImage() {

		driver.findElement(optionalimage).click();

	}

	public void validateGradeCategory() {

		driver.findElement(grade).isDisplayed();

	}

	public void validateChemicalMechanical() {
		driver.findElement(composition).isDisplayed();

	}

	public void selectDimension() throws InterruptedException {

		driver.findElements(alldimensions).get(0).click();
		Thread.sleep(1500);
		driver.findElements(alldimensions).get(11).click();
//		driver.findElements(alldimensions).get(13).click();
		driver.findElement(By.xpath("//input[@id='inputQty']")).sendKeys("5");
		driver.findElement(By.xpath("//button[@class='btn modal-close btn-secondary']")).click();
		
	}

	public void clickAddtoCart() {

		driver.findElement(addtocart).click();

	}

	public void clickBuyNow() {

		driver.findElement(buynow).click();
	}

	public boolean validateLogInPage() {

		return driver.findElement(loginpage).isDisplayed();
	}

	public boolean validateEstimateDelivery() {
		return driver.findElement(etdelivery).isDisplayed();
	}

	public boolean validatePrice() {
		return driver.findElement(price).isDisplayed();
	}

	public void validateLoginRegister() {
		driver.findElement(loginbutton).isDisplayed();
		driver.findElement(registerbutton).isDisplayed();
	}

	public void clickLogin() {

		driver.findElement(loginbutton).click();

	}

	public void clickRegister() {

		driver.findElement(registerbutton).click();

	}

	public boolean validateLogin() {
		return driver.findElement(loginpage).isDisplayed();
	}

	public boolean validateRegister() {
		return driver.findElement(nextbutton).isDisplayed();
	}

	public void clickSearchBar() {
		driver.findElement(searchbar).click();

	}

	public void enterProductKeyword() {
		driver.findElement(searchbar).sendKeys("Hot Rolled");
		driver.findElement(searchbutton).click();
	}

	public void validateProductListingPage() {
		driver.findElement(enquiryBanner).isDisplayed();
	}

	public void selectProduct() {
/*
		List<WebElement> productselected = driver.findElements(productselect);

		productselected.get(0).click();
		*/
		
		driver.findElement(By.xpath("//a[contains(text(),'JSW Steel Hot Rolled Sheets IS 2062:2011 E250A')]")).click();

	}

	public void validateCatalogBreadcrumb() {

		driver.findElement(breadcrumbcatalog).isDisplayed();
		driver.findElement(breadcrumbcatalog).click();

	}

	public void optionalMaximize() {
		driver.findElement(maximizeimage).isDisplayed();
	}

	public void CustomLength(String customlt) throws InterruptedException {
		driver.findElement(customLength).click();
		Thread.sleep(2000);
		driver.findElement(customLengthTextBox).sendKeys(customlt);
		driver.findElement(submitcustomLength).click();
	}

	public void CustomLengthwithlength(String customlt) throws InterruptedException {
		driver.findElement(customLength2).click();
		Thread.sleep(2000);
		driver.findElement(customLengthTextBox2).sendKeys(customlt);
		driver.findElement(submitcustomLength2).click();
	}
	
	
	
	public String validateCustomLengthErrorMessage() {
		System.out.println(driver.findElement(customLengthErrorMessage).getText());
		return driver.findElement(customLengthErrorMessage).getText();

	}
	
	public String validateCustomLengthErrorMessage2() {
		System.out.println(driver.findElement(customLengthErrorMessage2).getText());
		return driver.findElement(customLengthErrorMessage2).getText();

	}
	
	
//NewPDPGuest
	
	public void clickClose() {
		//driver.findElement(closebutton).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	public boolean validatetheLogInPage() {

		return driver.findElement(loginpage).isDisplayed();
	}
	
	public void clickviewAll() throws InterruptedException {
		driver.findElement(viewAll).click();
		Thread.sleep(5000);
	}
	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	public void clickproductCard() {
		driver.findElement(productCard).click();
	}
	
	public void clickthickness() {
		driver.findElement(thickness).click();
	}

	public void clickwidth() {
		driver.findElement(width).click();
	}

	public void clicklength() {
		driver.findElement(length).click();

	}

	public void enterQuantity() {
		driver.findElement(quantity).sendKeys("enterQuantity");
	}

	public boolean validateloginpage() {
		return driver.findElement(loginpage).isDisplayed();
	}

	public void clickBuynow() {
		driver.findElement(buynow).click();
	}

	public void validateMessage() {
		String mge = driver.findElement(message).getText();
		System.out.println("Message= "+mge);
	}
	
	

}