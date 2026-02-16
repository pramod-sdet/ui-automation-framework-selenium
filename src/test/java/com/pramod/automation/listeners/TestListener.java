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
import com.pramod.automation.utility.ExtentRepoerterUtility;
import com.pramod.automation.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		ExtentRepoerterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " PASSED");

		ExtentRepoerterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentRepoerterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
		ExtentRepoerterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " SKIPPED");
		ExtentRepoerterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
	}

	public void onStart(ITestContext context) {
		logger.info("Test  Suite Started");
		ExtentRepoerterUtility.setUpSparkReporter("report.html");

	}

	public void onFinish(ITestContext context) {
		logger.info("Test  Suite Completed");
		ExtentRepoerterUtility.flushReport();
	}
}
