package com.jswone.msme.oms.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jswone.msme.oms.util.ElementUtil;

public class DashboardPage {

	private WebDriver driver;
	public static String TodaysCountNo;
	private By googleLogin = By.xpath("//*[text()='Login with Google']");
	private By emailTextBox = By.xpath("//input[@type='email']");
	private By nextBtn = By.xpath("//span[normalize-space()='Next']");
	private By passwordBox = By.xpath("//input[@type='password']");
	private By orderDate = By.xpath("(//td[contains(@class,'MuiTableCell-root MuiTableCell-body')]//a)[1]");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToOMS() throws InterruptedException, IOException {
		ElementUtil ut = new ElementUtil(driver);
		//driver.get(ElementUtil.getGlobalValue("omsUrl"));
		driver.get("https://qa-oms.msme.jswone.in/oauth2/redirect?token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2X25pdGVlbi5zYWhuaUBqc3cuaW4iLCJhdXRoIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzAwNDc5OTA5LCJleHAiOjE3MDMwNzE5MDl9.VAwnZ-FEQOL-uegeQMZ4RyHeaWUeVdQVEhbEeQG2-sqL-Gkc0EuaLQXAk3WoC2wFYH17mXVWkMytsivLGPBCZQ");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		/*
		driver.findElement(googleLogin).click();
		driver.findElement(emailTextBox).sendKeys("qatestuser@jsw.in");
		Thread.sleep(1000);
		driver.findElement(nextBtn).click();
		ut.WaitUtilClickable(passwordBox);
		driver.findElement(passwordBox).sendKeys("Admin@123$");
		Thread.sleep(2000);
		driver.findElement(nextBtn).click();
		*/
		Thread.sleep(5000);

	}

	public void validateTabs() {
		driver.findElement(By.xpath("//*[@data='/assets/selected-dashboard.svg']")).isDisplayed();
		driver.findElement(By.xpath("//*[@data='/assets/order-list.svg']")).isDisplayed();
		driver.findElement(By.xpath("//*[@data='/assets/incoming-payments.svg']")).isDisplayed();
		driver.findElement(By.xpath("//object[@data='/assets/ledger.svg']")).isDisplayed();
		driver.findElement(By.xpath("//object[@data='/assets/user-management.svg']")).isDisplayed();
		driver.findElement(By.xpath("//object[@data='/assets/payout.svg']")).isDisplayed();
		driver.findElement(By.xpath("//object[@data='/assets/credit.svg']")).isDisplayed();
		driver.findElement(By.xpath("//object[@data='/assets/credit-card.svg']")).isDisplayed();

	}

	public void enterseller() throws AWTException {
		driver.findElement(By.xpath("(//label[text()='Seller company name']/following::input)[1]"))
				.sendKeys("jsw steel vijay");
		ElementUtil.SingleKeyDownEnter();
	}

