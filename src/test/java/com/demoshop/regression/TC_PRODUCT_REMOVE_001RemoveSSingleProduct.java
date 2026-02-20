package com.demoshop.regression;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.demoshop.base.BaseTest;
import com.demoshop.utils.LoggerManager;

import flows.AddProductoCartFlow;
import flows.LoginFlow;
import pages.ShoppingCartPage;

public class TC_PRODUCT_REMOVE_001RemoveSSingleProduct extends BaseTest {
	private static final Logger log= LoggerManager.getLogger(TC_PRODUCT_REMOVE_001RemoveSSingleProduct.class);
	
	AddProductoCartFlow addProductToCartFlow;
	LoginFlow loginFlow;
	
	@BeforeMethod(alwaysRun=true)
	public void productSetup() {
		loginFlow=new LoginFlow();
		loginFlow.loginWithValidCredentials();
        addProductToCartFlow=new AddProductoCartFlow();
    }
	
	@Test(groups= {"regression"})
	public void removeSingleProductinCart() {
		log.info("=======Test Started: Remove single product from cart=========");
		ShoppingCartPage cartPage= new ShoppingCartPage();
		addProductToCartFlow.addProductToCartFlow();
		log.info("Removing product from cart");
		cartPage.removeProductFromCart();
		log.info("verifying cart empty message");
		Assert.assertTrue(cartPage.isCartEmptyMessageDisplayed(),"Shooping cart empty message is NOT displayed");
		log.info("=========Test competed successfully============");
	}
}
