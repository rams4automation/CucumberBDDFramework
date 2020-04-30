/*package com.testautomation.Reporting;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testautomation.Utility.BaseTest;

public class ExtentReportManager extends BaseTest{

		
	   public ExtentHtmlReporter htmlReporter;
	   public ExtentReports extent;
	   public ExtentTest test;
	   
		
	@BeforeTest
	public void setExtent(){
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/TestResults.html");
		
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("TesterName", "Ramesh Potlapuvvu");
		extent.setSystemInfo("Browser", "Chrome");
		
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getThrowable());
			
			String screenshotpath=
			
		}
	}
	
}
*/