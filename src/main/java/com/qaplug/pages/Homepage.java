package com.qaplug.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qaplug.base.BaseClass;

public class Homepage extends BaseClass {
	
	@FindBy(xpath= "//span[contains(text(),'Plugs')]")
	WebElement labelplug;
	@FindBy(xpath="//input[@name='q']")
	WebElement searchbox;
	@FindBy(xpath="//table[@class='result-table']// tr /descendant :: div[@class='text']")
	WebElement searchelement;
	@FindBy (xpath="//span[@class='w-icons-create']")
	WebElement addbutton;
	@FindBy (xpath="//a[contains(text(),'Service')]")
	WebElement addservice;
	@FindBy(xpath="//span[contains(text(),'Add A Service')]")
	WebElement servicelabel;
	
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}	
   
	public String namelabel()
	{
		//takelementScreenshot(labelplug, "pluglabel");
		
	   return labelplug.getText();
	}
	
	public String userlabel(String name)
	{
	String label=	driver.findElement(By.xpath("//span[contains(text(),'Hi "+name+"')]")).getText();
	return label;
	}
	
	public List<WebElement> searchbox()
	{
		searchbox.sendKeys("eyebrows");
		searchbox.sendKeys(Keys.ENTER);
	List<WebElement>list=	driver.findElements(By.xpath("//table[@class='result-table']// tr /descendant :: div[@class='text']"));
	return list;
	}
	public void searchClick(String name)
	{
		driver.findElement(By.xpath("//table[@class='result-table'] // tr / descendant :: div[contains(text(),'"+name+"')]")).click();
	}
	public void clickplusButton()
	{
		addbutton.click();
	}
	public Servicepage clickservice()
	{
		Actions action=new Actions(driver);
		action.moveToElement(addservice).click().build().perform();
		return new Servicepage();
		
	}
	public String getServicelabel()
	{
		String label=servicelabel.getText();
		return label;
	}
	
}
