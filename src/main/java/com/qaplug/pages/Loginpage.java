package com.qaplug.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qaplug.base.BaseClass;

public class Loginpage extends BaseClass {
	public WebDriverWait Wait=new WebDriverWait(driver,30);
@FindBy(id="signInEmail")
WebElement username;
@FindBy(xpath="//input[@id='signInPassword']")
WebElement password;
@FindBy(xpath="//ul[@class='line-btn']//button[@class='btn btn-success w-btn-success']")
WebElement loginButton;
public Loginpage()
{
	PageFactory.initElements(driver, this);
	
}

	public Homepage login()
	{
	String s[]=	loginUser();
	String usr=s[0];
	String pwd=s[1];
	//Wait.until(ExpectedConditions.invi(username));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", username);
	username.sendKeys(usr);
	Wait.until(ExpectedConditions.elementToBeClickable(password));
	password.sendKeys(pwd);
	Wait.until(ExpectedConditions.elementToBeClickable(loginButton));
	loginButton.click();
	return new Homepage();
	
	}
	
}
