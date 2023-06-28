package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import factory.DriverFactory;
import util.ElementUtil;

public class MyOrderPages {
	private WebDriver driver;

	String expectedStatus = "Your order has been successfully placed";
	String cartEmptyMessage = "Your cart is empty.";
	String orderCancelMessage = "Your Order has been cancelled. Any amount charged will be refunded in\r\n"
			+ "        5-7 working days";
	String CancelOrder = "Cancel Order\r\n" + "To cancel your order contact\r\n" + "7208055523";

	@FindBy(xpath = "//div[@class='cancel-order-message']")
	private WebElement cancelMge;

	// ------------------- View details & Need help ------------------------
	@FindBy(xpath = "//a[contains(text(),'My orders')]")
	private WebElement myOrder;
	@FindBy(xpath = "(//div[@class='view-details mt-0'])[2]")
	private WebElement scrollViewDetails;
	@FindBy(xpath = "(//*[text()='Total amount:']//following::div[1]//following::button[1]//p[1])[1]")
	private WebElement viewDetails;
	@FindBy(xpath = "//span[normalize-space()='Price details']")
	private WebElement viewPriceBreakup;
	@FindBy(xpath = "(//a[text()='Need help '])[1]")
	private WebElement needHelp;
	// span[@class='cancel-btn cursor-pointer']

//------------------- Buy again -----------------------	

	@FindBy(xpath = "(//button[@class='need-help-order mt-custom'])[1]")
	private WebElement buyAgain;
	@FindBy(xpath = "//div[text()='Select dimensions']")
	private WebElement dimensionScroll;
	@FindBy(xpath = "//*[@id=\'Product-Overview\']/div[2]/div[2]/div/div[2]/div[9]/div[2]/input")
	private WebElement input;
	@FindBy(id = "5-10")
	private WebElement coilWeight0;
	@FindBy(id = "10-22")
	private WebElement coilWeight1;
	@FindBy(id = "22-27")
	private WebElement coilWeight2;
	@FindBy(xpath = "//button[@class='btn btn-quant']")
	private WebElement arrow;
	@FindBy(xpath = "//button[@class='btn cart-btn-secondary']")
	private WebElement addToCart;
	@FindBy(xpath = "//button[@class='ok-button']")
	private WebElement okCart;
	@FindBy(xpath = "//button[@class='btn cart-btn-primary']")
	private WebElement buyNow;
	@FindBy(xpath = "//*[@id=\'__layout\']/div/header/div[1]/div[3]/a/img")
	private WebElement myCart;
	@FindBy(xpath = "//span[text()='Proceed to pay']")
	private WebElement proceedToPay;
	@FindBy(id = "BanksList")
	private WebElement bankList;
	@FindBy(xpath = "//button[@class='btn btn-red']")
	private WebElement payNow;
	@FindBy(xpath = "//button[@class='success']")
	private WebElement successPayment;
	@FindBy(xpath = "//div[@class='success-order-title']")
	private WebElement successMge;

//------------------Cancel Order ----------------------

	@FindBy(className = "view-details mt-0")
	private WebElement viewOrderDetails;
	@FindBy(xpath = "//button[@class='btn btn-light-blue']")
	private WebElement cancel;
	@FindBy(className = "ok-button")
	private WebElement okCancel;
	// @FindBy(xpath = "//*[@id=\'__layout\']/div/header/div[1]/div[3]/div[4]/a")
	// private WebElement cancelOrder;
	@FindBy(xpath = "(//div[@class='cancel-order-section flex-column mt-0']//span)[1]")
	private WebElement cancelOrder;
	@FindBy(xpath = "//span[text()='CANCEL ORDER']")
	private WebElement cancelButton;

	@FindBy(xpath = "//textarea[@placeholder='Enter remarks']")
	private WebElement remark;
	@FindBy(xpath = "//div[@class='modal-body']//div[4]//button")
	private WebElement cancelOrderB;
	// @FindBy(xpath = "//button[@class='proceedhome-button-login mb-25 mt-25']")
	// private WebElement cancelOrderB;
	@FindBy(xpath = "(//li[@class='step0'])[4]")
	private WebElement inactiveDelivery;
	@FindBy(xpath = "(//li[@class='step0 activePro'])[4]")
	private WebElement activeDelivery;
	@FindBy(xpath = "//li[@class='activePro step0 activePro']")
	private WebElement activePlacedOrder;
	@FindBy(xpath = "//span[@class='cancel-timer ml-10']")
	private WebElement timer;
	@FindBy(xpath = "//div[@class='title-main']")
	private WebElement cancelOrderID;
	@FindBy(xpath = "//span[@class='order-value']")
	private WebElement orderNumber;

//Filter Functionality

