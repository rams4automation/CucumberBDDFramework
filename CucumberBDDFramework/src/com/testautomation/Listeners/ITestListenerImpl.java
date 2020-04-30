package com.testautomation.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;


public class ITestListenerImpl extends ExtentReportListener implements ITestListener {

	
	private ExtentReports extent;
	
		@Override
		public void onStart(ITestContext arg0) {
			 System.out.println("Execution Started on QA Environment................");
			 extent=setUp();
		}
		
		
		@Override
		public void onFinish(ITestContext arg0) {
			 System.out.println("Execution Completed on QA Environment................");		
			 extent.flush();
			 System.out.println("Generated Report . . .");
		}
	
		@Override
		public void onTestSuccess(ITestResult arg0) {
			System.out.println("PASS");
		}
		
		@Override
		public void onTestFailure(ITestResult arg0) {
			System.out.println("FAIL");
		}
		
		@Override
		public void onTestSkipped(ITestResult arg0) {
			System.out.println("SKIP");
		}
		
		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
			// TODO Auto-generated method stub
		}
	
		@Override
		public void onTestStart(ITestResult arg0) {
			
		}
	
		
		
		

}
