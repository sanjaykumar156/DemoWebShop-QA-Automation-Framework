package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoshop.base.BasePage;
import com.demoshop.base.BaseTest;


public class ShoppingCartPage extends BasePage {
	public ShoppingCartPage() {
		super(BaseTest.getDriver());
	}
	private By txtquantity=By.xpath("//input[@class='qty-input']");
	private By txtquantitycheck=By.xpath("//input[@class='qty-input']");
	private By txtpricecheck=By.cssSelector(".product-subtotal");
	private By txtunitpeice=By.cssSelector(".product-unit-price");
	private By btnradio=By.xpath("//input[@name='removefromcart']");
	private By btnupdatecart= By.xpath("//input[@name='updatecart']");
	private By txtverifydelete=By.cssSelector(".order-summary-content");
	private By btncountrydropdown=By.cssSelector(".country-input");
	private By txtPostalcode= By.id("ZipPostalCode");
	private By btntermsandcondition= By.xpath("//input[@id='termsofservice']");
	private By btncheckout=By.xpath("//button[@id='checkout']");
	
	
	
	public int validatePrice() {
		return(int) Double.parseDouble(getText(txtpricecheck));
	}
	public int validateProductQuantity() {
		return(int) Double.parseDouble(getText(txtquantitycheck));
	}
	public int productUnitPrice() {
		return(int) Double.parseDouble(getText(txtunitpeice));
	}
	public void addProductQuantity(String quantity) {
		clear(txtquantity);
		sendkeys(txtquantity,quantity);
	}
	public void removeProductFromCart() {
		click(btnradio);
		click(btnupdatecart);
}

	public int getCalculatedTotalPrice() {
		int productQuantity= validateProductQuantity();
		int unitPrice= productUnitPrice();
		return productQuantity*unitPrice;
		 
		}
	public void addCountryStateDetails(String country, String zipCode) {
		dropdownactions(btncountrydropdown,"bytext",country);
		//dropdownactions(btnstatedropdown,"bytext",state);
		clear(txtPostalcode);
		sendkeys(txtPostalcode, zipCode);
		click(btntermsandcondition);
		click(btncheckout);
	}
	public boolean isCartEmptyMessageDisplayed() {
		return isDisplayed(txtverifydelete);
	}
	

}
