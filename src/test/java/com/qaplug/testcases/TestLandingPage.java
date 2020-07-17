package com.qaplug.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.qaplug.base.BaseClass;
import com.qaplug.pages.Homepage;
import com.qaplug.pages.LandingPage;
import com.qaplug.pages.Loginpage;



public class TestLandingPage extends BaseClass {
	LandingPage page;
	Homepage homepage;
	Loginpage loginpage;

	@BeforeMethod
	public void launch()
	{
		setUp();
		 page=new  LandingPage();
		
	}
	@Test(priority=0)
	public void Testaboutlink()
	{
		page.clickOnabout();
	String act=	driver.getCurrentUrl();
if(act.contains("about"))
{
	Assert.assertTrue(true);
}

	}
	@Test(priority=1)
	public void checkLogo()
	{
		boolean exp=page.checkLogo();
		Assert.assertEquals(exp, true);
	}
	@Test(priority=2)
	public  void TestloginButton() throws InterruptedException
	{
		page.clickOnabout();
	loginpage=page.loginbutton();
	 homepage=loginpage.login();
	String act=driver.getTitle();
	if(act.contains("twoPLUGS"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
		
		//String act=driver.getCurrentUrl();
		/*
		 * if(act.contains("login")) { Assert.assertTrue(true); } else {
		 * Assert.assertTrue(false); }
		 */
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
}
