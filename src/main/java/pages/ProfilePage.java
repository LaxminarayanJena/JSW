package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ElementUtil;

public class ProfilePage {
	private WebDriver driver;

	private By MyProfileButton = By.className("drop-heading");
	private By SubMenu = By.linkText("Profile");
	private By Designation = By.name("designation");
	private By Udyam = By.xpath("//input[@name='udyam']");
	private By Options = By.xpath("//option[contains(text(),'Select an option')]");
	private By Interest = By.xpath("//div[@id='__nuxt']");
	private By Msg = By.xpath("//div[contains(text(),'Your changes have been saved.')]");
	private By Title = By.xpath("//a[@id='__BVID__389___BV_tab_button__']");
	private By Bname = By.xpath("//span[contains(text(),'Jsw One Platforms Limited')]");
	private By Bcopy = By.xpath(" (//div[@class='copy-icon'])[1]");
	private By Accountnumber = By.xpath("//span[contains(text(),'1112220057850296')]");
	private By Acopy = By.xpath(" (//div[@class='copy-icon'])[2]");
	private By IFSC = By.xpath("//p[@class='text-center with-success-icon']");
	private By Icopy = By.xpath("(//div[contains(text(),'Copy')])[4]");
	private By Save = By.xpath("//button[contains(text(),'Save details')]");
	private By Ok = By.xpath("//button[contains(text(),'Ok')]");
	private By addAddress = By.xpath("//*[text()='+ Add a new address']");
	private By DeleteAddress = By.xpath("//div[@class='delete-button']");
	private By Addresses = By.xpath("//*[text()='Addresses']");
	private By LedgerMenu = By.linkText("Ledger");
	private By Logout = By.xpath("(//*[text()='Logout'])[2]");
	

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMyProfileButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MyProfileButton).click();
	}

	public void clickSubProfile() throws InterruptedException {

		driver.findElement(SubMenu).click();
		Thread.sleep(5000);
	}

	public void clickDesignation() throws InterruptedException {
		driver.findElement(Designation).clear();

		driver.findElement(Designation).sendKeys("Manager");
		Thread.sleep(1000);
	}

	/*
	 * public boolean compareTitle() { return
	 * driver.findElement(Title).isDisplayed(); }
	 */
	public void clickUdyam() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='edit-profile-icon']")).click();
		driver.findElement(Udyam).sendKeys("U1233243543543543");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
	}
	
	public void validateUdyam()
	{
		driver.findElement(By.xpath("//div[contains(text(),'U1233-24-35-4354354')]")).isDisplayed();
	}

	public void clickOption() throws InterruptedException {
		driver.findElement(Options).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//option[contains(text(),'General Engineering & Fabrication')]")).click();
		Thread.sleep(1000);
		driver.findElement(Interest).click();
	}

	public void clickArea() throws InterruptedException {
		driver.findElement(By.xpath("(//input[@class='form-check-input'])[1]")).click();
		Thread.sleep(1000);
	}

	public void clickaccount() throws InterruptedException {
		driver.findElement(Bname).click();
		driver.findElement(Bcopy).click();
		Thread.sleep(3000);
	}

	public void verifycopyicon() throws InterruptedException {
		/* driver.findElement(Bname).getText(); */

		System.out.println(driver.findElement(Bname).getText());
	}

	public void clickaccnumber() throws InterruptedException {
		driver.findElement(Accountnumber).click();
		driver.findElement(Acopy).click();
		Thread.sleep(3000);
	}

	public void verifycopyacc() throws InterruptedException {

		System.out.println(driver.findElement(Accountnumber).getText());
	}

	public void clickIFSC() throws InterruptedException {
		//driver.findElement(IFSC).click();
		driver.findElement(Icopy).click();
	}

	public void verifycopyifsc() throws InterruptedException {
		/* driver.findElement(Bname).getText(); */

		System.out.println(driver.findElement(IFSC).getText());
	}

	public void clickSave() throws InterruptedException {
		driver.findElement(Save).click();
		Thread.sleep(1000);
	}

	public boolean compareMsg() {
		return driver.findElement(Msg).isDisplayed();
	}

	public void ok() {

		driver.findElement(Ok).click();
	}
	/*
	 * public void clickCancel() throws InterruptedException {
	 * driver.findElement(By.xpath(
	 * "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[4]/div[3]/label[1]/span[1]"
	 * )).click(); Thread.sleep(1000); }
	 */

	public void clickAddresses() {
		driver.findElement(Addresses).click();
	}

	public void DeleteAddresses() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,800)", "");
		driver.findElement(DeleteAddress).click();
	}

	public void addAddress() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,400)", "");
		driver.findElement(addAddress).click();
		driver.findElement(By.id("company")).sendKeys("Spark Avertising");
		driver.findElement(By.id("pincode")).sendKeys("600032");
		driver.findElement(By.id("address")).sendKeys("A-4, 3rd Phase, Labour Colony, SIDCO Industrial Estate");
		driver.findElement(By.id("city")).sendKeys("Chennai");
		driver.findElement(By.xpath("//button[text()='Save address']")).click();
	}

	public void cancelNewAddress() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,400)", "");
		driver.findElement(addAddress).click();
		driver.findElement(By.id("company")).sendKeys("Spark Avertising");
		driver.findElement(By.id("pincode")).sendKeys("600032");
		driver.findElement(By.id("address")).sendKeys("A-4, 3rd Phase, Labour Colony, SIDCO Industrial Estate");
		driver.findElement(By.id("city")).sendKeys("Chennai");
		driver.findElement(By.id("state")).sendKeys("Tamil Nadu");
		driver.findElement(By.xpath("//div[text()='Cancel']")).click();
	}

	public void ClickEditBillingAddress() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='edit-button']")).click();

		// List<WebElement>
		// editAddressButtons=driver.findElements(By.xpath("//div[@class='edit-button']"));
		// editAddressButtons.get(1).click();
	}

	public void EditBillingAddress() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='company']")).clear();
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("EditedCompany");
		driver.findElement(By.xpath("//input[@id='mobile']")).clear();
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9898987878");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[contains(text(),'Save address')]")).click();

	}

	// MH Pincode

	public void addNewAddress() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,400)", "");
		WebElement add = driver.findElement(By.xpath("//button[contains(text(),'+ Add a new address')]"));
		System.out.println(add.isDisplayed());
		add.click();
		Thread.sleep(2000);
	}

	public void MHaddress() throws InterruptedException {
		driver.findElement(By.id("company")).sendKeys("Maharashtra Steel");
		Thread.sleep(1500);
		driver.findElement(By.id("pincode")).sendKeys("411002");
		Thread.sleep(1500);
		driver.findElement(By.id("address")).sendKeys("1051/52, New Nana Peth, Bhawani Peth");
		Thread.sleep(1500);
		driver.findElement(By.id("city")).sendKeys("Pune");
		Thread.sleep(1500);
		//driver.findElement(By.id("state")).sendKeys("Maharashtra");
		Thread.sleep(1500);
	}

	public void defaultAddress() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='defaultAddress']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[text()='Save address']")).click();
		Thread.sleep(5500);
	}

	public void deleteExistingAddress() {
		WebElement pincode = driver.findElement(By.xpath("//div[contains(text(),'Maharashtra Steel')]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", pincode);
		WebElement mh = driver.findElement(
				By.xpath("//div[@class='delete-button']//following::div[contains(text(),'Maharashtra Steel')]"));
		boolean delete = mh.isDisplayed();
		if (delete == true) {
			mh.click();
		} else {
			System.out.println(delete);
		}
	}

	public void clickMHDefaultAddress() throws InterruptedException {
		WebElement pincode = driver.findElement(By.xpath("//div[contains(text(),'Maharashtra Steel')]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", pincode);
		j.executeScript("window.scrollTo(0,0)", "");
		WebElement defaultMH = driver.findElement(By.xpath(
				"//div[contains(text(),'Maharashtra Steel')]//following::div[contains(text(),'Default address')]"));
		boolean p = defaultMH.isDisplayed();
		if (p == true) {
			System.out.println(p);
			Thread.sleep(2000);
		} else {
			driver.findElement(By.xpath("//div[contains(text(),'Maharashtra Steel')]")).click();
			Thread.sleep(2000);
		}
	}
	
	public void clickLedgerMenu() throws InterruptedException {

		driver.findElement(LedgerMenu).click();
		Thread.sleep(2000);
	}
	
	public void LogOut() throws InterruptedException {

		driver.findElement(Logout).click();
		Thread.sleep(2000);
	}
	
	public boolean validateLogOutInProfileMenu() throws InterruptedException {

		//WebElement dropdownmenu= driver.findElement(By.xpath("(//section[@class='drop-body'])[1]"));
		//dropdownmenu.findElement(By.xpath("//div[@class='user-dropdown-item']"));
		ElementUtil obj= new ElementUtil(driver);
		boolean LogoutVisibility=obj.isElementPresent("//div[@class='user-dropdown-item']");
		return LogoutVisibility;
		
	}

}
