package com.amazon.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.amazon.Generic.BaseTest;
import com.amazon.Generic.ExcelData;
import com.amazon.pages.AmazonSignIn;
import com.amazon.pages.AmazoninTodayDeals;
import com.amazon.pages.OnlineShoppingsiteinIndia;

public class TC_03 extends  BaseTest
{
	@Test(priority=1)
	public void pinCode() throws InterruptedException
	{

		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		OnlineShoppingsiteinIndia on = new OnlineShoppingsiteinIndia(driver);
		AmazoninTodayDeals at = new AmazoninTodayDeals(driver);
		AmazonSignIn am = new AmazonSignIn(driver);
		on.clickOnSigin();
		am.enterUserName(un);
		am.clickONContinueButton();
		am.enterPassword(pw);
		am.clickOnLoginButton();
		String apin = at.verifyPinCode();
		String epin = "Bangalore 560103‌";
		Assert.assertEquals(apin, epin);
		Reporter.log("pin code is matching");
		Thread.sleep(5000);
		at.signinButton();
		Thread.sleep(5000);
		at.clickOnSigOutButton();
		Thread.sleep(5000);
		
	}

}
