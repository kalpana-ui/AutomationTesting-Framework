package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class accountPage {
	
	WebDriver driver;
	public accountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public  void verifyLoginSuccessfullText() {
		
		String actualtext = driver.findElement(By.xpath("//a[text()='Edit your account information']")).getText();
		String expectedtext = "Edit your account information";
		Assert.assertEquals(actualtext, expectedtext);
			
	}
	
}