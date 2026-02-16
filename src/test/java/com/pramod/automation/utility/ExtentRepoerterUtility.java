package com.pramod.automation.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepoerterUtility {
	private static ExtentReports extendReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static void setUpSparkReporter(String reportName) {

		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/" + reportName);
		extendReports = new ExtentReports();
		extendReports.attachReporter(extentSparkReporter);

	}

	public static void createExtentTest(String testName) {

		ExtentTest test = extendReports.createTest(testName);
		extentTest.set(test);
	}

	public static ExtentTest getTest() {

		return extentTest.get();
	}

	public static void flushReport() {
		extendReports.flush();

	}
}