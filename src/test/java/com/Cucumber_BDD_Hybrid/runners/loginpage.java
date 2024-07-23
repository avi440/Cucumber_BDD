//package com.cucumber001_BDD.runners;
//
//import com.cucumber001_BDD.testCases.BaseClass;
//
//import java.io.IOException;
//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeoutException;
//
////import org.testng.Assert;
//
//import com.cucumber001_BDD.runnersAction.AutomationDemoSiteVerificationAction;
//import com.cucumber001_BDD.runnersAction.OrangehrmLoginPageAction;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//
//public class loginpage extends BaseClass  {
//	String title = "OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM";
//	OrangehrmLoginPageAction test = new OrangehrmLoginPageAction(getDriver());
////	OrangehrmLoginPageAction test ;
//
//	@Given("User login to Applictaion")
//	public void user_login_to_applictaion(){
//		getDriver().get(baseUrl);
////		test = new OrangehrmLoginPageAction(driver);
//		logger.info("login to Application");
//	}
//
//	@Then("User can able to see the paga title")
//	public void user_can_able_to_see_the_paga_title() throws Exception {
//		test.homePageTitle(title);
//		logger.info("process was complited and taken the screenshort");
//	}
//
//	@Then("User can able to see the paga element")
//	public void user_can_able_to_see_the_paga_element() throws Exception {
//		test.pageElementDisplayedOrNot();
//		logger.info("Home page elements are displayed");
//	}
//
//	@When("User click on the Book a Free Demo button")
//	public void user_click_on_the_book_a_free_demo_button() throws Exception{
//		test.clickBookFreeDemoButton();
//		logger.info("click on free demo button");
//	}
//
//	@Then("User can able to see the Book a Free Demo page title")
//	public void user_login_to_book_a_free_demo() throws Exception {
//		test.verifyBookFreeDemoTitle();
//		logger.info("User can able to see the Book a Free Demo page title");
//	}
//
//	@Then("User can able to see the Book a Free Demo paga element")
//	public void User_can_able_to_see_the_Book_a_Free_Demo_paga_element() throws Exception{
//		test.bookFreeDemoElementDisplayedOrNot();
//	}
//
//	@Then("User close the Applicatin")
//	public void User_close_close_Applicatin() throws Exception {
//		tearDown();
//		logger.info("User logout from Application");
//	}
//}



