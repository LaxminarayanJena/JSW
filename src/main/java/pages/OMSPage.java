package pages;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import util.ElementUtil;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class OMSPage {

	private WebDriver driver;

	private By googleLogin = By.xpath("//*[text()='Login with Google']");
	private By emailTextBox = By.xpath("//input[@type='email']");
	private By nextBtn = By.xpath("//span[normalize-space()='Next']");
	private By passwordBox = By.xpath("//input[@type='password']");
	private By TrackShipments = By.xpath("//button[normalize-space()='Track shipments']");
	String orderno = Paymentpage.orderno;

	public OMSPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToOMS() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://qa-oms.msme.jswone.in/");
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
		Thread.sleep(5000);

	}

	public void goToOMSShipmentPage() throws InterruptedException, AWTException {
		
		driver.get("https://qa-oms.msme.jswone.in/order-list/?filterValue=today");
		Thread.sleep(3000);
		String xpath1 = "//a[normalize-space()='";
		String xpath2 = "']";
		driver.findElement(By.xpath(xpath1 + orderno + xpath2)).click();
		Thread.sleep(3000);
		ElementUtil obj = new ElementUtil(driver);
		obj.SwitchWindow(1);

		driver.findElement(By.xpath("//*[text()='Shipments']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Create shipment']")).click();

		Thread.sleep(3000);
		
		
	}
	
	public void createCompletedShipment() throws InterruptedException, AWTException
	{
		driver.findElement(By.xpath("(//*[text()='Seller name'])[1]//parent::div[1]")).click();
		driver.findElement(By.xpath("(//li[@role='option'])[1]")).click();

		String totalOrderqty = driver.findElement(By.xpath("//*[text()='Total order qty']//following::td[2]"))
				.getText();

		String totalOrderqtynumber = totalOrderqty.substring(0, totalOrderqty.indexOf(" "));
		System.out.println("totalOrderqty" + totalOrderqtynumber);
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[text()='Quantity']//following::td[4]//input")).sendKeys(totalOrderqtynumber);

		driver.findElement(By.xpath("(//*[text()='Scheduled dispatch date'])[1]//following::div[1]//input"))
				.sendKeys(ElementUtil.date(2));
		

		driver.findElement(By.xpath("//span[normalize-space()='Delivery type']//following::div[1]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Delivery']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[normalize-space()='Shipment no.']")).click();
		driver.findElement(By.xpath("((//*[text()='Planned'])[2]//parent::div[1])[1]")).click();
		driver.findElement(By.xpath("//*[text()='Ready for dispatch']")).click();
		driver.findElement(By.xpath("(//*[text()='Dispatch date'])[2]//following::div[1]//input"))
				.sendKeys(ElementUtil.date(2));
		driver.findElement(By.xpath("//*[text()='Delivery date']//following::div[1]//input")).sendKeys(ElementUtil.date(4));
		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();

		driver.findElement(By.xpath("//*[text()='Shipment status']//following::div[1]")).click();
		driver.findElement(By.xpath("//*[text()='Dispatched']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();

		driver.findElement(By.xpath("//*[text()='Shipment status']//following::div[1]")).click();
		driver.findElement(By.xpath("//*[text()='Delivered']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();

		driver.findElement(By.xpath("//*[text()='Shipment status']//following::div[1]")).click();
		driver.findElement(By.xpath("//*[text()='Invoiced']")).click();

		driver.findElement(By.xpath("//*[text()='Invoice No.']//following::div[1]//input")).sendKeys("123");
		driver.findElement(By.xpath("//*[text()='Invoice No.']//following::div[3]//input")).sendKeys("123");

		driver.findElement(By.xpath("(//*[text()='Quantity invoiced']//following::div[3]//div[1]//input)[1]"))
				.sendKeys(totalOrderqtynumber);
		driver.findElement(By.xpath("(//*[text()='Quantity invoiced']//following::div[3]//div[1]//input)[2]"))
				.sendKeys(totalOrderqtynumber);

		driver.findElement(By.xpath("//*[text()='Invoice date']//following::div[1]//input")).sendKeys(ElementUtil.date(4));
		driver.findElement(By.xpath("//*[text()='Invoice date']//following::div[6]//input")).sendKeys(ElementUtil.date(4));

		Thread.sleep(5000);
		WebElement fileUploadButton = driver.findElement(By.xpath("//*[text()='Invoices']//following::div[1]//p"));
		fileUploadButton.click();

		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\invoice.pdf";
		ElementUtil.UploadFile(filePath);
		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
		Thread.sleep(10000);
		ElementUtil scrl = new ElementUtil(driver);
		scrl.scrollUp();

		driver.findElement(By.xpath("//*[text()='Shipment status']//following::div[1]")).click();
		driver.findElement(By.xpath("//*[text()='Completed']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Order details']")).click();

		Thread.sleep(5000);
		WebElement selectedOption = driver
				.findElement(By.xpath("//*[text()='Order status']//following::div[1]//input"));
		String selectedValue = selectedOption.getAttribute("value");
		;
		System.out.println("Order status" + selectedValue);
		String expectedValue = "Delivered";
		if (selectedValue.equals(expectedValue)) {
			System.out.println("Order status is correct ie Delivered");
		} else {
			System.out.println("Order status is incorrect is not delivered.");
		}
		
	}
	public void navigateToshipMentsPageCCP() throws InterruptedException
	{
		driver.get("https://qa-ssr.msme.jswone.in/order-summary?order_num="+orderno);
		Thread.sleep(5000);
		ElementUtil obj = new ElementUtil(driver);
//		obj.MigrationUtil(TrackShipments);
//		driver.findElement(By.xpath("//button[normalize-space()='Track shipments']")).click();
//		driver.findElement(By.xpath("//th[normalize-space()='Shipment ID']")).isDisplayed();
//		driver.findElement(By.xpath("//a[@class='typography-font-bold typography-text-primary-main']")).click();
//		Thread.sleep(5000);
		//driver.findElement(By.xpath("//p[normalize-space()='Delivered']")).isDisplayed();

	}
	
	public void navigateToViewDocuments() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[normalize-space()='View documents']")).click();
		driver.findElement(By.xpath("//*[@class='typography-sub-heading typography-md-h5 typography-font-semibold d-inline-block ml-2']")).click();
		Thread.sleep(5000);
	}

}