	private By filterIcon = By.xpath("//div[@class='filter-myorder']");
	private By invoiceMessage = By.xpath("//div[@class='note']");
	private By filterWindow = By.xpath("//div[@id='filter-order___BV_modal_body_']");
	private By orderStatus = By.xpath("//div[text()='Status']");
	private By placedStatus = By.xpath("(//input[@class='vh-product'])[2]");
	private By statusDropdown = By.xpath("//span[@class='anchor']");
	private By sevenDays = By.xpath("//button[contains(text(),'Last 7 days')]");
	private By oneMonth = By.xpath("//button[contains(text(),'Last 1 month')]");
	private By threeMonths = By.xpath("//button[contains(text(),'Last 3 months')]");
	private By sixMonths = By.xpath("//button[contains(text(),'Last 6 months')]");
	private By fromDate = By.id("from-datepicker__value_");
	private By toDate = By.id("to-datepicker__value_");
	private By apply = By.xpath("//div[1]/div[2]/div[6]/button[1]");
	private By reset = By.xpath("(//span[contains(@class,'reset-btn')])[1]");
	private By clearAll = By.xpath("//button[@class='btn clearAllbtn ml-0 mt-1']");
	private By filterApplied = By.xpath("//div[@class='d-md-inline-flex d-lg-inline-flex my-4']");

	private By order = By.xpath("//div[contains(text(),'Orders')]");
	private By searchBox = By.xpath("//input[@id='basic.textInput']");
	private By FirstOrderNo = By.xpath("//div[@data-testid= 'cell-0-orderNumber']");
	private By ReviewAndPay = By.xpath("(//*[contains(text(),'Review & pay')])[1]");
	private By ViewDetails = By.xpath("//*[text()='View details']");
	
	
	
