package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.Generic.BasePage;
import com.amazon.Generic.GenericUtils;

public class ECraftIndiaLadoo extends BasePage 
{
	
	@FindBy(xpath="(//span[@id='a-autoid-10-announce']/..)[3]")
	private WebElement sm; 
	@FindBy(id="swfRecTextarea")
	private WebElement ema;
	@FindBy(xpath="(//span[@class='a-button-inner'])[40]")
	private WebElement butt;
	
	public ECraftIndiaLadoo(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickOnShareEmail()
	{
		GenericUtils.moveToElement(driver, sm);
	}
	public void EnterEmail(String Email)
	{
		ema.sendKeys(Email);
	}
	public void ClickOnSendEmail()
	{
		butt.click();
	}
}
