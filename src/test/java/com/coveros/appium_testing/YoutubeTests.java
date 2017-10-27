package com.coveros.appium_testing;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YoutubeTests {
	private static AndroidDriver<WebElement> driver;
	private static final String APP_PACKAGE_NAME = "com.google.android.youtube:";

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "emulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("unicodeKeyboard", "true");                                     
		capabilities.setCapability("resetKeyboard", "true");
		capabilities.setCapability("appPackage", "com.google.android.youtube");
		capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void youtubeSearch() throws Exception{
		String expected = "travis scott";

		driver.findElementByAccessibilityId("Search").click();
		driver.findElementById(APP_PACKAGE_NAME+ "id/search_edit_text").sendKeys(expected);
		//driver.findElementById(APP_PACKAGE_NAME+ "id/search_edit_text").sendKeys(Keys.ENTER);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView").click();
		
		WebElement search = driver.findElementById(APP_PACKAGE_NAME+"id/search_query");
	    
		
		String actual = search.getText().toString();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void checkCloseButton() throws Exception{
		driver.findElementByAccessibilityId("Account").click();
		driver.findElementByAccessibilityId("Close").click();
		
		
		WebElement details = driver.findElementById(APP_PACKAGE_NAME +"id/details");
		
		Assert.assertNotNull(details);
	}
	
    
}
