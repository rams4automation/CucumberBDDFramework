package com.testautomation.Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;



public class ActionsLibrary extends BaseTest{
	
	
	
	public ExtentReportLogs extentLogs = new ExtentReportLogs();
	
	
	
		public boolean type(WebElement element, String valueToType) throws Throwable {
			boolean status = false;
			try {
				if (valueToType != null) {
					WebDriverWait wait = new WebDriverWait(driver, 60);
					wait.until(ExpectedConditions.elementToBeClickable(element));
					element.clear();
					element.sendKeys(valueToType);
					Thread.sleep(100);
					status = true;
				}
	
			} catch (Exception e) {
				status = false;
				//extentLogs.error("Type","Failed to enter text value - '" + valueToType + "' due to execption - " + e.getMessage() + ".");
			}
			return status;
		}

	
		public boolean Click(WebElement element, String str) {
			boolean status = false;
			try {
				WebDriverWait wait = new WebDriverWait(driver, 60);
				if (ExpectedConditions.elementToBeClickable(element) == null) {
					System.out.println("null");
				}
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				Thread.sleep(100);
				status = true;
				//extentLogs.pass("Click", "Successfully clicked '" + str + "'");
			
		}catch (Exception e) {
			status = false;
			// extentLogs.error("Click", "Element is not clickable due to exception  " + e.getMessage() + ".");
		}
		return status;
		
		}
	
	
}
