package com.testautomation.StepDefination.PersonalConsumer;

import java.util.Map;

import com.testautomation.PageObjects.PersonalConsumer.PCSetupHomePage;
import com.testautomation.PageObjects.PersonalConsumer.SignInPage;
import com.testautomation.Utility.BaseTest;
import com.testautomation.Utility.ExcelHandler;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class PersonalConsumerSetup_001 extends BaseTest {
	
	private PCSetupHomePage homepage;
	private SignInPage signinPage;
	private Map<String,String> TestDataInMap;
	protected String sheetPath = System.getProperty("user.dir")+ "/resources-testdata/TestData.xlsx";
	protected String sheetName = "Driver";
	
		@Before("@PersonalConsumerSetUp")
		public void beforeMethod() throws Exception {
			homepage =new PCSetupHomePage();
			signinPage=new SignInPage();
			System.out.println("Executing Test Case " +  this.getClass().getSimpleName());
			TestDataInMap=ExcelHandler.getTestDataInMap(sheetPath, sheetName, this.getClass().getSimpleName());
		 }
		
		@After("@PersonalConsumerSetUp")
		public void afterMethod()throws Exception{
			Thread.sleep(2000);
			driver.close();
		}
		
		@Given("^Lunch PC TimeSheet Application$")
		public void lunch_PC_TimeSheet_Application() throws Throwable {
			BaseTest.lunachApplication();
		}
		
		@When("^Navigate to PC TimeSheet Application$")
		public void navigate_to_PC_TimeSheet_Application() throws Throwable {
			signinPage.enterUserNameandPwd(TestDataInMap.get("username"), TestDataInMap.get("passwrd"));
		}
		
		@When("^Click on PC Employee Detail Link$")
		public void click_on_PC_Employee_Detail_Link() throws Throwable {
			homepage.clickonEmpdetails();
		}
		


}
