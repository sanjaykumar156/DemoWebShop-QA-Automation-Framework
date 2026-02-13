package pages;

import org.openqa.selenium.By;

import com.demoshop.base.BasePage;
import com.demoshop.base.BaseTest;

public class HomePage extends BasePage{
	public HomePage() {
		super(BaseTest.getDriver());
	}
	private By txtvalidation=By.xpath("//div[@class='header-links']/ul/li[1]");
	private By regtxtvalidate=By.xpath("//div[@class='result']");
	
	private By btncomputers= By.xpath("//ul[@class='top-menu']//a[normalize-space()='Computers']");
	private By btndesktops= By.xpath("//ul[@class='top-menu']//a[normalize-space()='Desktops']");
	private By txtproduct= By.xpath("//a[text()='Simple Computer']");
	private By btnaddtocart= By.xpath("//a[text()='Simple Computer']/ancestor::div[@class='details']//input");
	private By txtactualprice= By.xpath("//a[text()='Simple Computer']/ancestor::div[@class='details']//span");
	
	
	
	public boolean IsUserLoggein() {
		return isDisplayed(txtvalidation);
	}
	public boolean IsUserRegistered() {
		return isDisplayed(regtxtvalidate);
	}
    
	public void AddingtoCart() {
		mouseActions(btncomputers,"hover");
		click(btndesktops);	
	}
	public String gethomePageProductName() {
		PresenceOfElement(txtproduct);
		return getText(txtproduct);
	}
	public String gethomePageProductPrice() {
		return getText(txtactualprice);
	}
	public void buttonCart() {
		click(btnaddtocart);
	}
}