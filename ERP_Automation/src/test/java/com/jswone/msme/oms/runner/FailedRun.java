package com.jswone.msme.oms.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		 glue = { "com.jswone.msme.oms.stepdefination",
			"com.jswone.msme.oms.hooks" }, 
		monochrome = true,	
	   // tags = "@DiscountCoupon",
		dryRun = false,
		stepNotifications=true,
		plugin = {
                        "pretty",
                        "json:target/cucumber-report/cucumber.json",
                        "html:target/cucumber-report/cucumber.html",
                        "rerun:target/failedrerun.txt"},
		features = {"@target/failedrerun.txt"}
		         )

public class FailedRun {

}

//CUCUMBER_PUBLISH_TOKEN=e5a3df1c-aa53-4e31-8246-69f7ea912bc1