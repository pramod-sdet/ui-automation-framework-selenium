package com.pramod.automation.tests;

import static com.pramod.automation.constants.Browser.CHROME;


import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.pramod.automation.pages.HomePage;
import com.pramod.automation.utility.BrowserUtility;
import com.pramod.automation.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;

	@BeforeMethod(description = "Load the Homepage of the website")
	public void setup() {
		Logger logger = LoggerUtility.getLogger(getClass());
		homePage = new HomePage(CHROME);

	}

	public BrowserUtility getInstance() {

		return homePage;
	}

}
