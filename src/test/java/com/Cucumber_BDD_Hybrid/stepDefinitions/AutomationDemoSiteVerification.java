package com.Cucumber_BDD_Hybrid.stepDefinitions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/com/Cucumber_BDD_Hybrid/features/submitAutomationPage.feature",
		glue = "com.Cucumber_BDD_Hybrid.runners",
        plugin = {"pretty", "html:target/cucumber-reports.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
) 

public class AutomationDemoSiteVerification extends AbstractTestNGCucumberTests {

}
