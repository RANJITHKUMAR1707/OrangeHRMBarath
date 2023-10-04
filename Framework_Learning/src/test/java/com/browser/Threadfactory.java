package com.browser;

import org.openqa.selenium.WebDriver;

public class Threadfactory {

	
	private static ThreadLocal<WebDriver> dr=new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);
	}
	
    public static void unload() {
    	dr.remove();
    }
}
