package com.amazon.Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void VerifyTile(String title)
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		try
		{
		wait.until(ExpectedConditions.titleIs(title));
		Reporter.log("Title is matching  "+driver.getTitle(),true);
		}
		catch (Exception e)
		{
		Reporter.log("Title is not matching"+driver.getTitle(),true);
		Assert.fail();
		}
	}
	public void VerifyElement(WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present",true);
		}
		catch (Exception e)
		{
			Reporter.log("Element is not prersent",true);
			Assert.fail();
		}
	}
	

}
