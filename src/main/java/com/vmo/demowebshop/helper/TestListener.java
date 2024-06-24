package com.vmo.demowebshop.helper;

import com.vmo.demowebshop.helper.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        com.vmo.demowebshop.helper.Log.info("on Test Start");
    }

    public void onTestSuccess(ITestResult result) {
        com.vmo.demowebshop.helper.Log.info("Test Passed");

    }

    public void onTestFailure(ITestResult result) {
        Log.info("Test Failed");

    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}
