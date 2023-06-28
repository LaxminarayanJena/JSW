package pages;

import java.util.List;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class PLPEnquiryPage {

	private WebDriver driver;
	private By steelbycategory = By.xpath("//a[contains(text(),'Steel by categories')]");
	// private By steelbycategory =
	// By.xpath("//ul[@class='main-categories-first-child-menu']/parent::div/child::a");
	private By menu = By.xpath("(//a[contains(text(),'Hot rolled')])[1]");
	private By secondmenu = By.xpath("(//a[contains(text(),'Hot rolled coils')])");
	//private By menu = By.xpath("//div[@class='drop-submenu']");
	//private By secondmenu = By.xpath("//div[@class='drop-inner-sub']");
	
	private By enquiryBanner = By.xpath("//img[@class='bg2']");
	private By enquireNowbutton = By.xpath("//button[@class='enquery-button plp-banner-btn']");
	private By enquiryUserName = By.xpath("//input[@name='nameChange']");
	private By mobileNo = By.xpath("//input[@class='input-section label-set']");
	private By emailId = By.xpath("//input[@name='email']");
	private By loginButton = By.xpath("//span[text()='LOGIN']");
	private By registerButton = By
			.xpath("//*[@id=\"enqueryFormGuest___BV_modal_body_\"]/div/div[2]/div[3]/div[2]/div/span");
	private By sendEnquirybutton = By.xpath("//button[@class='enquery-button']");
	private By signInButton = By.xpath("//button[@class='btn btn-danger btn-md mt-60 btn-prime']");
	private By registerNextButton = By.xpath("//button[@id='register-next']");
	private By proceedButton = By.xpath("//button[@class=\"enquery-button\"]");
	private By proceedButtonEnabled = By.xpath("//button[@class=\"enquery-button selected\"]");
	private By subcategoriesdropdown = By.xpath("//select[@class='form-control form-control-md']");
	private By requirementTextarea = By.xpath("//textarea[@id='message']");
	private By grade = By.xpath("//input[@id='grade']");
	private By thankMessage = By.xpath("//div[@class='your-query']");
	private By searchbar = By.xpath("//input[@id=\"SearchText\"]");
	private By notfoundsearchimage = By.xpath("//div[@class='error_img']");
	private By searchButton = By.xpath("//button[@class='btn btn-primary search-icon']");
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	public PLPEnquiryPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validateEnquiryBanner() {

		return driver.findElement(enquiryBanner).isDisplayed();

	}

	public String validateTextonbanner() {

		return driver.findElement(enquiryBanner).getText();

	}

	public boolean enquiryFormPopup() {

		return driver.findElement(enquiryUserName).isDisplayed();

	}

	public boolean validateEnquireButton() {

		return driver.findElement(enquireNowbutton).isDisplayed();
	}

	public void clickonEnquireNow() {

		driver.findElement(enquireNowbutton).click();
	}

	public boolean verifyLoginButton() {

		return driver.findElement(loginButton).isDisplayed();
	}

	public void clickLoginButton() {

		driver.findElement(loginButton).click();
	}

	public boolean validateLoginPage() {
		return driver.findElement(signInButton).isDisplayed();
	}

	public void clickRegistrationButton() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(registerButton).click();
	}

	public boolean validateRegistrationPage() {

		return driver.findElement(sendEnquirybutton).isDisplayed();
	}

	public void validateRegistrationButton() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(registerButton).isDisplayed();
	}

	public void enterNameMobileEmail()

	{

		driver.findElement(enquiryUserName).sendKeys("ramya");
		driver.findElement(mobileNo).sendKeys("8238775234");
		driver.findElement(emailId).sendKeys("ramya1347@gmail.com");
	}

	public void clickProceed() {
		driver.findElement(proceedButton).click();

	}

	public void clickProceedenabled() {

		driver.findElement(proceedButtonEnabled).click();

	}

	public void enterProductDetails()

	{
		driver.findElement(requirementTextarea).sendKeys("Need some information..Could you please provde");
		driver.findElement(grade).sendKeys("YS_550");

	}

	public void clickSendEnquiryButton() {

		driver.findElement(sendEnquirybutton).click();

	}

	public boolean validateProductDetailSubCategories() {

		return driver.findElement(subcategoriesdropdown).isDisplayed();
	}

	public String verifyThanksMessage() {

		String message = driver.findElement(thankMessage).getText();
		return message;
	}

	public void enterInvalidEmail() {

		driver.findElement(emailId).sendKeys("ramya");
	}

	public void enterInvalidName() {

		driver.findElement(enquiryUserName).sendKeys("1234");
	}

	public boolean enterInvalidPhoneNumber() {
		driver.findElement(mobileNo).sendKeys("ABC");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		System.out.println(jse.executeScript("document.getElementById('mobile').innerText;"));
		String value = jse.executeScript("return document.getElementById('mobile').innerText;").toString();
		// System.out.println(value);
		return value.equalsIgnoreCase("");

	}

	
	public boolean enterBlankPhone() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		System.out.println(jse.executeScript("document.getElementById('mobile').innerText;"));
		String value = jse.executeScript("return document.getElementById('mobile').innerText;").toString();
		System.out.println(value);
		return value.equalsIgnoreCase("");

	}

	public boolean enterBlankName() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		System.out.println(jse.executeScript("document.getElementById('nameChange').innerText;"));
		String value = jse.executeScript("return document.getElementById('nameChange').innerText;").toString();
		// System.out.println(value);
		return value.equalsIgnoreCase("");

	}

	public boolean disableProceed() {

		return driver.findElement(proceedButton).isEnabled();
	}

	public boolean searchNotFound() {
		driver.findElement(searchbar).sendKeys("ice cream");
		driver.findElement(searchButton).click();
		return driver.findElement(notfoundsearchimage).isDisplayed();

	}

	public void validateEnquiryID() {
		driver.findElement(By.xpath("//input[@name='email']")).isDisplayed();
	}

	public void validatePopUp() {
		driver.findElement(By.xpath("//strong[contains(text(),'Enquiry Form')]")).isDisplayed();
	}

	public void validatereguserpopup() {
		driver.findElement(By.xpath("//button[@class='enquery-button']")).isDisplayed();
	}

	public void selectCategory() throws InterruptedException {
		
		Thread.sleep(3000);
		Actions act= new Actions(driver);
		WebElement steel =driver.findElement(steelbycategory);
		WebElement Menu= driver.findElement(menu);
		WebElement SubMenu = driver.findElement(secondmenu);
		act.moveToElement(steel).moveToElement(Menu).moveToElement(SubMenu).click().build().perform();
		Thread.sleep(10000);
		
	}
	
	public void validateBannerAfter3() {

	List<WebElement> products=	driver.findElements(By.xpath("//div[@id='product']"));
	if (products.size()	>0)
	{
		int bannerexpected = 314;
		int banner=driver.findElement(By.xpath("//div[@class='enqueryBanner_grid']")).getLocation().y;
		//Assert.assertEquals(bannerexpected, banner);
		
	}
	
	
	
	}

}
