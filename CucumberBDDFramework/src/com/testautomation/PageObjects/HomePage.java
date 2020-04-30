package com.testautomation.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.Utility.BaseTest;

public class HomePage extends BaseTest{
	
	
	
	@FindBy(xpath="/html/body/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[3]/td/ul/li[1]/a")
	WebElement Empdetails;
	
	@FindBy(xpath="/html/body/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/a[1]")
	WebElement adminlink;
	
	@FindBy(xpath="/html/body/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/a[2]")
	WebElement logoutlink;
	
	
	
	// Initializing the Page objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
		public String verifyHomepagetitle(){
			return driver.getTitle();
		}
		public void clickonEmpdetails(){
			Empdetails.click();
		}
		
		public void clickadminlink(){
			adminlink.click();
		}
		
		public void clickLogoutlink(){
			logoutlink.click();
		}

}
