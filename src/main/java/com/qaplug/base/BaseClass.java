package com.qaplug.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qaplug.config.ReadConfig;
import com.qaplug.utilities.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public ReadConfig con=new ReadConfig();
	String arr[]=new String[2];
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	
 
	
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		e_driver=new EventFiringWebDriver(driver);
		eventlistener=new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		String url=con.getUrl();
		driver.get(url);
		
		
}
	
	public String[] loginUser()
	{
		arr[0]= con.getUsername();
		arr[1]= con.getpassword();
		return arr;
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
   public void takeScreenshot(String  testname)
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File soursce=ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(soursce, new File("./Screenshot/"+testname+" "+ System.currentTimeMillis() +".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}

}


	/*
	 * public void takelementScreenshot(WebElement element,String filename) { File
	 * src=element.getScreenshotAs(OutputType.FILE); try { FileUtils.copyFile(src,
	 * new File("./test-output/screenshot/"+filename+".png ")); } catch (IOException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */
	
	public void tearDown()
	{
		
		
		driver.close();
	}
	

}
