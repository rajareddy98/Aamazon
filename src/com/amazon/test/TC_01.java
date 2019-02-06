package com.amazon.test;

import java.util.Set;

import org.testng.annotations.Test;

import com.amazon.Generic.BaseTest;
import com.amazon.Generic.ExcelData;
import com.amazon.pages.AmazonSignIn;
import com.amazon.pages.AmazoninTodayDeals;
import com.amazon.pages.ECraftIndiaLadoo;
import com.amazon.pages.MiMobiles;
import com.amazon.pages.OnlineShoppingsiteinIndia;

public class TC_01 extends BaseTest 
{
	
	@Test(priority=3)
	public void Login() throws InterruptedException
	{
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		OnlineShoppingsiteinIndia on= new OnlineShoppingsiteinIndia(driver);
		AmazonSignIn am= new AmazonSignIn(driver);
		MiMobiles mi=new MiMobiles(driver);
		AmazoninTodayDeals atd= new AmazoninTodayDeals(driver);
		on.clickOnSigin();
		am.enterUserName(un);
		am.clickONContinueButton();
		am.enterPassword(pw);
		am.clickOnLoginButton();
		mi.clickOnTodaysDeals();
		atd.clickOncheckBox1();
		atd.clickOncheckBox2();
		Thread.sleep(5000);
		atd.clickOnListBox();
		atd.clickOnPrice();
		Thread.sleep(5000);
		atd.clickOnFirstProduct();
		
		Thread.sleep(10000);

		
	}
}
