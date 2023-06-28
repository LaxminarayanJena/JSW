package pages;

import java.awt.AWTException;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	private WebDriver driver;
	private By JSWLogo = By.xpath("//img[@alt='JSW One MSME']");
	private By search = By.id("SearchText");
	private By languageIndicator = By.xpath("//div[@data-value='ENG']");
	private By cartIcon = By.xpath("//*[contains(@href,'cart')]");
	private By noofCartItems = By.xpath("//div[@class='count']");
	private By address = By.xpath("//*[@id=\'address-dropdown\']");
	private By connectWithUs = By.xpath("//span[text()='Connect with us']");
	private By helpLineNumber = By.xpath("//div[@class='ph-num']");
	private By SociaMediaLogos = By.xpath("//div[@class='social-icons-out']");
	private By footerpartContainer = By.xpath("//div[@id='footer-cotain']");
	private By sliderContainerImages = By.xpath("//*[@id=\'carousel_nelosakfom\']/div[1]/div/div/div/img");// img[@class='top-br-img']
	private By mapIcon = By.xpath("//i[@class='fas fa-map-marker-alt']");
	private By thanksLanding = By.xpath("//div[@class='thanks-landing']");
	private By arrowdropdown = By.xpath("//*[@id='drop-down-head']");
	private By steelMenu = By.xpath("//div[@class='navigation-item'][1]");
	private By WeldingConsumables = By.xpath("//a[normalize-space()='Welding consumables']");

	private By HomePageHotRolledSheet = By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");
	private By HomePageHotRolledSheetSeries200 = By
			.xpath("//div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]");
	private By HomePageHotRolled = By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");
	private By HomePageHotRolledCoils = By.xpath("//*[text()='Coils ']");

	// Header
	private By userName = By.id("drop-down-head");
	private By myOrder = By.xpath("//a[text()='My orders']");
	private By steelTree = By.xpath("(//a[@class='nav-link-jsw nav-active-link-jsw'])[1]");
	private By stainlessSteelTree = By.xpath("(//a[@class='nav-link-jsw nav-active-link-jsw'])[2]");
	private By constructionMaterial = By.xpath("(//a[@class='nav-link-jsw nav-active-link-jsw'])[3]");
	private By helpSupport = By.xpath(
			"(//a[contains(@class,'nav-link-jsw nav-active-link-jsw')]/following::a[contains(text(),'Help & support')])[1]");
	private By aboutUs = By.xpath(
			"(//a[contains(@class,'nav-link-jsw nav-active-link-jsw')]/following::a[contains(text(),'About us')])[1]");
	private By blogs = By.xpath("//header/div[3]/div/div[1]/div[6]/a");
	private By toggled = By.xpath("//button[@id='direct-distributor-switchv2']");
	private By addressIcon = By.xpath("//*[@id=\'address-dropdown\']");
	private By manageAddress = By.xpath("(//button[@class='manage-btn mt-3'])[1]");

	// Footer
	private By footerSection = By.xpath("//div[@class='main-footer']");
	private By footerJSWLogo = By.xpath("//img[@alt='JSW Logo']");
	private By emailSupport = By.xpath("//*[@id=\'footer-cotain\']/div/div[1]/div/div[3]/div[2]/a");

	// HomepageVerification
	private By steelCategory = By.xpath("//*[@id=\"Steel\"]");
	private By ssCategory = By.xpath("//*[@id=\'Stainless Steel\']");
	private By hotRolled = By.xpath("//*/div[1]/div/div/div/div/div[1]/ul/li[1]/a");
	private By steelHRC = By.xpath("(//div[@class='selectHead'])[1]");
	private By steelViewall = By.xpath("(//button[contains(text(),'View all')])[1]");
	private By hotrolledsheet = By.xpath("(//a[contains(text(),'Hot rolled sheets')])[4]");
	private By series200 = By.xpath("(//a[contains(text(),'Series 200')])[5]");
	private By ssViewall = By.xpath("(//button[contains(text(),' View all')])[2]");
	private By blogsandarticles = By.xpath("//h1[contains(text(),'Browse articles & blogs')]");
	private By bloglist = By.xpath("//div[@class='blog-list']");
	private By blogViewall = By.xpath("//a[@class='btn view-all-articles-btn btn-outline-primary']");
	private By videosection = By.xpath("//span[@class='play-button']");
	private By workflow = By.xpath("(//div[@class='owl-carousel owl-theme owl-loaded owl-drag'])[4]");
	private By tmt = By.xpath("//a[@class='nav-link-jsw nav-active-link-jsw'][normalize-space()='TMT']");
	private By welding = By.xpath("//div[1]/div[5]/a[1]");
	private By weldingCategory = By.xpath("//h2[@id='Welding Consumables']");
	private By weldingProductsList = By.xpath("//h2[@id='Welding Consumables']//following::ul[@class='categorylist']");
	private By viewAllWelding = By.xpath("//h2[@id='Welding Consumables']//following::button[text()=' View all']");
	private By Blogs = By.linkText("Blogs");
	private By cement = By.xpath("//a[@class='nav-link-jsw nav-active-link-jsw'][normalize-space()='Cement']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validateJSWLogo() {
		return driver.findElement(JSWLogo).isDisplayed();
	}

	public void hotRolledPLP(WebElement element) throws AWTException {
		// Robot r = new Robot();
		// r.
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
		a.contextClick().click();
	}

	public void selectHotRolledProduct() throws InterruptedException {
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).build().perform();

		WebElement we1 = driver.findElement(By.partialLinkText("Hot rolled"));
		action.moveToElement(we1).build().perform();

		driver.findElement(By.xpath("//div[1]/div/ul/li[1]/div/ul/li[1]/a")).click();
		Thread.sleep(3000);
	}

	public void selectWeldingElectrodes() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(WeldingConsumables);
		action.moveToElement(we).build().perform();

		WebElement we1 = driver.findElement(By.partialLinkText("Welding Electrodes"));
		action.moveToElement(we1).build().perform();

		we1.click();

		Thread.sleep(3000);
	}

	public void selectWeldingWire() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(WeldingConsumables);
		action.moveToElement(we).build().perform();

		WebElement we1 = driver.findElement(By.partialLinkText("Welding Wires"));
		action.moveToElement(we1).build().perform();

		we1.click();

		Thread.sleep(3000);
	}

	public boolean validateSearch() {
		return driver.findElement(search).isDisplayed();

	}

	public boolean validateLanguageIndicator() {
		return driver.findElement(JSWLogo).isDisplayed();

	}

	public boolean validateCartIcon() {
		return driver.findElement(cartIcon).isDisplayed();

	}

	public void clickonHomePageLogo() throws InterruptedException {
		driver.findElement(JSWLogo).click();
		Thread.sleep(2000);
	}

	public String countCartItems() {
		return driver.findElement(noofCartItems).getText();
	}

	public CartDetailPage clickonCart() {
		driver.findElement(cartIcon).click();
		return new CartDetailPage(driver);
	}

	public String getAddress() {
		return driver.findElement(address).getAttribute("textContent");
	}

	public boolean validatemapIcon() {
		return driver.findElement(mapIcon).isDisplayed();

	}

	public boolean validateConnectWithUs() {
		return driver.findElement(connectWithUs).isDisplayed();

	}

	public boolean validateSociaMediaLogos() {
		return driver.findElement(SociaMediaLogos).isDisplayed();

	}

	public boolean validatehelpLineNumber() {
		return driver.findElement(helpLineNumber).isDisplayed();

	}

	public void myProfile() throws InterruptedException {
		driver.findElement(arrowdropdown).click();
		driver.findElement(By.linkText("Profile")).click();
		Thread.sleep(2000);
	}

	public void distributor() throws InterruptedException {
		driver.findElement(arrowdropdown).click();
		driver.findElement(By.linkText("Distributors")).click();
		Thread.sleep(2000);
	}

	public void enterEnquiryFormDetails() throws InterruptedException {
		driver.findElement(By.name("nameChange")).clear();
		driver.findElement(By.name("nameChange")).sendKeys("ramaaa");
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys("7876767656");
		Thread.sleep(2000);
		driver.findElement(By.name("email")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("ravikishan1@gmail.com");
		driver.findElement(By.name("message")).sendKeys("sending one test enquiry");

		driver.findElement(By.xpath("//div[1]/div[4]/label[1]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//button[@id='reachoutus-submit-1']")).click();
		Thread.sleep(19000);

	}

	public void extractEnquiryFormDetails() throws InterruptedException {
		String typedNameText = driver.findElement(By.name("nameChange")).getAttribute("value");
		String typedMobileText = driver.findElement(By.name("mobile")).getAttribute("value");
		String typedEmailText = driver.findElement(By.name("email")).getAttribute("value");
		System.out.println("Named inside name textfiled   " + typedNameText);
		System.out.println("Named inside mobile textfiled   " + typedMobileText);
		System.out.println("Named inside email textfiled   " + typedEmailText);
	}

	public boolean validatequeryId() {
		return driver.findElement(thanksLanding).isDisplayed();

	}

	public int validatefooterContainer() {
		WebElement block = driver.findElement(footerpartContainer);

		List<WebElement> blocklinks = block.findElements(By.tagName("a"));

		System.out.println("no of links inside block only  are: " + blocklinks.size());

		for (WebElement blocklink : blocklinks) {
			System.out.println(blocklink.getText());
			System.out.println(blocklink.getAttribute("href"));
		}
		return blocklinks.size();
	}

	public int validateSliderContainerImages() {

		List<WebElement> sliderImages = driver.findElements(sliderContainerImages);
		return sliderImages.size();
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public boolean validateHotRolledSheetsInHomePage() {
		return driver.findElement(HomePageHotRolledSheet).isDisplayed();

	}

	public boolean validateSeries200InHomePage() {
		return driver.findElement(HomePageHotRolledSheetSeries200).isDisplayed();

	}

	public boolean validateHotrolledInHomePage() {
		return driver.findElement(HomePageHotRolled).isDisplayed();

	}

	public boolean validateCoilsInHomePage() {
		return driver.findElement(HomePageHotRolledCoils).isDisplayed();

	}

	public void clickonStainlessSteelMenu() throws InterruptedException {
		Thread.sleep(3200);
		driver.findElement(By.xpath("//div[@class='navigation-item'][2]")).click();
	}

	public void clickonSteelMenu() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='navigation-item'][1]")).click();
	}

	// HomeVerification

	public void SteelSection() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)", "");
	}

	public void validateHotRolledSteel() {
		driver.findElement(hotRolled).isDisplayed();
		driver.findElement(HomePageHotRolledCoils).isSelected();
	}

	public void validateViewAllSteel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1000)", "");
		driver.findElement(steelViewall).isDisplayed();
	}

	public void ClickSteelViewAll() throws InterruptedException {
		driver.findElement(steelViewall).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Hot Rolled')]")).isDisplayed();
		Thread.sleep(2000);
	}

	public void SSSection() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1200)", "");
	}

	public boolean validateHotRolledSheet() {
		driver.findElement(hotrolledsheet).isDisplayed();
		return driver.findElement(HomePageHotRolledCoils).isSelected();
	}

	public boolean validateSSViewall() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1500)", "");
		return driver.findElement(ssViewall).isDisplayed();
	}

	public void SSClickViewAll() throws InterruptedException {
		driver.findElement(ssViewall).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Stainless Steel Hot Rolled Sheets')]")).isDisplayed();
		Thread.sleep(2000);
	}

	public boolean validateblogs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2000)", "");
		return driver.findElement(bloglist).isDisplayed();
	}

	public void blogsList() {
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='blog-item']"));
		System.out.println("Number of articles= " + items.size());
	}

	public boolean validateBlogsViewall() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2300)", "");
		return driver.findElement(blogViewall).isDisplayed();
	}

	public boolean validatevideoSection() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2750)", "");
		return driver.findElement(videosection).isDisplayed();
	}

	public void validateworkFLow() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,3350)", "");
	}

	public boolean validateworkbanner() {
		return driver.findElement(workflow).isDisplayed();
	}

	// Header
	public boolean validateUserName() {
		return driver.findElement(userName).isDisplayed();
	}

	public boolean validateMyorder() {
		boolean Order = driver.findElement(myOrder).isDisplayed();
		System.out.println(Order);
		return Order;
	}

	public boolean validateSteel() {
		return driver.findElement(steelTree).isDisplayed();
	}

	public boolean validateStainlessSteel() {
		return driver.findElement(stainlessSteelTree).isDisplayed();
	}

	public boolean validateConstructionMaterial() {
		return driver.findElement(constructionMaterial).isDisplayed();
	}

	public boolean validateHelpandSupport() {
		return driver.findElement(helpSupport).isDisplayed();
	}

	public boolean validateAboutUs() {
		return driver.findElement(aboutUs).isDisplayed();
	}

	public boolean validateBlogs() {
		return driver.findElement(blogs).isDisplayed();
	}

	public void validateToggled() {
		// return driver.findElement(toggled).getText();
		System.out.println(driver.findElement(toggled).getText());

	}

	public void subSteelTree() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).perform();
		Thread.sleep(2000);
	}

	public void subSSTree() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(stainlessSteelTree);
		action.moveToElement(we).perform();
		Thread.sleep(2000);
	}

	public void subConstructionTree() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(constructionMaterial);
		action.moveToElement(we).perform();
		Thread.sleep(2000);
	}

	public void clickMyorder() {
		driver.findElement(myOrder).click();
	}

	public void clickHelp() {
		driver.findElement(helpSupport).click();
	}

	public void clickAboutUs() {
		driver.findElement(aboutUs).click();
	}

	public boolean validateAddressIcon() {
		return driver.findElement(addressIcon).isDisplayed();
	}

	public String validateAddress() {
		return driver.findElement(address).getAttribute("textContent");
	}

	public void clickConnect() {
		driver.findElement(connectWithUs).click();
		driver.findElement(By.xpath("//span[text()='Help & support']")).click();
	}

	// Footer

	public boolean validateFooter() {
		return driver.findElement(footerpartContainer).isDisplayed();
	}

	public void scroll() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,3200)", "");

	}

	public void socialogo() {
		for (int i = 0; i < 5; i++) {
			String logo = driver.findElement(SociaMediaLogos).getAttribute("title");
			System.out.println(logo);
		}
	}

	public boolean validateEmailID() {
		boolean email = driver.findElement(emailSupport).isDisplayed();
		System.out.println(email);
		return email;
	}

	// TMT and Welding Consumables

	public void validateTMT() throws InterruptedException {
		driver.findElement(tmt).isDisplayed();
		driver.findElement(tmt).click();
		Thread.sleep(3000);
	}

	public void validateWelding() throws InterruptedException {
		driver.findElement(welding).isDisplayed();
		driver.findElement(welding).click();
		Thread.sleep(3000);
	}

	public void verifyWeldingCategory() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2100)", "");
		driver.findElement(weldingCategory).isDisplayed();
	}

	public void weldingCategoryList() throws InterruptedException {
		// List<WebElement> products = driver.findElements(weldingProductsList);
		// int no = products.size();
		// for (int i = 0; i < no; i++) {
		// driver.findElement(weldingProductsList).getText();
		// }
		String product = driver.findElement(weldingProductsList).getText();
		System.out.println("Welding Products :" + product);
		Thread.sleep(2000);
	}

	public void viewAllWelding() {
		driver.findElement(viewAllWelding).isDisplayed();
		driver.findElement(viewAllWelding).click();
	}

	public void selectHotRolled() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(steelMenu);
		action.moveToElement(we).build().perform();

		WebElement we1 = driver.findElement(By.partialLinkText("Hot rolled"));
		action.moveToElement(we1).build().perform();

		we1.click();

		Thread.sleep(3000);
	}

	public void clickOnBlogs() throws InterruptedException {
		driver.findElement(Blogs).click();
		Thread.sleep(4000);
	}
	
	public void validateCement() throws InterruptedException {
		driver.findElement(cement).isDisplayed();
		driver.findElement(cement).click();
		Thread.sleep(3000);
	}
	
	public void refreshPage() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();;
	}


}
