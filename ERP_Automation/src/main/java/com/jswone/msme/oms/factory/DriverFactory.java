package com.jswone.msme.oms.factory;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static final String USERNAME = "jsw_WuFw80";
	public static final String AUTOMATE_KEY = "aysSxb52PQhhf6XB5xQJ";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public WebDriver init_driver(String browser) throws Exception {

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+ "\\src\\test\\resources\\com\\jswone\\msme\\oms\\drivers\\chromedriver.exe");

			tlDriver.set(new ChromeDriver(options));
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		}

		if (browser.equals("browserstack")) {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "latest");

			try {
				tlDriver.set(new RemoteWebDriver(new URL(URL), caps));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
