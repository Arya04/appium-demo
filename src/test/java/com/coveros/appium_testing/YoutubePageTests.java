package com.coveros.appium_testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class YoutubePageTests {
	private static AndroidDriver<WebElement> driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "emulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.google.android.youtube");
		capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void searchMethod() throws Exception{
		String expected = "batman";
		YoutubePage youtube = new YoutubePage(driver);
		youtube.search(expected);
		youtube.assertSearch(expected);
	}
	
	@Test
	public void goToAccount() throws Exception{
		YoutubePage youtube = new YoutubePage(driver);
		youtube.goToAccount();
		youtube.isOnAccount();
		
	}
	@Test
	public void goToVideo() throws Exception{
		YoutubePage youtube = new YoutubePage(driver);
		youtube.goToVideo();
		youtube.isHome();
	}
}
