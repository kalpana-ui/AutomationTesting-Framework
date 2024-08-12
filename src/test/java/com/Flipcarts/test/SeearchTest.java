package com.Flipcarts.test;

	import java.io.IOException;

import org.openqa.selenium.WebDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

import com.BaseClass.base;
import com.Pages.SearchhPage;



	public class SeearchTest extends base {

		
		//some comments added
		
		public WebDriver driver;
		
		SeearchTest() throws IOException{
			super();//we are bringing the code to read data from properties file
		}
		
		@BeforeMethod
		public void startUp(){
			
			driver = initializeBrowserAndAppllicationLaunch();
		}
		
		@AfterMethod
		public void quitBrowser() {
			driver.quit();
		}	
		
		@Test(priority=1)
		public void verifySearchWithValidProduct() throws Exception {
			
			SearchhPage searchPage = new SearchhPage(driver);	
			searchPage.enterProductAndClickOnSearchButton(prop.getProperty("productName"));
			searchPage.verifyValidProductDetailOnSearchPage();
		}
		
		@Test(priority=2)
		public void verifySearchWithInvalidProduct() throws Exception{
			
			SearchhPage searchPage = new SearchhPage(driver);	
			searchPage.enterProductAndClickOnSearchButton(prop.getProperty("invalidProduct"));
			searchPage.verifyNoProductDeatilMessage();
		}	
		
		@Test(priority=3, dependsOnMethods = {"verifySearchWithInvalidProduct"})
		public void verifySearchWithoutAnyProduct() throws Exception{
			
			SearchhPage searchPage = new SearchhPage(driver);	
			searchPage.enterProductAndClickOnSearchButton("");
			searchPage.verifyNoProductDeatilMessage();		
		}
	}















