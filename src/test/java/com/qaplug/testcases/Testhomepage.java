package com.qaplug.testcases;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import com.qaplug.base.BaseClass;
import com.qaplug.config.ReadConfig;
import com.qaplug.pages.Homepage;
import com.qaplug.pages.LandingPage;
import com.qaplug.pages.Loginpage;

public class Testhomepage extends BaseClass {

	LandingPage page;
	Homepage homepage;
	Loginpage loginpage;
	public ReadConfig con=new ReadConfig();
	@BeforeMethod
	public void launch()
	{
		setUp();
		 page=new  LandingPage();
		page.clickOnabout();
		loginpage=page.loginbutton();
		 homepage = loginpage.login();
		
	}
	
	@Test(enabled=true)
	public void Testlabel() throws Exception
	{
		String act=homepage.namelabel();

		
		
		Assert.assertEquals(act,"plugs","label is not right" );
		
	}
	@Test(priority=1)
	public void Testuserlabel()
	{
		String name=con.getUsername();
		String act=homepage.userlabel(name);
		Assert.assertEquals(act, "Hi polaris");
		
	}
	@Test(priority=2)
	public void TestsearchserviceBox() throws InterruptedException
	{
	List<WebElement>list=homepage.searchbox();
//List<WebElement>list1=	driver.findElements(By.xpath("//table[@class='result-table']// tr /descendant :: div[@class='title']"));
	System.out.println("number of elements" +list.size());
	for(int i=0;i<list.size();i++) {
		if(list.get(i).getText().contains("eyebrows"))
		{
			
			System.out.println("---test");
			//list.get(i).click();
		String act=	driver.findElement(By.xpath("//table[@class='result-table']// tr /descendant :: div[@class='title']")).getText();
			
		System.out.println("text is" +act);
		homepage.searchClick("eyebrows");
			break;
			
		}
	}
	
	}
	@Test(priority=3)
	public void testserviceButton()
	{
		homepage.clickplusButton();
		homepage.clickservice();
		String act=homepage.getServicelabel();
		Assert.assertEquals(act, "Add A Service","service label is not matching");
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult result)
	{
		
			if(ITestResult.FAILURE==result.getStatus())
			{
				takeScreenshot(result.getName());
			}
		
		
		tearDown();
	}
	
}