	public  MyOrderPages(WebDriver driver2){
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public void validateCancelmge() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='cancel-order-message']")).isDisplayed();
		return;
	}

	public void clickSucessPayment() {
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		driver.switchTo().window(ar.get(1));
		driver.findElement(By.xpath("//button[text()='Success']")).click();
		return;
	}

	public void validateRazorpayPage()

	{
		Set<String> windows = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		windows.remove(parent);
		Iterator<String> it = windows.iterator();
		String child = null; // This is for referencing specific child window
		while (it.hasNext()) {
			child = (String) it.next();
			driver.switchTo().window(child);
			driver.findElement(By.xpath("//button[@class='success']")).isDisplayed();
		}
		return;
	}

	public void validateOrderSuccessfulmsg() {
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		driver.switchTo().window(ar.get(0));
		// driver.findElement(By.xpath("//div[@class='success-order-title']")).isDisplayed();
		return;
	}

	public void scrollingDown(WebElement element) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", element);
		return;
	}

	public void dropDownValue(WebElement element, String colour) {
		Select s = new Select(element);
		s.selectByValue(colour);
		return;
	}

	public void implicitWaitSec(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		return;
	}

	public void implicitWaitMin(long min) {
		driver.manage().timeouts().implicitlyWait(min, TimeUnit.MINUTES);
		return;
	}

	public void placedOrder() {
		driver.findElement((By) activePlacedOrder).isDisplayed();
		driver.findElement((By) cancelOrder).click();
		return;
	}

	public void validateNeedHelp() {
		driver.findElement(By.xpath("//div[@class='help-container']")).isDisplayed();
		return;
	}

	public void cancelledOrderID() {
		driver.findElement((By) cancelOrderID).isDisplayed();
		String cancelID = driver.findElement((By) cancelOrderID).getText();
		return;
	}

	public void orderNumber() {
		driver.findElement((By) orderNumber).isDisplayed();
		String number = driver.findElement((By) orderNumber).getText();
		return;
	}

	// Payment History

	public void DOorder() throws InterruptedException {
		WebElement scroll = driver.findElement(By.xpath("//div[text()='TEST999-12284']"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", scroll);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[3]/div/div[3]/div[1]/div[3]/div[2]/div")).click();
	}

	public void validateOrderSummaryPage() {
		driver.findElement(By.xpath("//div[text()='Order details']")).isDisplayed();
	}

	public void validatePaymentReceived() {
		driver.findElement(By.xpath("//span[text()='Payment received']")).isDisplayed();
	}

	public void clickPaymentHistory() {
		driver.findElement(By.xpath("//button[contains(text(),'Payment history')]")).click();
	}

	public void paymentHistory() {
		List<WebElement> payment = driver.findElements(By.xpath("//div[@class='payment-details']"));
		System.out.println("Number of payment history: " + payment.size());
		for (Iterator iterator = payment.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());
		}
	}

	public void scrollPayment() {
		WebElement paymentReceived = driver.findElement(By.xpath("//span[text()='Payment received']"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", paymentReceived);
		return;
	}

	// Applied coupons view

	public void validateViewCoupons() {
		WebElement coupons = driver.findElement(By.xpath("//span[text()='View coupons']"));
		System.out.println(coupons.isDisplayed());
		System.out.println(coupons.getText());
	}

	public void couponsCount() {
		WebElement count = driver.findElement(By.xpath("//div[@class='coupon-applied-message']"));
		System.out.println(count.getText());
	}

	public void clcikViewCoupons() {
		driver.findElement(By.xpath("//span[text()='View coupons']")).click();
	}

	public void validateAppliedCoupon() throws InterruptedException {
		System.out.println(driver.findElement(By.xpath("//h1[@class='coupon-modal-heading']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='applied-coupons']")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='close']")).click();
		Thread.sleep(2000);
	}

//Filter Functionality

	public void clickFilter() {
		driver.findElement(filterIcon).isDisplayed();
		driver.findElement(filterIcon).click();
	}

	public boolean verifyFilterPopup() {
		boolean popup = driver.findElement(filterWindow).isDisplayed();
		return popup;
	}

	public void invoiceMessage() {
		driver.findElement(invoiceMessage).isDisplayed();
		System.out.println(driver.findElement(invoiceMessage).getText());
	}

	public void selectedPlaced() throws InterruptedException {
		driver.findElement(statusDropdown).click();
		Thread.sleep(1000);
		driver.findElement(placedStatus).click();
		Thread.sleep(1500);
	}

	public void durationDefault() throws InterruptedException {
		driver.findElement(threeMonths).click();
		Thread.sleep(2000);
	}

	public void customFromDuration() throws InterruptedException {
		driver.findElement(fromDate).click();
		driver.findElement(By.xpath("(//div[@aria-hidden='true'])[2]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(
				"(//span[@class='btn border-0 rounded-circle text-nowrap btn-outline-light text-dark font-weight-bold'])[1]"))
				.click();
		Thread.sleep(1500);
	}

	public void customToDuration() throws InterruptedException {
		driver.findElement(toDate).click();
		driver.findElement(By.xpath(
				"(//span[@class='btn border-0 rounded-circle text-nowrap btn-outline-light text-dark font-weight-bold'])[1]"))
				.click();
		Thread.sleep(1500);
	}

	public void clickApply() {
		driver.findElement(apply).click();
	}

	public void verifyFilterApplied() throws InterruptedException {
		String applied = driver.findElement(filterApplied).getText();
		System.out.println(applied);
		Thread.sleep(2000);
	}

	public void clickReset() throws InterruptedException {
		driver.findElement(reset).click();
		Thread.sleep(1500);
	}

	public void clickClearAll() throws InterruptedException {
		driver.findElement(clearAll).click();
		Thread.sleep(1500);
	}

	public String verifyMyOrderPage() {
		return driver.findElement(By.xpath("(//*[text()='My orders'])[1]")).getText();
	}

	public void clearedAppliedFilter() {
		boolean cleared = driver.findElement(By.xpath("//div[@class='showorderCount mt-1']")).isDisplayed();
		System.out.println("Cleared Applied filter: " + cleared);
	}

	public WebElement getOrderNumber() {
		return orderNumber;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getRemark() {
		return remark;
	}

	public WebElement getCancelOrderB() {
		return cancelOrderB;
	}

	public WebElement getActivePlacedOrder() {
		return activePlacedOrder;
	}

	public WebElement getTimer() {
		return timer;
	}

	public WebElement getCancel() {
		return cancel;
	}

	public WebElement getCancelOrderID() {
		return cancelOrderID;
	}

	public WebElement getInactiveDelivery() {
		return inactiveDelivery;
	}

	public WebElement getActiveDelivery() {
		return activeDelivery;
	}

	public WebElement getSuccessPayment() {
		return successPayment;
	}

	public WebElement getSuccessMge() {
		return successMge;
	}

	public WebElement getDimensionScroll() {
		return dimensionScroll;
	}

	public String getExpectedStatus() {
		return expectedStatus;
	}

	public String getCartEmptyMessage() {
		return cartEmptyMessage;
	}

	public String getOrderCancelMessage() {
		return orderCancelMessage;
	}

	public WebElement getCancelMge() {
		return cancelMge;
	}

	public WebElement getMyOrder() {
		return myOrder;
	}

	public WebElement getScrollViewDetails() {
		return scrollViewDetails;
	}

	public WebElement getViewDetails() {
		return viewDetails;
	}

	public WebElement getViewPriceBreakup() {
		return viewPriceBreakup;
	}

	public WebElement getNeedHelp() {
		return needHelp;
	}

	public WebElement getViewOrderDetails() {
		return viewOrderDetails;
	}

	public WebElement getCancelOrder() {
		return cancelOrder;
	}

	public WebElement getOkCancel() {
		return okCancel;
	}

	public WebElement getBuyAgain() {
		return buyAgain;
	}

	public WebElement getCoilWeight0() {
		return coilWeight0;
	}

	public WebElement getCoilWeight1() {
		return coilWeight1;
	}

	public WebElement getCoilWeight2() {
		return coilWeight2;
	}

	public WebElement getInput() {
		return input;
	}

	public WebElement getArrow() {
		return arrow;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getOkCart() {
		return okCart;
	}

	public WebElement getBuyNow() {
		return buyNow;
	}

	public WebElement getMyCart() {
		return myCart;
	}

	public WebElement getProceedToPay() {
		return proceedToPay;
	}

	public WebElement getBankList() {
		return bankList;
	}

	public WebElement getPayNow() {
		return payNow;
	}

	public String getOrderNo() {
		String orderNo = driver.findElement(By.xpath("//*[contains(text(),'Order number')]//following::div[1]"))
				.getText();
		System.out.println("order number" + orderNo);
		return orderNo;
	}

	public String gettax() {
		driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div[2]/button[1]")).click();
		String tax = driver
				.findElement(By.xpath("//div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]"))
				.getText();
		return tax;
	}

	public void clickOrder() throws InterruptedException {

		driver.findElement(order).click();
		Thread.sleep(1000);
		driver.findElement(order).click();

	}

	public boolean isElementPresentpopup() {
		try {
			driver.findElement(By.xpath("//button[@label='Close dialog']"));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void checkPopup() {

		driver.findElement(By.xpath("//button[@label='Close dialog']")).click();

	}

	public void enterOrdernoSearchBox(String orderno) throws InterruptedException {

		driver.findElement(searchBox).sendKeys(orderno);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='search-button']//*[name()='svg']")).click();
		Thread.sleep(2000);
		driver.findElement(FirstOrderNo).click();
		Thread.sleep(10000);

	}

	public void closePopup() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	public void validateOrdersAwaitingPaymentHeader() {
		driver.findElement(By.xpath("//*[normalize-space()='Orders awaiting payment']")).isDisplayed();
	}

	public void validatemyOrdersHeader() {
		WebElement block = driver.findElement(By.xpath("(//div[@class='common-container'])[3]"));
		block.findElement(By.xpath(
				"(//p[@class='typography-h3 typography-md-h2 typography-font-bold typography-font-md-semibold'])[1]"))
				.isDisplayed();

	}

	public void clickReviewAndPay() throws InterruptedException {
		ElementUtil elementUtil = new ElementUtil(DriverFactory.getDriver());
		if (elementUtil.isElementPresent("(//*[contains(text(),'Review & pay')])[1]")) {
			driver.findElement(By.xpath("(//*[contains(text(),'Review & pay')])[1]")).click();
		}
	}

	public void verifyActiveDeliveredAndCancelled() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='All']")).isDisplayed();
      driver.findElement(By.xpath("//button[normalize-space()='Active']")).isDisplayed();
      driver.findElement(By.xpath("//button[normalize-space()='Delivered']")).isDisplayed();
      driver.findElement(By.xpath("//button[normalize-space()='Cancelled']")).isDisplayed();
      
	}
	
	public void countlistofOrders() throws InterruptedException {
		List<WebElement>lt =driver.findElements(By.xpath("//*[text()='View details']"));
		System.out.println("No of orders"+lt.size());
        
	}
	
	public void clickViewDetails()
	{
		driver.findElement(By.xpath("(//*[normalize-space()='Order number:']//following::a[1])[1]//div")).click();
	}
	
	public void verifyOrderPlaced()
	{
		driver.findElement(By.xpath("(//*[text()='Order placed'])[1]")).isDisplayed();
	}
	public void verifyBillToShipTo()
	{
		driver.findElement(By.xpath("(//*[text()='Bill to'])[1]")).isDisplayed();
		driver.findElement(By.xpath("(//*[text()='Ship to'])[1]")).isDisplayed();
	}
	public void verifyOrderNumber()
	{
		driver.findElement(By.xpath("(//*[text()='Ship to'])[1]")).isDisplayed();
	}
	public void verifyPaymentDetails()
	{
		driver.findElement(By.xpath("((//div[@class='order-status-details-container'])[1]//following::div[20]//p)[1]")).isDisplayed();
	}
	public void verifyItemDetails()
	{
		driver.findElement(By.xpath("((//div[@class='order-status-details-container'])[1]//following::div[6]//p)[1]")).isDisplayed();
	}
	public void verifyOrderStatus()
	{
		driver.findElement(By.xpath("(//div[@class='order-status-details-container'])[1]")).isDisplayed();
	}
	
	
	



}
