package com.testautomation.StepDefination;

import org.testng.Assert;

import com.testautomation.PageObjects.HomePage;
import com.testautomation.PageObjects.LoginPage;
import com.testautomation.Utility.BaseTest;
import com.testautomation.Utility.PropertiesFileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogintoTimeSheet extends BaseTest{
	
         PropertiesFileReader obj=new PropertiesFileReader();
         LoginPage loginpage;
         HomePage homepage;
	
			
			@Given("^Launch TimeSheet Application$")
			public void launch_TimeSheet_Application() throws Throwable {
					BaseTest.lunachApplication();
					loginpage=new LoginPage();
					String logintitel=loginpage.validateLoginPagetitle();
					String actualtitel="Online Timesheet • Qualitypointtech.com";
					Assert.assertEquals(actualtitel, logintitel);
			   }
		
			@When("^Enter UserName and Password$")
			public void enterUserNameandPassword() throws Throwable {
				  loginpage.enterUserNameandPwd("admin","admin");
		     	}
		
			@Then("^verify home Page$")
			public void verify_home_Page() throws Throwable {
				homepage=new HomePage();
					String actualhometitle=homepage.verifyHomepagetitle();
					String expecthometitle="Report - Online Timesheet • Qualitypointtech.com123";
					Assert.assertEquals(expecthometitle, actualhometitle);
			}
			
			@Then("^click on Employee details$")
			public void click_on_Employee_details() throws Throwable {
				    homepage.clickonEmpdetails();
			  }
	
			@Then("^click on admin link$")
			public void click_on_admin_link() throws Throwable {
					  homepage.clickadminlink();
   			}
	
			@Then("^click on logout$")
			public void click_on_logout() throws Throwable {
					homepage.clickLogoutlink();
					Thread.sleep(2000);
					driver.close();
			}

}
