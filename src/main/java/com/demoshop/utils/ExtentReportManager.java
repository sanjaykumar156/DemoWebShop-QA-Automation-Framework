package com.demoshop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getextentreports() {
		if(extent==null) {
			
			String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String reportPath=System.getProperty("user.dir")+ "/test-output/ExtentReport_" + timeStamp + ".html";
			
			ExtentSparkReporter sparkreporter= new ExtentSparkReporter(reportPath);
			sparkreporter.config().setTheme(Theme.STANDARD);
			sparkreporter.config().setDocumentTitle("DemoWebShop Automation Report");
			sparkreporter.config().setReportName("Functional Test Execution");
			
			extent =new ExtentReports();
			extent.attachReporter(sparkreporter);
			extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("Environment", "QA");
		}
		return extent;
	}

}
