package com.qaplug.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qaplug.base.BaseClass;

import okio.Timeout;

public class Servicepage extends BaseClass {
	@FindBy(xpath="//input[@id='name']")
	WebElement servicename;
	@FindBy(xpath="//div[@class='jq-selectbox__select-text placeholder']")
    WebElement category;
	@FindBy(xpath="//div[contains(text(),'All')]")
    WebElement subcategory;
	@FindBy(xpath="//input[@id='price']")
	WebElement price;
	@FindBy(xpath= "//ul[@class='line-btn pull-right']//button[@class='btn btn-success w-btn-success']")
	//@FindBy(linkText="CREATE")
	//ul[@class='line-btn pull-right']//button[@class='btn btn-success w-btn-success']
	WebElement submitbutton;
	Select sel;
	@FindBy(xpath="//div[contains(text(),'Service has been added')]")
	WebElement actualvalue;
	
	Actions mouse =new Actions(driver);
	
	public Servicepage()
	{
	
		PageFactory.initElements(driver, this);
		
	}
	public void serviceTitle(String title)
	{
		servicename.sendKeys(title);
	}
	public void serviceCategory(String categoryname)
	{
		category.click();
	WebElement categoryelement=	driver.findElement(By.xpath("//li[contains(text(),'"+categoryname+"')]"));
		mouse.moveToElement(categoryelement).click().build().perform();
		
		 
	}
	public void serviceSubcategory(String subcategoryname)
	{
		subcategory.click();
		//div[@class='jq-selectbox__dropdown']// ul /descendant :: li[contains(text(),'DIY & Landscaping')]
		//WebElement subcategoryelement=	driver.findElement(By.xpath("//div[@class='jq-selectbox__dropdown']// ul /descendant ::li[contains(text(),'"+subcategoryname+"')]"));
		//mouse.moveToElement(subcategoryelement).click().build().perform();
		
		
	}
	public void serviceprice(String pricevalue)
	{
		
	//	WebDriverWait wait=new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@id='price']")));
		price.sendKeys(pricevalue);
	}
	public void createservice()
	{
		submitbutton.click();
	}
	public String getActual()
	{
	String act=	actualvalue.getText();
	return act;
	}
	
	
	
}
