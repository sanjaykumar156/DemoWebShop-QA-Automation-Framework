package com.demoshop.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.demoshop.base.BaseTest;
import com.google.common.io.Files;

public class ScreenshotUtil extends BaseTest {

	public static String captureScreenshot(String testName) {
        try {
        	WebDriver driver = BaseTest.getDriver();
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dirPath = System.getProperty("user.dir")
                    + "/test-output/screenshots/";
            File directory = new File(dirPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            String path = dirPath + testName + ".png";
            Files.copy(src, new File(path));
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}
