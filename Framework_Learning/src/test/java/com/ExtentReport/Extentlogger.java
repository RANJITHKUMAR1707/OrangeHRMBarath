package com.ExtentReport;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tests.BaseClass;


public class Extentlogger extends BaseClass {

	public static Logger log =Logger.getLogger(Extentlogger.class);
	static {
		PropertyConfigurator.configure("log4j.properties");
	}
	/**
	 * take a screenshot for base64
	 * @return string
	 */
	public static String Base64image() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	/**
	 * passed withonly message
	 * @param message enter the message
	 */
	private static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
		log.info(message);
	}


	/**
	 * Failed log with only message
	 * @param message enter the message
	 */
	private static void fail(String message) {

		ExtentManager.getExtentTest().fail(message);
		log.error(message);
	}
	/**
	 * Skipped log with only message
	 * @param message Enter the message
	 */
	private static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
		log.info(message);
	}
	/**
	 * information log with only messsage
	 * @param Testinfo Enter the info message
	 */
	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
		log.info(message);
	}
	/**
	 * Passed log message along with screenshot 
	 * @param message Enter the message 
	 * @param needscreenshot need screenshot? (true or false)
	 */
	public static void pass(String message,boolean needscreenshot) {
		if(prop.getProperty("passedstepsscreenshot").equalsIgnoreCase("yes")&& needscreenshot) {
			log.info(message);
			ExtentManager.getExtentTest().pass(message.concat(" is passed"),
					MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.Base64image()).build());
		}else {
			pass(message);
		}
	}
	/**
	 * Failed log message along with screenshot 
	 * @param message Enter the message
	 * @param needscreenshot need screenshot? (true or false)
	 */
	public static void fail(String message,boolean needscreenshot) {
		if(prop.getProperty("failedstepsscreenshot").equalsIgnoreCase("yes")&& needscreenshot) {
			log.error(message);
			ExtentManager.getExtentTest().fail(message.concat(" is failed"),
					MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.Base64image()).build());
		}else {
			fail(message);
		}
	}
	/**
	 * Skipped log message along with screenshot
	 * @param message Enter the message
	 * @param needscreenshot need screenshot? (true or false)
	 */
	public static void skip(String message,boolean needscreenshot) {
		if(prop.getProperty("skippedstepsscreenshot").equalsIgnoreCase("yes")&& needscreenshot) {
			log.info(message);
			ExtentManager.getExtentTest().skip(message.concat(" is Skipped"),
					MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.Base64image()).build());
		}else {
			skip(message);
		}
	}
	/**
	 * geting list of data's and report that in string
	 * @param value value for the report
	 */
	public static void Reportlistofdata(List<WebElement>value) {
		String data=null;
		for(WebElement alloptions:value) {
			data = alloptions.getText();
			implictwait(20);
		}
		ExtentManager.getExtentTest().info(MarkupHelper.createOrderedList(Arrays.asList(new String[] {data})));
	}

}
