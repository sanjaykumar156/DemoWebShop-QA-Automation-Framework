package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoshop.base.BasePage;
import com.demoshop.base.BaseTest;

public class CheckoutPage extends BasePage {

	public CheckoutPage() {
		super(BaseTest.getDriver());
		
	}
	private By txtquantity=By.xpath("//input[@class='qty-input']");
	private By txtquantitycheck=By.xpath("//input[@class='qty-input']");
	private By txtpricecheck=By.cssSelector(".product-subtotal");
	private By txtunitpeice=By.cssSelector(".product-unit-price");
	
	private By btnradio=By.xpath("//input[@name='removefromcart']");
	private By btnupdatecart= By.xpath("//input[@name='updatecart']");
	private By txtverifydelete=By.cssSelector(".order-summary-content");
	
	public void addProductQuantity(String quantity) {
		clear(txtquantity);
		sendkeys(txtquantity,quantity);
		pressEnterKey();
	}
	public int validateProductQuantity() {
		String value= getAttributeValue(txtquantitycheck,"value");
		return Integer.parseInt(value.trim());
	}
	public int validatePrice() {
		return(int) Double.parseDouble(getText(txtpricecheck));
	}
	public int productUnitPrice() {
		return(int) Double.parseDouble(getText(txtunitpeice));
	}
	public void removeProductFromCart() {
		click(btnradio);
		click(btnupdatecart);
	}
	public boolean isCartEmptyMessageDisplayed() {
		return isDisplayed(txtverifydelete);
	}
	public int getCalculatedTotalPrice() {
		int productQuantity= validateProductQuantity();
		int unitPrice= productUnitPrice();
		return productQuantity*unitPrice;
		 
		}
	

}
