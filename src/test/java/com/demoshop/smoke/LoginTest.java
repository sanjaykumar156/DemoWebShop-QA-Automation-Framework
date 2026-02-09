package com.demoshop.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.base.BaseTest;

import com.demoshop.utils.ConfigReader;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(groups= {"smoke"})
	public void verifyLoginWithValidCredentials() {
		String email=ConfigReader.getproperty("email");
		String password=ConfigReader.getproperty("password");
		LoginPage loginPage= new LoginPage();
		HomePage homePage= new HomePage();
		loginPage.login(email, password);
		
		Assert.assertTrue(homePage.IsUserLoggein(),"User should be logged in successfully");
	}

}
