package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DistributorPage {

	private WebDriver driver;

	private By MyProfileButton = By.xpath("//header[@id='drop-down-head']");
	private By distributor = By.linkText("Distributors");
	private By add = By.className("add-button");
	private By sel = By.id("e9f280f5-ac5a-43e9-9452-0b5a636135b3");
	private By confirm = By.className("distributor-buttom");
	private By remove = By.xpath("//div[contains(text(),'Remove')]");
	private By confirmrem = By.xpath("//div[contains(text(),'CONFIRM')]");
	private By okay = By.xpath("//div[contains(text(),'OKAY')]");
	private By delet = By.xpath("//div[contains(text(),'Change')]");
	private By dist = By.id("e9f280f5-ac5a-43e9-9452-0b5a636135b3");

	public DistributorPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validateMyProfileButton() {
		return driver.findElement(MyProfileButton).isDisplayed();

	}

	public void clickMyProfileButton() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MyProfileButton).click();
	}

	public void clickdistributor() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(distributor).click();
	}

	public boolean validateadddistributor() {
		return driver.findElement(add).isDisplayed();

	}

	public void adddistributor() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(add).click();

		Thread.sleep(3000);
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
		radio.get(1).click();
		Thread.sleep(1000);
		driver.findElement(By.className("distributor-buttom")).click();
		Thread.sleep(2000);
	}

	public boolean validateeditdistributor() {
		return driver.findElement(delet).isDisplayed();

	}

	public void editdistributor() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(delet).click();
		Thread.sleep(1000);
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));

		radio.get(2).click();
		Thread.sleep(1000);
		driver.findElement(confirm).click();
		Thread.sleep(2000);

	}

	public boolean validateremovedistributor() {
		return driver.findElement(remove).isDisplayed();

	}

	public void removedistributor() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(remove).click();
		Thread.sleep(1000);
		driver.findElement(confirmrem).click();
		Thread.sleep(1000);
		driver.findElement(okay).click();
		Thread.sleep(3000);

	}

}