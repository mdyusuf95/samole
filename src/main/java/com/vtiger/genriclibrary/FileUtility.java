package com.vtiger.genriclibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String readDatafromPropertyFile(String key) throws IOException
	{  
		FileInputStream fl= new FileInputStream("./src/test/resources/CommonData.property");
		Properties p= new Properties();
		p.load(fl);
		String data = p.getProperty(key);
		return data;
		
	}
	
	

}
