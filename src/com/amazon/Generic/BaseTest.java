package com.amazon.Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements Autoconstant
{
	public WebDriver driver;
	@BeforeMethod
	public void precondition()
	{
		System.setProperty(chrome_key, chrome_value);
		driver= new ChromeDriver();
//		System.setProperty(firefox_key, firefox_value);
//		driver= new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
			
	}
	@AfterMethod
	public void postcondition(ITestResult res)
	{
		int status=res.getStatus();
		if(status==2)
		{
			String name=res.getMethod().getMethodName();
			GenericUtils.getScreenShot(driver, name);
		}
		
		driver.quit();
		
	}
}
