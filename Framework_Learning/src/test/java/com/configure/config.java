package com.configure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import com.browser.Browser;

public class config extends Browser {

	/**
	 * get current time of system 
	 * @return data time format
	 */
	public static String getcurrenttime() {
		Date currentdate = new Date();
		String datafilename = currentdate.toString().replace(" ","-").replace(":", "-");
		return datafilename;
	}
	/** 
	 * Get property from the properties file
	 * @throws IOException
	 */
	public static void Getdatafrompropertiesfile() throws IOException {
		File file=new File("./src/test/resources/config/data.properties");
		FileInputStream fis= new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
	}


}