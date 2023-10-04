package com.tests;

import org.testng.annotations.Test;

import com.pom.Loginpage;

public class Login extends BaseClass{
	/**
	 * Verify a website's URL and login using valid credentials.
	 */
	@Test(priority = 1,enabled=true)
	public void verifyurlTC001() {
		
		verifyURL(prop.getProperty("URL"));
		implictwait(10);
		Loginpage.Login(prop.getProperty("UN"),prop.getProperty("PW"));
		implictwait(10);
		verifyisdisplay(isdisplay(Dashboard.Dashboardheading));
		Logout();
	}

	/**
	 * Verify a error message for an login using invalid credentials.
	 */
	@Test(priority = 2)
	public void VerifytheerrormessageonloginpageTC002() {

		Loginpage.Login(prop.getProperty("INUN"),prop.getProperty("INPW"));
		implictwait(10);
		verifyisdisplay(isdisplay(Loginpage.Invalidcredentialerrormessage));
		implictwait(10);
	}
}
