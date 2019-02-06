package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.Generic.BasePage;

public class OnlineShoppingsiteinIndia extends BasePage
{
	@FindBy(xpath="//span[.='Hello, Sign in']")
	private WebElement signin;

	public OnlineShoppingsiteinIndia(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSigin()
	{
		signin.click();
	}

}
