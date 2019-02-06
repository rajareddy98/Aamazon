package com.amazon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.amazon.Generic.BasePage;

public class BuyPigeonPages extends BasePage
{
	@FindBy(xpath="//span[@class='a-list-item']//span[@class='a-button-inner']")
	private List<WebElement> allPh;
	
	@FindBy(xpath="(//span[@class='a-button-inner'])[7]")
	private WebElement addCT;
	
	@FindBy(xpath="//span[@class='nav-cart-icon nav-sprite']")
	private WebElement cartBT;
	@FindBy(xpath="(//span[@class='a-size-medium sc-product-title a-text-bold'])[1]")
	private WebElement shpCT;
	
	@FindBy(xpath="(//span[@class='a-button-inner'])[1]")
	private WebElement ptc;
	
	@FindBy(xpath="(//ul)[1]")
	private WebElement VADD;
	
	@FindBy(xpath="(//a[@class='a-declarative a-button-text '])[1]")
	private WebElement deBT;
	
	@FindBy(xpath="//span[@id='acrCustomerReviewText']")
	private WebElement reBT;
	
	@FindBy(xpath="//td[@class='a-text-right aok-nowrap']")
	private List<WebElement> allrew;
	@FindBy (xpath="//td[@class='aok-nowrap']")
	private List<WebElement> allRT;
	
	@FindBy(xpath="//div[@class='a-row a-spacing-top-mini']")
	private List<WebElement> crRt;
	public BuyPigeonPages(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void CustomerReviewsMsg()
	{
		for(WebElement c : crRt)
		{
			String str = c.getText().toString();
			System.out.println(str);
			String[] s = str.split(". ");
			for(String a:s) {
				Reporter.log(a,true);
				System.out.println(a);
			}
			
			Reporter.log("=============================================",true);
		}
	}
	public void CustomerReviews()
	{
		
		ArrayList<String> al1 = new ArrayList<>();
		ArrayList<String> al2 = new ArrayList<>();
		for(WebElement rew : allrew)
		{
			String cR=rew.getText();
			al1.add(cR);
		
		}
		for(WebElement rt : allRT)
		{
			String r= rt.getText();
			al2.add(r);
		}
		for(int i=0; i<al1.size();i++)
		{
			
			Reporter.log(al2.get(i)+" Customer Reviews->  "+al1.get(i),true);
		}
		Reporter.log("=============================================",true);
	}
	
	public void switchToAllPhotos() throws InterruptedException
	{
		for (WebElement ph : allPh) 
		{
			Actions act =new Actions(driver);
			act.moveToElement(ph).perform();
			Thread.sleep(2000);
			
		}
	}
	public void ClickOnReviewsButton()
	{
		reBT.click();
		
	}
	public void ClickOnDeliverButton()
	{
		deBT.click();
	}
	public void ClickOnAddCT()
	{
		addCT.click();
	}
	
	public void ClickOnCartButton()
	{
		cartBT.click();
	}
	public void ClickONProcedToCheckOut() 
	{
		ptc.click();
	
	}
	
		
	public String VerifyCart()
	{
		VerifyElement(shpCT);
		String atext= shpCT.getText();
		Reporter.log(atext,true);
		Reporter.log("=============================================",true);
		return atext;
		
	}
	public String verifyAddress()
	{
		VerifyElement(VADD);
		String text = VADD.getText();
		Reporter.log(text,true);
		Reporter.log("=============================================",true);
		return text;
	}
}
