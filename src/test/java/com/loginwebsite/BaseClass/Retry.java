package com.loginwebsite.BaseClass;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = Integer.parseInt(ReadConfigFile.getProperty("retry")); 

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; 
        }
        return false; 
    }
}
