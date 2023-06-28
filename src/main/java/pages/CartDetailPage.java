package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.ElementUtil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;

public class CartDetailPage {

	private WebDriver driver;

	private By myCart = By.xpath("//h4[@class='cart_title']");
	private By Cart = By.xpath("//div[@class='count']");
	private By TandC = By.xpath("//span[@class='text-primary']/a");
	private By TandCimgtext = By.xpath("//div[@class='img_p']");
	private By checkbox = By.xpath("//input[@id='termsCondition']");
	private By techspec = By.xpath("//input[@id='termsCondition']//following::label[1]");
	private By deliverydate = By.xpath("(//*[text()='Delivery in 2 - 5 days'])[1]");
	private By apply = By.xpath("(//div[@class='coupon-persuasion-container'])[1]");
	private By applied = By.xpath("(//div[@class='coupon-applied-container'])[1]");

	public CartDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	public String validateMyCart() throws InterruptedException {
		return driver.findElement(myCart).getText();

	}

	public void clickCart() {
		driver.findElement(Cart).click();
	}

	public void validateTandC() {
		driver.findElement(TandC).isDisplayed();
	}

	public void clickTandC() {
		driver.findElement(TandC).click();
	}

	public void validateTandCpage() {
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		System.out.print(ar);
		driver.switchTo().window(ar.get(1));
		driver.findElement(TandCimgtext).isDisplayed();
		driver.findElement(By.xpath("//*[text()='TERMS OF USE ']")).isDisplayed();
	}

	public void validateTechSpec() {
		driver.findElement(techspec).isDisplayed();
	}

	public void clickCheckbox() throws InterruptedException {
		Thread.sleep(8000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);

		WebElement checkboxTerms = driver.findElement(By.xpath("//input[@id='termsCondition']"));
		// jse.executeScript("arguments[0].click();", checkboxTerms);

	}

	public void validateDeliveryDate() {
		String str = driver.findElement(deliverydate).getText();
		System.out.println(str);
		Assert.assertEquals(str, "Delivery in 2 - 5 days");
	}

	// Discount
	public void validateCartPage() {
		WebElement cartPage = driver.findElement(By.xpath("//ul[@class='nav nav-tabs requirements-nav']"));
		System.out.println(cartPage.getText());
	}

	public void applySteel250() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@class='primary apply-button'])[1]")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[contains(text(),'×')]")).click();
	}

	public void removeProduct() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'×')]")).click();
		WebElement remove = driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/span[1]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		// j.executeScript("window.scrollTo(0,700)", "");
		j.executeScript("arguments[0].scrollIntoView()", remove);
		Thread.sleep(2000);
		remove.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[contains(text(),'Remove item')]")).click();
		Thread.sleep(10000);
	}

	public boolean priceverification() {
		// driver.findElement(By.xpath("//span[@class='strike']").isDisplayed();
		driver.findElement(By.xpath("//div[2]/div[1]/div/div[1]/div[2]/div[2]/span[1]")).isDisplayed();
		return true;
	}

	public boolean apply() {
		return driver.findElement(apply).isDisplayed();
	}

	public boolean applied() {
		return driver.findElement(applied).isDisplayed();
	}

	public void validateApplyCoupons() {
		WebElement coupons = driver.findElement(By.xpath("(//div[@class='coupon-persuasion-container'])[1]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", coupons);
		System.out.println(coupons.getText());
	}

	public void validateAppliedCoupons() {
		WebElement coupons = driver.findElement(By.xpath("(//div[@class='coupon-applied-container'])[1]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", coupons);
		System.out.println(coupons.getText());
	}

	public void removeHRInCart() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'×')]")).click();
		Thread.sleep(2000);
		WebElement remove = driver.findElement(By
				.xpath("//div[contains(text(),'JSW Steel Hot Rolled Sheets IS 2062:2011 E250A')]//following::div[2]"));
		remove.click();
		driver.findElement(By.xpath("//*[text()='Proceed']")).click();
		Thread.sleep(8000);
	}

	public void changeAddress(int index) {
		driver.findElement(By.xpath("//a[contains(text(),'Change address')]")).click();
		List<WebElement> deladress = driver.findElements(By.xpath("//div[@class='d-flex change-address-list']"));
		deladress.get(index).click();
	}

	public void selectDelivery() throws InterruptedException {
		driver.findElement(By.xpath("(//button[contains(text(),'Deliver here')])[2]")).click();
		Thread.sleep(4000);

	}

	public String verifydeliveryCharges() {

		String text = driver.findElement(By.xpath("//div[2]/div[1]/div[1]/div[3]/div[1]/span[1]")).getText();
		return text;

	}

	public void verifyCgstSgst() {
		driver.findElement(By.xpath("//div[contains(text(),'18% IGST')]")).isDisplayed();
		// driver.findElement(By.xpath("//div[contains(text(),'9%
		// SGST')]")).isDisplayed();

	}

	public void verifysubTotal() {
		String subtotal = driver.findElement(By.xpath("//div[2]/div[1]/div[1]/div[4]/div[2]/div[1]")).getText();
		System.out.println("subtotal" + subtotal);

	}

	public void verifyBillTo() {
		driver.findElement(By.xpath("//*[normalize-space()='Bill to']")).isDisplayed();
	}

	public void verifyshipTo() {
		WebElement block = driver.findElement(By.xpath("//div[@class='delivery-add-wrap']"));
		block.findElement(By.xpath("(//label[normalize-space()='Ship to'])[1]")).isDisplayed();
		driver.findElement(By.xpath("//*[normalize-space()='Bill to']")).isDisplayed();
	}

	public void changeAddress() throws InterruptedException {
		Thread.sleep(2500);
		driver.findElement(By.xpath("//a[normalize-space()='Change address']")).click();
	}

	public void addNewAddress() {
		driver.findElement(By.xpath("//*[contains(text(),'Add new')]")).click();
	}

	public void fillAddressInformation() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("companyname1");
		driver.findElement(By.xpath("//input[@id='addressLineOne']")).sendKeys("address1");
		driver.findElement(By.xpath("//input[@id='pincode']")).sendKeys("753010");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("cuttack");
		//driver.findElement(By.xpath("(//input[@id='defaultAddress'])[2]")).click();

		ElementUtil.zoomout();
		driver.findElement(By.xpath("(//button[@id='save-change'])[2]")).click();
		Thread.sleep(6000);
	}

	public void clickNewlycreatedAddress() {
		driver.findElement(By.xpath("(//div[normalize-space()='Companyname1'])[1]")).click();
	}

	public void clickDeliverHere() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='button primary-btn large-btn w-50 s-ml-10']")).click();
		ElementUtil.Esc();
	}

	public void editAddress() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[contains(text(),'Companyname1')]//following::img[starts-with(@class,'option')])[1]")).click();
		driver.findElement(By.xpath(" //*[contains(text(),'Edit')]")).click();
		driver.findElement(By.xpath("//input[@id='mobile']")).clear();
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("8090909009");
		ElementUtil.zoomout();
		driver.findElement(By.xpath("(//button[@id='save-change'])[2]")).click();
		Thread.sleep(6000);

	}
	public void removeAddress() throws InterruptedException, AWTException {
		Thread.sleep(3500);
		driver.findElement(By.xpath("(//*[contains(text(),'Companyname1')]//following::img[starts-with(@class,'option')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Remove address')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[contains(text(),'Proceed')])[3]")).click();
		Thread.sleep(6000);
	

	}

}
