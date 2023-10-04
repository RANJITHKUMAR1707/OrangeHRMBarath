package com.browser;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.ExtentReport.ExtentReport;
import com.configure.Factory;
import com.configure.config;
import com.pom.Dashboardpage;
import com.tests.BaseClass;

public class Browser {

	public static WebDriver driver;
	public static Dashboardpage Dashboard;
	public static SoftAssert Softassert;
	public static Capabilities capabilities;
	static String BrowserName;
	static String BrowserVersion;
	public static Properties prop;
	

	@BeforeSuite
	public static void BeforeLaunchingbrowser() throws IOException {
		config.Getdatafrompropertiesfile();
		ExtentReport.extent.setSystemInfo("URL",prop.getProperty("URL"));

		ExtentReport.extent.setSystemInfo("Username",prop.getProperty("UN"));
		ExtentReport.extent.setSystemInfo("Password",prop.getProperty("PW"));
		Softassert=new SoftAssert();
	}
	@Parameters("Browser")
	@BeforeMethod
	public static void LaunchBrowser(String Browser){

		if(Browser.equalsIgnoreCase("Chrome")) {
			driver =new ChromeDriver();
			capabilities=((RemoteWebDriver)driver).getCapabilities();
			BrowserName = capabilities.getBrowserName();
			BrowserVersion = capabilities.getBrowserVersion();
		}else if(Browser.equalsIgnoreCase("Firefox")) {

			driver=new FirefoxDriver();
			capabilities=((RemoteWebDriver)driver).getCapabilities();
			BrowserName = capabilities.getBrowserName();
			BrowserVersion = capabilities.getBrowserVersion();
		}else if(Browser.equalsIgnoreCase("Edge")) {

			driver=new EdgeDriver();
			capabilities=((RemoteWebDriver)driver).getCapabilities();
			BrowserName = capabilities.getBrowserName();
			BrowserVersion = capabilities.getBrowserVersion();
		}

		driver.get(prop.getProperty("URL"));

		BaseClass.implictwait(30);
		Factory.initelements();
		Dashboard= new Dashboardpage(driver);
	
	}
	/**
	 * Close the Browser
	 * @throws IOException 
	 */
	@AfterMethod	
	public void CloseBrowser() throws IOException {
		driver.quit();
		Softassert.assertAll();
	}

	public static void Browserinfo() {
		ExtentReport.extent.setSystemInfo("Browser Name",BrowserName);
		ExtentReport.extent.setSystemInfo("Browser Version",BrowserVersion);
	}
}
