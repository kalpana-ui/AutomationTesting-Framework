package com.Flipcarts.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.base;
import com.Pages.RegisterPages;
import com.Pages.accountPage;
import com.Pages.homePage;
import com.utilites.Utility;



	public class RegisterTest extends base {

		
		 
		public RegisterTest() throws IOException {
			super();// we are bringing the code to read data from properties file

		}
		  WebDriver driver;
		
		@BeforeMethod
		public void startUp() throws Exception {

			driver = initializeBrowserAndAppllicationLaunch();
			homePage home = new homePage(driver);
			home.clickOnMyAccount();
			home.selectRegister();
		}

		@AfterMethod
		public void quitBrowser() {
			driver.quit();
		}

		@Test(priority = 1)
		public void registerWithValidFields() throws Throwable {

			RegisterPages registerPage = new RegisterPages(driver);
			registerPage.enterFirstName(prop.getProperty("firstName"));
			registerPage.enterLastName(prop.getProperty("lastName"));
			registerPage.enterEmail(Utility.generateRandomEmailAddress());
			registerPage.enterTelephone(prop.getProperty("telephone"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
			registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
			registerPage.clickOnPrivacyPolicyAgree();
			registerPage.clickOnContinueButton();
			registerPage.verifyAccountHasBeenCreatedSuccessMessage();
			
			
			Utility utl = new Utility(driver);
			utl.takingScreenshot();
		}

		@Test(priority = 2)
		public void registerWithValidFieldsAndSubscribe() throws Throwable {

			RegisterPages registerPage = new RegisterPages(driver);
			registerPage.enterFirstName(prop.getProperty("firstName"));
			registerPage.enterLastName(prop.getProperty("lastName"));
			registerPage.enterEmail(Utility.generateRandomEmailAddress());
			registerPage.enterTelephone(prop.getProperty("telephone"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
			registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
			registerPage.clickOnNewsLetterAsYes();
			registerPage.clickOnPrivacyPolicyAgree();
			registerPage.clickOnContinueButton();
			registerPage.verifyAccountHasBeenCreatedSuccessMessage();	
			
			Utility utl = new Utility(driver);
			utl.takingScreenshot();
		}

		@Test(priority = 3)
		public void registerWithoutAgreeingToPrivacyPolicy() throws Throwable {

			RegisterPages registerPage = new RegisterPages(driver);
			registerPage.enterFirstName(prop.getProperty("firstName"));
			registerPage.enterLastName(prop.getProperty("lastName"));
			registerPage.enterEmail(Utility.generateRandomEmailAddress());
			registerPage.enterTelephone(prop.getProperty("telephone"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
			registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
			registerPage.clickOnNewsLetterAsYes();
			// Here we are not agreeing the Privacy Policy
			
			registerPage.clickOnContinueButton();
			registerPage.verifyYouMustAgreePolicyWarningMessage();
			
			Utility utl = new Utility(driver);
			utl.takingScreenshot();
			
		}

		@Test(priority = 4)
		public void registerWithoutEnteringAnyField() throws Throwable {
			
			RegisterPages registerPage = new RegisterPages(driver);
			registerPage.clickOnContinueButton();
			registerPage.verifyYouMustAgreePolicyWarningMessage();
			registerPage.verifyFirstNameFieldErrorMessage();
			registerPage.verifyLastNameFieldErrorMessage();
			registerPage.verifyEmailFieldErrorMessage();
			registerPage.verifyTelePhoneFieldErrorMessage();
			registerPage.verifyPasswordFieldErrorMessage();
			
			Utility utl = new Utility(driver);
			utl.takingScreenshot();
		}
	}



