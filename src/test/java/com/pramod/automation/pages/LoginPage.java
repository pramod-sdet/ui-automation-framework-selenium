package com.pramod.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pramod.automation.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email']");
	private static final By PASSWORD_TEXT_BOXLOCATOR = By.xpath("//input[@id='passwd']");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//i[@class='icon-lock left']");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOXLOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());

		return myAccountPage;

	}

}
