package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoshop.base.BasePage;
import com.demoshop.base.BaseTest;

public class CheckoutPage extends BasePage{

	public CheckoutPage() {
		super(BaseTest.getDriver());
	}
	private By accName=By.xpath("//div[@class='header-links']//a[@class='account']");
	
	private By btncountrydropdown=By.xpath("//select[@id='BillingNewAddress_CountryId']");
	private By txtcity=By.xpath("//input[@id='BillingNewAddress_City']");
	private By txtaddress=By.xpath("//input[@id='BillingNewAddress_Address1']");
	private By txtzipcode=By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	private By txtmobile=By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	private By btncontinue=By.xpath("//div[@id='billing-buttons-container']//input");
	
	//private By btnshippingdropdown=By.xpath("//select[@id='shipping-address-select']");
	private By btnshippingcontinue=By.xpath("//div[@id='shipping-buttons-container']//input");
	
	private By btnshippingmethodcontinue =By.xpath("//div[@id='shipping-method-buttons-container']//input");
	private By btnpaymentcard=By.cssSelector("#paymentmethod_2");
	private By btnpaymentmethodcontinue=By.xpath("//div[@id='payment-method-buttons-container']//input");
	
	private By txtcardtype=By.xpath("//select[@id='CreditCardType']");
	private By txtcardholder=By.xpath("//input[@id='CardholderName']");
	private By txtcardnumber=By.xpath("//input[@id='CardNumber']");
	private By btnexpmonthdrp=By.xpath("//select[@id='ExpireMonth']");
	private By txtcvv=By.xpath("//input[@id='CardCode']");
	private By btnpaymentinfocontinue=By.xpath("//div[@id='payment-info-buttons-container']//input");
	
	private By verifybillingemail=By.xpath("//ul[@class='billing-info']//li[@class='email']");
	private By verifypaymentmethod=By.xpath("//ul[@class='billing-info']//li[@class='payment-method']");
	
	private By verifyshippingemail =By.xpath("//ul[@class='shipping-info']//li[@class='email']");
	private By verifyShippingmethod=By.xpath("//ul[@class='shipping-info']//li[@class='shipping-method']");
	
	private By verifyproduct=By.cssSelector(".product-name");
	private By txtsubtotal=By.xpath("//span[text()='Sub-Total:']/ancestor::tr//span[@class='product-price']");
	private By txtshippingcost=By.xpath("//span[normalize-space()='Shipping:']/ancestor::tr//span[@class='product-price']");
	private By txttaxprice=By.xpath("//span[normalize-space()='Tax:']/ancestor::tr//span[@class='product-price']");
	private By txttotalprice=By.xpath("//span[normalize-space()='Total:']/ancestor::tr//span[@class='product-price order-total']");
	private By btnconformorder=By.xpath("//input[@class='button-1 confirm-order-next-step-button']");
	
	private By successMessage=By.xpath("//strong[text()='Your order has been successfully processed!']");
	private By orderNumber=By.xpath("//ul[@class='details']//li[starts-with(normalize-space(),'Order')]");
	private By orderDetailsLink=By.xpath("//ul[@class='details']//li[starts-with(normalize-space(),'Click')]");
	
	
	public boolean accountHolderemail() {
		return isDisplayed(accName);
	}
	public void selectCountryStateAndZip(String country,String city,String zipcode,String address,String mobile) {
		dropdownactions(btncountrydropdown, "bytext",country);
		sendkeys(txtcity,city);
		sendkeys(txtaddress, address);
		sendkeys(txtzipcode, zipcode);
		sendkeys(txtmobile,mobile);
		click(btncontinue);
	}

	public void selectShippingAddress() {
		elementToBeClickable(btnshippingcontinue);
		click(btnshippingcontinue);
	}
	
	public void selectShippingMethod() {
		elementToBeClickable(btnshippingmethodcontinue);
		click(btnshippingmethodcontinue);
	}
	public void selectPaymentMethod() {
		elementToBeClickable(btnpaymentcard);
		click(btnpaymentcard);
		click(btnpaymentmethodcontinue);
	}
	public void addPaymentInformation(String cardtype,String cardholdername,String cardnumber, String expmonth,String cardcode ) {
		visibilityofElement(txtcardtype);
		dropdownactions(txtcardtype,"bytext",cardtype);
		sendkeys(txtcardholder,cardholdername);
		sendkeys(txtcardnumber,cardnumber);
		dropdownactions(btnexpmonthdrp,"bytext",expmonth);
		sendkeys(txtcvv,cardcode);
		click(btnpaymentinfocontinue);
	}
	public boolean verifybillingemail() {
		return isDisplayed(verifybillingemail);	
	}
	public boolean verifyPaymentmethod() {
		visibilityofElement(verifypaymentmethod);
		return isDisplayed(verifypaymentmethod);
	}
	public boolean verifyShippingEmail() {
		visibilityofElement(verifyshippingemail);
		return isDisplayed(verifyshippingemail);
	}
	public boolean verifyShippingMethod() {
		visibilityofElement(verifyShippingmethod);
		return isDisplayed(verifyShippingmethod);
	}
	public String verifyProduct() {
		return getText(verifyproduct);
	}
	public double getSubTotal() {
		String subTotalText=getText(txtsubtotal);
		return Double.parseDouble(subTotalText.replaceAll("[^0-9.]", ""));
	}
	public double getShippingCost() {
		String ShippingText=getText(txtshippingcost);
		return Double.parseDouble(ShippingText.replaceAll("[^0-9.]", ""));
	}
	public double getTax() {
		String taxText=getText(txttaxprice);
		return Double.parseDouble(taxText.replaceAll("[^0-9.]", ""));
	}
	public double getTotal() {
		String totalText=getText(txttotalprice);
		return Double.parseDouble(totalText.replaceAll("[^0-9.]", ""));
	}
	public double getCalculatedTotal() {
		double subtotal=getSubTotal();
		double shipping= getShippingCost();
		double tax=getTax();
		return subtotal+shipping+tax;
	}
	public void confirmOrder() {
		click(btnconformorder);
	}
	
	public boolean getSuccessMessage() {
		visibilityofElement(successMessage);
		return isDisplayed(successMessage);
	}
	public String getOrderId() {
	visibilityofElement(orderNumber);
		String orderText = getText(orderNumber); 
	    return orderText.replaceAll("[^0-9]", "");
	}
	public void clickOrderDetails() {
		elementToBeClickable(orderDetailsLink);
		click(orderDetailsLink);
	}
	
	
	
	

}
