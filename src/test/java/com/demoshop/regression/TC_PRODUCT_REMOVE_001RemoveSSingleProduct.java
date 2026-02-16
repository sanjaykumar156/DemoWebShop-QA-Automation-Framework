package com.demoshop.regression;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.demoshop.base.BaseTest;
import com.demoshop.utils.LoggerManager;

import flows.AddProductoCartFlow;
import flows.LoginFlow;
import pages.CheckoutPage;

public class TC_PRODUCT_REMOVE_001RemoveSSingleProduct extends BaseTest {
	private static final Logger log= LoggerManager.getLogger(TC_PRODUCT_REMOVE_001RemoveSSingleProduct.class);
	
	AddProductoCartFlow addProductToCartFlow;
	LoginFlow loginWithValidCredentials;
	@BeforeMethod
	public void productSetup() {
		loginWithValidCredentials=new LoginFlow();
        addProductToCartFlow=new AddProductoCartFlow();
    }
	
	@Test(groups= {"regression"})
	public void removeSingleProductinCart() {
		log.info("=======Test Started: Remove single product from cart=========");
		CheckoutPage checkout= new CheckoutPage();
		loginWithValidCredentials.loginWithValidCredentials();
		addProductToCartFlow.addProductToCartFlow();
		log.info("Removing product from cart");
		checkout.removeProductFromCart();
		log.info("verifying cart empty message");
		Assert.assertTrue(checkout.isCartEmptyMessageDisplayed(),"Shooping cart empty message is NOT displayed");
		log.info("=========Test competed successfully============");
	}
}
