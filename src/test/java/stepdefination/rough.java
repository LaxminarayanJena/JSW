package stepdefination;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class rough {

	 private static WebDriver driver;
	    public static final String USERNAME = "jsw_WuFw80";
		public static final String AUTOMATE_KEY = "aysSxb52PQhhf6XB5xQJ";
		public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) {
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("os", "Windows");
    	caps.setCapability("os_version", "10");
    	caps.setCapability("browser", "Chrome");
    	caps.setCapability("browser_version", "latest");
 
    	try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

        driver.navigate().to("https://www.jswonemsme.com/");
        driver.quit();

	}

}
