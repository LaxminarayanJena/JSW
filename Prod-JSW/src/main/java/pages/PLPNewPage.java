package pages;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PLPNewPage {

	private WebDriver driver;

	private By steelMenu = By.xpath("//header/div[3]/div[1]/div[1]/div[1]/a[1]");
	private By steelPLP = By.xpath("//*[@class='list-title desc']");
	private By breadcrump = By.xpath("//div[@class='breadcrumb-url']");
	private By hotRolledMenu = By.xpath("//div[3]/div/div[1]/div[1]/div/ul/li[1]/a");
	private By coldRolledMenu = By.xpath("//div[3]/div/div[1]/div[1]/div/ul/li[2]/a");
	private By wireRodMenu = By.xpath("//div[3]/div/div[1]/div[1]/div/ul/li[3]/a");
	private By coated = By.xpath("//div[3]/div/div[1]/div[1]/div/ul/li[4]/a");
	private By colourCoated = By.xpath("//div[3]/div/div[1]/div[1]/div/ul/li[5]/a");

	private By metalAndAlloys = By.xpath("//span[contains(text(),'Metals and Alloys')]");
	private By steel = By.xpath("//span[contains(text(),'Steel')]");
	private By home = By.xpath("//span[contains(text(),'Home')]");
	private By metal = By.xpath("//span[contains(@class,'list-title desc')]");
	// TMT
	private By constructionSteel = By.xpath("//div[@class='breadcrumb-url d-none d-md-block']//span[@class='home'][normalize-space()='Construction materials']");
	private By constructionMaterials = By.xpath("//span[contains(text(),'Construction materials')]");
	private By gradeTMT = By.xpath("//label[contains(text(),'IS')]");
	private By diameterMin = By.xpath("//div[@class='range-left']");
	private By minValue = By.xpath("//option[@value='8.0']");
	private By maxValue = By.xpath("//option[text()='Max']//following::option[@value='40.0']");
	private By diameterMax = By.xpath("//div[@class='range-right']");
	private By clearDiameter = By.xpath("//div[contains(text(),'Diameter')]//following::div[@class='clearButton']");

	public PLPNewPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSteelMenu() {
		driver.findElement(steelMenu).click();
	}

	public void selectHR() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).perform();
		driver.findElement(hotRolledMenu).click();
	}

	public void selectHRC() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(hotRolledMenu);
		action.moveToElement(we).perform();
		driver.findElement(By.linkText("Hot rolled coils")).click();
	}

	public void selectHRS() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(hotRolledMenu);
		action.moveToElement(we).perform();
		driver.findElement(By.linkText("Hot rolled sheets")).click();
	}

	public void selectCR() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).perform();
		driver.findElement(coldRolledMenu).click();
	}

	public void selectCRS() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(coldRolledMenu);
		action.moveToElement(we).perform();
		driver.findElement(By.linkText("Cold rolled sheets")).click();
	}

	public void selectWR() {

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).build().perform();
		driver.findElement(By.partialLinkText("Wire")).click();

	}

	public void selectCoated() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).perform();
		driver.findElement(coated).click();
	}

	public void selectColourCoated() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).perform();
		driver.findElement(colourCoated).click();
	}

	public String validateSteelPLP() {
		driver.findElement(steelPLP).isDisplayed();
		return driver.findElement(steelPLP).getText();
	}

	public String verifySteel() {
		System.out.println(driver.findElement(By.xpath("//span[@class='home'][3]")).getText());
		return driver.findElement(By.xpath("//span[@class='home'][3]")).getText();
	}

	public String verifyHR() {
		System.out.println(driver.findElement(By.xpath("//span[@class='home'][4]")).getText());
		return driver.findElement(By.xpath("//span[@class='home'][4]")).getText();
	}

	public String verifyCR() {
		System.out.println(driver.findElement(By.xpath("//span[@class='home'][4]")).getText());
		return driver.findElement(By.xpath("//span[@class='home'][4]")).getText();
	}

	public void verifyHRProducts() throws InterruptedException {
		WebElement hrs = driver.findElement(By.className("list-title desc"));
		hrs.isDisplayed();
		Thread.sleep(2000);
		System.out.println(hrs.getText());
		return;
	}

	public void validateProductName() {
		driver.findElement(By.className("prod-plpimage1name")).getText();
	}

	public void validateGrades() {
		WebElement grade = driver.findElement(By.xpath("//div[contains(text(),'Grade')]//following::div//div[1]/div[1]/label"));
		System.out.println("Grades :" + grade.getText() + "\t");
	}

	public void clickMetal() {
		driver.findElement(metalAndAlloys).click();
	}

	public void clickSteel() throws InterruptedException {
		driver.findElement(steel).click();
		Thread.sleep(2000);
	}

	public void clickClear() {
		driver.findElement(By.xpath("(//div[contains(text(),'Clear')])[1]")).click();
	}

	public String verifyMetal() {
		System.out.println(driver.findElement(By.xpath("//*[contains(@class,'list-title desc')]")).getText());
		return driver.findElement(By.xpath("//*[contains(@class,'list-title desc')]")).getText();
	}

	public void verifyHome() {
		String homePage = driver.findElement(By.xpath("//h2[@class='category-title']")).getText();
		System.out.println("Landing Home page: " + homePage);
	}

	public void verifyReset() {
		driver.findElement(By.className("reset-product-list")).isDisplayed();
	}

	public void steel() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).perform();
	}

	public String verifySubCategorySteelMenu() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).perform();
		// driver.findElement(By.className("menu-tree-container
		// menu-tree-jsw")).isDisplayed();
		String steelList = driver.findElement(By.className("menu-list-jsw")).getText();
		System.out.println(steelList);
		return steelList;
	}

	public void verifyClear() {
		driver.findElement(By.xpath("(//div[contains(text(),'Clear')])[1]")).isDisplayed();
	}

	public String verifyAllHRProducts() {
		System.out.println(driver.findElement(By.className("right-list-value")).getText());
		return driver.findElement(By.className("right-list-value")).getText();
	}

	public void verifyFilterSection() {
		driver.findElement(By.className("left-col")).isDisplayed();

		List<WebElement> filterList = driver.findElements(By.className("form-filter-shade"));

		System.out.println("Number of Filters displayed: " + filterList.size());

		for (WebElement webElement : filterList) {
			String name = webElement.getText();
			System.out.println(name);
		}
	}

	public void clickBrand() {
		driver.findElement(By.xpath("//*[text()='JSW Steel']")).click();
	}

	public void clickGrade() {
		driver.findElement(By.xpath("//label[contains(text(),'2062:2011')]")).click();
	}

	public void clickReset() {
		driver.findElement(By.className("reset-product-list")).click();
	}

	public void clickFilterX() {
		driver.findElement(By.xpath("//button[@class='badge-close with-filter button']//span[contains(text(),'×')]"))
				.click();
	}

	public int countAppliedFilters() throws InterruptedException {
		List<WebElement> close = driver.findElements(By.xpath("//span[text()='×']"));
		System.out.println("No of filters applied: " + close.size());
		return close.size();
	}

	public void clearAppliedFilters() throws InterruptedException {
		List<WebElement> close = driver.findElements(By.xpath("//span[contains(text(),'×')]"));
		close.size();
		for (int i = 0; i < close.size(); i++) {
			driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
			Thread.sleep(3000);
		}
		// driver.findElement(By.xpath("(//span[text()='×'])[3]")).click();
		// Thread.sleep(1500);
		// driver.findElement(By.xpath("(//span[text()='×'])[2]")).click();
		// Thread.sleep(1500);
		// driver.findElement(By.xpath("(//span[text()='×'])[1]")).click();
		// Thread.sleep(1500);
	}

	public String countSteelProd() {
		System.out.println(driver.findElement(By.xpath("//span[@class='right-list-value']")).getText());
		return driver.findElement(By.xpath("//span[@class='right-list-value']")).getText();
	}

	public void thicknessMin() throws InterruptedException {
		driver.findElement(
				By.xpath("(//div[@class='range-left']//select[@class='custom-select rangeSelectionCss'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//option[contains(text(),'1.6')])[1]")).click();
		Thread.sleep(2000);
	}

	public void thicknessMax() throws InterruptedException {
		driver.findElement(
				By.xpath("(//div[@class='range-right']//select[@class='custom-select rangeSelectionCss'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//option[contains(text(),'1.6')])[2]")).click();
		Thread.sleep(2000);
	}

	// TMT Products

	public void valiadtePLP() {
		String PLPpage = driver.findElement(By.xpath("//*[@class='list-title desc']")).getText();
		System.out.println("Landing on PLP page :" + PLPpage);
	}

	public void TMTGrade() throws InterruptedException {
		driver.findElement(gradeTMT).click();
		Thread.sleep(2000);
	}

	public void diameterMin() throws InterruptedException {
		driver.findElement(diameterMin).click();
		Thread.sleep(2000);
		driver.findElement(minValue).click();
		Thread.sleep(1500);
	}

	public void diameterMax() throws InterruptedException {
		driver.findElement(diameterMax).click();
		Thread.sleep(2000);
		driver.findElement(maxValue).click();
		Thread.sleep(1500);
	}

	public void diameterClear() throws InterruptedException {
		boolean clear = driver.findElement(clearDiameter).isDisplayed();
		System.out.println("Available diamter clear: " + clear);
		Thread.sleep(2000);
	}

	public void Pdpnavigate() throws InterruptedException {
		List<WebElement> TMTproducts = driver.findElements(By.xpath("//a[@class='prod-plpimage1name']"));
		System.out.println("No. of TMT products: " + TMTproducts.size());
		driver.findElement(By.xpath("//a[@title='JSW Neosteel Fe550D TMT Rebar']")).click();
		Thread.sleep(3600);
	}

	public void verifyTMTPDPpage() throws InterruptedException {
		boolean TMTpdp = driver.findElement(By.xpath("//div[@class='d-none d-lg-block']//div//h1[@class='h1'][normalize-space()='JSW Neosteel Fe550D TMT Rebar']"))
				.isDisplayed();
		System.out.println("PDP page: " + TMTpdp);
		Thread.sleep(1500);
	}

	public void clickConstructionSteel() throws InterruptedException {
		driver.findElement(constructionSteel).click();
		Thread.sleep(3000);
	}

	public void clickConstructionMaterials() throws InterruptedException {
		driver.findElement(constructionMaterials).click();
		Thread.sleep(3000);
	}

	public void verifyTMTProd() throws InterruptedException {
		String titleProd = driver.findElement(By.xpath("//a[@title='JSW Neosteel Fe550D TMT Rebar']")).getText();
		Assert.assertEquals(titleProd, "JSW Neosteel Fe550D TMT Rebar");
		Thread.sleep(2000);
	}

	public void removeDiamterTMT() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'8.0 - 40.0')]//following::span[contains(text(),'×')]"));
		Thread.sleep(2000);
	}

	public void priceRangeTMT() throws InterruptedException {
		String price = driver
				.findElement(
						By.xpath("//a[@title='JSW Neosteel Fe550D TMT Rebar']//following::span[@class='price-range']"))
				.getText();
		System.out.println("Product Price: " + price);
		Thread.sleep(2000);
	}

	public void selectCementProduct() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(text(),'JSW Concreel HD Cement')]")).click();

	}

	public void selectWireProduct() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'JSW Steel Wire Rod Coils IS 7887:1992 SAE1006')]")).click();

	}
	
	public void selectColdRolledProduct() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'JSW Steel Cold Rolled Coils IS 513 (Part 1):2016 CR2')]")).click();

	}
	
	public void selectPPGLCoilProduct() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'JSW Pragati+ Pre-Painted Galvalume Coils IS 15965:')]")).click();

	}
	
	public void PPGLCoilProductDetails(String qty) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Thickness')]//following::div[3]//div//button[1]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Width')]//following::div[2]//div//button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Coating')]//following::div[2]//div//button[1]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Select colour']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Sky Blue']")).click();
		driver.findElement(By.xpath("(//input[@id='inputQty'])[1]")).sendKeys(qty);
		Thread.sleep(4000);
	}

}
