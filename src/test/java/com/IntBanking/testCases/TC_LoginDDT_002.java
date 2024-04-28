package com.IntBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.IntBanking.pageObjects.LoginPage;
import com.IntBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pass) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		Logger.info("Username provided");
		lp.setPassword(pass);
		Logger.info("Password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();  // Close the alert
			driver.switchTo().defaultContent();  // This command will switch to login page
			Assert.assertTrue(false);
			Logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			Logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();  // Close the logout alert
			driver.switchTo().defaultContent();  // This command will switch to login page
		}
	}
	
	// We need to create the user defined method for verifying the Alert pop-up window 
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	// Below is the data provider method
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		// String path = "C:\\Users\\Shubham\\Documents\\Devlopment tools\\SeleniumWebDriver\\IntBankingV1\\src\\test\\java\\com\\IntBanking\\testData\\loginData.xlsx";
		String path = System.getProperty("user.dir")+"/src/test/java/com/IntBanking/testData/loginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		// Now need to convert the data in 2D array
		
		String logindata[][] = new String [rownum][colcount];
		
		// Now need to create the for loop array to get the data
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);  // Sending for 1 and 0
			}
		}
	return logindata;
	}

}
