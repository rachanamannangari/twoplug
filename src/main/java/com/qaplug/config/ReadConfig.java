package com.qaplug.config;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public Properties pro;

	public ReadConfig() 
	{
		File file=new File("./src/main/java/com/qaplug/config/config.properties");
		 pro=new Properties();
		 FileInputStream read;
		try {
			read = new  FileInputStream(file);
			
				pro.load(read);
			
				// TODO Auto-generated catch block
				
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
		public String getUrl()
		{
		String url=	pro.getProperty("url");
		return url;
			
		}
		public String getUsername()
		{
			String usr=pro.getProperty("username");
			return usr;
		
		}
		public String getpassword()
		{
			String psw=pro.getProperty("password");
			return psw;
		
		}
		
		
	}
	

