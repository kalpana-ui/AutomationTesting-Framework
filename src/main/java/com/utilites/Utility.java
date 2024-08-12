package com.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Utility {
	
	WebDriver driver;

	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public static void timestamp() {

	}

	// code to take screenshot
	public void takingScreenshot() throws Throwable {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File(System.getProperty("user.dir") + "\\screenshots\\RegisterPageScreenshot.png");
		FileUtils.copyFile(src, dst);
	}

	// Take Screenshot for attaching it in extent report
	public static String takeScreenshot(WebDriver driver, String testCaseName) {
		// Add Screenshot when test case failed
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcScreenshotPath = screenshot.getScreenshotAs(OutputType.FILE);
		String destScreenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + testCaseName + ".png";
		try {
			FileUtils.copyFile(srcScreenshotPath, new File(destScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destScreenshotPath;
	}


	// to generate Random email address
	public static String generateRandomEmailAddress() {
		Random rnd = new Random();
		int number = rnd.nextInt(99999);
		String emailId = "Subhash" + number + "@gamil.com";
		System.out.println(emailId);
		return emailId;
		}
	

	
	public  void ReadDataFromPropertiesFile () throws IOException {
		//C:\excel\SeleniumExcel\config.properties.txt
		
	}
	
	//C:\excel\SeleniumExcel\readDataFile.xlsx

	
	public void ReadDataFromExcel() {
		
	String path1 ="C:\\excel\\SeleniumExcel\\readDataFile.xlsx" ;
	
	 XSSFWorkbook wbook=null;
	 
		try {
			FileInputStream fis=new FileInputStream(path1);
			   wbook =new XSSFWorkbook(fis);
			  
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		XSSFSheet sheet=wbook.getSheetAt(0);
		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		for(int i=0;i<rowCount;i++) {
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0;j<colCount;j++) {
				XSSFCell cell=row.getCell(j);
				
			switch(cell.getCellType()) {
			case STRING: System.out.print(cell.getStringCellValue());
			break;
			case NUMERIC:System.out.print(cell.getNumericCellValue());
			break;
			
			}
			System.out.print("  |  ");
			}
			System.out.println();
			
		}
	 }
}


