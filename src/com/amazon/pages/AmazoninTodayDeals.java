package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.amazon.Generic.BasePage;

public class AmazoninTodayDeals extends BasePage
{
	
	@FindBy(xpath="(//span[.='Department']/../..//input[@type='checkbox'])[1]")
	private WebElement ch1; 
	@FindBy(xpath="(//span[.='Department']/../..//input[@type='checkbox'])[2]")
	private WebElement ch2;
	@FindBy(xpath="(//span[@class='a-button-inner'])[5]")
	private WebElement liBT;
	@FindBy(xpath="//a[contains(.,'Price - Low to High')]")
	private WebElement plBT;
	@FindBy(xpath="(//div[@class='a-row dealContainer'])[5]")
	private WebElement ftBT;
	@FindBy(xpath="(//span[@class='nav-line-2'])[1]")
	private WebElement piBT;
	@FindBy(xpath="//span[contains(.,'Hello')]")
	private WebElement opt;
	@FindBy(xpath="//span[.='Sign Out']")
	private WebElement signOut;
	
	public AmazoninTodayDeals(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSigOutButton()
	{
		signOut.click();
	}
	
	public void signinButton()
	{
		Actions act =new Actions(driver);
		act.moveToElement(opt).perform();
	}
	public String verifyPinCode()
	{
		VerifyElement(piBT);
		String atext = piBT.getText();
		Reporter.log(atext,true);
		return atext;
	}
	
	public void clickOncheckBox1()
	{
		ch1.click();
	}
	public void clickOncheckBox2()
	{
		ch2.click();
	}
	
	public void clickOnListBox()
	{
		liBT.click();
	}
	public void clickOnPrice()
	{
		plBT.click();
	}
	public void clickOnFirstProduct()
	{
		ftBT.click();
	}

}
