package com.demoshop.regression;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoshop.base.BaseTest;

import pages.HomePage;
import pages.ProductPage;

public class TC_CART_001_AddProductToCart
 extends BaseTest{
	
	@BeforeMethod
	public void productSetup() {
        loginToApplication();
    }
	
	@Test(groups={"regression"})
	public void addProductToCart() {
		HomePage homepage= new HomePage();
		ProductPage product=new ProductPage();
		
		homepage.AddingtoCart();
		String homePageProductPrice=homepage.gethomePageProductPrice();
		homepage.buttonCart();
		
		String productPageName=product.getProductNameFromProductPage();
		Assert.assertTrue(product.productInStock());
		product.selectProcessor();
		
		String productPagePrice=product.getProductPriceFromProductPage();
		Assert.assertEquals(productPagePrice, homePageProductPrice, "Product price mismatch between Home and Product page");
		
		product.addtoCart();
		System.out.println("verified");
		String actualProduct=product.getProductNameFromCart();
		Assert.assertEquals(actualProduct, productPageName, "Product in cart does not match selected product");

	}

}
