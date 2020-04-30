package com.testautomation.StepDefination;

import java.util.Map;

import com.testautomation.Utility.ExcelHandler;

import cucumber.api.java.en.Given;

public class ReadingData {
	
	
	
	@Given("^Read test data for testcase_(\\d+)$")
	public void read_test_data_for_testcase_(int arg1) throws Throwable {
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap("./resources-testdata/TestData.xlsx", "Driver", "TestCase_001");
		System.out.println(TestDataInMap.get("Test1"));
	}
	

}
