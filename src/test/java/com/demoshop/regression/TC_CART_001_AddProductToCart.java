package com.demoshop.regression;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoshop.base.BaseTest;
import com.demoshop.utils.LoggerManager;

import flows.LoginFlow;
import pages.HomePage;
import pages.ProductPage;

public class TC_CART_001_AddProductToCart extends BaseTest{
	private static final Logger log=LoggerManager.getLogger(TC_CART_001_AddProductToCart.class);
	LoginFlow loginWithValidCredentials;
	@BeforeMethod(alwaysRun=true)
	public void productSetup() {
		loginWithValidCredentials=new LoginFlow();
		loginWithValidCredentials.loginWithValidCredentials();
    }
	
	@Test(groups={"regression"})
	public void verifyUserCanAddProductToCartSuccessfully() {
		HomePage homepage= new HomePage();
		ProductPage product=new ProductPage();
		log.info("Test started: Product is add to cart");
		
		homepage.AddingtoCart();
		log.info("Product is selected");	
		String homePageProductPrice=homepage.gethomePageProductPrice();
		
		homepage.buttonCart();
		log.info("Product is selected");
		
		String productPageName=product.getProductNameFromProductPage();
		Assert.assertTrue(product.productInStock());
		log.info("Verified product availability text");
		
		product.selectProcessor();
		log.info("Selected processor from radio button");
		
		String productPagePrice=product.getProductPriceFromProductPage();
		Assert.assertEquals(productPagePrice, homePageProductPrice, "Product price mismatch between Home and Product page");
		log.info("Verified product is same for selected item");
		
		product.addtoCart();
		log.info("Product added to cart");
		
		String actualProduct=product.getProductNameFromCart();
		Assert.assertEquals(actualProduct, productPageName, "Product in cart does not match selected product");
		log.info("Verified selected product and actual product successfully");
	}

}
