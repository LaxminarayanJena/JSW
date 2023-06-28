package pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BlogsPage {

	private WebDriver driver;
	private By Business = By.linkText("Business");
	private By Sustainability = By.linkText("Sustainability");
	private By Technology = By.linkText("Technology");
	private By Product = By.linkText("Product");
	private By Pagination = By.xpath("//UL[@class='v-pagination theme--light']");
	private By RecentBlogs = By.xpath("//UL[@class='v-pagination theme--light']");

	public BlogsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String validateBlogPageisDisplayed() {

		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(handles);
		System.out.print(ar);
		driver.switchTo().window(ar.get(1));
		String title = driver.getTitle();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").toString().equals("complete");

		return title;
	}
	
	public void validateHeader()
	{
		driver.findElement(Business).isDisplayed();
		driver.findElement(Sustainability).isDisplayed();
		driver.findElement(Technology).isDisplayed();
	}

	public void validatePagination() {
		driver.findElement(By.xpath("//UL[@class='v-pagination theme--light']")).isDisplayed();
		
	}
	
	public void clickonProduct() throws InterruptedException
	{
		driver.findElement(Product).click();
		Thread.sleep(3000);
	}

	public void validaterecentBlogs() {
		driver.findElement(RecentBlogs).isDisplayed();
		
	}

}
