package com.testautomation.PageObjects.PersonalConsumer;

import org.openqa.selenium.By;
import com.testautomation.Utility.ActionsLibrary;


public class SignInPage extends ActionsLibrary{
	
	
	public By UserName = By.xpath("//*[@id='username']");
	public By PassWrd = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/input");
	public By LoginBtn = By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/input");
	
	
	
	
		public void enterUserNameandPwd(String UName,String Pwd){
			try {
				fillUserName(UName);
				fillPassword(Pwd);
				ClickonLoginBtn();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			
		}
		
		public void fillUserName(String username) throws Throwable {
			try {
			  type(driver.findElement(UserName), username);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		public void fillPassword(String password) throws Throwable {
			try {
				type(driver.findElement(PassWrd), password);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		
		public void ClickonLoginBtn() {
			try {
				Click(driver.findElement(LoginBtn), "Login Button");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

}
