package com.demoshop.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.*;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions action;
	protected JavascriptExecutor js;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		this.action=new Actions(driver);
		this.js=(JavascriptExecutor)driver;	
	}
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	public void sendkeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	public void clear(By locator) {
		driver.findElement(locator).clear();
	}
	public String getText(By locator) {
		try {
		return driver.findElement(locator).getText();
		}catch(Exception e) {
			throw new RuntimeException("Failed to get text from element: " + locator, e);
		}
	}
	public String getAttributeValue(By locator, String attributeName) {
		try {
		return driver.findElement(locator).getAttribute(attributeName);
		}catch(Exception e) {
			throw new RuntimeException("Failed to get Attributevalue from element: " + locator, e);
		}
	}
	public boolean isDisplayed(By locator) {
		try {
		return driver.findElement(locator).isDisplayed();
		}catch(Exception e){
			return false;
		}
	}
	public boolean isEnabled(By locator) {
		try {
			return driver.findElement(locator).isEnabled();
		}catch(Exception e){
			return false;
		} 
		}
	public boolean isSelected(By locator) {
		try {
			return driver.findElement(locator).isSelected();
		}catch(Exception e){
			return false;
		}
		}
	public void visibilityofElement(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void elementToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void PresenceOfElement(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void mouseActions(By locator, String actionType) {
	WebElement acc=driver.findElement(locator);
	switch(actionType.toLowerCase()) {
	
	case "hover":
		action.moveToElement(acc).perform();
		break;
	case "doubleclick":
		action.doubleClick(acc).perform();
		break;
	case "contextclick":
		action.contextClick(acc).perform();
		break;
	case "click":
		action.click(acc);
		default:
			throw new IllegalArgumentException("in valid mouse action"+action);
	}
	}
	
	public void dropdownactions(By locator,String type,String value) {
		WebElement element= driver.findElement(locator);
		Select select= new Select(element);
		
		switch(type.toLowerCase()) {
		case "byvalue":
			select.selectByValue(value);
			break;
		case "bytext":
			select.selectByVisibleText(value);
			break;
		case "byindex":
			select.selectByIndex(Integer.parseInt(value));
			break;
			default:
				throw new IllegalArgumentException("Invalid dropdown selection type: " + type);
		}
		
	}
	public void AcceptAlert() {
		Alert alert= driver.switchTo().alert();
		alert.accept();
	}
	public void DismissAlert() {
		Alert alert= driver.switchTo().alert();
		alert.dismiss();
	}
	public String getalertText() {
		Alert alert=driver.switchTo().alert();
		return alert.getText();
	}
	public void SendTextToAlert(String text) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}
	public void jsClick(By locator) {
	    WebElement element = driver.findElement(locator);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	public void jsType(By locator, String value) {
	    WebElement element = driver.findElement(locator);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value=arguments[1];", element, value);
	}
	public void scrollToElement(By locator) {
	    WebElement element = driver.findElement(locator);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void highlightElement(By locator) {
	    WebElement element = driver.findElement(locator);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	public String getTitleByJS() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    return js.executeScript("return document.title;").toString();
	}
	public void switchToFrameByIndex(int index) {
	    driver.switchTo().frame(index);
	}
	public void switchToFrameBylocator(String locator) {
	    driver.switchTo().frame(locator);
	}
	public void FramebyElement(By locator){
		WebElement element=driver.findElement(locator);
		driver.switchTo().frame(element);
	}
	public void switchToParentFrame() {
	    driver.switchTo().parentFrame();
	}
	public void defaultFrame(){
		driver.switchTo().defaultContent();
	}
	public String getParentWindow() {
	    return driver.getWindowHandle();
	}
	public void switchToWindowByTitle(String expectedTitle) {
	    Set<String> windows = driver.getWindowHandles();

	    for (String window : windows) {
	        driver.switchTo().window(window);
	        if (driver.getTitle().contains(expectedTitle)) {
	            return;
	        }
	    }
	    throw new RuntimeException("Window with title not found:" + expectedTitle);
	}
	public void switchToParentWindow(String parentWindow) {
	    driver.switchTo().window(parentWindow);
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public String pageTitle() {
		return driver.getTitle();
	}
	public void pressEnterKey() {
        action.sendKeys(Keys.ENTER).perform();
    }

    public void pressShiftKey() {
        action.keyDown(Keys.SHIFT).keyUp(Keys.SHIFT).perform();
    }




	
	

	

}
