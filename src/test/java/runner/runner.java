package runner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.sorting.SortingMethod;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/" }, glue = { "stepdefination",
		"hooks" }, 
monochrome = true, 
tags = "@Addresses",
dryRun = false, 
stepNotifications = true, plugin = { "pretty",
				"json:target/cucumber-report/cucumber.json", "html:target/cucumber-report/cucumber.html",
				"rerun:target/failedrerun.txt" })

public class runner {
	@AfterClass
	public static void tSearDown() {
		File reportOutputDirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/cucumber-report/cucumber.json");

		String buildNumber = "1";
		String projectName = "JSW MSME Project";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);

		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Branch", "release/1.0");
		configuration.setSortingMethod(SortingMethod.NATURAL);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();

	}

}

//CUCUMBER_PUBLISH_TOKEN=e5a3df1c-aa53-4e31-8246-69f7ea912bc1