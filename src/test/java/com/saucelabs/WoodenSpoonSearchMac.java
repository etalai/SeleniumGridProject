package com.saucelabs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Version;

import pages.AmazonPage;
import pages.EtsyPage;

public class WoodenSpoonSearchMac {
	WebDriver driver;
	public static final String USERNAME = "takeshi90";
	public static final String ACCESS_KEY = 
			"7123429c-de3c-47f5-aa88-8f3ff49cd38a";
	public static final String URL = "https://" + USERNAME
		+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.safari();
		caps.setCapability("platform", "macOS 10.12");
		caps.setCapability("version", "10.1");
		
		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(10, 
											TimeUnit.SECONDS);
	}

	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
	
	@Test
	public void EtsySearch() {

		EtsyPage etsy = new EtsyPage(driver);
		etsy.goToWebsite();
		assert (etsy.atEtsyPage());
		etsy.searchFor("wooden spoon");
		assert (etsy.resultsRdisplayed());
		
	}

	@Test
	public void AmazonSearch() {
		
		AmazonPage amazon = new AmazonPage(driver);
		amazon.goToWebsite();
		assert (amazon.atAmazonPage());
		amazon.searchFor("wooden spoon");
		assert (amazon.resultsRdisplayed());
	
	}

}
