package com.demoshop.regression;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoshop.base.BaseTest;
import com.demoshop.utils.ConfigReader;
import com.demoshop.utils.LoggerManager;

import flows.AddProductoCartFlow;
import flows.LoginFlow;
import pages.CheckoutPage;
import pages.OrderInfoPage;
import pages.ShoppingCartPage;

public class TC_PlaceOrder_001PlaceOderWithValidCredentials extends BaseTest{
	
private static final Logger log= LoggerManager.getLogger(TC_PlaceOrder_001PlaceOderWithValidCredentials.class);
	
	AddProductoCartFlow addProductToCartFlow;
	LoginFlow loginFlow;
	
	@BeforeMethod(alwaysRun=true)
	public void productSetup() {
		loginFlow=new LoginFlow();
		loginFlow.loginWithValidCredentials();
        addProductToCartFlow=new AddProductoCartFlow();
    }
	
	@Test(groups= {"regression"})
	public void verifyUserCanPlaceOrderWithValidDetails() {
		log.info("=======Test Started: Placing order with valid details=========");
		log.info("Adding product to cart");
		addProductToCartFlow.addProductToCartFlow();
		log.info("Product successfully added to cart");
		
		ShoppingCartPage cartPage= new ShoppingCartPage();
		OrderInfoPage orderInfo=new OrderInfoPage();
		log.info("Entering country,zip details");
		cartPage.addCountryStateDetails(
				ConfigReader.getProperty("country"),
				ConfigReader.getProperty("zip"));
		
		CheckoutPage checkout= new CheckoutPage();
		checkout.selectCountryStateAndZip(ConfigReader.getProperty("country"), 
				ConfigReader.getProperty("city"),
				ConfigReader.getProperty("zip"),
				ConfigReader.getProperty("address"),
				ConfigReader.getProperty("mobile"));
		log.info("Country selected: India");
		log.info("State selected : Other (Non US)");
		log.info("Zip selected :456783");
		
		log.info("Selecting shipping address");
		checkout.selectShippingAddress();
		log.info("Shipping address selected successfully");
		
		log.info("Selecting shipping method");
		checkout.selectShippingMethod();
		log.info("Shipping method selected successfully");
		
		log.info("Selecting payment method");
		checkout.selectPaymentMethod();
		log.info("Payment method selected successfully");
		
		log.info("Entering payment information");
		checkout.addPaymentInformation(
				ConfigReader.getProperty("cardType"), 
				ConfigReader.getProperty("cardHolder"),
				ConfigReader.getProperty("cardnumber"),
				ConfigReader.getProperty("expiryMonth"),
				ConfigReader.getProperty("cardCode"));
		log.info("Card type selected: Credit Card");
		log.info("Card holder name entered");
		log.info("Card number entered");
		log.info("Expiry month selected");
		log.info("CVV entered");
		
//		log.info("Verifying account holder email");
//		Assert.assertEquals(checkout.verifybillingemail(),checkout.accountHolderemail());
//		log.info("Billing email verified successfully");
		
		log.info("Verifying payment method");
		Assert.assertTrue(checkout.verifyPaymentmethod());
		log.info("Payment method verification successful");
		
		log.info("Verifying shipping email");
		Assert.assertEquals(checkout.verifybillingemail(), checkout.verifyShippingEmail());
		log.info("Shipping email verified successfully");
		
		log.info("Verifying shipping method");
		Assert.assertTrue(checkout.verifyShippingMethod());
		log.info("Shipping method verification successfully");
		
		log.info("Verifying product details in checkout");
		Assert.assertEquals("Simple Computer", checkout.verifyProduct());
		log.info("Product verified successfully: Simple Computer");
		
		log.info("Calculating expected total price");
		double expectedTotal=checkout.getCalculatedTotal();
		double actualTotal=checkout.getTotal();
		log.info("Expected total calculated successfully");
		
		log.info("Fetching actual total price from UI");
		Assert.assertEquals(actualTotal, expectedTotal,0.01,"Total price Mismatch");
		log.info("Total price validated successfully");
		
		log.info("Confirming order");
		checkout.confirmOrder();
		log.info("Order placed successfully");
		
		log.info("Verifying order success message");
		Assert.assertTrue(checkout.getSuccessMessage(),"Order success message mismatch");
		log.info("Success message validated successfully");
		
		
		log.info("Fetching order ID from confirmation page");
		String orderId=checkout.getOrderId();
		log.info("Fetched order ID from order information page");
		
		
		log.info("Navigating to order details page");
		checkout.clickOrderDetails();
		log.info("Navigated to order details page");
		
		log.info("Fetching order ID from confirmation page");
		String orderinfoId=orderInfo.getInfoOrderId();
		log.info("Fetched order ID from order conformation page");
		
		log.info("validating Product Id");
		Assert.assertEquals(orderId,orderinfoId,"oder Id is Mismatch");
		log.info("Order ID validated successfully");
		
		log.info("======= Test Completed Successfully =======");
		
		
		
		
		
		
		
		
	}

}
