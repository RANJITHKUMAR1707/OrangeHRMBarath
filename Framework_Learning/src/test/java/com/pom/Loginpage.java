package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tests.BaseClass;

public class Loginpage {

	@FindBy(xpath="//input[@name='username']")
	private static WebElement Username;

	@FindBy(xpath="//input[@name='password']")
	private static WebElement Password;

	@FindBy(xpath="//button[contains(.,'Login')]")
	private static WebElement Loginbutton;

	@FindBy(xpath="//div/p[contains(.,'Invalid credentials')]")
	public static WebElement Invalidcredentialerrormessage;

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	public static WebElement usersettingdropdownElement;

	@FindBy(xpath="//a[contains(.,'Logout')]")
	public static WebElement Logout;
	/*
	 * Login the orange HRM website
	 */
	public  static void Login(String UN,String PW) {
		BaseClass.sendkeys(Username, UN);
		BaseClass.sendkeys(Password,PW);
		BaseClass.clickelement(Loginbutton);
	}
}
