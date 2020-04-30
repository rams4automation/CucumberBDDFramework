package com.testautomation.StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LogintoEmployeeSheet {
	
	WebDriver driver;
	
		
	   @Given("^Launch Employee TimeSheet$")
		public void launch_Employee_TimeSheet() throws Throwable {
			System.setProperty("webdriver.chrome.driver","C://SeleniumDrivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://qualitypointtech.net/timesheetdemo/index.php?logout=true#logoutstatus");
		}
	
	   @When("^Enter \"([^\"]*)\" and \"([^\"]*)\"$")
	   public void enter_and(String UName, String pass) throws Throwable {
			driver.findElement(By.xpath("//*[@id='username']")).sendKeys(UName);
			driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/input")).sendKeys(pass);
			driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/input")).click();
		}
	
	   @Then("^Logout Employee timesheet$")
		public void logout_Employee_timesheet() throws Throwable {
			Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/a[2]")).click();
		    Thread.sleep(2000);
		    driver.quit();
		}
	   

}
