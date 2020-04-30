package com.testautomation.StepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Timesheet {
	
	WebDriver driver;

	@Test
	public void TimeSheetSignin() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","C://SeleniumDrivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://qualitypointtech.net/timesheetdemo/index.php?logout=true#logoutstatus");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/input")).click();
		Thread.sleep(1000);
		clickonDocument();
	//	driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[3]/td/ul/li[1]/a")).click();
	//	Thread.sleep(2000);
		
	/*	
		boolean textResult=variftextinwebtable("Ravi");
		System.out.println(textResult);
		if(textResult==true){
			System.out.println("Value present in webtable");
		}else{
			System.out.println("Value not present in webtable");
		}
	}*/
		
		
	}
	
	
	
		public boolean variftextinwebtable(String Expectetext) {
			  boolean status=false;
			WebElement mytable=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table/tbody"));  
			//To locate rows of table. 
	    	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
	    	//To calculate no of rows In table.
	    	int rows_count = rows_table.size();
	    	//Loop will execute till the last row of table.
	    	for (int row = 0; row < rows_count; row++) {
	    	    //To locate columns(cells) of that specific row.
	    	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
	    	    //To calculate no of columns (cells). In that specific row.
	    	    int columns_count = Columns_row.size();
	    	    //Loop will execute till the last cell of that specific row.
	    	    for (int column = 0; column < columns_count; column++) {
	    	        // To retrieve text from that specific cell.
	    	        String celtext = Columns_row.get(column).getText();
	    	        System.out.println(celtext);
	    	        if(celtext.equals(Expectetext)){
	    	        	status=true;
	    	        }
	    	    }
	    	}
			return status;
		}
		
		public void clickonDocument() {
			  boolean status=false;
			WebElement mytable=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[3]/td/table"));  
			//To locate rows of table. 
	    	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
	    	//To calculate no of rows In table.
	    	int rows_count = rows_table.size();
	    	//Loop will execute till the last row of table.
	    	for (int row = 1; row < rows_count; row++) {
	    	    //To locate columns(cells) of that specific row.
	    	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
	    	    //To calculate no of columns (cells). In that specific row.
	    	    int columns_count = Columns_row.size();
	    	    //Loop will execute till the last cell of that specific row.
	    	    //for (int column = 0; column < columns_count; column++) {
	    	        // To retrieve text from that specific cell.
	    	        boolean checkboxval = Columns_row.get(5).isSelected();
	    	        System.out.println(checkboxval);
	    	       String Expectetext="test";
	    	        if(checkboxval==true){
	    	        	Columns_row.get(1).click();
	    	        }
	    	   // }
	    	}
		}
		
	
}
