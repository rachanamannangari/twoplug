package com.qaplug.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qaplug.base.BaseClass;

public class LandingPage extends BaseClass {
	
	
	@FindBy(linkText= "ABOUT")
	 WebElement aboutlink;
	@FindBy(xpath= "/html/body/div/header/div/a/img")
WebElement logo;
	@FindBy(linkText="LOG IN")
	WebElement login;
	
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}
public void clickOnabout()
{
	aboutlink.click();
}
public boolean checkLogo()
{
	return logo.isDisplayed();
}
public Loginpage loginbutton()
{
login.click();
return new Loginpage();
}



}
