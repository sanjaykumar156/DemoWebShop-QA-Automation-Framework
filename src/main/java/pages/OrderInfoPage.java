package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoshop.base.BasePage;
import com.demoshop.base.BaseTest;

public class OrderInfoPage extends BasePage{

	public OrderInfoPage() {
		super(BaseTest.getDriver());
	}

	private By infoOrderNumber=By.xpath("//div[@class='order-overview']//strong[contains(text(),'#')]");
	
	
	public String getInfoOrderId() {
		visibilityofElement(infoOrderNumber);
		String orderText = getText(infoOrderNumber); 
	    return orderText.replaceAll("[^0-9]", "");
	} 
}
