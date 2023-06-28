package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDPDiscountPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private By quantity = By.xpath("//input[@class='input-quant']");
	// private By searchTextBox = By.id("SearchText");
	private By alldimensions = By.xpath("//li[contains(@class,'product-list')]");
	private By totalPrice = By.xpath("//span[@class='fl-right tot-cost']");
	private By cartOKbutton = By.xpath("//button[@class='ok-button']");
	private By cart1 = By.xpath("//div[@class='count' and contains(text(),\"1\")]");
	private By viewOffers = By.xpath("//button[contains(text(),\"View offers\")]");
	private By coupontextbox = By.xpath("//input[@id=\"coupon-input\"]");
	private By applyButton = By.xpath("//button[@id=\"coupon-apply-cta\"]");
	// private By sellerPromoLabel =
	// By.xpath("//label[@class='coupon-seller-promo-label']");
	private By sellerPromoLabel = By.xpath("//div[@class='price-summary-row ps-intermediate-row'][2]/child::div[1]");
	private By platformPromoLabel = By
			.xpath("//label[@class='coupon-seller-promo-label' and contains (text(),'Platform promo')]");
	private By deliverycharges = By.xpath("//div[@class='price-summary-row ps-intermediate-row'][4]/child::div[2]");
	private By deliverycharges2 = By.xpath("//div[@class='price-summary-row ps-intermediate-row'][3]/child::div[2]");
	// private By carttotal = By.xpath("//p[@class='cart_total']");
	// private By carttotal = By.xpath("//span[@class='price_amount']");
	// private By carttotal= By.xpath("//span[@class='fl-right tot-cost']");
	private By carttotal = By.xpath("//div[@class='price-summary-row ps-intermediate-row']/child::div[2]");
	// private By error = By.xpath("//input[@class='error-input']");
	private By error = By.xpath("//input[@id='coupon-input']");
	// private By totalWithCoupon= By.xpath("//p[@class='total_amount']");
	private By totalWithCoupon = By.xpath("//div[@class='ps-total-value']");

	private By expcouponerror = By.xpath("//div[@class='input-error-message']");
	private By closebutton = By.xpath("//button[@class='close']");
	private By remove = By.xpath("//a[@role='button']");
	private By confirmremove = By.xpath("//input[@class='remove_item_btn']");
	private By messagecartempty = By.xpath("//div[@class='empty-content text-center']");
	private By productselect = By.xpath("//div[@class='product-plp1 col-sm-12 col-xxl-4']");
	private By couponSection = By.xpath("//div[@class='pdp_coupons mt-3']");
	private By couponsList = By.xpath("//li[@class='cp_description']");
	private By couponCode = By.xpath("//h1[@class='cp_code']");

	// private By subtotal= By.xpath("//*[@id='collapsePrice1']/div/ul/li[5]/span");
	public PDPDiscountPage(WebDriver driver) {
		this.driver = driver;
	}

	// public void enterSearchText(String searchProduct) throws InterruptedException
	// {
	// driver.findElement(searchTextBox).sendKeys(searchProduct);
	// }

	public String ValidatebreadcrumbColourCoated() throws InterruptedException {
		Thread.sleep(5000);
		String breadcrumbTxt = driver.findElement(By.xpath("//b[contains(text(),'Colour Coated')]")).getText();
		return breadcrumbTxt;
	}

	public void selectDimensionreguser() throws InterruptedException {
		List<WebElement> alldimensions2 = driver.findElements(alldimensions);
		int i = driver.findElements(alldimensions).size();
		System.out.println(i);
		Thread.sleep(3000);
		alldimensions2.get(9).click();
		// alldimensions2.get(1).click();
		alldimensions2.get(12).click();
		alldimensions2.get(15).click();

	}

	public void selectProduct() throws InterruptedException {
		Thread.sleep(2000);

		List<WebElement> productselected = driver.findElements(productselect);

		if (productselected.get(1).getText().contains("Coils"))
		{
		System.out.println("The value is " + productselected.get(1).getText());
			productselected.get(1).click();
		}
		else if (productselected.get(0).getText().contains("Coils"))
		{
			productselected.get(0).click();
		}
		

	}

	public boolean validatePrice() {

		driver.findElement(totalPrice).isDisplayed();

		String total = driver.findElement(totalPrice).getText();
		int total_price = Integer.parseInt(total.replaceAll("[^0-9]", ""));
		double totalprice = (double) total_price / 100.00;

		if (totalprice > 500000.00)
			return true;
		else
			return false;
	}

	public boolean validatePrice1L() {

		driver.findElement(totalPrice).isDisplayed();

		String total = driver.findElement(totalPrice).getText();
		int total_price = Integer.parseInt(total.replaceAll("[^0-9]", ""));
		double totalprice = (double) total_price / 100.00;

		if (totalprice > 100000.00)
			return true;
		else
			return false;
	}

	public boolean validatePrice2L() {

		driver.findElement(totalPrice).isDisplayed();

		String total = driver.findElement(totalPrice).getText();
		int total_price = Integer.parseInt(total.replaceAll("[^0-9]", ""));
		double totalprice = (double) total_price / 100.00;

		if (totalprice > 200000.00)
			return true;
		else
			return false;
	}

	public void enterQuantity5() throws InterruptedException {

		driver.findElement(quantity).sendKeys("5");
		Thread.sleep(3000);

	}
	public void enterQuantity3() throws InterruptedException {

		driver.findElement(quantity).sendKeys("3");
		Thread.sleep(3000);

	}

	public void enterQuantity2() throws InterruptedException {

		driver.findElement(quantity).sendKeys("2");
		Thread.sleep(3000);

	}

	public void validateitemAddedinCart() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(cartOKbutton).isDisplayed();
		driver.findElement(cartOKbutton).click();
	}

	public void validateCartIcon1() {

		driver.findElement(cart1).isDisplayed();
	}

	public void clickCartIcon1() {

		driver.findElement(cart1).click();
	}

	public void clickViewOffers()

	{

		driver.findElement(viewOffers).click();
	}

	public void enterCouponCode() {
		String total = driver.findElement(carttotal).getText();
		int total_price = Integer.parseInt(total.replaceAll("[^0-9]", ""));
		double totalprice = total_price / 100.00;
		System.out.println(totalprice);
		if (totalprice <= 500000.00)
			driver.findElement(coupontextbox).sendKeys("QAFLAT500");
		else {
			driver.findElement(coupontextbox).sendKeys("QAFLAT5");
			// driver.findElement(coupontextbox).sendKeys("FLAT2000");
		}

	}

	public void clickApplyButton() throws InterruptedException {
		driver.findElement(applyButton).click();
		Thread.sleep(5000);
		driver.findElement(closebutton).click();
	}

	public void validateSellerPromo() {

		driver.findElement(sellerPromoLabel).isDisplayed();

	}

	public double cartTotal()

	{

		String cart_total = driver.findElement(carttotal).getText();
		int value1 = Integer.parseInt(cart_total.replaceAll("[^0-9]", ""));
		double carttotal = (double) value1 / 100.00;
		return carttotal;
	}

	public double validatePriceBeforeCoupon() {
		String cart_total = driver.findElement(carttotal).getText();
		int value1 = Integer.parseInt(cart_total.replaceAll("[^0-9]", ""));
		double carttotal = (double) value1 / 100.00;
		String charges = driver.findElement(deliverycharges).getText();
		int value2 = Integer.parseInt(charges.replaceAll("[^0-9]", ""));
		double delivery_charges = value2 / 100.00;
		// double sgst= 0.09*(carttotal+delivery_charges);
		// double cgst= 0.09*(carttotal+delivery_charges);
		double sgst = 0.09 * carttotal;
		double cgst = 0.09 * carttotal;
		double pricewithoutcoupon = carttotal + sgst + cgst + delivery_charges;
		System.out.println("Cart total" + carttotal);
		System.out.println("CGST" + cgst);
		System.out.println("sGST" + sgst);
		System.out.println("delivery charges" + delivery_charges);
		return pricewithoutcoupon;
	}
	
	public double validatePriceBeforeCoupon2000() {
		String cart_total = driver.findElement(carttotal).getText();
		int value1 = Integer.parseInt(cart_total.replaceAll("[^0-9]", ""));
		double carttotal = (double) value1 / 100.00;
		String charges = driver.findElement(deliverycharges2).getText();
		int value2 = Integer.parseInt(charges.replaceAll("[^0-9]", ""));
		double delivery_charges = value2 / 100.00;
		double sgst = 0.09 * carttotal;
		double cgst = 0.09 * carttotal;
		double pricewithoutcoupon = carttotal + sgst + cgst + delivery_charges;
		System.out.println("Cart total" + carttotal);
		System.out.println("CGST" + cgst);
		System.out.println("sGST" + sgst);
		System.out.println("delivery charges" + delivery_charges);
		return pricewithoutcoupon;
	}
	

	public double priceAftercoupon() {
		String totalwithcoupon = driver.findElement(totalWithCoupon).getText();
		int value1 = Integer.parseInt(totalwithcoupon.replaceAll("[^0-9]", ""));
		double total_coupon = (double) value1 / 100.00;
		return total_coupon;

	}

	public void validatePlatformPromo() {
		driver.findElement(platformPromoLabel).isDisplayed();

	}

	public boolean validateAmountdiscount(double rupees) {
		double pricebeforecoupon = validatePriceBeforeCoupon();
		double difference;
		double priceaftercoupon = priceAftercoupon();
		difference = pricebeforecoupon - priceaftercoupon;
		if (difference > rupees)
			return true;
		else
			return false;

	}

	public void clickApplyButton2() throws InterruptedException {
		driver.findElement(applyButton).click();
		//Thread.sleep(5000);

	}

	public void validateCouponCodeError() throws InterruptedException {

		driver.findElement(expcouponerror).isDisplayed();
		driver.findElement(closebutton).click();

	}

	public void enterExpireCoupon() {
		driver.findElement(coupontextbox).sendKeys("QAEXP50");

	}

	public void enterCouponCode2000() {
		driver.findElement(coupontextbox).sendKeys("FLAT2000");
	}
	
	public void enterBreachedCouponCode() {
		driver.findElement(coupontextbox).sendKeys("QAONETIME");
	}

	public void deleteProductfromCart() throws InterruptedException

	{

		driver.findElement(remove).click();
		Thread.sleep(2000);
		driver.findElement(confirmremove).click();
		Thread.sleep(5000);
		driver.findElement(messagecartempty).isDisplayed();
	}
	
	public void clickApplyCouponButton()
	{
		driver.findElement(By.xpath("//div[1]/div[3]/button[1]")).click();
	}
	
	public void CouponList()
	{
		List<WebElement> couponsList=driver.findElements(By.xpath("//div[@class='applied-coupons']"));
		for(int i=0; i<couponsList.size();i++)
		{
		System.out.println(couponsList.get(i).getText());
		}
	}
	
	public void enterTheCouponCode(String coupon) {
		driver.findElement(coupontextbox).sendKeys(coupon);
	}
	
	public void closeCouponDialog()
	{
		driver.findElement(By.xpath("//button[contains(text(),'×')]")).click();
	}
	
	public void validateCouponAppplied() {
	
	   // wait = new WebDriverWait(driver,60);
	   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Coupon applied successfully')]")));
	   //driver.findElement(By.xpath("//*[contains(text(),'Coupon applied successfully')]")).isDisplayed();
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30L))
			       .pollingEvery(Duration.ofSeconds(5L))
			       .ignoring(NoSuchElementException.class);
		
	WebElement button = wait.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(By.xpath("//*[contains(text(),'Coupon applied successfully')]"));
			}
		});
		

	}
	public void validateremoveButton() {
		driver.findElement(By.xpath("//button[@class='primary removeButton']")).isDisplayed();

	}
	
	public void clickremoveButton() {
		driver.findElement(By.xpath("//button[@class='primary removeButton']")).click();

	}
	public void clickSeeMoreButton() {
		driver.findElement(By.xpath("//div[@class='cp_see_more']//span")).click();

	}
	
	public void SeeMoreCouponsonPDPPage()
	{
		List<WebElement> couponsList=driver.findElements(By.xpath("//h1[@class='cp_code']"));
		for(int i=0; i<couponsList.size();i++)
		{
		System.out.println(couponsList.get(i).getText());
		}
	}
	
	public void verifyViewCoupons() {
		driver.findElement(By.xpath("//button[normalize-space()='View details']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='View details']")).click();
		
		String coupon= driver.findElement(By.xpath("//div[@class='applied-coupon-code']")).getText();
		System.out.print(coupon);

	}
	
	public void verifyDiscountSection() throws InterruptedException {
		driver.findElement(couponSection).isDisplayed();
		String couponArea = driver.findElement(By.xpath("//h1[@class='cp_head']")).getText();
		System.out.println(couponArea);
		Thread.sleep(1500);
	}
	
	public void listCouponCode() throws InterruptedException {
		int size = driver.findElements(couponsList).size();
		System.out.println("No. of coupons listed: "+size);
		Thread.sleep(1500);
	}
	
	public void verifyCouponCasing() {
			String code = driver.findElement(couponCode).getText();
			System.out.println("Coupon code: "+code);
		
	
	}

}
