package com.jswone.msme.oms.pages;


import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jswone.msme.oms.util.ElementUtil;
import com.jswone.msme.oms.util.Database.LedgerBalance;

public class LedgerPage {

	private WebDriver driver;
	public static String TodaysCountNo;
	public static String ccporderno;
	private By BuyerTab = By.xpath("//button[text()='Buyer']");

	public LedgerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToBuyerModule() throws IOException {
		driver.get(ElementUtil.getGlobalValue("omsUrl") + "ledger?tab=buyer");
			}

	public void validateTabs() {
		ElementUtil obj= new ElementUtil (driver);
		obj.WaitUntilVisible(BuyerTab);
		driver.findElement(By.xpath("//button[text()='Buyer']")).isDisplayed();
		driver.findElement(By.xpath("//button[text()='Seller']")).isDisplayed();
		driver.findElement(By.xpath("//button[text()='Orders']")).isDisplayed();
		driver.findElement(By.xpath("//button[text()='Account payable']")).isDisplayed();
		driver.findElement(By.xpath("//button[text()='Account receivable']")).isDisplayed();
		driver.findElement(By.xpath("//button[text()='Buyer ledger']")).isDisplayed();

	}

	public void validateSearch() {
		driver.findElement(By.xpath("//input[@placeholder='Search here']"))
				.sendKeys("ALFALOGIC SOLUTIONS INDIA PRIVATE LIMITED");
		driver.findElement(By.xpath("//p[text()='Show results']")).click();
		List<WebElement> lt=driver.findElements(By.xpath("//table[contains(@class,'MuiTable-root MuiTable-stickyHeader')]/tbody[1]/tr"));
		Assert.assertTrue(lt.size()>0);
		
	}
	
	public void validateLedgerBalance()
	{
		LedgerBalance lb = new LedgerBalance();
		String lgerblance = lb.extractLedgerBalance("0");
		System.out.println(lgerblance);

		double balance = Double.parseDouble(lgerblance);

		if (balance == 0.0) {
			System.out.println("The ledger balance is equal to 0.");
		} else {
			System.out.println("The ledger balance is not equal to 0.");
		}

		
	}

}
