package com.jswone.msme.oms.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SauceLabsWeb {
	private WebDriver driver;
	public static final String USERNAME = "jsw_WuFw80";
	public static final String AUTOMATE_KEY = "aysSxb52PQhhf6XB5xQJ";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Test
	public void Windows() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "latest");

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.navigate().to("https://qa-oms.msme.jswone.in/");
		driver.quit();
	}
}