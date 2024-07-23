package com.Cucumber_BDD_Hybrid.runners;

import java.util.List;
import java.util.Map;



import com.Cucumber_BDD_Hybrid.runnersAction.AutomationDemoSiteVerificationAction;
import com.Cucumber_BDD_Hybrid.testCases.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationDemoSiteVerification001 extends BaseClass {
	

	AutomationDemoSiteVerificationAction test ;
	
	@Given("^User login to Automation demo aplication Applictaion$")
	public void user_login_to_automation_demo_aplication_applictaion() {
		setup();
		test = new AutomationDemoSiteVerificationAction(driver,logger);
//		driver.get(baseUrl);
		logger.info("login to Application");
	}
	

	@Then("^User can able to see the Automation demo paga title$")
	public void user_can_able_to_see_the_automation_demo_paga_title(String title) throws Exception {
		test.automationDemoPagaTitle(title);

	}

	@Then("^User can able to see the Automation demo paga (header element|submition field element|submition button)$")
	public void user_can_able_to_see_the_automation_demo_paga_header_element(String elementType,DataTable dataTable) throws Exception {
		List<String> elements = dataTable.asList(String.class);
		test.automationDemoPagaElement(elements,elementType);
	}
	
	@When("^User send the data into (First Name|last Name|Adress|Email address|Phone) field$")
	public void user_send_the_data_into_info_field(String elementType,DataTable dataTable) throws Exception {
		 Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		test.sendDatatoInfoAllField(dataMap, elementType);
	}
	
	@When("^User select the Gender$")
	public void userSelectGender(DataTable GenderdataTable) throws Exception {
		 Map<String, String> dataMap = GenderdataTable.asMap(String.class, String.class);
			test.clickOnGender(dataMap);
	}
	
	@When("^User select the Hobbies$")
	public void userSelectHobbies(DataTable HobbiesTable) throws Exception {
		 Map<String, String> dataMap = HobbiesTable.asMap(String.class, String.class);
			test.clickOnHobbies(dataMap);
	}
	
	@When("^User select the Languages$")
	public void userSelectLanguages(DataTable languagesTable) throws Exception {
		 Map<String, String> dataMap = languagesTable.asMap(String.class, String.class);
			test.selectLanguages(dataMap);
	}
	
	@When("^User select the Skills$")
	public void userSelectSkills(DataTable languagesTable) throws Exception {
		 Map<String, String> dataMap = languagesTable.asMap(String.class, String.class);
			test.userSelectSkills(dataMap);
	}
	
	@When("^User select the Select Country$")
	public void userSelectCountry(DataTable languagesTable) throws Exception {
		 Map<String, String> dataMap = languagesTable.asMap(String.class, String.class);
			test.userSelectCountry(dataMap);
	}
	
	@When("^User select the Date Of Birth$")
	public void userSelectDateOfBirth(DataTable languagesTable) throws Exception {
		 Map<String, String> dataMap = languagesTable.asMap(String.class, String.class);
			test.userSelectDateOfBirth(dataMap);
	}
	
	@When("^User send the (Password|Confirm Password)$")
	public void userSendPassword(String elementType, DataTable languagesTable) throws Exception {
		 Map<String, String> dataMap = languagesTable.asMap(String.class, String.class);
			test.userSendPasswords(dataMap, elementType);
	}
	
	@When("^User upload the file$")
	public void userUploadFile() throws Exception {
		 test.userupload();
	}
	
	@When("Click on button {string}")
	public void clickOnbutton(String string) throws Exception {
		test.pageButton(string);
	}
	
	@Then("^User Can able to (.*) are empty$")
	public void AllFieldsEmpty(String allFields) throws Exception {
		System.out.println(allFields);
		test.FieldsEmpty(allFields);
	}
	
	@Then("User can able to see the error massage {string}")
	public void user_can_able_to_see_the_error_massage(String string) throws Exception {
	   test.errorMassage(string);
	}
	
	@When("^close the Applicaton$")
	public void closeApplicaton() {
		test.tearDown();
	}

}
