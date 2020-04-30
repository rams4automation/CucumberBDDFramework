package com.testautomation.StepDefination.PersonalConsumer;

import java.util.Map;

import com.testautomation.PageObjects.PersonalConsumer.EmployeeRegistrationFormPage;
import com.testautomation.PageObjects.PersonalConsumer.PCSetupHomePage;
import com.testautomation.PageObjects.PersonalConsumer.SignInPage;
import com.testautomation.Utility.BaseTest;
import com.testautomation.Utility.ExcelHandler;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class PersonalConsumerMaintenance_002 extends BaseTest{
	
	
	private PCSetupHomePage homepage;
	private SignInPage signinPage;
	private EmployeeRegistrationFormPage ERformpage;
	//private TestDataHandler testdata;
	//private Map<String,String> testdataInMap;
	private Map<String,String> TestDataInMap;
	protected String sheetPath = System.getProperty("user.dir")+ "/resources-testdata/TestData.xlsx";
	protected String sheetName = "Driver";
	
	//private String UserName, Password, firstName, lastName, colorCode, birthMonth, birthDay, birthYear, bookingNumber;

	
	@Before("@PersonalConsumerMaintenance")
	public void beforeMethod() throws Exception {
		homepage =new PCSetupHomePage();
		signinPage=new SignInPage();
		ERformpage=new EmployeeRegistrationFormPage();
		//testdata =new TestDataHandler();
		TestDataInMap=ExcelHandler.getTestDataInMap(sheetPath, sheetName, this.getClass().getSimpleName());
		System.out.println("Executing Test Case " +  this.getClass().getSimpleName());
		//testdata.setTestDataInMap(TestDataInMap);
		//testdataInMap=testdata.getTestDataInMap();
		System.out.println(TestDataInMap.get("username"));
		System.out.println(TestDataInMap.get("passwrd"));
		
	}

		
	
	@Given("^Lunch TimeSheet Application$")
		public void lunchTimeSheetApplication() throws Throwable {
			BaseTest.lunachApplication();
		}
		
		@When("^Navigate to TimeSheet Application$")
		public void NavigatetoTimeSheetApplication() throws Throwable {
			signinPage.enterUserNameandPwd(TestDataInMap.get("username"), TestDataInMap.get("passwrd"));
			
		}
		
		@When("^Click on Employee Detail Link$")
		public void ClickEmployeeDetailstab() throws Throwable {
			homepage.clickonEmpdetails();
		}
		
		@When("^Navigate to Employee Registration Form$")
		public void NavigatetoemployeeRegistrationform() throws Throwable {
			homepage.ClickonNewUser();
		}
		
		@Given("^Enter details in New Employee Registration Form$")
		public void filllEmployeeRegistrationform() throws Throwable {
		 ERformpage.enternewemployeedetails("Test5", TestDataInMap.get("FirstName"),TestDataInMap.get("PassWord"), TestDataInMap.get("ConfirmPassWord")
					,TestDataInMap.get("DateOfJoining"), TestDataInMap.get("EmailID"),TestDataInMap.get("selectCounty"), TestDataInMap.get("RatePerHour"));
		}

		@When("^Click on Admin Link$")
		public void clickonAdminLink() throws Throwable {
			homepage.clickadminlink();
		}
		
		@Given("^Click on Logout Link$")
		public void clickonLogout() throws Throwable {
			homepage.clickLogoutlink();
			Thread.sleep(2000);
			driver.close();
		}
		

}
