package pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage {

	private WebDriver driver;

	private By steelByCategories = By.xpath("//li[1]/div[1]/a[1]");
	private By hotRolled = By.xpath("//div[1]/ul[1]/li[1]/a[1]");
	private By hotRolledSheets = By.xpath("//*[text()=' Hot rolled sheets ']");
	private By productselect = By.xpath("//a[@class='prod-plpimage1name']");
	private By productsList = By.xpath("//div[@class='prod-plpimg1']");
	private By stainlessSteelByCategories = By.xpath("//h2[contains(text(),'Stainless Steel')]");
	private By series300 = By.xpath("(//a[contains(text(),'Series 300')])[5]");
	private By hrseries300SS = By.xpath("//div[@class='plp-product-item']");
	private By viewAllSS = By.xpath("(//button[@class='btn view-all btn-outline-primary primary'])[2]");
	private By ssHRS = By.xpath("//div[@class='plp-product-item']");
	private By stainlessSteelMenu = By.xpath("//a[contains(text(),'Stainless Steel')]");
	private By steelMenu = By.xpath("//div[@class='navigation-item'][1]");
	private By WeldingConsumables = By.xpath("//a[contains(text(),'Welding consumables')]");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnHotRolledSheets() throws InterruptedException {
		driver.findElement(steelByCategories).click();
		Thread.sleep(2000);
		driver.findElement(hotRolled).click();

	}

	public void clickOnproductfromListingPage() throws InterruptedException {

		driver.findElements(productsList).get(1).click();
		Thread.sleep(3000);

		List<WebElement> Thickness = driver.findElements(
				By.xpath("//div[(@class='dimension-size') and contains (text(),'Thickness (mm)')]//following::li"));
		Thickness.get(0).click();

		List<WebElement> width = driver.findElements(
				By.xpath("//div[(@class='dimension-size') and contains (text(),'Width (mm)')]//following::li[1]"));
		width.get(1).click();

		List<WebElement> length = driver.findElements(
				By.xpath("//div[(@class='dimension-size') and contains (text(),'Length (mm)')]//following::li[1]"));
		length.get(1).click();

		driver.findElement(By.xpath("//input[@class='input-quant']")).sendKeys("50");
		driver.findElement(By.xpath("//input[@class='input-quant']//following::img[1]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[1]/span[1]/i[1]")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@class='ok-button']")).click();

	}

	public void hrSheets() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,1300)", "");
		Thread.sleep(5000);
		driver.findElement(stainlessSteelByCategories).isDisplayed();
	}

	public void selectSeries300() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", viewAllSS);
		driver.findElement(viewAllSS).isDisplayed();
		Thread.sleep(3000);
		driver.findElement(viewAllSS).click();
	}

	public String validateHRSeries300Page() {

		driver.findElement(By.xpath("//*[contains(text(),'Stainless Steel hot rolled sheets')]")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//*[@class='list-title desc']")).getText());
		return driver.findElement(By.xpath("//*[@class='list-title desc']")).getText();
	}

	public void SSMenu() throws InterruptedException, AWTException {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(stainlessSteelMenu);
		action.moveToElement(we).build().perform();
		// Robot r = new Robot();
		// r.keyPress(KeyEvent.VK_DOWN);
		// r.keyRelease(KeyEvent.VK_DOWN);
		driver.findElement(By.partialLinkText("Hot rolled sheets")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	public void CRMenu() throws InterruptedException, AWTException {

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).build().perform();

		WebElement we1 = driver.findElement(By.partialLinkText("Cold rolled"));
		action.moveToElement(we1).build().perform();

		driver.findElement(By.xpath("//div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[2]/a[1]")).click();
		Thread.sleep(3600);

	}

	public void selectProductreguserHRS() {

		List<WebElement> productlist = driver.findElements(productselect);

		for (int i = 0; i < productlist.size(); i++) {
			System.out.println(productlist.get(i).getText());
			if (productlist.get(i).getText().equals("JSL stainless steel HRAP 304L N1 finish sheets")) {
				productlist.get(i).click();
				break;
			} else {

			}

		}

	}

	// Customer length watermark

	public void SheetDimension() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Thickness (mm)')]//following::div[2]//div//button[2]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Width (mm)')]//following::div[1]//div//button[1]")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//div[contains(text(),'Length
		// (mm)')]//following::div[1]//div//button[1]")).click();
		// Thread.sleep(2000);
	}

	public void clickCustomerLength() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Custom length ')]")).click();
		Thread.sleep(2000);

	}

	public void validateCTL() throws InterruptedException {
		String ctl = driver.findElement(By.xpath("//div[contains(text(),'Enter a value between 2500 to 6300')]")).getText();
		System.out.println("CTL msg: " + ctl);
		Thread.sleep(2000);
	}

	public void selectHotRolledSheet() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'JSW Steel Hot Rolled Sheets IS 2062:2011 E250A')]")).click();
		Thread.sleep(2000);
	}

	public void selectColdRolledSheet() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'JSW Steel Cold Rolled Sheets IS 513 (Part 1):2016 ')]"))
				.click();
		Thread.sleep(2000);
	}

	public void ClickWeldingConsumables() throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(WeldingConsumables);
		action.moveToElement(we).build().perform();

	}

	public void ClickWeldingFlux() throws InterruptedException {

		WebElement we1 = driver.findElement(By.partialLinkText("Welding Fluxes"));
		we1.click();
		Thread.sleep(3000);
	}

	public void clickWeldingFluxProduct() {
		driver.findElement(By.xpath("//a[contains(text(),'Ador AUTOMELT B-71 Steel F7A4/P4-EM12K SAW Welding Flux')]"))
				.click();

	}
	
	public void WeldingFluxDetails() throws InterruptedException
	{
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//button[normalize-space()='30']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//input[@id='inputQty'])[1]")).sendKeys("10");
	    Thread.sleep(1500);
	}

}