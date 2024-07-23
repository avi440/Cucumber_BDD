package com.Cucumber_BDD_Hybrid.stepDefinitions;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
//		features = "src/main/resources/features/submitAutomationPage.feature",
		features = "src/test/java/com/Cucumber_BDD_Hybrid/features/submitAutomationPage.feature",
//        glue = {"com.cucumber001_BDD.runners","com.cucumber001_BDD.testCases.demp"},
				glue = "com.Cucumber_BDD_Hybrid.runners",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
) 


public class AutomationDemoSiteVerification extends AbstractTestNGCucumberTests {

}
