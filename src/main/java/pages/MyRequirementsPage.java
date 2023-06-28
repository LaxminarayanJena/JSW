package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyRequirementsPage {

	private WebDriver driver;
	private By myRequirements = By.xpath("//a[normalize-space()='My requirements']");
	private By requirementId = By.xpath("(//*[contains(text(),'Requirements ID')])[1]");
	private By ProductDetails = By.xpath("(//*[contains(text(),'Item details')])[1]");
	private By TotalQuantity = By.xpath("(//*[contains(text(),'Total quantity')])[1]");

	public MyRequirementsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMyrequirementTab() {
		driver.findElement(myRequirements).click();
	}

	public void verifyRequirementsID() {

		driver.findElement(requirementId).isDisplayed();
	}

	public void validateProductDetails() {
		driver.findElement(ProductDetails).isDisplayed();
	}

	public void validateTotalQuantity() {
		driver.findElement(TotalQuantity).isDisplayed();

	}

}
