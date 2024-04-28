package com.IntBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.pageObjects.AddCustomerPage;
import com.IntBanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass
{
	@Test
	public void AddNewCustomer() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);   // Import the login page and created the object of it by the name lp
		lp.setUserName(Username);
		lp.setPassword(Password);
		lp.clickSubmit();
				
		Thread.sleep(3000);    // It'll wait for 3000 ms before performing any action
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		{
			addcust.clickAddNewCustomer();
			Thread.sleep(4000);
			addcust.closeAd();
			
			addcust.customerName("Aakash");
			addcust.customerGender();
			addcust.customerDob("01", "01", "2000");
			Thread.sleep(3000);
			addcust.customerAddress("India");
			addcust.customerCity("Bangalore");
			addcust.customerPin("454501");
			addcust.customerState("Karnataka");
			addcust.customerMno("7865089657");
			
			String email = randomestring()+"@gmail.com";
			addcust.customerEmail(email);
			
			addcust.customerPass("abcd");
			addcust.submitButton();
			
			Thread.sleep(3000);
			
			boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
			if (res==true)
			{
				Assert.assertTrue(true);
			}
			else
			{
				captureScreen(driver,"addNewCustomer");
				Assert.assertTrue(false);
			}
		}
	}
	// Now we need to create a function that will generate the random email address so the our TC will not get failed
	
	public String randomestring()
	{
		String generatestring = RandomStringUtils.randomAlphabetic(5);
		return(generatestring);
	}
	
}
