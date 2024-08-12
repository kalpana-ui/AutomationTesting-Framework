package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class loginPage {
	WebDriver driver;

	public  loginPage(WebDriver driver) {
	this.driver=driver;
}
	
	public void enteruserName (String userName) {
		driver.findElement(By.id("input-email")).sendKeys(userName);
	}
	public void enterPassword(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}
	public void clickOnSubmitButton() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	public void verifyLoginWarningMessage () {
		
		String actualtext = driver.findElement(By.xpath("//div[contains(text(),'Warning')]")).getText();
		String expectedtext = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(expectedtext, actualtext);
	}
}
