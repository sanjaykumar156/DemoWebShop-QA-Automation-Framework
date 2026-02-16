package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoshop.base.BasePage;
import com.demoshop.base.BaseTest;

public class ProductPage extends BasePage{

	public ProductPage() {
		super(BaseTest.getDriver());
	}
	private By txtproductname=By.xpath("//h1[normalize-space()='Simple Computer']");
	private By btnprocessor=By.xpath("//input[@id='product_attribute_75_5_31_96']");
	private By btnaddtocart=By.xpath("//input[@id='add-to-cart-button-75']");
	private By txtinstock=By.xpath("//span[text()='In stock']");
	private By txtverifyprice=By.xpath("//span[@class='price-value-75']");
	private By txtsuccess= By.xpath("//p[text()='The product has been added to your ']");
	private By btnshoppingcart= By.xpath("//span[normalize-space()='Shopping cart']");
	private By txtverifycartproduct= By.xpath("//div[@class='mini-shopping-cart']//div[@class='name']//a[text()='Simple Computer']");
	
	
	public String getProductNameFromProductPage() {
		PresenceOfElement(txtproductname);
		 return getText(txtproductname);
	}
	public boolean productInStock() {
		  PresenceOfElement(txtinstock);   
		  return isDisplayed(txtinstock);
	}
	public void selectProcessor() {
		 click(btnprocessor);
	}
	public String getProductPriceFromProductPage() {
		return getText(txtverifyprice);
	}
	public void addtoCart() {
		 click(btnaddtocart);
	}
	public boolean verifySuccesmessage() {
		 return isDisplayed(txtsuccess);
	}
	public String getProductNameFromCart() {
	    mouseActions(btnshoppingcart, "hover");
	    return getText(txtverifycartproduct);
	} 
	
}
