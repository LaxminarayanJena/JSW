package com.jswone.msme.oms.pages;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jswone.msme.oms.util.ElementUtil;

public class SFPage {

	private WebDriver driver;
	public static String SFOrderNo;

	private By username = By.xpath("//input[@id='username']");
	private By passwordTextBox = By.xpath("//input[@id='password']");
	private By LoginBtn = By.xpath("//input[@id='Login']");
	private By spinnerWheel = By.xpath("(//div[@class='spinner'])[2]");
	private By sourceSellerQuote = By.xpath("//label[text()='Source Seller Quote']/following::input");
	private By OrderTab = By.xpath("//a[contains(text(),'Order')]");
	private By OrderNo = By.xpath("//span[@title='Order Number']//following::div[7]//a");
	private By quickOpportunity = By.xpath("//button[normalize-space()='Quick Opportunity']");
	private By sucessMsg = By.xpath("//*[text()='Success']");
	private By saveBtn = By.xpath("(//button[text()='Save'])[2]");
	private By processOpportunityBtn = By.xpath("//button[text()='Process Opportunity']");
	private By DeleteCartBtn = By.xpath("//button[text()='Delete Cart']");
	private By ActionBtn = By.xpath(
			"//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']");

	private By sucessOrderCreatedMsg = By
			.xpath("//*[contains(text(),'Order is created successfully with Order Number')]");

	
	public SFPage(WebDriver driver) {
	
		this.driver = driver;
	}

