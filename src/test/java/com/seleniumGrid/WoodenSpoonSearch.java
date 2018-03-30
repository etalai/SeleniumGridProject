package com.seleniumGrid;

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

import pages.AmazonPage;
import pages.EtsyPage;

public class WoodenSpoonSearch {
	WebDriver driver;
	public static final String 
				 URL ="http://localhost:4444/wd/hub";
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.edge();
		caps.setPlatform(Platform.ANY);

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
