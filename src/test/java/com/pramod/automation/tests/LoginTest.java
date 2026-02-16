package com.pramod.automation.tests;

import static com.pramod.automation.constants.Browser.*;
import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pramod.automation.pages.HomePage;

import com.pramod.pojo.User;

@Listeners({ com.pramod.automation.listeners.TestListener.class })

public class LoginTest {

	HomePage homePage;

	@BeforeMethod(description = "Load the Homepage of the website")
	public void setup() {
		homePage = new HomePage(CHROME);

	}

	@Test(description = "Verifies if the user is able to login into the System...!", groups = { "e2e",
			"sanity" }, dataProviderClass = com.pramod.automation.dataproviders.LoginDataProvider.class, dataProvider = "LoginDataProvider")

	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Pramod Pardeshi");
	}

	@Test(description = "Verifies if the user is able to login into the System...!", groups = { "e2e",
			"sanity" }, dataProviderClass = com.pramod.automation.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")

	public void loginCSVTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Pramod Pardeshi");
	}

	@Test(description = "Verifies if the user is able to login into the System...!", groups = { "e2e",
			"sanity" }, dataProviderClass = com.pramod.automation.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.pramod.automation.listeners.MyRetryAnalyzer.class)

	public void loginExcelTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Pramod Pardeshi");

	}

}