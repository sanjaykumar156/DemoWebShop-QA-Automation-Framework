package flows;

import org.testng.Assert;

import pages.HomePage;
import pages.ProductPage;

public class AddProductoCartFlow {
	
	public void addProductToCartFlow() {
		HomePage homepage= new HomePage();
		ProductPage product=new ProductPage();
		
		homepage.AddingtoCart();
		homepage.buttonCart();
		
		Assert.assertTrue(product.productInStock(),"Product is not in stock");
		product.selectProcessor();
		product.addtoCart();
		homepage.buttonShoppincart();
		
	}

}
