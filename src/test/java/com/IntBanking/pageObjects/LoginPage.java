package com.IntBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;                     // Add the WebDriver as local driver
	
	public LoginPage(WebDriver rdriver)    // Adding WebDriver as remote driver
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//body/div[3]/div[1]/ul[1]/li[15]/a[@href=\"Logout.php\"]")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
