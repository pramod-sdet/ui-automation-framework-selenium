package com.pramod.automation.utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pramod.automation.constants.Browser;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // this is the instance variable

	public BrowserUtility(WebDriver driver) { // this is the locale variable
		super();
		this.driver.set(driver); // initialize the instance variable driver
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());

		} else {
			System.err.print("Invalid Browser Name....");
		}

	}

	public WebDriver getDriver() {
		return driver.get();

	}

	public void goToWebsite(String url) {
		driver.get().get(url);

	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		WebElement element = driver.get().findElement(locator);// Find the Element
		element.click();
	}

	public void enterText(By locator, String textToEnter) {

		WebElement element = driver.get().findElement(locator);// Find the Element
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();

	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		}

		else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());

		}

		else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());

		}

	}

	public String takeScreenshot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/screenshot/" + name;
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}

}
