package com.pramod.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pramod.automation.constants.Browser;
import com.pramod.automation.utility.BrowserUtility;
import com.pramod.automation.utility.JSONUtility;
import com.pramod.automation.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import static com.pramod.automation.constants.Env.*;

public final class HomePage extends BrowserUtility {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[@class=\"login\"]");

	public HomePage(Browser browser, boolean isHeadless) {

		super(browser, isHeadless); // This will call the Parent Class constructor from the Child class constructor
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}
	
	
	public HomePage(WebDriver driver) {
		
		super(driver); //To call PArent Class Constructor from child Class constructor
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}

	public LoginPage goToLoginPage() { // These are the page functions and page functions cannot return void return
										// type
		logger.info("Trying to perform click to go to Sign in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);

		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
