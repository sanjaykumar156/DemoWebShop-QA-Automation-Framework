package com.demoshop.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demoshop.utils.ExtentReportManager;
import com.demoshop.utils.ScreenshotUtil;

public class TestListeners implements ITestListener {

	
	private static ExtentReports extent=ExtentReportManager.getextentreports();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	@Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }
	@Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, result.getThrowable());
        
        String screenshotPath=ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());
        if(screenshotPath!=null) {
        	extentTest.get().addScreenCaptureFromPath(screenshotPath);
        }
	}
	@Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
	
}
