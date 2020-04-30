package com.testautomation.PageObjects.PersonalConsumer;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.testautomation.Utility.ActionsLibrary;




public class EmployeeRegistrationFormPage extends ActionsLibrary {
	

	
	
	public By txt_UserName = By.xpath("//input[@name='employee_id']");
	public By txt_firstName = By.xpath("//input[@name='first_name']");
	public By txt_passwrd = By.xpath("//input[@name='password']");
	public By txt_confirmpassword = By.xpath("//input[@name='confirmpassword']");
	public By txt_dateofJoining = By.xpath("//input[@name='date']");
	public By txt_emailid = By.xpath("//input[@name='emailid']");
	public By drp_country = By.xpath("//select[@name='country']");
	public By txt_rateperhour = By.xpath("//input[@name='rateperhour']");
	public By btn_submit = By.xpath("//input[@type='submit']");



	public void enternewemployeedetails(String Username,String firstName,String passwrd,String confirmpwd
			,String dateofjoin,String emilid,String countryval,String ratehour) throws Throwable{
		type(driver.findElement(txt_UserName),Username);
		type(driver.findElement(txt_firstName),firstName);
		type(driver.findElement(txt_passwrd),passwrd);
		type(driver.findElement(txt_confirmpassword),confirmpwd);
		type(driver.findElement(txt_dateofJoining),dateofjoin);
		type(driver.findElement(txt_emailid),emilid);
		Select drpdown=new Select(driver.findElement(drp_country));
		drpdown.selectByVisibleText(countryval);
		type(driver.findElement(txt_rateperhour),ratehour);
		Thread.sleep(2000);
		Click(driver.findElement(btn_submit),"Submit Button");
	}
	
	
	
	
	
}
