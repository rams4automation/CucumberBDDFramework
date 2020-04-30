package com.testautomation.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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

public class ExtentReportLogs extends BaseTest{

		
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
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getThrowable());
			String screenshotpath=ExtentReportLogs.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		}else if (result.getStatus()== ITestResult.SKIP){
			test.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
		}else if(result.getStatus()== ITestResult.SUCCESS){
			test.log(Status.PASS, "Test Case PASSED is " + result.getName());
		}
	}
	
	
	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		
		String destination=System.getProperty("user.dir") + "/ScreenShots/" + screenshotName + dateName + ".png";
		File finalDestinaton =new File (destination);
		FileUtils.copyFile(Source, finalDestinaton);
		return destination;
	}
	
	
	
}
