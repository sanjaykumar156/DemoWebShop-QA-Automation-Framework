package com.demoshop.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.base.BaseTest;
import com.demoshop.utils.ConfigReader;

import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest{

	
	@Test(groups= {"smoke"})
	public void UserRegistration() {
		
		String firstName=ConfigReader.getProperty("fname");
		String lastName=ConfigReader.getProperty("lname");
		String email = "user" + System.currentTimeMillis() + "@testmail.com";
		String password=ConfigReader.getProperty("rpassword");
		String cnrfPassword=ConfigReader.getProperty("crpassword");
		
		HomePage homePage= new HomePage();
		RegistrationPage registration= new RegistrationPage();
		registration.Registration(firstName, lastName, email, password, cnrfPassword);
		Assert.assertTrue(homePage.IsUserRegistered(),"User should be Registred successfully");
		
	}


}
