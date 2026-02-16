package com.pramod.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pramod.automation.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//span[normalize-space()=\"Pramod Pardeshi\"]");

	public MyAccountPage(WebDriver driver) {

		super(driver);
	}

	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);

	}

}
