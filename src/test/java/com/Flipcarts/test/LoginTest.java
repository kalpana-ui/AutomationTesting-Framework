package com.Flipcarts.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.base;
import com.Pages.accountPage;
import com.Pages.homePage;
import com.Pages.loginPage;

public class LoginTest extends base { //only one time use extend keyword in class [multiple inheritences cannot support java
	//login changes
	public LoginTest() throws IOException{
		super();
	}
	
	WebDriver driver ;//Gobal Variable declariation
	
	@BeforeMethod
	@Parameters("browserName")
	public void setup() {
		
		driver = initializeBrowserAndAppllicationLaunch();
		homePage home = new homePage(driver); // instead of extend, create an object because here already have extend 
		home.clickOnMyAccount();
		home.selectLogin();
		
	}
	
	//@AfterTest
	//public void applicationLogout() {
		//driver.findElement(By.xpath("//a[text()='Logout']")).click();
	
	
	@AfterMethod
	public void quitBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test (priority = 1)
	public void loginWithValidUserNameAndValidPassword1() {
		
		loginPage login = new loginPage(driver);
		login.enteruserName(prop.getProperty("username"));
		login.enterPassword(prop.getProperty("password"));
		login.clickOnSubmitButton();
	
		accountPage acctpag = new accountPage(driver);
		acctpag.verifyLoginSuccessfullText();
		
	}	

//TC-2
	@Test(priority =2)
	public void loginWithValidUserNameAndInvalidPassword() {
	
		loginPage login = new loginPage(driver);
		login.enteruserName(prop.getProperty("username"));
		login.enterPassword(prop.getProperty("incorrectpassword"));
		login.clickOnSubmitButton();
		login.verifyLoginWarningMessage();
	
	}

//TC-3
	@Test(priority =3)
	public void loginWithInvalidUserNameAndValidPassword() {
		
		loginPage login = new loginPage(driver);
		login.enteruserName(prop.getProperty("incorrectUserName"));
		login.enterPassword(prop.getProperty("password"));
		login.clickOnSubmitButton();
		login.verifyLoginWarningMessage();
	
	}
	@Test (priority =4)
	public void loginWithInvalidUserNameAndInvalidPassword() {

		loginPage login = new loginPage(driver);
		login.clickOnSubmitButton();
		login.verifyLoginWarningMessage(); //assertion
		
		
		
	}
}