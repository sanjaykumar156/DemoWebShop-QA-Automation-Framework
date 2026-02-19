package com.demoshop.regression;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.demoshop.base.BaseTest;
import com.demoshop.utils.LoggerManager;

import flows.AddProductoCartFlow;
import flows.LoginFlow;

import pages.CheckoutPage;
public class TC_CART_002_UpadteQuantity extends BaseTest{
	private static final Logger log=(Logger) LoggerManager.getLogger(TC_CART_002_UpadteQuantity.class);
	AddProductoCartFlow addProductToCartFlow;
	LoginFlow loginWithValidCredentials;
	@BeforeMethod
	public void productSetup() {
		loginWithValidCredentials=new LoginFlow();
        addProductToCartFlow=new AddProductoCartFlow();
    }
	
	@Test(groups= {"regression"})
	public void verifyUserCanAddProductToCartSuccessfully() {
		
		CheckoutPage checkout= new CheckoutPage();
		log.info("======= Test Started: verify user can update product quantity successfully=======");
		
		log.info("Adding product to cart");
		addProductToCartFlow.addProductToCartFlow();
		log.info("Product successfully added to cart");
		
		log.info("uodateing product qauntity to 3");
		checkout.addProductQuantity("3");
		
		log.info("Calculating expected total price based on quantity and unit price");
		int expectedTotal=checkout.getCalculatedTotalPrice();
		log.info("Expected total price calculated: " +expectedTotal);
		
		log.info("Validating total price after updating the quantity");
		Assert.assertEquals(expectedTotal, checkout.validatePrice(),"total price is mistmatching");
		log.info("Total price validated successfully after quantity update");
		
		log.info("Refreshing the page to verify price presistance");
		driver.get().navigate().refresh();
		
		log.info("Validating total price after page refresh");
		Assert.assertEquals(expectedTotal, checkout.validatePrice(),"total price is mistmatching after refresh");
		log.info("Total price validated successfully after page refresh");
		
		log.info("======Test completed Successfully========");

		
	}

}