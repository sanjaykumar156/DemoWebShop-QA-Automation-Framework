package com.demoshop.sanity;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.base.BaseTest;
import com.demoshop.utils.ConfigReader;

import pages.RegistrationPage;

public class RegistrationDuplicateEmailTest extends BaseTest {
	
	
	@Test(groups= {"sanity"})
	public void DuplicateEmailRegistrationTest() {
		
		String firstName=ConfigReader.getProperty("fname");
		String lastName=ConfigReader.getProperty("lname");
		String email=ConfigReader.getProperty("remail");
		String password=ConfigReader.getProperty("rpassword");
		String cnrfPassword=ConfigReader.getProperty("crpassword");
		
		RegistrationPage registration= new RegistrationPage();
		
		registration.Registration(firstName, lastName, email, password, cnrfPassword);
		
		String isErrorDisplayed=registration.validateErrorMessage();
		Assert.assertEquals(isErrorDisplayed, "The specified email already exists");
			
		}
		
		
	}

