package com.pramod.automation.tests;

import static com.pramod.automation.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.pramod.automation.pages.HomePage;
import com.pramod.automation.utility.BrowserUtility;
import com.pramod.automation.utility.LambdaTestUtility;
import com.pramod.automation.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLamdaTest = true;
	private boolean isHeadless = true;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the Homepage of the website")

	public void setup(
			@Optional("chrome") String browser,
			@Optional("false") Boolean isLamdaTest,
			@Optional("true") Boolean isHeadless, ITestResult result) {

		this.isLamdaTest = isLamdaTest;
		WebDriver lambdaDriver;

		if (isLamdaTest) {

			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("chrome", result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {

			logger.info("Load the Homepage of the website");
			homePage = new HomePage(CHROME, isHeadless);
		}
	}

	public BrowserUtility getInstance() {

		return homePage;
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {

		if (isLamdaTest) {
			LambdaTestUtility.quitSession(); // close the browser session on LT
		} else {
			homePage.quit(); // quit local
		}
	}

}
