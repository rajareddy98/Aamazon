package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.Generic.BasePage;

public class MiMobiles extends BasePage 
{
	@FindBy(xpath="//a[contains(.,'Today')]")
	private WebElement td;

	public MiMobiles(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTodaysDeals()
	{
		td.click();
	}
}
