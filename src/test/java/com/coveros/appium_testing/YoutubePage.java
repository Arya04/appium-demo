package com.coveros.appium_testing;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YoutubePage {
	AndroidDriver<WebElement> driverX;
	public YoutubePage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		driverX = driver;
	}
	
	@AndroidFindBy(id = "Search")
	public WebElement search;
	
	@AndroidFindBy(id = "search_edit_text")
	public WebElement searchQuery;
	
	@AndroidFindBy(id = "Account")
	public WebElement account;
	
	@AndroidFindBy(id = "Video")
	public WebElement video;
	
	@AndroidFindBy(id = "Navigate up")
	public WebElement nav;
	
	@AndroidFindBy(id = "YouTube")
	public WebElement home;
	
	

	public void search(String params) throws Exception{
		search.click();
		searchQuery.sendKeys(params);
		assertSearch(params);
	}
	public void goToAccount() {
		account.click();
		isOnAccount();
	}
	public void goToVideo() {
		video.click();
		nav.click();
		isHome();
	}
	public void assertSearch(String params) {
		Assert.assertEquals(searchQuery.getText(), params);
	}
	public void isHome() {
		Assert.assertTrue(home.isDisplayed());
	}
	public void isOnAccount() {
		Assert.assertTrue(account.isDisplayed());
	}
}
