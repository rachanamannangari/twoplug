package com.qaplug.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaplug.base.BaseClass;
import com.qaplug.config.ReadConfig;
import com.qaplug.pages.Homepage;
import com.qaplug.pages.LandingPage;
import com.qaplug.pages.Loginpage;
import com.qaplug.pages.Servicepage;
import com.qaplug.utilities.XLutils;

public class TestServicepage extends BaseClass{

	
	
	LandingPage page;
	Homepage homepage;
	Loginpage loginpage;
	Servicepage servicepage;
	public ReadConfig con=new ReadConfig();
	//XLutils xlutils;
	@BeforeMethod
	public void launch()
	{
		setUp();
		 page=new  LandingPage();
		page.clickOnabout();
		loginpage=page.loginbutton();
		 homepage = loginpage.login();
		
	}
	@Test(dataProvider="serviceData")
	public void addnewService(String title,String category,String subcategory, String price)
	{
		homepage.clickplusButton();
	servicepage=homepage.clickservice();
	servicepage.serviceTitle(title);
	servicepage.serviceCategory(category);
	servicepage.serviceSubcategory(subcategory);
	servicepage.serviceprice(price);
	//JavascriptExecutor jse = (JavascriptExecutor)driver;
	//jse.executeScript("window.scrollBy(0,250)");
	servicepage.createservice();
	String act=servicepage.getActual();
	System.out.println("Actual value is" +act);
	Assert.assertEquals(act, "Service has been added","Result is not expected");
	}
	
	@DataProvider
	public String[][] serviceData() throws IOException
	{
	String XLfile= "C:\\Users\\BIJOY\\Desktop\\busyqa course work\\eclipse\\twoplug\\src\\main\\java\\com\\qaplug\\testdata\\servicedata.xlsx";
		int rowcount=XLutils.getRowCount(XLfile, "Sheet1");
		int columncount=XLutils.getCellCount(XLfile, "Sheet1", 1);
		System.out.println("rowcount is" + rowcount);
		System.out.println("column count is"+ columncount);
	String[][]data=new String[rowcount][columncount];
	for(int i=1;i<=rowcount;i++)
	{
		for(int j=0;j<columncount;j++)
		{
			data[i-1][j]=XLutils.getCellData(XLfile, "Sheet1", i, j);
			
		}
			
	}
	for(int i=0;i<rowcount;i++)
	{
		for(int j=0;j<columncount;j++)
		{
			System.out.print(data[i][j]+ " ");
			
		}
		System.out.println();
			
	}
	return data;
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
