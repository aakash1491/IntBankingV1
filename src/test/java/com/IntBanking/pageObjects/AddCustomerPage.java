package com.IntBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;    // Call the WebDriver along with that its variable is also defined
	
	// Create the constructor
	public AddCustomerPage (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Elements that are being used from the AddCustomerPage are defined below
	@FindBy(xpath="//body//div[3]//div[1]//ul[1]/li[2]//a[text()=\"New Customer\"]")
	@CacheLookup
	WebElement NewCustomer;
	
	@FindBy(xpath="//input[@name=\"name\"]")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(xpath="//input[@value=\"m\"]")
	@CacheLookup
	WebElement Gender;
	
	@FindBy(xpath="//input[@type=\"date\"]")
	@CacheLookup
	WebElement DOB;
	
	@FindBy(xpath="//textarea[@name=\"addr\"]")
	@CacheLookup
	WebElement Address;
	
	@FindBy(xpath="//input[@name=\"city\"]")
	@CacheLookup
	WebElement City;
	
	@FindBy(xpath="//input[@name=\"state\"]")
	@CacheLookup
	WebElement State;
	
	@FindBy(xpath="//input[@name=\"pinno\"]")
	@CacheLookup
	WebElement PIN;
	
	@FindBy(xpath="//input[@name=\"telephoneno\"]")
	@CacheLookup
	WebElement MobNo;
	
	@FindBy(xpath="//input[@name=\"emailid\"]")
	@CacheLookup
	WebElement Email;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	@CacheLookup
	WebElement Password;

	@FindBy(xpath="//input[@type=\"submit\"]")
	@CacheLookup
	WebElement SubmitButton;
	
	@FindBy(xpath="//div[@class=\"ns-1eyds-e-6 close-text\"]/span[text()=\"Close\"]")
	@CacheLookup
	WebElement CloseAdButton;
	
	//Methods to call the web elements defined above
	public void clickAddNewCustomer() {
		NewCustomer.click();
	}
	
	public void closeAd() {
		CloseAdButton.click();
	}
	
	public void customerName(String cname) {
		CustomerName.sendKeys(cname);
	}
	
	public void customerGender() {
		Gender.click();
	}
	
	public void customerDob(String mm, String dd, String yyyy) {
		DOB.sendKeys(mm);
		DOB.sendKeys(dd);
		DOB.sendKeys(yyyy);
	}
	
	public void customerAddress(String address) {
		Address.sendKeys(address);
	}
	
	public void customerState(String cstate) {
		State.sendKeys(cstate);
	}
	
	public void customerPin(String cpin) {
		PIN.sendKeys(String.valueOf(cpin));
	}
	
	public void customerMno(String cmno) {
		MobNo.sendKeys(cmno);
	}
	
	public void customerCity(String ccity) {
		City.sendKeys(ccity);
	}
	
	public void customerEmail(String cemail) {
		Email.sendKeys(cemail);
	}
	
	public void customerPass(String cpass) {
		Password.sendKeys(cpass);
	}
	
	public void submitButton() {
		SubmitButton.click();
	}	
}
