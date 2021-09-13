package com.gap.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun = false,
		glue = { "stepdefinitions", "AppHooks" },
		features = { "src/test/resources/features" },
		plugin = {"pretty",
				"html:target/cucumber-html-report.html",
				"json:target/cucumber.json",
				"junit:target/cucumber.xml",
				"timeline:test-output-thread/"
		//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			}, 
		monochrome = true
	
)

public class MyTestRunner {

	
}
