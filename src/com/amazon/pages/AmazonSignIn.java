package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.Generic.BasePage;

public class AmazonSignIn extends BasePage
{
	//Declaration
	@FindBy(id="ap_email")
	private WebElement unTX;
	
	@FindBy(id="continue")
	private WebElement conBT;
	
	@FindBy(id="ap_password")
	private WebElement pwTX;
	
	@FindBy(id="signInSubmit")
	private WebElement lgBT;
	
	@FindBy(xpath="(//span)[1]")
	private WebElement errmsg;
	//Initialization
	public AmazonSignIn(WebDriver driver) 
	{
	
		super(driver);
		PageFactory.initElements(driver, this);
		//if not initialization it will throw nullPointerException
	}
	//Utilization
	public void enterUserName(String un)
	{
		unTX.sendKeys(un);
	}
	
	public void clickONContinueButton()
	{
		conBT.click();
	}
	
	public void enterPassword(String pw)
	{
		pwTX.sendKeys(pw);
	}
	
	public void clickOnLoginButton()
	{
		lgBT.click();
	}
	
	
	public String verifyErrMsg()
	{
		VerifyElement(errmsg);
		String aerrormsg=errmsg.getText();
		return aerrormsg;
	}
	
	
	
	
}
