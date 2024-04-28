package com.IntBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.IntBanking.utilities.ReadConfig;

public class BaseClass 
{
	// We need to create the object of ReadConfig for using the methods present init
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String Username = readconfig.getUsername();
	public String Password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	// Parameters will take the value from xml file
	@Parameters("browser")
	
	// Below method will execute before every Test Case
	@BeforeClass
	// Same variable we need to pass in the setup method. Here br is browser variable
	public void setup(String br)
	{
		// By adding Syste.getProperty("user.dir") will give the project directory path so no need to provide the whole path of the driver 
		
		Logger=org.apache.log4j.Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver = new ChromeDriver();	
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.geco.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	// Below method will run after the compilation of every test case
	@AfterClass
	public void teatdown()
	{
		driver.quit();
	}
	
	// Below method is used for taking screenshot in case of TC failure
	
	public void captureScreen(WebDriver driver, String tname) {
	    try {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	        FileUtils.copyFile(source, target);
	        System.out.println("Screenshot taken and saved to: " + target.getAbsolutePath());
	    } catch (IOException e) {
	        System.out.println("Failed to capture screenshot: " + e.getMessage());
	        e.printStackTrace();
	    } catch (Exception ex) {
	        System.out.println("An unexpected error occurred: " + ex.getMessage());
	        ex.printStackTrace();
	    }	    
	}
	
	// Method to handle test failures and capture screenshot
    @AfterMethod
    public void handleTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreen(driver, result.getName());
        }
    }   
}
