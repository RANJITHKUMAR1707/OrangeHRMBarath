package com.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tests.BaseClass;

public class PIMinfopage extends BaseClass {

	@FindBy(xpath="//label[contains(.,'Nickname')]//parent::div/following::input[@class='oxd-input oxd-input--active']")
	private static WebElement Nickname;
	
	@FindBy(xpath="//label[contains(.,'Nationality')]/parent::div/following::div[@class='oxd-select-text-input']")
	private static WebElement Nationality;
	
	@FindBy(xpath="//div[@role='option']/span")
	private static List<WebElement> dropdownoptions;
	
	

	public static void Employeeinfo(String NickName,String Nation) {
		javascriptclick(Nickname);
		implictwait(10);
		Nickname.sendKeys(NickName);
		selectaoption(dropdownoptions, Nationality, Nation);
		wait3sec();
	}
}
