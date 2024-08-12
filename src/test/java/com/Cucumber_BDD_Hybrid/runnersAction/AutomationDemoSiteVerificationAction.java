package com.Cucumber_BDD_Hybrid.runnersAction;


import java.util.*;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Cucumber_BDD_Hybrid.testCases.Getpage;


import org.apache.log4j.Logger;

//import org.junit.Assert;



public class AutomationDemoSiteVerificationAction extends Getpage {
	WebDriver driver ;
	Logger logger;
	public AutomationDemoSiteVerificationAction(WebDriver driver,Logger logger) {
		super(driver, "submitAutomationtesting");
		this.driver = driver; 
		this.logger = logger;
	}

	public void  automationDemoPagaTitle(String fields) throws Exception{
		if (driver.getTitle().equalsIgnoreCase(fields)) {
			Assert.assertTrue(true);
			captureScreenshot(driver,"bookFreeDemo");

		} else {
			captureScreenshot(driver,"logTest01");
			Assert.assertTrue(false);
		}
		logger.info("login to Application and title of page"+ fields);

	}


	public void  automationDemoPagaElement(List<String> elements, String elementType) throws Exception{
		if(elementType =="header element") {
			for(int i=0; i<elements.size(); i++) {
//				Assert.assertTrue(element("fieldElement",elements.get(i)).isDisplayed());
				Assert.assertTrue(isElementDisplayed(element("fieldElement",elements.get(i))));
				logger.info("Assertion pass : field is "+elements.get(i)+ "is displaying");
			}
		}
		if(elementType =="submition field element || submition button") {
			for(int i=0; i<elements.size(); i++) {
//				Assert.assertTrue(element("fieldElement",elements.get(i)).isDisplayed());
				Assert.assertTrue(isElementDisplayed(element("fieldElement",elements.get(i))));
				logger.info("Assertion pass : field is "+elements.get(i)+ "is displaying");
			}
		}		
	}

	public void  sendDatatoInfoAllField(Map<String, String> dataMap, String elementType) throws Exception{
		for(Entry<String, String> dataArr :dataMap.entrySet()) {
			sendText(element("FullAndAddressNameElements",dataArr.getKey()),dataArr.getValue());
			logger.info("Assertion pass : Insert Data into "+elementType);
		}
	}

	public void  clickOnGender(Map<String, String> dataMap) throws Exception{
		for(Entry<String, String> dataArr :dataMap.entrySet()) {
			click(element("GenderElement",dataArr.getKey(),dataArr.getValue()));
		}
	}

	public void  clickOnHobbies(Map<String, String> dataMap) throws Exception{
		for(Entry<String, String> dataArr :dataMap.entrySet()) {
			String[] splitArray = dataArr.getValue().split(",");
			for(int i=0; i<splitArray.length; i++) {
				click(element("HobbiesElement",dataArr.getKey(),splitArray[i]));
			}
		}
	}

	public void  selectLanguages(Map<String, String> dataMap) throws Exception{
		click(element("languagesMultiselect"));
		for(Entry<String, String> dataArr :dataMap.entrySet()) {
			String[] splitArray = dataArr.getValue().split(",");
			for(int i=0; i<splitArray.length; i++) {
				click(element("languageSelect",dataArr.getKey(),splitArray[i].trim()));
			}
		}
	}

	public void  userSelectSkills(Map<String, String> dataMap) throws Exception{
		click(element("skillsSearchselect"));
		for(Entry<String, String> dataArr :dataMap.entrySet()) {
			selectProvidedTextFromDropDown(element("SkillsSelect",dataArr.getKey(),dataArr.getKey()), dataArr.getValue());
		}
	}

	public void  userSelectCountry(Map<String, String> dataMap) throws Exception{
		click(element("countrySearchselect"));
		for(Entry<String, String> dataArr :dataMap.entrySet()) {
			click(element("CountrySelectElements",dataArr.getKey(),dataArr.getValue()));
		}
	}

	public void  userSelectDateOfBirth(Map<String, String> dataMap) throws Exception{
		for(Entry<String, String> dataArr :dataMap.entrySet()) {
			String[] splitArrayKey = dataArr.getKey().split("-");
			String[] splitArrayValue = dataArr.getValue().split("-");
			for(int i=0; i<splitArrayKey.length; i++) {
				selectProvidedTextFromDropDown(element("DateOfBirthSelectElements",splitArrayKey[i]), splitArrayValue[i]);
			}
		}
	}

	public void  userSendPasswords(Map<String, String> dataMap, String elementType) throws Exception{
		for(Entry<String, String> dataArr :dataMap.entrySet()) {
			sendText(element("PasswordandCPElements",dataArr.getKey()),dataArr.getValue());
			logger.info("Assertion pass : Insert Data into "+elementType);
		}
	}
	
	public void  userupload() throws Exception {
		sendFilePath(element("uploadImElements"),System.getProperty("user.dir") + "/TestData/nature.png");
		wait.hardWait(10);
	}
	
	public void  pageButton(String button) throws Exception {
		click(element("fieldElement",button));
	}
	
	public void  FieldsEmpty(String emptyFields) throws Exception {
		String[] fieldValus = emptyFields.split(",");
		for(int i=0; i<fieldValus.length; i++) {
			String Valus = fieldValus[i].trim();
//			if(Valus.equalsIgnoreCase("FirstName") || Valus.equalsIgnoreCase("LastName") || Valus.equalsIgnoreCase("Adress") || Valus.equalsIgnoreCase("EmailAdress") || Valus.equalsIgnoreCase("Phone")){
//				Assert.assertTrue(isFieldEmpty(element("FullAndAddressNameElements",Valus)));
//				logger.info("Assertion pass : Field is Empty "+Valus+"!!!!!!!");
//			}
			if(Valus.equalsIgnoreCase("Gender") || Valus.equalsIgnoreCase("Hobbies")){
				Assert.assertFalse(element("GenderandHobbiesElement",Valus).isSelected());
				logger.info("Assertion pass : Field is Empty "+Valus+"!!!!!!!");
			}else if(Valus.equalsIgnoreCase("Select Country")){
				Assert.assertTrue(element("countrySearchselect").getText().equals(""));
				logger.info("Assertion pass : Field is Empty "+Valus+"!!!!!!!");
			}else if(Valus.equalsIgnoreCase("Languages")){
				Assert.assertTrue(element("languagesMultiselect").getText().equals(""));
				logger.info("Assertion pass : Field is Empty "+Valus+"!!!!!!!");
			}else {
				Assert.assertTrue(isFieldEmpty(element("FullAndAddressNameElements",Valus)));
				logger.info("Assertion pass : Field is Empty "+Valus+"!!!!!!!");
			}
			
		}
		
	}
	

	
	public void tearDown() {
		driver.quit();
	}
	
	







}
