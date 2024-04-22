package com.jswone.msme.oms.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jswone.msme.oms.util.ElementUtil;
import com.jswone.msme.oms.util.TestDataBuild;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import junit.framework.Assert;

public class OrderPage {

	private WebDriver driver;
	private By googleLogin = By.xpath("//*[text()='Login with Google']");
	private By emailTextBox = By.xpath("//input[@type='email']");
	private By nextBtn = By.xpath("//span[normalize-space()='Next']");
	private By passwordBox = By.xpath("//input[@type='password']");
	private By pipo = By.xpath("//*[text()='Verify PI/PO']");
	TestDataBuild data = new TestDataBuild();

	public static String CCPorderno = CCPPage.ccporderno;

	public OrderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToOMS() throws InterruptedException, IOException {

		driver.get(ElementUtil.getGlobalValue("omsUrl"));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(googleLogin).click();
		driver.findElement(emailTextBox).sendKeys("qatestuser@jsw.in");
		Thread.sleep(1000);
		driver.findElement(nextBtn).click();
		Thread.sleep(4000);
		driver.findElement(passwordBox).sendKeys("Admin@123$");
		Thread.sleep(2000);
		driver.findElement(nextBtn).click();
		Thread.sleep(19000);

		ElementUtil obj = new ElementUtil(driver);

		if (obj.isElementPresent("//*text()='You don't have access to requested feature'")) {
			driver.findElement(By.xpath("//p[text()='Welcome,']/following-sibling::button")).click();
			driver.findElement(googleLogin).click();
		}

	}

	public void goToIncomingPayments() throws IOException {
		driver.get(ElementUtil.getGlobalValue("omsUrl") + "incoming-payments");
	}

	public void navigateToERPOrderPageUsingSFOrderNo(String orderNo) throws InterruptedException, IOException {
		goToOMS();
		driver.get("https://qa-oms.msme.jswone.in/order-list/" + orderNo);
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	public void selectOrderStatus(String value) {
		ElementUtil ut = new ElementUtil(driver);
		ut.scrollDownToElement(pipo);

		driver.findElement(By.xpath("//p[text()='Order status']//following::div[1]")).click();
		driver.findElement(By.xpath("//*[text()='" + value + "']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	public void hoversourceSeller() {
		WebElement sellerName = driver.findElement(By.xpath("//*[text()='Seller']//following::p[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sellerName).perform();

	}

	public void viewSellerDetails() {
		driver.findElement(By.xpath("//*[text()='name']")).isDisplayed();
		driver.findElement(By.xpath("//*[text()='mobile']")).isDisplayed();
		driver.findElement(By.xpath("//*[text()='email']")).isDisplayed();
		driver.findElement(By.xpath("//*[text()='companyName']")).isDisplayed();
		driver.findElement(By.xpath("//*[text()='gstin']")).isDisplayed();

	}

	public void untaggedPaymentThroughCurl(String amt) {
		String pymntId = ElementUtil.generateRandomString(6);

		RestAssured.baseURI = "https://qa.msme.jswone.in";
		RestAssured.given().contentType(ContentType.JSON)
				.header("X-Razorpay-Signature", "41002be0d7ab4ef3a8b1d2a8dcf76e9843c09946811480c914fac7ab5b35bb8e")
				.body(data.neftTestData(pymntId, amt)).post("/payment/capturePayment").then().assertThat()
				.statusCode(204);
	}

	public void untaggedPayment() throws InterruptedException {
		WebElement inputField = driver.findElement(By.xpath("(//input[@id='search-bar'])[1]"));
		inputField.sendKeys("ALFALOGIC SOLUTIONS INDIA PRIVATE LIMITED");
		Thread.sleep(5000);
		inputField.sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[text()='ALFALOGIC SOLUTIONS INDIA PRIVATE LIMITED']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//p[text()='Save'])[1]")).click();
		Thread.sleep(3000);

	}

	public String validatePaymentStatus() {
		String paymentStatus = driver.findElement(By.xpath("//*[text()='Payment status']//following::p[1]")).getText();
		return paymentStatus;
	}

}
