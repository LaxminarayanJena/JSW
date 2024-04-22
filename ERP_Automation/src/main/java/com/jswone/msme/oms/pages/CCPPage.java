package com.jswone.msme.oms.pages;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jswone.msme.oms.util.ElementUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CCPPage {

	private WebDriver driver;
	public static String TodaysCountNo;
	public static String ccporderno;
	private By loginButton = By.xpath("//div[2]/div[1]/button[1]");
	private By loginByEmail = By.xpath("//button[contains(text(),'Login via email')]");
	private By email = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@type='password']");
	private By signIn = By.xpath("//button[@id='login-to-continue']");
	private By MyOrders = By.xpath("//a[contains(text(),'My orders')]");
	private By stainlessSteelMenu = By.xpath("//a[contains(text(),'Stainless Steel')]");
	private By addtocartbutton = By.xpath("//*[@id='product-add-to-cart']");
	private By cartcount = By.xpath("//div[@class='count']");
	private By cart1 = By.xpath("//div[@class='count' and contains(text(),\"1\")]");
	private By productselect = By.xpath("//a[@class='prod-plpimage1name']");
	private By cartPreview = By.xpath("//*[contains(text(),'Cart preview')]");
	private By Cart = By.xpath("//div[@class='count']");
	private By ViewCart = By.xpath("//btn[text()='View cart']");
	
	private By proceedtopay = By.xpath("//button[@class='proceed-to-pay primary']");
	private By payViaNetBanking = By.xpath(
			"//div[@id='pay-via-section-desktop']//button[@class='pay-via-netbanking-button'][normalize-space()='Pay via netbanking']");
	private By banklistnew = By.xpath("//select[@id='banks']");
	private By payNow = By.xpath("//span[contains(text(),'Proceed to pay')]");
	private By Success = By.xpath("//button[@class='success']");
	private By successmessage = By.xpath("//div[text()='Your order payment is successful']");
	public static String APIdisplayAmount;
	public static Response response;
	
	public CCPPage(WebDriver driver) {
		this.driver = driver;
	}


	public void goToCCP(String useremail) throws InterruptedException, IOException {
		ElementUtil util = new ElementUtil(driver);
		driver.get(ElementUtil.getGlobalValue("CCPUrl"));
		driver.manage().window().maximize();
		util.WaitUntilVisible(loginButton);
		driver.findElement(loginButton).click();
		driver.findElement(loginByEmail).click();
		driver.findElement(email).sendKeys(ElementUtil.getGlobalValue("ccpemail"));
		driver.findElement(password).sendKeys(ElementUtil.getGlobalValue("ccppassword"));
		driver.findElement(signIn).click();
		util.WaitUntilVisible(MyOrders);

	}

	public void addProduct() throws InterruptedException, AWTException {
		ElementUtil util = new ElementUtil(driver);
		if (util.isElementPresent("//div[@class='count']")) {
			driver.findElement(cartcount).click();
			driver.findElement(By.xpath("//span[contains(text(),'Clear cart')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='clear-cart-cnf']")).click();
		} else {
			System.out.println("No product added in cart");
		}
		driver.navigate().refresh();
		
		driver.get("https://qa-ssr.msme.jswone.in/product-detail/jsw-portland-slag-psc-cement");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("700");
		/*
		util.WaitUntilVisible(stainlessSteelMenu);
		WebElement we = driver.findElement(stainlessSteelMenu);
		we.click();
		util.WaitUntilVisible(productselect);
		driver.navigate().refresh();
		util.WaitUntilVisible(productselect);
		List<WebElement> productlist = driver.findElements(productselect);

		for (int i = 0; i < productlist.size(); i++) {
			System.out.println(productlist.get(i).getText());
			if (productlist.get(i).getText().equals("JSL stainless steel HRAP 304L N1 finish sheets")) {
				productlist.get(i).click();
				break;
			} else {

			}

		}
		driver.findElement(By.xpath("//div[contains(text(),'Thickness (mm)')]//following::div[3]//div//button[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Width (mm)')]//following::div[2]//div//button[1]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Length (mm)')]//following::div[2]//div//button[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("1");
		*/
		util.WaitUtilClickable(addtocartbutton);
		driver.findElement(addtocartbutton).click();
		Thread.sleep(5000);
		util.WaitUtilClickable(ViewCart);
		util.WaitUntilVisible(cartPreview);
		ElementUtil.Esc();
		driver.findElement(cartcount).isDisplayed();
		driver.findElement(cart1).isDisplayed();

	}
	
	public void createOrder() throws InterruptedException
	{
		ElementUtil util = new ElementUtil(driver);
		driver.findElement(Cart).click();
		Thread.sleep(4000);
		driver.findElement(proceedtopay).click();
		Thread.sleep(5000);
		util.WaitUtilClickable(payViaNetBanking);
		driver.findElement(payViaNetBanking).click();
		Thread.sleep(3000);
	}
	
	public void createOrderUsingLedgerBalance() throws InterruptedException
	{
		ElementUtil util = new ElementUtil(driver);
		driver.findElement(Cart).click();
		Thread.sleep(4000);
		driver.findElement(proceedtopay).click();
		Thread.sleep(5000);
	}
	
	public void clickPayViaNetBanking() throws InterruptedException
	{
		ElementUtil util = new ElementUtil(driver);
		util.WaitUtilClickable(payViaNetBanking);
		driver.findElement(payViaNetBanking).click();
		Thread.sleep(3000);
	}
	
	public void payUsingNetBanking() throws InterruptedException
	{
		WebElement dropdown = driver.findElement(banklistnew);
		Select select = new Select(dropdown);
		select.selectByVisibleText("ICICI Bank");
		driver.findElement(payNow).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windows = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		windows.remove(parent);
		Iterator<String> it = windows.iterator();
		String child = null; // This is for referencing specific child window
		while (it.hasNext()) {
			child = (String) it.next();
			driver.switchTo().window(child);
			driver.findElement(Success).isDisplayed();
		}
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		driver.switchTo().window(ar.get(1));
		driver.findElement(By.xpath("//button[@class='success']")).click();
	}
	
	public void validateOrderSuccessfulmsg() throws InterruptedException
	{
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		driver.switchTo().window(ar.get(0));
		Thread.sleep(3500);
		driver.findElement(successmessage).isDisplayed();
		ccporderno = driver.findElement(By.xpath("//div[normalize-space()='Order number']//following::div[1]")).getText();
		System.out.println(ccporderno);
	}
	
	public void navigateToOrderPage(String orderNo)
	{
		driver.get("https://qa-ssr.msme.jswone.in/order-summary?order_num="+orderNo);
	}
	
	public void goToCCPOrderinERP() throws InterruptedException
	{
		driver.get("https://qa-oms.msme.jswone.in/order-list/" + ccporderno);
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);

	}
	
public void validateOrderValueFromV2API() throws IOException {

		
		String bearerToken = ElementUtil.getGlobalValue("ERPbearerToken");

		String url = ElementUtil.getGlobalValue("omsUrl")+"oms/order/v2/number/" + ccporderno;
		System.out.println("api urL" +url);
		response = RestAssured.given().header("Authorization", "Bearer " + bearerToken).when().get(url).then()
				.statusCode(200).extract().response();
		APIdisplayAmount = ElementUtil.getJsonPath(response, "orderAmount.displayAmount");
		System.out.println("The DisplayAmount is - " + APIdisplayAmount);
		

	}
	public void validateV2OrderDetailsAPIContract(String jsonName) throws FileNotFoundException
	{
		System.out.println("poltua");
		System.out.println(response.asPrettyString());
		assertThat(response.asPrettyString(), containsString("displayAmount"));

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\com\\jswone\\msme\\oms\\schemas\\"+jsonName+".json");

		response.then().assertThat().body(matchesJsonSchema(fis));
	}
	
	
	

}
