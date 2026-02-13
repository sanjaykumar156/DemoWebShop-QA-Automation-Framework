package com.demoshop.regression;

import org.testng.Assert;
import org.testng.annotations.*;

import com.demoshop.base.BaseTest;
import flows.AddProductoCartFlow;
import pages.CheckoutPage;
public class TC_CART_002_UpadteQuantity extends BaseTest{
	AddProductoCartFlow addProductToCartFlow;
	@BeforeMethod
	public void productSetup() {
        loginToApplication();
        addProductToCartFlow=new AddProductoCartFlow();
    }
	
	@Test(groups= {"regression"})
	public void verifyUserCanAddProductToCartSuccessfully() {
		CheckoutPage checkout= new CheckoutPage();
		
		addProductToCartFlow.addProductToCartFlow();
		checkout.addProductQuantity("3");
		
		int productQuantity= checkout.validateProductQuantity();
		int unitPrice= checkout.productUnitPrice();
		int totalPrice= productQuantity*unitPrice;
		System.out.println(totalPrice);
		Assert.assertEquals(totalPrice, checkout.validatePrice(),"total price is mistmatching");
		driver.get().navigate().refresh();
		Assert.assertEquals(totalPrice, checkout.validatePrice(),"total price is mistmatching after refresh");
		System.out.println("success");
		
	}

}