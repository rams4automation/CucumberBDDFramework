package com.testautomation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testautomation.Listeners.ExtentReportListener;


public class BaseTest extends ExtentReportListener{
	
	public static WebDriver driver;
	public static Properties pro;
	

	
		public BaseTest() {
			pro=new Properties();
				try {
					FileInputStream fis=new FileInputStream("resources/config.properties");
					pro.load(fis);
				} catch (IOException e) {
					e.getMessage();
				}
		}
		
	
		public static void lunachApplication(){
			String browserName=pro.getProperty("Browser");
			if(browserName.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver",pro.getProperty("chromepath"));
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			} else if(browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.chrome.driver",pro.getProperty(""));
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}else if(browserName.equalsIgnoreCase("Firfox")) {
				System.setProperty("webdriver.chrome.driver",pro.getProperty(""));
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			} else{
				System.out.println("Browser is not initiated");
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(pro.getProperty("baseURL"));
			
		}
		
		
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