	public void clickSubmit() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		Thread.sleep(3000);
	}

	public void validateSellerCount() {
		List<WebElement> lineItemTableRows = driver
				.findElements(By.xpath("//table[contains(@class,'MuiTable-root MuiTable-stickyHeader')]//tr"));
		int rowCount = lineItemTableRows.size() - 1;

		IntStream.range(1, rowCount).forEach(i -> {
			String sellerName = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[11]")).getText();
			Assert.assertEquals(sellerName, "JSW Steel Vijaynagar Works");
		});

	}

	public void selectSPOC() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//p[text()='Ops SPOC']")).click();
		String textToType = "Shahaji Muley";
		ElementUtil.enterText(textToType);
		ElementUtil.Esc();
	}

	public void validateSPOC() {
		List<WebElement> lineItemTableRows = driver
				.findElements(By.xpath("//table[contains(@class,'MuiTable-root MuiTable-stickyHeader')]//tr"));
		int rowCount = lineItemTableRows.size() - 1;
		IntStream.range(1, rowCount).forEach(i -> {
			String sellerName = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[6]")).getText();
			Assert.assertEquals(sellerName, "Shahaji Muley");
		});
	}

	public void clickReset() {
		driver.findElement(By.xpath("//*[text()='Reset']")).click();
	}

	public void verifyLineItem(int orderCount) {
		List<WebElement> orders=driver.findElements(By.xpath("//th[text()='Buyer order no.']//following::a"));
		Assert.assertEquals(orders.size(), orderCount);
	}

	public boolean validateFilterCleared() {
		ElementUtil elementUtil = new ElementUtil(driver);
		boolean FilterCleared = elementUtil.isElementPresent("//p[text()='Ops SPOC']/following-sibling::div");
		return FilterCleared;
	}

	public void dashboardRefresh() throws InterruptedException {
		clickReset();
		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	public void TodaysTab(String TabName) throws InterruptedException {
		dashboardRefresh();
		WebElement TodaysCount = driver.findElement(By.xpath("//p[text()='" + TabName + "']//following::h3[1]"));
		TodaysCountNo = TodaysCount.getText();
		System.out.println("TotalOrderIn" + TabName + "bucket " + TodaysCountNo);
		TodaysCount.click();

	}

	public void orderCreationDate() throws InterruptedException {

		if (TodaysCountNo.equals("0")) {
			driver.findElement(By.xpath("//p[text()='No data found']")).isDisplayed();

		} else {
			ElementUtil obj = new ElementUtil(driver);
			obj.WaitUntilVisible(orderDate);
			List<WebElement> lineItemTableRows = driver
					.findElements(By.xpath("//table[contains(@class,'MuiTable-root MuiTable-stickyHeader')]//tr"));
			int rowCount = lineItemTableRows.size() - 1;
			IntStream.range(1, rowCount).forEach(i -> {
				String date = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText();
				System.out.println(date);
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date givenDate = null;
				try {
					givenDate = dateFormat.parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				LocalDate givenLocalDate = givenDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
				LocalDate currentDate = LocalDate.now();
				if (givenLocalDate.isEqual(currentDate) || givenLocalDate.plusDays(1).isEqual(currentDate)) {
					System.out.println("Order date is equal to or 1 day less than today's date.");
				} else {
					System.out.println("Order date is not equal to or 1 day less than today's date.");
					Assert.fail();
				}
			}

			);
		}
	}

	public void onetothreedaysTab(String TabName) throws InterruptedException {
		dashboardRefresh();
		WebElement TodaysCount = driver.findElement(By.xpath("//p[text()='" + TabName + "']//following::h3[2]"));
		TodaysCountNo = TodaysCount.getText();
		System.out.println("TotalOrderIn" + TabName + "bucket " + TodaysCountNo);
		TodaysCount.click();

	}

	public void fourtosevendaysTab(String TabName) throws InterruptedException {
		dashboardRefresh();
		WebElement TodaysCount = driver.findElement(By.xpath("//p[text()='" + TabName + "']//following::h3[3]"));
		TodaysCountNo = TodaysCount.getText();
		System.out.println("TotalOrderIn" + TabName + "bucket " + TodaysCountNo);
		TodaysCount.click();

	}

	public void oneweekplusTab(String TabName) throws InterruptedException {
		dashboardRefresh();
		WebElement TodaysCount = driver.findElement(By.xpath("//p[text()='" + TabName + "']//following::h3[4]"));
		TodaysCountNo = TodaysCount.getText();
		System.out.println("TotalOrderIn" + TabName + "bucket " + TodaysCountNo);
		TodaysCount.click();

	}

	public void validatePaginationCount() throws InterruptedException {

		if (TodaysCountNo.equals("0")) {
			driver.findElement(By.xpath("//p[text()='No data found']")).isDisplayed();

		} else {
			String TotalOrderPagination = driver.findElement(By.xpath("//tfoot[1]/tr[1]/td[1]/div[1]//P")).getText();
			Pattern pattern = Pattern.compile("of (\\d+)");
			Matcher matcher = pattern.matcher(TotalOrderPagination);
			if (matcher.find()) {
				String TotalOrderInOrderList = matcher.group(1);
				System.out.println("TotalOrderInOrderList: " + TotalOrderInOrderList);
				Assert.assertEquals(TodaysCountNo, TotalOrderInOrderList);
			} else {
				Assert.fail();
				System.out.println("Order count doesnot matches");
			}
		}
	}

}
