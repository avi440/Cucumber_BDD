package com.Cucumber_BDD_Hybrid.testCases;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.Reporter;

import com.education.testCases.BaseClass;

import static com.Cucumber_BDD_Hybrid.testCases.ObjectFileReader.getPageTitleFromFile;
import static org.testng.Assert.assertTrue;
import static com.Cucumber_BDD_Hybrid.testCases.BaseClass.readConfig;


//import junit.framework.Assert;

public class BaseUI {

	public String browser = readConfig.getBrowser();

	WebDriver driver; 
	protected SeleniumWait wait; 
	private String pageName ;
	private int demoWaitSeconds = 1; 
	//	ObjectFileReader object = new ObjectFileReader();

	public BaseUI(WebDriver driver, String pageName) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this); 
		this.driver = driver;
		this.pageName = pageName; 
		this.wait = new SeleniumWait(driver, Integer.parseInt(readConfig.getExplicitWait())); 
	}

	protected String getPageTitle() {
		return driver.getTitle(); 
	} 

	protected void logMessage(String message) {
		Reporter.log(message, true); 
	}

	protected void hover(WebElement element) {
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(element).build().perform(); 
	} 
	protected String hoverAndGetHTML(WebElement element) {
		String a = new String(); 
		Actions hoverOver = new Actions(driver); 
		hoverOver.moveToElement(element).build().perform(); 
		a = element.getText();
		return a; 
	} 
	public void hoverAndClick(WebElement element) {
		Actions hoverClick = new Actions(driver); 
		hoverClick.moveToElement(element).click().build().perform(); 
	} 



	public void hardWaitForlEBrowser(int seconds) {
		if (readConfig.getBrowser().equalsIgnoreCase( "IE")||
				readConfig.getBrowser().equalsIgnoreCase("ie")||
				readConfig.getBrowser().equalsIgnoreCase("internetexplorer")) { 
			wait.hardWait(seconds); 
		} 
	} 

	protected void selectProvidedTextFromDropDown(WebElement e1, String text) {
		try { wait.waitForElementToBeVisible(e1);
		scrollDown(e1); 
		Select sel = new Select(e1); 
		sel.selectByVisibleText(text); 
		hardWaitForDemo(); 
		} catch(StaleElementReferenceException exl){ 
			wait.hardWait(2);
			wait.waitForElementToBeVisible(e1); 
			scrollDown(e1); Select sel = new Select(e1); 
			sel.selectByVisibleText(text); 
			logMessage("Selected Element " + e1 + 
					" after catching Stale Element Exception"); 
		}
	}

	protected void scrollDown(WebElement element) { 
		((JavascriptExecutor)driver).executeScript( "arguments[0].scrollIntoView(true);", element); 
		hardWaitForDemo(); 
	} 

	public void hardWaitForDemo() { 
		hardWaitForDemo(getDemoWaitSeconds());
	} 
	public void hardWaitForDemo(int seconds) { 
		if (getDemoWaitSeconds()!=0) 
			wait.hardWait(seconds); 
	}

	public int getDemoWaitSeconds() {
		return demoWaitSeconds; 
	}

	public void sendText(WebElement e,String text){
		scrollDown(e);
		e.clear(); 
		e.sendKeys(text); 
		hardWaitForDemo(); 
	} 

	protected void click(WebElement element) {
		try { 
			wait.waitForElementToBeVisible(element);
			scrollDown(element); 
			element. click();
			hardWaitForDemo(); 
		} catch (StaleElementReferenceException exi) { 
			wait.hardWait(3); 
			wait.waitForElementToBeVisible(element);
			scrollDown(element); 
			element.click(); 
			logMessage("Clicked Element " + element + " after catching Stale Element Exception"); 
		}catch (Exception ex2) {
			logMessage("Element " + element + " could not be clicked! " + ex2.getMessage());
		}
	}
	
	public void sendFilePath(WebElement e,String filePath){ 
    	//e.clear(); 
    	e.sendKeys(filePath); 
    } 
	
	 public static boolean isFieldEmpty(WebElement e) {
		 return  e.getAttribute("value").isEmpty();
	    }
	 
	 public void doubleClickAction(WebElement e) {
		 Actions actions = new Actions(driver);
         // Perform double-click action
         actions.doubleClick(e).perform();
	    }
	 
	 public void rightClickAction(WebElement e) {
		 Actions actions = new Actions(driver);
         actions.contextClick(e).perform();
	    }
	 
	 protected boolean isElementDisplayed(WebElement e) throws NoSuchElementException, TimeoutException { 
 		wait.waitForElementToBeVisible(e);
 		boolean result = e.isDisplayed(); 
 		return result; 
 	}


}
