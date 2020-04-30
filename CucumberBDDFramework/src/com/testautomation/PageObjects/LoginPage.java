package com.testautomation.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.Utility.BaseTest;

public class LoginPage extends BaseTest {
	
	@FindBy(xpath="//*[@id='username']")
	WebElement UserName;
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/input")
	WebElement PassWrd;
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/input")
	WebElement LoginBtn;
	
	
	
	// Initializing the Page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
		
		public String validateLoginPagetitle(){
			return driver.getTitle();
		}
		
		public void enterUserNameandPwd(String UName,String Pwd){
			UserName.sendKeys(UName);
			PassWrd.sendKeys(Pwd);
			LoginBtn.click();
		}
		

}