	public void goToSF() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jswoneplatforms--prdreplica.sandbox.lightning.force.com/lightning/page/home");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(username).sendKeys("v_laxminarayan.jena@jsw.in");
		driver.findElement(passwordTextBox).sendKeys("Ramya@123");
		driver.findElement(LoginBtn).click();
		Thread.sleep(4000);

	}

	public void goToAccounts() {
		driver.get(
				"https://jswoneplatforms--prdreplica.sandbox.lightning.force.com/lightning/r/Account/0019D00000TfVQ0QAN/view");
		// driver.get("https://jswoneplatforms--prdreplica.sandbox.lightning.force.com/lightning/r/Account/0019D00000RMEvhQAH/view");

	}

	public void clickNewOpportunity() {
		ElementUtil wt = new ElementUtil(driver);
		driver.navigate().refresh();
		wt.WaitUtilClickable(quickOpportunity);
		driver.findElement(quickOpportunity).click();
	}

	public void fillSKURequirementDetails() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//button[@title='Add']//lightning-primitive-icon")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search Products...']"))
				.sendKeys("MS HR Sheet 2062:2011 E250A");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@placeholder='Search Products...']")).click();
		Thread.sleep(4000);
		ElementUtil.DoubleKeyDownEnter();
		driver.findElement(By.xpath("(//label[text()='Primary Revised Quantity']/following::input)[1]")).sendKeys("7");
		driver.findElement(By.xpath("(//label[text()='Thickness (mm)']/following::input)[1]")).sendKeys("2");
		driver.findElement(By.xpath("//label[text()='Length (mm)']/following::input")).sendKeys("1500");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement elemnt = driver.findElement(By.xpath("(//button[text()='Save'])[2]"));
		je.executeScript("arguments[0].scrollIntoView(true);", elemnt);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		ElementUtil wt = new ElementUtil(driver);
		//wt.WaitUtilElementInvisible(spinnerWheel);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Process Opportunity']")).click();
		driver.findElement(By.xpath("(//button[@title='Show More'])[1]")).click();
		driver.findElement(By.xpath("//button[@aria-label='Delivery Instructions, Select Delivery Instructions']"))
				.click();
		driver.findElement(By.xpath("//*[text()='Self pickup']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Sales Requested Timeline, --None--']")).click();
		driver.findElement(By.xpath("//*[text()='2 days']")).click();
		driver.findElement(By.xpath("(//label[text()='Advance %']/following::input)[1]")).sendKeys("45");
		//driver.findElement(By.xpath("((//label[text()='Cashback rate'])[2]/following::input)[1]")).sendKeys("200");
		driver.findElement(
				By.xpath("(//label[text()='Special delivery instructions (Flows in PI)']/following::input)[1]"))
				.sendKeys("advance");
		driver.findElement(By.xpath("(//label[text()='Width (mm)']/following::input)[1]")).sendKeys("1500");

		driver.findElement(By.xpath("(//label[text()='Final Distributor Quote']/following::input)[1]"))
				.sendKeys("40000");

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Source Seller Name'])//following::div[1]//input"))
				.sendKeys("JSW Steel Vijayanagar");
		ElementUtil.DoubleKeyDownEnter();

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//label[text()='Seller Name'])//following::div[1]//input"))
				.sendKeys("JSW Steel Vijayanagar");
		ElementUtil.DoubleKeyDownEnter();
		wt.WaitUntilVisible(sourceSellerQuote);
		wt.WaitUntilVisible(sourceSellerQuote);
		driver.findElement(By.xpath("//label[text()='Source Seller Quote']/following::input")).sendKeys("40000");
		driver.findElement(By.xpath("//label[text()='Source Seller Quote']/following::input")).click();

		WebElement Saveelemnt = driver.findElement(By.xpath("(//button[text()='Save'])[2]"));
		je.executeScript("arguments[0].scrollIntoView(true);", Saveelemnt);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		// driver.findElement(By.xpath("//input[@name='Delivery_Timeline__c']")).sendKeys("2");

		wt.WaitUntilVisible(sucessMsg);

		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Move to awaiting documents']")).click();
		wt.WaitUntilVisible(sucessMsg);
		wt.WaitUntilVisible(saveBtn);
		Thread.sleep(14000);

		/*
		 * driver.findElement(By.
		 * xpath("//lightning-formatted-text[text()='Awaiting documents']//following::span[1]"
		 * )) .click(); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//span[text()='Awaiting documents']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//span[text()='Awaiting Payment']")).click();
		 * Thread.sleep(4000);
		 */
		driver.findElement(saveBtn).click();
		Thread.sleep(6000);

		System.out.println(driver.getCurrentUrl());
		WebElement tdcElement = driver.findElement(By.xpath("(//span[text()='NCO opportunity'])[1]"));
		je.executeScript("arguments[0].scrollIntoView(true);", tdcElement);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Edit TDC required?']//span[1]")).click();
		Thread.sleep(2000);
		WebElement tdcElement2 = driver.findElement(By.xpath("//label[text()='Call Comments']"));
		je.executeScript("arguments[0].scrollIntoView(true);", tdcElement2);
		WebElement tdcElement1 = driver
				.findElement(By.xpath("(//span[text()='TDC required?']/following::input)[1]"));
		tdcElement1.click();
		WebElement AdvancePayment = driver.findElement(By.xpath("//span[text()='Direct Opportunity']"));
		je.executeScript("arguments[0].scrollIntoView(true);", AdvancePayment);
		driver.findElement(By.xpath("(//label[text()='Advance Value']/following::input)[1]")).clear();
		driver.findElement(By.xpath("(//label[text()='Advance Value']/following::input)[1]")).sendKeys("15000");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		wt.WaitUtilElementInvisible(spinnerWheel);
		wt.WaitUtilClickable(processOpportunityBtn);
		driver.findElement(By.xpath("//button[text()='Process Opportunity']")).click();
		driver.findElement(By.xpath("(//label[text()='Delivery Timeline']/following::input)[1]")).sendKeys("2");
		WebElement saveBtn = driver.findElement(By.xpath("(//button[text()='Save'])[2]"));
		je.executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		saveBtn.click();
		wt.WaitUtilElementInvisible(spinnerWheel);
		Thread.sleep(8000);
		saveBtn.click();
		wt.WaitUtilElementInvisible(spinnerWheel);
		// wt.WaitUtilClickable(processOpportunityBtn);
		Thread.sleep(2000);
		wt.scrollUp();
		WebElement EndElement = driver.findElement(By.xpath("//button[@title='Edit Payment Type']//span[1]"));
		je.executeScript("arguments[0].scrollIntoView(true);", EndElement);
		driver.findElement(By.xpath("//button[@title='Edit Payment Type']//span[1]")).click();
		driver.findElement(By.xpath("//label[text()='Payment Type']/following::div[4]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[text()='Cash & Carry - Advance']")).click();
		wt.scrollUp();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//span[text()='Awaiting documents'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Awaiting Payment']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(24000);
		driver.findElement(By.xpath("//button[text()='Create Order']")).click();
		Thread.sleep(25000);
		wt.WaitUtilClickable(DeleteCartBtn);

	}

	public String orderDetails() throws InterruptedException {
		
		ElementUtil wt = new ElementUtil(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='Create Order'])[2]")).click();
		wt.WaitUntilVisible(sucessOrderCreatedMsg);
		Thread.sleep(4000);
		wt.scrollUp();
		driver.findElement(OrderTab).click();
		Thread.sleep(4000);
		SFOrderNo = driver.findElement(OrderNo).getAttribute("title");
		System.out.println("Order No" + SFOrderNo);
		return SFOrderNo;
	}
	
	public String extractSFOrderNo()
	{
		return SFOrderNo;
	}
	

	public void closeRestTabs() {
		try {
			String currentTabId = driver.getWindowHandle();
			java.util.Set<String> allTabIds = driver.getWindowHandles();
			for (String tabId : allTabIds) {
				if (!tabId.equals(currentTabId)) {
					driver.switchTo().window(tabId);
					driver.close();
				}
			}
			driver.switchTo().window(currentTabId);
		} catch (Exception e) {
		}

	}

	public void approvePayment() throws InterruptedException {
		goToSF();
		driver.get(
				"https://jswoneplatforms--prdreplica.sandbox.lightning.force.com/lightning/o/ProcessInstanceWorkitem/list?filterName=00B5g00000GiocQEAR");
		ElementUtil wt = new ElementUtil(driver);
		wt.WaitUtilClickable(ActionBtn);
		driver.findElement(By.xpath(
				"//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']"))
				.click();
		driver.findElement(By.xpath("//a[@title='Approve']")).click();
		driver.findElement(By.xpath("(//*[text()='Approve'])[1]")).click();
		Thread.sleep(9000);
	}
	
	


}
