package com.testautomation.PageObjects.PersonalConsumer;

import org.openqa.selenium.By;
import com.testautomation.Utility.ActionsLibrary;


public class PCSetupHomePage extends ActionsLibrary{
	

	public By Empdetails = By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[3]/td/ul/li[1]/a");
	public By adminlink = By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/a[1]");
	public By logoutlink = By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/a[2]");
	public By createnewuser = By.xpath("//a[text()='Create New User']");
	
	
		
		public void clickonEmpdetails() {
			try {
				Click(driver.findElement(Empdetails), "Employee Details Link");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		

		public void ClickonNewUser() {
			try {
				Click(driver.findElement(createnewuser), "Create New User");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		public void clickadminlink() {
			try {
				Click(driver.findElement(adminlink), "Admin Link");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		public void clickLogoutlink() {
			try {
				Click(driver.findElement(logoutlink), "Logout Button");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		

}
