package util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class OtpUtil {

	public static AndroidDriver<MobileElement> addriver;

	public static String getOTP() throws MalformedURLException, InterruptedException {

		{
			AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File("c:\\Program Files\\nodejs\\node.exe"))
					.withAppiumJS(new File(
							"C:\\Users\\admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withLogFile(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\logs.txt")));

			service.start();

			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability("deviceName", "Android");
			capabilities.setCapability("appPackage", "com.google.android.apps.messaging");
			capabilities.setCapability("appActivity", "com.google.android.apps.messaging.home.HomeActivity");
			capabilities.setCapability("noReset", true);

			addriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			String otp = addriver.findElementById("com.google.android.apps.messaging:id/suggestion_button_label")
					.getText();
			otp = otp.replaceAll("[^0-9]", "");
			addriver.quit();
			service.stop();
			return otp;

		}
	}
}

// C:\Program Files
// (x86)\Appium\node_modules\appium\node_modules\appium-chromedriver\chromedriver\win

// C:\Program Files
// (x86)\Appium\resources\app\node_modules\appium\build\lib\main.js

// "C:/Users/Poltu/AppData/Local/Android/sdk/tools/uiautomatorviewer"