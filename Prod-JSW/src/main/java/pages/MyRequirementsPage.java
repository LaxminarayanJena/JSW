package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyRequirementsPage {

	private WebDriver driver;
	private By myRequirements = By.xpath("//a[normalize-space()='My requirements']");

	public MyRequirementsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMyrequirementTab() {
     driver.findElement(myRequirements).click();
	}

	public void verifyRequirementsID() {
		

	}

	public void validateProductDetails() {

	}

	public void validateTotalQuantity() {

	}

}
