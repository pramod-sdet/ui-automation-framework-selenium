package com.pramod.automation.pages;

import java.util.Properties;

import org.openqa.selenium.By;

import com.pramod.automation.constants.Browser;
import com.pramod.automation.utility.BrowserUtility;
import com.pramod.automation.utility.JSONUtility;

import static com.pramod.automation.constants.Env.*;
import static com.pramod.automation.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[@class=\"login\"]");

	public HomePage(Browser browserName) {
		super(browserName); // This will call the Parent Class constructor from the Child class constructor
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}

	public LoginPage goToLoginPage() { // These are the page functions and page functions cannot return void return
										// type
		clickOn(SIGN_IN_LINK_LOCATOR);

		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
