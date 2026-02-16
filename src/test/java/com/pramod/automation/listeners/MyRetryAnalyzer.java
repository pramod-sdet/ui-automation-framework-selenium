package com.pramod.automation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.pramod.automation.constants.Env;
import com.pramod.automation.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	private static final int MAX_NUMBERS_OF_ATTEMPTS = Integer
			.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBERS_OF_ATTEMPTS"));

	private static int current_attempt = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (current_attempt <= MAX_NUMBERS_OF_ATTEMPTS) {
			current_attempt++;
		}

		return false;
	}

}
