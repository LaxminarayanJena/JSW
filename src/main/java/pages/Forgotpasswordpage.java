package pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Forgotpasswordpage {
	private static WebDriver driver;
	private By loginButton = By.xpath("//div[2]/div[1]/button[1]");
	private By forgotPassword = By.xpath("//div[1]/div[2]/div[2]/div[3]");
	private By proceed = By.xpath("//*[text()='Proceed']");
	private By email = By.xpath("//input[@id='email']");
	private By submit = By.xpath("//button[@id='login-via-otp']");
	private By Okay = By.xpath("//button[@class='proceedhome-button-login btn btn-primary']");
	private By confirmation = By.xpath(
			"//*[contains(text(),'Password reset link has been sent to your registered email address')]");
	private By errorMessage = By.xpath(
			"//div[@class='reset-password-login' and contains(text(),'Kindly register yourself to proceed further for JSW One journey')]");
	private By validEmail = By
			.xpath("//div[contains(text(),'You have entered a wrong email address')]");
	private By passwordSubmit = By.xpath("//button[@class='submit-button-login no-empty']");
	private By passwordConfirmtionText = By
			.xpath("//div[@class='bottom-source']/h6/b[contains(text(),'You have successfully reset your password')]");

	private By enterGmail = By.xpath("//*[@id='identifierId']");
	private By clickNext = By.xpath("//*[@id='identifierNext']/div/button/span");
	private By enterPassword = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
	private By clickpasswordNext = By.xpath("//*[@id='passwordNext']/div/button/span");
	private By inboxFirstrecord = By.xpath("//table[@role='grid']//tr[1]");
	private By clickResetLink = By.xpath("//a[contains(text(),'Reset')]");
	private By clickResetNow = By.partialLinkText("Reset now");
	private By clicknewPassword = By.xpath("//input[@id='password']");
	private By clickconfirmPassword = By.id("confirmPassword");
	private By clickSubmit = By.xpath("//button[normalize-space()='Submit']");

	public Forgotpasswordpage(WebDriver driver) {
		Forgotpasswordpage.driver = driver;
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLoginButton() {
		return driver.findElement(loginButton).isDisplayed();

	}

	public void clickForgotPassword() {

		driver.findElement(forgotPassword).click();
	}

	public boolean validateproceedButton() {
		return driver.findElement(proceed).isDisplayed();

	}

	public void clickproceed() throws InterruptedException {
		driver.findElement(proceed).click();
		Thread.sleep(4000);
	}

	public boolean clickEmail() {
		return driver.findElement(email).isDisplayed();
	}

	public void enterGmail(String Email) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(enterGmail).sendKeys(Email);
	}

	public void enterPassword(String Password) {
		driver.findElement(enterPassword).sendKeys(Password);
	}

	public void forgotpassword(String Email) {
		driver.findElement(email).sendKeys(Email);
		driver.findElement(By.xpath("//*[contains(text(),'Password')]")).click();
	}

	public void newPassword(String NewPassword) throws InterruptedException {
		Thread.sleep(5000);
		Set<String> allTabs = null;

		allTabs = driver.getWindowHandles();
		for (String s : allTabs) {
			System.out.println("window name" + s.toString());
			if (driver.switchTo().window(s).getTitle().contains("JSW One")) {

				driver.switchTo().window(s);
			}

		}
		driver.findElement(clicknewPassword).sendKeys(NewPassword);

	}

	public void confirmPassword(String ConfirmPassword) {
		driver.findElement(clickconfirmPassword).sendKeys(ConfirmPassword);
	}

	public void Submit() throws InterruptedException {
		driver.findElement(submit).click();
		Thread.sleep(5000);

	}

	public void clickSubmit() throws InterruptedException {
		driver.findElement(clickSubmit).click();
		Thread.sleep(5000);
	}

	public void clickokay() {

		driver.findElement(Okay).click();
	}

	public void passwordSubmit() {
		driver.findElement(passwordSubmit).click();
	}

	public String verifyText() throws InterruptedException {
		// Thread.sleep(10000);
		String actualConfirmation = driver.findElement(confirmation).getText();
		return actualConfirmation;

	}

	public String verifyErrorText() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		String actualErrorConfirmation = driver.findElement(errorMessage).getText();
		return actualErrorConfirmation;

	}

	public String verifyEmail() throws InterruptedException {
		String actualError = driver.findElement(validEmail).getText();
		return actualError;

	}

	public String verifypasswordConfirmationText() {

		String actualpasswordconfirmation = driver.findElement(passwordConfirmtionText).getText();
		return actualpasswordconfirmation;
	}

	public void enterGmail() {
		driver.findElement(enterGmail).click();
	}

	public void clickNext() {
		driver.findElement(clickNext).click();
	}

	public void enterPassword() {
		driver.findElement(enterPassword).click();
	}

	public void clickpasswordNext() {
		driver.findElement(clickpasswordNext).click();
	}

	public void clickinboxFirstrecord() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(inboxFirstrecord).click();

	}

	public void clickRestLink() throws InterruptedException {
		Thread.sleep(4000);
		 if(isElementPresent("//img[@class='ajT']"))
			 
		 {
			 driver.findElement(By.xpath("//img[@class='ajT']")).click();
		 }
		 else
		 {
			
				
		 }
		driver.findElement(clickResetLink).click();
		Thread.sleep(10000);
		driver.findElement(clickResetNow).click();
	}
	
	public static boolean isElementPresent(String id)
	{
		try {
			driver.findElement(By.xpath(id));
			return true;
		} catch (Exception e) {
			return false;	
		}
		
	}

}
