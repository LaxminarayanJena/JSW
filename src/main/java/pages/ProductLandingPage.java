package pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductLandingPage {

	private WebDriver driver;

	private By searchTextBox = By.id("SearchText");

	private By search = By.xpath("//i[@class='search-icon1']");

	public ProductLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterSearchText(String searchProduct) throws InterruptedException {
		driver.findElement(searchTextBox).sendKeys(searchProduct);
	}

	public void Search() {

		driver.findElement(search).click();
	}

	public boolean Validatebreadcrumb() {
		return driver.findElement(By.xpath("//div[@class='breadcrumb-out with-plp']")).isDisplayed();

	}

	public void clickonHomeHyperLink() {
		driver.findElement(By.xpath("//span[contains(text(),'Found')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
	}

	public void categoriesTabList() throws InterruptedException {
		driver.findElement(By.xpath("(//a[contains(text(),'Steel')])[2]")).click();
		Thread.sleep(2000);
		List<WebElement> categoriesList = driver
				.findElements(By.xpath("//ul[@class='main-categories-first-child-menu']//a"));
		for (int i = 0; i < categoriesList.size(); i++) {
			System.out.println(categoriesList.get(i).getText());
		}

	}

	public boolean validateReset() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(By.className("reset-product-list")).isEnabled();

	}

	public void clickReset() throws InterruptedException {

		driver.findElement(By.className("reset-product-list")).click();

	}

	public void clickGradesAndSubgrades() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='JSW Steel']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='2062:2011']")).click();
	}
	
	public void clickGrades() throws InterruptedException {
		driver.findElement(By.xpath("//label[text()='JSW Steel']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='2062:2011']")).click();
	}

	public void click277_2018() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Grades and sub grades')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='277_2018']")).click();
		Thread.sleep(2000);
	}

	public void clickE350A() throws InterruptedException {
		// driver.findElement(By.xpath("//span[contains(text(),'Grades and sub
		// grades')]")).click();
		driver.findElement(By.xpath("//input[@value='E350A']")).click();
		Thread.sleep(3000);
	}

	public void clickGradesE250A() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Grades and sub grades')]")).click();
		driver.findElement(By.xpath("//input[@value='E250A']")).click();
		Thread.sleep(3000);
	}

	public boolean validateGridView() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//a[@class='grid-icon active']")).isEnabled();
	}

	public void countResultPLP() {
		String countResult = driver.findElement(By.xpath("//div[1]/div[1]/b[1]")).getText();
		System.out.println("countResult-" + countResult);
	}

	public void clickListView() {
		driver.findElement(By.xpath("//a[@class='list-icon']")).click();
	}

	public boolean validateFiltersTobeRemoved() throws InterruptedException {
		Thread.sleep(3000);
		if (isElementPresent("//div[contains(text(),'Filters applied')]")) {
			boolean filterApplied = driver.findElement(By.xpath("//div[contains(text(),'Filters applied')]")).isDisplayed();
			return filterApplied;
		}
		return false;

	}

	public void validateFiltersTobeShown() throws InterruptedException {
		Thread.sleep(1200);
		if (isElementPresent("//div[contains(text(),'Filters applied')]")) {
			System.out.print("Products display applied filters should display with cross button");
		} else {
			Assert.fail();
		}
	}

	public boolean validateClearAll() throws InterruptedException {
		return driver.findElement(By.xpath("//span[contains(text(),'×')]")).isEnabled();

	}

	public void validateflitersDisplayed() {
		List<WebElement> filtersDisplayed = driver.findElements(By.xpath("//li[@class='filtersapplied-productlist2']"));

		for (int i = 0; i < filtersDisplayed.size(); i++) {
			System.out.print(filtersDisplayed.get(i));
		}
	}

	public void clickClearAll() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
	}

	public void countNoofProductImages() {
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='prod-plpimg1']"));

		System.out.println("No of product Images" + productList.size());

	}

	public void removingfilterE350A() {
		driver.findElement(By.xpath("//li[@class='filtersapplied-productlist2'][2]")).click();
	}

	public void removingfilterE250A() {
		driver.findElement(By.xpath("//li[@class='filtersapplied-productlist2'][1]")).click();
	}

	public void validateHotRolledSheetFilterSection() {
		driver.findElement(By.xpath("//span[contains(text(),'Application Sectors')]")).isDisplayed();
		driver.findElement(By.xpath("//div[contains(text(),'Forms')]")).isDisplayed();
		driver.findElement(By.xpath("//span[contains(text(),'Grades and sub grades')]")).isDisplayed();
		driver.findElement(By.xpath("//span[contains(text(),'Application Sectors')]")).isDisplayed();
		driver.findElement(By.xpath("//div[contains(text(),'Thickness')]")).isDisplayed();
		driver.findElement(By.xpath("//div[3]/div[4]/div[1]/div[1]")).isDisplayed();
		driver.findElement(By.xpath("//div[contains(text(),'Length')]")).isDisplayed();

	}

	public void validateFilters() {
		driver.findElement(By.xpath("//span[contains(text(),'Application Sectors')]")).isDisplayed();
		driver.findElement(By.xpath("//div[contains(text(),'Forms')]")).isDisplayed();
		driver.findElement(By.xpath("//span[contains(text(),'Grades and sub grades')]")).isDisplayed();
		driver.findElement(By.xpath("//span[contains(text(),'Application Sectors')]")).isDisplayed();
		driver.findElement(By.xpath("//div[@class='thickness-container']")).isDisplayed();

	}

	public void validateHotRolledProductName() throws InterruptedException {
		
		Thread.sleep(2500);
		List<WebElement> productNameList = driver
				.findElements(By.xpath("//div[@class='plp-prod-img']//following::div[1]"));

		System.out.println("No of product Images: " + productNameList.size());

		for (int i = 0; i < productNameList.size(); i++) {
			System.out.println(productNameList.get(i).getText());
			System.out.println(StringUtils.contains(productNameList.get(i).getText(), "Hot Rolled"));
		}

	}

	public void clickonProduct() {

		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='plp-prod-img']"));
		productList.get(1).click();
	}

	public void validatedeliveryDate() throws InterruptedException {
         
		Thread.sleep(2200);
		List<WebElement> productList = driver.findElements(By.xpath("//span[@class='deliveryschedule']"));
		System.out.println("Delivery Date: " + productList.get(1).getText());
	}

	public void validatePrice() throws InterruptedException {
		Thread.sleep(3000);

		List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='product-cost']//span"));
		System.out.println("Product Price: " + productPrice.get(0).getText());
	}

	public void validateInvalidSearchMessage() {
		String firstmsg = driver.findElement(By.xpath("//div[@class='message1']")).getText();
		String secondmsg = driver.findElement(By.xpath("//div[@class='message2']")).getText();
		String thirdmsg = driver.findElement(By.xpath("//div[@class='message3']")).getText();
		System.out.println(firstmsg);
		System.out.println(secondmsg);
		System.out.println(thirdmsg);

	}

	public void verifyGradesAndSubgradesForHotRolled() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Grades and sub grades')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='2062_2011']")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='E250A']")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='E250BR']")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='E350A']")).isDisplayed();

	}

	public void verifyFilterWithColor() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Grades and sub grades')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='YS_550']")).isDisplayed();

	}
	
	public void verifyFilterColorCoated() throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(text(),'Grade')]"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@value,'15965_2012')]")).isDisplayed();
		driver.findElement(By.xpath("//label[contains(text(),'15965_2012')]")).click();
	}

	public void verifyDiameter() {
		driver.findElement(By.xpath("//div[@class='thickness-container']//div[@class='thickness-img-name']"))
				.isDisplayed();

	}

	public void verifyGradesAndSubgradesForColdRolled() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Grades and sub grades')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='2062_2011']")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='E250A']")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='513_PART1_2016']")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='1079_2017']")).isDisplayed();

	}

	public void verifyGradesAndSubgradesForCoated() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Grades and sub grades')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='15961_2012']")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='GPIF']")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='GP']")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='GPD']")).isDisplayed();

	}
	
	public void verifyGradesForCoated() throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(text(),'Grade')]"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='15961:2012']")).isDisplayed();
		driver.findElement(By.xpath("//label[contains(text(),'15961:2012')]")).click();


	}

	public void scrollTillEnquiryForm() {

		WebElement PLPEnquiry = driver.findElement(By.xpath("//button[@class='enquery-button plp-banner-btn']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", PLPEnquiry);
		// PLPEnquiry.click();
		// driver.findElement(By.xpath("//input[@name='nameChange']")).sendKeys("fbhfgf");

	}

	public void enquiry() throws InterruptedException {
		WebElement PLPEnquiry = driver.findElement(By.xpath("//button[@class='enquery-button plp-banner-btn']"));

		PLPEnquiry.click();
		driver.findElement(By.id("message")).sendKeys("test requirement");
		driver.findElement(By.xpath("//button[@class='enquery-button']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='query-id']//following::div[2]")).getText();

	}

	public void guestenquiry() throws InterruptedException {
		WebElement PLPEnquiry = driver.findElement(By.xpath("//button[@class='enquery-button plp-banner-btn']"));

		PLPEnquiry.click();
		driver.findElement(By.id("nameChange")).sendKeys("ramam");
		driver.findElement(By.name("mobile")).sendKeys("8787898989");
		driver.findElement(By.xpath("//*[text()='Procced']")).click();

		driver.findElement(By.id("message")).sendKeys("test requirement");
		driver.findElement(By.xpath("//button[@class='enquery-button']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='query-id']//following::div[2]")).getText();

	}

	public String validatePLPListResults() {
		//driver.findElement(By.xpath("//span[contains(text(),'Found')]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@class='list-title desc']")).getText());
		return driver.findElement(By.xpath("//*[@class='list-title desc']")).getText();

	}
	
	public String validatePLPBreadCrumb() {
		System.out.println(driver.findElement(By.xpath("//*[@class='home'][3]")).getText());
		return driver.findElement(By.xpath("//*[@class='home'][3]")).getText();

	}
	
	public void  TotalProductCount()
	{
		String totalcount=driver.findElement(By.xpath("//span[@class='right-list-value']//b")).getText();
		System.out.println("Total no of products - " +totalcount);
	}
	
	public boolean validatePLPFilter() {
		
		driver.findElement(By.xpath("//div[contains(text(),'Width')]")).isDisplayed();
		driver.findElement(By.xpath("//div[contains(text(),'Length')]")).isDisplayed();
		return driver.findElement(By.xpath("//div[contains(text(),'Thickness')]")).isDisplayed();

	}
	public void clickonGradeFilter() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'JT')]")).click();
	}
	
	public void clickonGradeFilterinSteel() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'277:2018')]")).click();
	}
	
	
	public void clickResetFilter()
	{
		
		driver.findElement(By.className("reset-product-list")).click();
	}
	
	

	public boolean isElementPresent(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {
			return false;
		}

	}



}
