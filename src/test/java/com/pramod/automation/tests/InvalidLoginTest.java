package com.pramod.automation.tests;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pramod.automation.utility.LoggerUtility;
import com.pramod.pojo.User;

@Listeners({ com.pramod.automation.listeners.TestListener.class })

public class InvalidLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS = "pramodpardeshi44@gmail.com";
	private static final String INVALID_PASSWORD = "12344";

	@Test(description = "Verifies if the error message is shown for the user for invalid credentials!", groups = {
			"e2e", "sanity","smoke" })

	public void loginTest() {

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.");

	}
}