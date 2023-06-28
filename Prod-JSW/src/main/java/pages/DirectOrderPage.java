package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class DirectOrderPage {
	private WebDriver driver;

	private By alldimensions = By.xpath("//li[contains(@class,'product-list')]");
	private By quantity = By.xpath("//input[@class='input-quant']");
	private By buyfromverified = By.xpath("//span[contains(text(),'Buy from verified sellers')]");
	private By directlyfromJSW = By.xpath("//span[contains(text(),'Buy directly from')]");
	private By myrequirements = By.xpath("(//a[@class='links'])[2]");
	private By requestprice = By.xpath("//span[normalize-space()='Request for price']");
	private By viewrequirementlist = By.xpath("//*[contains(text(),'Requirements cart')]");
	private By requestforprice = By.xpath("//span[contains(text(),'Request for price')]");
	private By requirementTab = By.xpath("(//a[@role='tab'])[1]");
	private By quantitybutton = By.xpath("//button[@class='btn btn-quant']");
	private By message = By.xpath("(//*[@class='mt-14'])[1]");
	private By deliverydate = By.xpath("(//*[text()='Delivery in 30 - 45 days'])[1]");
	private By clickpasswordNext = By.xpath("//*[@id='passwordNext']/div/button/span");
	private By uploadFiles = By.xpath("(//span[contains(text(),'Upload files')])[1]");
	private By proceedtopaytop = By.xpath("//button[@id='oi-proceed-to-pay-notification']");
	private By myCart = By.xpath("//a[contains(text(),'My Cart')]");
	private By cartlogo = By.xpath("(//img[@alt='cart'])[1]");
	private By proceedtopay = By.xpath("//button[@class='proceed-to-pay primary']");
	private By confirmPayment = By.xpath("(//button[@id='confirm-btn'])[1]");
	private By makePayment = By.xpath("//button[@id='confirm-btn-payment-indicator']");
	private By paymentSuccessful = By.xpath("//div[contains(text(),'Thanks for confirming payment')]");
	private By myOrder = By.xpath("//a[contains(text(),'My orders')]");
	private By orderNo = By.xpath("(//span[@class='label-field-value'])[1]");
	private By viewOrderDetailsLink = By.xpath("(//div[@class='view-details mt-0'])[1]");
	private By paymentStatus = By.xpath("(//span[@class='label-field-value'])[3]");
	private By merchantEmail = By.xpath("//input[@name='email']");
	private By merchantPassword = By.xpath("//input[@name='password']");
	private By merchantloginButton = By.xpath("//span[contains(text(),'Sign in')]");
	private By cartcount = By.xpath("//div[@class='count']");
	// private By selectDev= By.xpath("(//div[@class='
	// css-d58yad-singleValue']/parent::div/div)[2]");
	private By remove = By.xpath("//a[@role='button']");
	private By confirmremove = By.xpath("//div[@class='remove_item_btn_b']//button");
	private By order = By.xpath("//div[contains(text(),'Orders')]");
	private By searchBox = By.xpath("//input[@name='search-text']");
	private By FirstOrderNo = By.xpath("//div[@data-testid= 'cell-0-orderNumber']");
	private By paymentstab = By.xpath("//*[contains(text(),'Payments')]");
	private By paymentId = By.xpath("//h4[contains(text(),'Payment #1')]/parent::span/div");

	public DirectOrderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validateBuyFromVerified() {
		driver.findElement(buyfromverified).isDisplayed();

	}

	public void clickonJswSteel() {
		driver.findElement(By.xpath("//span[contains(text(),'Buy directly from')]")).click();

	}

	public boolean isElementPresentcart() throws Exception {
		try {
			driver.findElement(cartcount);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void deleteProductfromCart() throws Exception

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

	public void clickpasswordNext() {
		driver.findElement(clickpasswordNext).click();
	}

	public void goToGoogleCloud() {
		// driver.get(
		// "https://console.cloud.google.com/storage/browser/data-importer-bucket-qa/new/cart;tab=objects?pageState=(%22StorageObjectListTable%22:(%22f%22:%22%255B%255D%22))&project=modular-bucksaw-305821&prefix=&forceOnObjectsSortingFiltering=false&pli=1");

		// driver.get("https://console.cloud.google.com/storage/browser/data-importer-bucket-qa-1/new/cart?pageState=(%22StorageObjectListTable%22:(%22f%22:%22%255B%255D%22))&prefix=&forceOnObjectsSortingFiltering=false");

		driver.get(
				"https://console.cloud.google.com/storage/browser/data-importer-bucket-prod/new/cart;tab=objects?project=modular-bucksaw-305821&pageState=(%22StorageObjectListTable%22:(%22f%22:%22%255B%255D%22))&prefix=&forceOnObjectsSortingFiltering=false");
	}

	public void gotoGoogleCloudforTransaction() {

		driver.get(
				"https://console.cloud.google.com/storage/browser/data-importer-bucket-prod/new/transaction;tab=objects?pageState=(%22StorageObjectListTable%22:(%22f%22:%22%255B%255D%22))&project=modular-bucksaw-305821&prefix=&forceOnObjectsSortingFiltering=false");
	}

	public void gotoGoogleCloudforPayment() {
		driver.get(
				"https://console.cloud.google.com/storage/browser/data-importer-bucket-prod/new/payment;tab=objects?pageState=(%22StorageObjectListTable%22:(%22f%22:%22%255B%255D%22))&project=modular-bucksaw-305821&prefix=&forceOnObjectsSortingFiltering=false");
	}

	public void clickUploadFiles() {

		driver.findElement(uploadFiles).click();
	}

	public static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public void uploadFile() throws AWTException, InterruptedException {
		Thread.sleep(38000);
		driver.findElement(uploadFiles).click();
		setClipboardData(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\cartimport.xlsx");

		Robot robot = new Robot();
		robot.delay(2000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(8000);
	}

	public void validateProceedtoPaytop() {
		driver.findElement(proceedtopaytop).isDisplayed();
	}

	public void clickProceedtoPaytop() {
		driver.findElement(proceedtopaytop).click();
	}

	public void clickMyCart() {

		driver.findElement(myCart).click();

	}

	public void clickCartLogo() {
		driver.findElement(cartlogo).click();
	}

	public void clickProceedtoPay() {

		driver.findElement(proceedtopay).click();
	}

	public void clickConfirmPayment() {
		driver.findElement(confirmPayment).click();

	}

	public void clickmakePayment() {

		driver.findElement(makePayment).click();
	}

	public void validatePaymentSuccessful() {

		driver.findElement(paymentSuccessful).isDisplayed();
	}

	public void clickBuyFromVerified() {
		driver.findElement(buyfromverified).click();

	}

	public void validateDirectlyfromJSW() {
		driver.findElement(directlyfromJSW).isDisplayed();
	}

	public void clickDirectlyfromJSW() {

		driver.findElement(directlyfromJSW).click();
	}

	public void validateMyRequirements() {
		driver.findElement(myrequirements).isDisplayed();
	}

	public void enterQuantity50() throws InterruptedException {

		driver.findElement(quantity).sendKeys("50");
		Thread.sleep(3000);

	}

	public void validateRequestPrice() {

		driver.findElement(requestprice).isDisplayed();
	}

	public void clickRequestPrice() {

		driver.findElement(requestprice).click();
	}

	public void validateViewRequirementList() {

		driver.findElement(viewrequirementlist).isDisplayed();

	}

	public void clickViewRequirementsList() {

		driver.findElement(viewrequirementlist).click();
	}

	public void clickQuantity() {
		driver.findElement(quantitybutton).click();

	}

	public void validateRequestforPrice() {
		driver.findElement(requestforprice).isDisplayed();
	}

	public void clickRequestforPrice() {
		driver.findElement(requestforprice).click();
	}

	public void validateRequirementTab() {

		driver.findElement(requirementTab).isDisplayed();

	}

	public void clickRequirementTab() {
		driver.findElement(requirementTab).click();

	}

	public void validateMessage() {
		driver.findElement(message).isDisplayed();
	}

	public void clickMyRequirements() {
		driver.findElement(By.xpath("//a[text()='My requirements']")).click();
	}

	public boolean validateEmptyRequirement() throws Exception {

		if (isElementAvailable("//*[text()='Requirement list (1 Item)']")) {
			System.out.print("requirement list has not been emptied");
			return false;
		} else {
			System.out.print("requirement list has  been emptied");
			return true;
		}

	}

	public void clickRemoveButton() throws Exception {

		List<WebElement> lt = driver.findElements(By.xpath("//div[@class='product-name-price']//div[2]//div"));
		for (int i = 0; i < lt.size(); i++) {
			driver.findElement(By.xpath("//div[@class='product-name-price']//div[2]//div")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Proceed']")).click();
			Thread.sleep(2000);
		}

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

	// driver.findElement(By.xpath("(//a[@role='button'])")).isDisplayed();
	public boolean isElementPresent() throws Exception {
		try {
			driver.findElement(By.xpath("(//a[@role='button'])"));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isElementPresentemptycart() throws Exception {
		try {
			driver.findElement((By.xpath("//div[@class='empty-content text-center']")));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public String validateDeliveryDate() {
		return driver.findElement(deliverydate).getText();

	}

	public String validateAddToRequirementCart() {
		String txt = driver.findElement(By.xpath("(//span[contains(text(),'Add to requirements cart')])[1]")).getText();
		System.out.println(txt);
		return txt;

	}

	public void clickAddToRequirementCart() {
		driver.findElement(By.xpath("(//span[contains(text(),'Add to requirements cart')])[1]")).click();

	}

	public void clickViewRequirementCart() {
		driver.findElement(By.xpath("(//span[contains(text(),'View requirements cart')])[1]")).click();

	}

	public void enterHRDimension() throws InterruptedException {

		List<WebElement> alldimensions2 = driver.findElements(alldimensions);
		int i = driver.findElements(alldimensions).size();
		System.out.println("The HR size is " + i);
		alldimensions2.get(5).click();
		Thread.sleep(1000);
		alldimensions2.get(16).click();
		alldimensions2.get(19).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='input-quant']")).sendKeys("1234");
		Thread.sleep(3000);

	}

	public void refreshHomepage() {

		driver.navigate().refresh();
	}

	public boolean isElementPresent2() {
		try {
			driver.findElement(proceedtopaytop);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickMyOrder() {
		driver.findElement(myOrder).click();
	}

	public void clickViewOrderDetails() {

		driver.findElement(viewOrderDetailsLink).click();
	}

	public String getOrderNo() {
		System.out.println("Order no. " + driver.findElement(orderNo).getText());
		return driver.findElement(orderNo).getText();
	}

	public String getpaymentStatus() {
		return driver.findElement(paymentStatus).getText();
	}

	public String getOrderID() {
		String strurl = driver.getCurrentUrl();
		int startindex = strurl.indexOf('=');
		System.out.println("Order ID" + strurl.substring(startindex + 1));
		return strurl.substring(startindex + 1);

	}

	public void gotoMerchantCentre() {

		driver.get("https://mc.australia-southeast1.gcp.commercetools.com/one_ecom_dev/welcome");
	}

	public void loginMerchantCentre(String Email, String Password) throws InterruptedException {
		driver.findElement(merchantEmail).sendKeys(Email);
		Thread.sleep(1000);
		driver.findElement(merchantPassword).sendKeys(Password);
		Thread.sleep(1000);
		driver.findElement(merchantloginButton).click();

	}

	public void changeEnvironment() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[contains(@class,'control')])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='JSWOne MSME Prod']")).click();

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
		driver.findElement(By.xpath("//div[@data-testid='search-button']")).click();
		Thread.sleep(2000);
		driver.findElement(FirstOrderNo).click();
		Thread.sleep(10000);

	}

	public String getPaymentId() throws InterruptedException {
		driver.findElement(paymentstab).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(paymentId).getText());
		return driver.findElement(paymentId).getText();

	}

	FileInputStream fis;
	FileOutputStream fos;

	public void sendPaymentIdTransExcel(String PaymentId) throws IOException, AWTException {
		try {
			String strPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\TransactionDTO.xlsx";
			// Robot robot = new Robot();
			fis = new FileInputStream(strPath);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(1);
			XSSFCell cell = row.getCell(0);
			System.out.println("Payment Id is" + PaymentId);

			if (cell != null) {
				cell.setCellValue(PaymentId);
			} else {
				throw new Exception("Cell Exception.");
			}

			fos = new FileOutputStream(strPath);
			book.write(fos);

		} catch (Exception e) {
			System.out.println("ERROR : Not able to update the cell");
			e.printStackTrace();
		} finally {
			if (fis != null || fos != null) {

				fis.close();
				fos.flush();
				fos.close();
			}
		}

	}

	public void sendPaymentidOrderidPaymentExcel(String orderId, String PaymentId) throws IOException {

		try {
			String strPath2 = System.getProperty("user.dir")
					+ "\\src\\test\\resources\\testData\\Payment ImportDO1.xlsx";
			// Robot robot = new Robot();
			fis = new FileInputStream(strPath2);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(1);
			XSSFCell cell = row.getCell(0);
			XSSFCell cell1 = row.getCell(1);
			System.out.println("Payment Id is" + PaymentId);

			if (cell != null && cell1 != null) {
				cell.setCellValue(orderId);
				cell1.setCellValue(PaymentId);
			} else {
				throw new Exception("Cell Exception.");
			}

			fos = new FileOutputStream(strPath2);
			book.write(fos);

		} catch (Exception e) {
			System.out.println("ERROR : Not able to update the cell");
			e.printStackTrace();
		} finally {
			if (fis != null || fos != null) {

				fis.close();
				fos.flush();
				fos.close();
			}
		}

	}

	public void uploadTransactionfile() throws AWTException, InterruptedException {
		driver.findElement(uploadFiles).click();
		Thread.sleep(3000);
		setClipboardData(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\TransactionDTO.xlsx");

		Robot robot = new Robot();
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(4000);
	}

	public void uploadPaymentfile() throws AWTException, InterruptedException {
		driver.findElement(uploadFiles).click();
		Thread.sleep(3000);
		setClipboardData(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Payment ImportDO1.xlsx");

		Robot robot = new Robot();
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(4000);
	}

	public boolean isElementAvailable(String xpath) throws Exception {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
