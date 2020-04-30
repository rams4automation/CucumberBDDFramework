package com.testautomation.Listeners;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener {
	
	
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	
	
	 public static ExtentReports setUp(){
		 String reportlocation = ".Reports/Extent_Report.html";
		 report = new ExtentHtmlReporter(reportlocation);
		 report.config().setDocumentTitle("Automation Test Report");
		 report.config().setReportName("Automation Test Report");
		 report.config().setTheme(Theme.STANDARD);
		 System.out.println("Extent Report loaction initialized....");
		 report.start();
		 
		 extent = new ExtentReports();
		 extent.attachReporter(report);
		 extent.setSystemInfo("Application", "TimeSheet");
		 extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		 extent.setSystemInfo("User Name", System.getProperty("user.name"));
		 System.out.println("System Info. set in Extent Report");
		 return extent;
	 }
	 
	 
	 public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable){
		 
		 switch (teststatus) {
		 case "FAIL":
			 extenttest.fail(MarkupHelper.createLabel("test Case is Failed : ", ExtentColor.RED));
			 extenttest.error(throwable.fillInStackTrace());
			 
			 if(driver != null) {
				 driver.quit();
			 }
		 
		   break;
		   
		 case "PASS":
			 extenttest.pass(MarkupHelper.createLabel("test Case is Passed : ", ExtentColor.GREEN));
			 break;
			 
		default:
		    break;
		 
		 }
		 
		 
		 
		 
		 
	 }
	

}
