package com.amazon.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.amazon.Generic.BaseTest;
import com.amazon.Generic.ExcelData;
import com.amazon.pages.AmazonSignIn;
import com.amazon.pages.OnlineShoppingsiteinIndia;

public class TC_02 extends BaseTest
{
	@Test(priority=2)
	public void inValideData() throws InterruptedException
	{
		String un = ExcelData.getData("C:\\Users\\RAJAREDDY\\git\\Amazon\\data\\pageDetails.xlsx", "TC02", 1, 0);
		OnlineShoppingsiteinIndia on= new OnlineShoppingsiteinIndia(driver);
		AmazonSignIn am= new AmazonSignIn(driver);
		
		on.clickOnSigin();
		am.enterUserName(un);
		am.clickONContinueButton();
		int cn =ExcelData.getRowCount("C:\\Users\\RAJAREDDY\\git\\Amazon\\data\\pageDetails.xlsx", "TC02");
		
		for(int i=0; i<cn; i++)
		{
			String pw = ExcelData.getData("C:\\Users\\RAJAREDDY\\git\\Amazon\\data\\pageDetails.xlsx", "TC02", i, 1);
			Reporter.log("password"+pw,true);
			am.enterPassword(pw);
			am.clickOnLoginButton();
		String aerrmsg = am.verifyErrMsg();
		String eerrmsg = "Your password is incorrect";
		Assert.assertEquals(aerrmsg,eerrmsg);
		Reporter.log("Error msg is correct",true);
		Reporter.log("============================",true);
		Thread.sleep(2000);
		}
	}

}
