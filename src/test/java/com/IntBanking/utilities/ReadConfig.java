package com.IntBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;			// We have created one object for the property class
						   // Now we need to create the constructor	by name ReadConfig
	public ReadConfig()    // In pageObject we have created the driver object at the first time. Similarly here we have to create one constructor
	{
		File src = new File("./Configurations/config.properties");  // src is the variable of config.properties 
		try
		{
			FileInputStream fis = new FileInputStream(src);  // For reading the data from config.properties in read mode we have used the FileInputStream method.  
			pro = new Properties();
			pro.load(fis);  // pro.load is the method which load the config.properties file at the run time 
		}
		catch (Exception e) // In case if config.properties file is not present then we will get the below exception
		{
			System.out.println("Exception is " + e.getMessage());
		}		
	}
	// Now we'll create the different method for each variable just like a page object class
	
	public String getApplicationURL()
		{
			String url=pro.getProperty("baseURL");
			return url;
		}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
