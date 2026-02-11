package com.demoshop.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demoshop.utils.ConfigReader;

public class BaseTest {
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	@BeforeMethod
	public void browserSetup() throws MalformedURLException {
		String browser=ConfigReader.getProperty("browser");
		String url=ConfigReader.getProperty("url");
		String remoteurl=ConfigReader.getProperty("gridUrl");
		String execution=ConfigReader.getProperty("execution");
		
		ChromeOptions coptions=new ChromeOptions();
		//coptions.addArguments("--headless=new");
		coptions.addArguments("--disable-notifications");
		
		EdgeOptions eoptions=new EdgeOptions();
		eoptions.addArguments("--headless=new");
		eoptions.addArguments("--disable-notifications");
		if(driver.get()==null) {
			if(execution.equalsIgnoreCase("remote")) {
				URL gridURL=new URL(remoteurl);
				switch(browser.toLowerCase()) {
				
				case "chrome":					 
				driver.set(new RemoteWebDriver(gridURL,coptions));
				break;

				case "edge":
				driver.set(new RemoteWebDriver(gridURL,eoptions));
				break;
				default:
					throw new IllegalArgumentException("no browser is matching"+browser);
					
				}
			}else {
				switch(browser.toLowerCase()) {
				
				case "chrome":
				driver.set(new ChromeDriver(coptions));
				break;
				
				case "edge":
					driver.set(new EdgeDriver(eoptions));
				break;
				default:
					throw new IllegalArgumentException("no browser is matching"+browser);
			}
			
		}
		}
		
		if(driver.get()!=null) {
			driver.get().manage().window().maximize();
			driver.get().manage().deleteAllCookies();
			driver.get().get(url);
			
		}
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@AfterMethod
	public void teardown() {
		if(driver.get()!=null) {
			driver.get().quit();
			driver.remove();
		}
		
	}
	

}
