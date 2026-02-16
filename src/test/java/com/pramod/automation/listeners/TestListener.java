package com.pramod.automation.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pramod.automation.tests.TestBase;
import com.pramod.automation.utility.BrowserUtility;

import com.pramod.automation.utility.ExtentReporterUtility;
import com.pramod.automation.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " PASSED");

		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

		Object testclass = result.getInstance();

		BrowserUtility browserUtility = ((TestBase) testclass).getInstance();

		logger.info("Capturing screenshot of failed tests");
		String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attaching the  screenshot to the HTML file");
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
	}

	public void onStart(ITestContext context) {
		logger.info("Test  Suite Started");
		ExtentReporterUtility.setUpSparkReporter("report.html");

	}

	public void onFinish(ITestContext context) {
		logger.info("Test  Suite Completed");
		ExtentReporterUtility.flushReport();
	}
}
