package com.IntBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.IntBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{
	@Test
	public void loginTest() throws IOException      // loginTest is the test case name
	{
		driver.get(baseURL);
		
		Logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver); // Here we have created an object for pageObjects. Now we can use methods present in it
		lp.setUserName(Username);
		Logger.info("Entered Username");
		
		lp.setPassword(Password);
		Logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			Logger.info("Login test failed");
		}
	}	
}
