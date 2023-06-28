package pages;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSummaryPage {

	private WebDriver driver;
	String url = "";

	private By RecentBlogs = By.xpath("//UL[@class='v-pagination theme--light']");
	private By OrderNumber = By.xpath("//div[normalize-space()='Order number']//following::div[1]");
	private By Ordertotal = By.xpath("//*[normalize-space()='Order total']//following::div[1]");
	private By PaymentReceived = By.xpath("//*[normalize-space()='Payment received']//following::div[1]");
	private By DeliveryType = By.xpath("//*[normalize-space()='Delivery type']//following::div[1]");
	private By PendingPayment = By.xpath("//*[normalize-space()='Pending payment']//following::div[1]");
	private By PaymentStatus = By.xpath("//*[normalize-space()='Payment status']//following::div[1]");
	private By NotificationText = By.xpath("//div[@class='notification-text']");
	private By BeneficiaryName = By.xpath(
			"//div[@id='pay-via-section-desktop']//p[@class='label'][normalize-space()='Beneficiary name']//following::p[1]");
	private By NEFTRTGS = By
			.xpath("//div[@id='pay-via-section-desktop']//div[@class='neft-section']//p[@class='title']");
	private By AccountNumber = By.xpath(
			"//div[@id='pay-via-section-desktop']//p[@class='label'][normalize-space()='Account Number']//following::p[1]");
	private By IFSCCode = By.xpath(
			"//div[@id='pay-via-section-desktop']//p[@class='label'][normalize-space()='IFSC Code']//following::p[1]");

	private By NetBanking = By.xpath(
			"//div[@id='pay-via-section-desktop']//button[@class='pay-via-netbanking-button'][normalize-space()='Pay via netbanking']");

	private By ViewDetails = By.xpath("//button[normalize-space()='View details']");
	private By DeliveryDays = By.xpath(
			"//*[@class='bottom-section-card']//*[@class='description'][normalize-space()='Delivery in 2 - 5 days']");
	private By ItemDetailsProduct = By.xpath("//div[@class='product-link']");
	private By Shipping = By.xpath("//div[@class='shipping-address']");
	private By Billing = By.xpath("//div[normalize-space()='Billing address:']");
	private By BatchQuery = By.xpath("//a[normalize-space()='process-customer-balance']//following::td[9]//button");

	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validaterecentBlogs() {
		driver.findElement(RecentBlogs).isDisplayed();

	}

	public String validateOrderDetails() {
		driver.findElement(OrderNumber).isDisplayed();
		driver.findElement(Ordertotal).isDisplayed();
		driver.findElement(PaymentReceived).isDisplayed();
		driver.findElement(PendingPayment).isDisplayed();
		String deliveryType = driver.findElement(DeliveryType).getText();
		return deliveryType;

	}

	public String validateOrderAwaitingMessage() {

		String OrderAwaitingMessage = driver.findElement(NotificationText).getText();
		return OrderAwaitingMessage;

	}

	public void validateNetBankingAndNeft() {

		driver.findElement(BeneficiaryName).isDisplayed();
		driver.findElement(NEFTRTGS).isDisplayed();
		driver.findElement(AccountNumber).isDisplayed();
		driver.findElement(IFSCCode).isDisplayed();

		String Beneficiaryname = driver.findElement(BeneficiaryName).getText();
		assertThat(Beneficiaryname.contentEquals("JSW One Platforms Limited"));

		String AcountNumber = driver.findElement(AccountNumber).getText();
		assertThat(AcountNumber.contentEquals("1112220052340710"));

		String IFSCode = driver.findElement(IFSCCode).getText();
		assertThat(IFSCode.contentEquals("RAZR0000001"));

	}

	public void validateMinimiseOfItemDetails() {
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).isDisplayed();
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		driver.findElement(By.xpath("//div[@class='itemsList']//div//i[@class='fa fa-angle-up']")).isDisplayed();

	}

	public void validateNetBankingDisabled() {
		if (driver.findElement(NetBanking).isEnabled()) {
			Assert.fail("netbanking is enabled");
		} else {
			System.out.println("netbanking is disabled");
		}

	}

	public void viewDetails() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ViewDetails));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(ViewDetails).click();
		driver.findElement(By.xpath("//*[text()='1 coupon applied']")).isDisplayed();
	}

	public void viewItemDetails() {
		driver.findElement(DeliveryDays).isDisplayed();
	}

	public void validateDeliveryDays() {
		driver.findElement(ItemDetailsProduct).isDisplayed();
	}

	public void validateShippingAndBilling() {
		driver.findElement(Shipping).isDisplayed();
		driver.findElement(Billing).isDisplayed();
	}

	public void validateOrderNoinURL() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DeliveryDays));
		url = driver.getCurrentUrl();
		String order_num = url.substring(url.lastIndexOf("=") + 1);
		System.out.print("order num" + order_num);
		assertThat(order_num.contains("JOO"));
	}

	public String validatePaymentStatus() throws InterruptedException {

		driver.navigate().refresh();
		driver.findElement(PaymentStatus).isDisplayed();
		String paymntStatus = driver.findElement(PaymentStatus).getText();
		return paymntStatus;
	}

	public void loginToCloudScheduler() {
		driver.get("https://console.cloud.google.com/cloudscheduler?project=jswone-qa-356112");

	}

	public void runBatchQuery() throws InterruptedException {
		driver.findElement(BatchQuery).click();
		driver.findElement(By.xpath("//div[contains(text(),'Force a job run')]")).click();
		Thread.sleep(5000);

	}

	public void navigateToOrder() throws InterruptedException {
		driver.get(url);
		
	}
	
	public void validateSucessfulMsg()
	{
		while (true) {
			try {
				WebElement element = driver.findElement(By.xpath("//*[text()='Your order payment is successful']"));
				if (element.isDisplayed()) {
					break;
				}
			} catch (Exception e) {
				driver.navigate().refresh();
			}
		}

	}
	
	public void validateOrderSummary()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Order summary']")).isDisplayed();
	}
	

}
