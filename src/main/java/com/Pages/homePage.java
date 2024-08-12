package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	
	WebDriver driver;
	public homePage(WebDriver driver) { //homePage Constructor
		this.driver = driver;
	}
//i want driver from login test
	public void clickOnMyAccount() {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
	}
	
	public void selectLogin() {
		driver.findElement(By.linkText("Login")).click();
		
	}
	public void selectRegister() {
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}

}