package com.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class base {

	WebDriver driver;
	public Properties prop ;
	
	//read data from properties file  - created a base class constructor
	public base() throws IOException{
		String propPath ="C:\\Users\\dell\\eclipse-workspace\\Flipcarts\\src\\main\\java\\com\\TestData\\config.properties";
		FileInputStream fis = new FileInputStream(propPath);
		prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("browserName"));
		}
	
	
	public WebDriver initializeBrowserAndAppllicationLaunch() {
		
		String browserName = prop.getProperty("browserName");
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Provide a valid browser name");
		}
		
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
}
