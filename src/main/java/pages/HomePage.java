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
	
	public boolean IsUserLoggein() {
		return isDisplayed(txtvalidation);
	}
	public boolean IsUserRegistered() {
		return isDisplayed(regtxtvalidate);
	}
}
