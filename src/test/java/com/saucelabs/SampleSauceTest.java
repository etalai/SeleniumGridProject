package com.saucelabs;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SampleSauceTest {
	
	public static final String USERNAME = "takeshi90";
	public static final String ACCESS_KEY = "7123429c-de3c-47f5-aa88-8f3ff49cd38a";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws Exception {
		/**
		 * 
		 */
		// DesiredCapabilities caps = DesiredCapabilities.firefox();
		// caps.setCapability("platform", "Windows 8");
		// caps.setCapability("version", "43.0");

		DesiredCapabilities caps = DesiredCapabilities.edge();
		caps.setPlatform(Platform.WIN10);	
//		OR
//		caps.setCapability("platform", "Windows 10");
		
		caps.setVersion("14.14393");
//		OR
//		caps.setCapability("version", "14.14393");
		
//		DesiredCapabilities caps = DesiredCapabilities.safari();
//		caps.setCapability("platform", "macOS 10.12");
//		caps.setCapability("version", "11.0");
		
//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//		caps.setCapability("platform", "OS X 10.10");
//		caps.setCapability("version", "62.0");
		
//		DesiredCapabilities caps = DesiredCapabilities.safari();
//		caps.setCapability("platform", "OS X 10.10");
//		caps.setCapability("version", "8.0");
		
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		/**
		 * Goes to Sauce Lab's guinea-pig page and prints title
		 */

		driver.get("https://amazon.com");
		System.out.println("title of page is: " + driver.getTitle());

		driver.quit();
	}
}