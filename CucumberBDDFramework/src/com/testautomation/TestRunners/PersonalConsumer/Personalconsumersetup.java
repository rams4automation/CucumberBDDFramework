package com.testautomation.TestRunners.PersonalConsumer;

	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import com.cucumber.listener.Reporter;
	import cucumber.api.CucumberOptions;
	import cucumber.api.testng.CucumberFeatureWrapper;
	import cucumber.api.testng.TestNGCucumberRunner;

	
	@CucumberOptions(
	        features ="./features",
	        glue = {"com.testautomation.StepDefination"},
	        tags = {"@PersonalConsumerSetUp"},
			plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
	                "pretty",
	                "html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/CucumberTestReport.json",
	                "rerun:target/cucumber-reports/rerun.txt",
	                "junit:target/cucumber-reports/cucumber.xml"})



public class Personalconsumersetup {
	    private TestNGCucumberRunner testNGCucumberRunner;
	 
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() throws Exception {
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }
	 
	    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }
	 
	    @DataProvider
	    public Object[][] features() {
	        return testNGCucumberRunner.provideFeatures();
	    }
	 
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();
	    }

	        @AfterClass
	        public static void setup() {
	           //Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
	            Reporter.setSystemInfo("User", System.getProperty("user.name"));
	            Reporter.setSystemInfo("OS", "Windows");
	            Reporter.setSystemInfo("Project", "TimeSheet Application");
	           
	      }
	        
	        
	}

