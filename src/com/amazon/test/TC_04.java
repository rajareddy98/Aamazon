 package com.amazon.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazon.Generic.BaseTest;
import com.amazon.Generic.ExcelData;
import com.amazon.Generic.windowUtility;
import com.amazon.pages.AmazonSignIn;
import com.amazon.pages.AmazoninTodayDeals;
import com.amazon.pages.BuyPigeonPages;
import com.amazon.pages.MiMobiles;
import com.amazon.pages.OnlineShoppingsiteinIndia;

public class TC_04 extends BaseTest
{
	@Test
	public void addcart() throws InterruptedException
	{
		String un = ExcelData.getData("C:\\Users\\RAJAREDDY\\git\\Amazon\\data\\TestCases.xlsx", "TC01", 1, 0);
		String pw = ExcelData.getData("C:\\Users\\RAJAREDDY\\git\\Amazon\\data\\TestCases.xlsx", "TC01", 1, 1);
		String add = ExcelData.getData("C:\\Users\\RAJAREDDY\\git\\Amazon\\data\\TestCases.xlsx", "TC04", 1, 0);
		OnlineShoppingsiteinIndia on= new OnlineShoppingsiteinIndia(driver);
		AmazonSignIn am= new AmazonSignIn(driver);
		MiMobiles mi=new MiMobiles(driver);
		AmazoninTodayDeals atd= new AmazoninTodayDeals(driver);
		BuyPigeonPages by = new BuyPigeonPages(driver);
		on.clickOnSigin();
		am.enterUserName(un);
		am.clickONContinueButton();
		am.enterPassword(pw);
		am.clickOnLoginButton();
		mi.clickOnTodaysDeals();
		atd.clickOnFirstProduct();
		Thread.sleep(2000);
		windowUtility.switchWindow(driver, "Buy Pigeon by Stovekraft Handy Mini Plastic Chopper with 3 Blades, Grey Online at Low Prices in India - Amazon.in");
		Thread.sleep(5000);
		by.switchToAllPhotos();
		Thread.sleep(2000);
		by.ClickOnReviewsButton();
		Thread.sleep(2000);
		windowUtility.switchWindow(driver, "Amazon.in:Customer reviews: Pigeon by Stovekraft New Handy Mini Plastic Chopper with 3 Blades, Green");
		by.CustomerReviews();
		by.CustomerReviewsMsg();
		by.ClickOnAddCT();
		Thread.sleep(2000);
		by.ClickOnCartButton();
		Thread.sleep(2000);
		by.VerifyCart();
		by.ClickONProcedToCheckOut();
		String aaddress= by.verifyAddress();
		String eaddress = add;
		Assert.assertEquals(aaddress, eaddress);
		by.ClickOnDeliverButton();
		Thread.sleep(5000);
	}
}
