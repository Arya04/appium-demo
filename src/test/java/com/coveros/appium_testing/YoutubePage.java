package com.coveros.appium_testing;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class YoutubePage {
	public YoutubePage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
	}
	public void goToAccount() {
		account.click();
	}
	public void goToVideo() {
		video.click();
		nav.click();
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
