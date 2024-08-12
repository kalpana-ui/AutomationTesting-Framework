package com.utilites;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtendReport () {
		
		ExtentReports extentreport = new ExtentReports();
		File extentreportPath = new File("C:\\Users\\dell\\eclipse-workspace\\Flipcarts\\test-output\\ExtentReport\\extentReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentreportPath);
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setReportName("Selenium Project Report");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentreport.attachReporter(sparkReporter);
		
		extentreport.setSystemInfo("Application URL" , "https://tutorialsninja.com/demo/");
		extentreport.setSystemInfo("Browser Name" , "Chrome");
		extentreport.setSystemInfo("Operaring System", System.getProperty("os.name"));
		extentreport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentreport;
	}
	

}
