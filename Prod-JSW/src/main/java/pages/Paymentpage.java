package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Paymentpage {

	private WebDriver driver;
	private By quantity = By.xpath("//input[@class='input-quant']");
	private By alldimensions = By.xpath("//li[contains(@class,'product-list')]");
	private By buynow = By.xpath("//*[text()='Buy now']");
	private By payViaNetBanking = By.xpath(
			"//div[@id='pay-via-section-desktop']//button[@class='pay-via-netbanking-button'][normalize-space()='Pay via netbanking']");
	private By proceedtopay = By.xpath("//button[@class='proceed-to-pay primary']");
	// private By proceedtopay = By.xpath("//button[@class='btn m-3
	// purchase-button']");
	// private By banklist = By.xpath("//select[@id='BanksList']");
	private By banklistnew = By.xpath("//select[@id='banks']");
	private By remove = By.xpath("//span[text()='Remove']");
	// private By confirmremove = By.xpath("//input[@class='remove_item_btn']");
	private By confirmremove = By.xpath("//div[@class='remove_item_btn_b']/button");
	private By messagecartempty = By.xpath("//div[@class='empty-content text-center']");
	// private By count1 = By.xpath("//div[@class='count' and text()=1]");
	private By cartcount = By.xpath("//div[@class='count']");
	private By productselect = By.xpath("//div[@class='product-plp1 col-sm-12 col-xxl-4']");
	private By payNow = By.xpath("//span[contains(text(),'Proceed to pay')]");
	private By Success = By.xpath("//button[@class='success']");
	private By successmessage = By.xpath("//div[contains(text(),'Payment successful')]");
	private By unsuccessmessage = By.xpath("//div[@class='alert alert-danger error-alert']");
	private By user = By.xpath("//div[@class='drop-down-whole']");
	private By UTR = By.xpath("//div[@class='utr-field']/input");
	private By confirmPayment = By.xpath("//button[@class='bold-text confirm-btn primary']");
	private By error = By.xpath("//span[text()=' Enter a valid UTR number.']");
	private By error2 = By.xpath("//span[contains(text(),'Special characters are not allowed.')]");
	private By netbankingdisabled = By.xpath("//a[@aria-disabled='true'][(text()='Net banking')]");
	private By neftsuccessmessage = By.xpath("//div[text()='Thanks for confirming payment']");
	private By proceedtopaypmtpage = By.xpath("//span[text()='Proceed to pay']");
	private By myCart = By.xpath("//a[contains(text(),'My cart')]");

	private By confirmlater = By.xpath("//*[@id=\'no-confirm-btn\']");
	private By pendingmessage = By.xpath("//*[contains(text(),'Your order is awaiting payment')]");
	private By makepayment = By.xpath(
			"//div[@id='pay-via-section-desktop']//button[@class='pay-via-netbanking-button'][normalize-space()='Pay via netbanking']");

	public Paymentpage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickBuyNow() {

		driver.findElement(buynow).click();

	}

	public void clickSelfPickup() {

		driver.findElement(By.xpath("//input[@id='Pickuprom']")).click();

	}

	public void verifyPickupFrom() {

		driver.findElement(By.xpath(
				"//*[contains(text(),'Pickup address will be available before the shipment is ready for pickup')]"))
				.isDisplayed();

	}

	public void validatecartdetailpage() {

		driver.findElement(proceedtopay).isDisplayed();
	}

	public void scroll() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,500)", "");
	}

	public void clickproceedtopay() {

		driver.findElement(proceedtopay).click();
	}

	public void clickpayViaNetBanking() throws InterruptedException {

		driver.findElement(payViaNetBanking).click();
		Thread.sleep(15000);
	}

	public void validateBankList() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(banklistnew).isDisplayed();
	}

	public void clickBankList() throws InterruptedException {
		Thread.sleep(3000);
		WebElement dropdown = driver.findElement(banklistnew);
		Select select = new Select(dropdown);
		select.selectByVisibleText("HDFC Bank");

	}

	public void validateBankSelected() {
		// driver.findElement(banklist).isSelected();
	}

	public void deleteProductfromCart() throws Exception

	{

		driver.findElement(cartcount).click();
		driver.findElement(By.xpath("//span[contains(text(),'Clear cart')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='clear-cart-cnf']")).click();

		/*
		 * 
		 * 
		 * driver.findElement(cartcount).click();
		 * 
		 * while (!isElementPresentemptycart()) {
		 * 
		 * driver.findElement(By.xpath("//span[contains(text(),'Clear cart')]")).click()
		 * ; Thread.sleep(2000); //driver.findElement(confirmremove).click();
		 * //Thread.sleep(4500); }
		 */

	}

	public void deleteDirectOrderProductfromCart() throws Exception

	{

		driver.findElement(cartcount).click();
		driver.findElement(By.xpath("//span[contains(text(),'Clear cart')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='clear-cart-cnf']")).click();

		while (!isElementPresentemptycart()) {

			/*
			 * driver.findElement(By.xpath("(//a[@role='button'])")).click();
			 * driver.findElement(By.xpath("(//span[text()='Remove'])")).click();
			 * Thread.sleep(2000); //
			 * driver.findElement(By.xpath("//button[@class='remove_item_btn primary']")).
			 * click();
			 * driver.findElement(By.xpath("//span[text()='Remove item']")).click();
			 * Thread.sleep(2000);
			 * 
			 */

		}

	}

	public boolean isElementPresent() throws Exception {
		try {
			driver.findElement(cartcount);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isElementPresentemptycart() throws Exception {
		try {
			driver.findElement(messagecartempty);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void selectDimension() throws InterruptedException {
		List<WebElement> alldimensions2 = driver.findElements(alldimensions);
		int i = driver.findElements(alldimensions).size();
		System.out.println(i);
		// Thread.sleep(3000);
		alldimensions2.get(5).click();
		alldimensions2.get(10).click();
		alldimensions2.get(7).click();
		// alldimensions2.get(8).click();

	}

	public void selectDimensionreguser2() throws InterruptedException {
		List<WebElement> alldimensions2 = driver.findElements(alldimensions);
		int i = driver.findElements(alldimensions).size();
		System.out.println(i);
		Thread.sleep(3000);
		// alldimensions2.get(9).click();
		alldimensions2.get(i - 7).click();
		// alldimensions2.get(13).click();
		alldimensions2.get(i - 3).click();
		// alldimensions2.get(15).click();
		alldimensions2.get(i - 1).click();

	}

	public void enterQuantity3() throws InterruptedException {

		driver.findElement(quantity).sendKeys("3");
		Thread.sleep(3000);

	}

	public void enterQuantity30() throws InterruptedException {

		driver.findElement(quantity).sendKeys("30");
		Thread.sleep(3000);

	}

	public void selectProduct() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> productselected = driver.findElements(productselect);

		productselected.get(0).click();
	}

	public void selectBank() throws InterruptedException {
		Thread.sleep(3000);
		Select bank = new Select(driver.findElement(By.id("banks")));
		bank.selectByVisibleText("HDFC Bank");

	}

	public void selectBankNew() throws InterruptedException {
		Thread.sleep(3000);
		Select bank = new Select(driver.findElement(banklistnew));
		bank.selectByVisibleText("HDFC Bank");

	}

	public void clickPayNow() {
		driver.findElement(payNow).click();

	}

	public void clickPaymentSucess() {
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		driver.switchTo().window(ar.get(1));
		driver.findElement(By.xpath("//button[@class='success']")).click();

	}

	public void clickPaymentFailure() {
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		driver.switchTo().window(ar.get(1));
		driver.close();

	}

	public String validateRazorpayPage() throws InterruptedException

	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windows = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		windows.remove(parent);
		Iterator<String> it = windows.iterator();
		String child = null; // This is for referencing specific child window
		while (it.hasNext()) {
			child = (String) it.next();
			driver.switchTo().window(child);

		}
		Thread.sleep(4000);
		String title = driver.getTitle();
		System.out.print("poltu" + title);
		return title;

	}

	public void validateOrderSuccessfulmsg() {

		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		driver.switchTo().window(ar.get(0));
		driver.navigate().refresh();
		driver.findElement(successmessage).isDisplayed();

	}

	public void validateunsuccessfulmsg() {

		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		driver.switchTo().window(ar.get(0));
		driver.findElement(unsuccessmessage).isDisplayed();

	}

	public void enterUTR(String UTRnumber) {
		driver.findElement(UTR).clear();
		driver.findElement(UTR).sendKeys(UTRnumber);
	}

	public void validateConfirmPayment(String UTRnumber2) throws InterruptedException {
		if (UTRnumber2.matches("^[a-zA-Z0-9]{1,15}$")) {
			System.out.println("Second");
			driver.findElement(error).isDisplayed();

		} else if (UTRnumber2.matches("^[a-zA-Z]+[0-9]+{16,22}$")) {
			System.out.println("First");
			driver.findElement(confirmPayment).isEnabled();
			Thread.sleep(2000);
			System.out.println(UTRnumber2.matches("^[a-zA-Z]+[0-9]+{16,22}$"));
			driver.findElement(confirmPayment).click();

		}

		else if (UTRnumber2.matches("^[0-9]+{1,22}$")) {
			System.out.println("Third");
			driver.findElement(error2).isDisplayed();

		} else if (UTRnumber2.matches("^[a-zA-Z]+{1,22}$")) {
			System.out.println("Fourth");
			driver.findElement(error2).isDisplayed();
		}

	}

	public String validateConfirmPayment2(String UTRnumber2) throws InterruptedException {
		if (UTRnumber2.matches("^[a-zA-Z0-9]{1,15}$")) {
			System.out.println("Second");
			return driver.findElement(error).getText();

		} else if (UTRnumber2.matches("^[a-zA-Z]+[0-9]+{16,22}$")) {
			System.out.println("First");
			driver.findElement(confirmPayment).isEnabled();
			Thread.sleep(2000);
			System.out.println(UTRnumber2.matches("^[a-zA-Z]+[0-9]+{16,22}$"));
			driver.findElement(confirmPayment).click();

		}

		else if (UTRnumber2.matches("^[0-9]+{1,22}$")) {
			System.out.println("Third");
			return driver.findElement(error2).getText();

		} else if (UTRnumber2.matches("^[a-zA-Z]+{1,22}$")) {
			System.out.println("Fourth");
			return driver.findElement(error2).getText();
		}
		return driver.findElement(error).getText();

	}

	public void validateNEFTSuccessMessage() {
		driver.findElement(neftsuccessmessage).isDisplayed();
	}

	public void clickNEFT() throws InterruptedException {
		// driver.findElement(netbankingdisabled).isDisplayed();
		driver.findElement(By.linkText("NEFT/RTGS")).click();
		Thread.sleep(2500);

	}

	public void clickConfirmPayment() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(confirmPayment).click();
	}

	public void clickProceedToPayPMTPage() {

		driver.findElement(proceedtopaypmtpage).click();
	}

	public void clickLogOut() throws InterruptedException {

		driver.findElement(user).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[text()='Logout']")).click();
		Thread.sleep(3000);
	}

	public boolean isElementPresentcart() throws Exception {
		try {
			driver.findElement(cartcount);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void deleteProductfromCartdo() throws Exception

	{

		driver.findElement(cartcount).click();
		Thread.sleep(3000);
		driver.findElement(myCart).click();
		while (!isElementPresentemptycart()) {

			driver.findElement(remove).click();
			Thread.sleep(2000);
			driver.findElement(confirmremove).click();
			Thread.sleep(2000);
		}
	}

	public void clickConfirmLater() {
		driver.findElement(confirmlater).isDisplayed();
		driver.findElement(confirmlater).click();
	}

	public void validatePaymentPendingmsg() {
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		driver.switchTo().window(ar.get(0));
		driver.findElement(pendingmessage).isDisplayed();
	}

	public void validateMakePayment() {
		driver.findElement(makepayment).isDisplayed();
	}

}
