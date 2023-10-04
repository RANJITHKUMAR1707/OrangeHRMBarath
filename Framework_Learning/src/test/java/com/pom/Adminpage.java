package com.pom;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tests.BaseClass;

public class Adminpage extends BaseClass  {

	@FindBy(xpath="//a/span[contains(.,'Admin')]")
	private static WebElement AdminMenu;

	@FindBy(xpath="//div/label[contains(.,'Username')]//following::div/input[@class='oxd-input oxd-input--active']")
	private static WebElement Systemusers;

	@FindBy(xpath="//div[@role='option']//span")
	private static List<WebElement> StatusOptions;

	@FindBy(xpath="//div/label[contains(.,'Status')]//following::div[@class='oxd-select-text oxd-select-text--active']")
	private static WebElement status;


	@FindBy(xpath="//div//input[contains(@placeholder,'Type for hints')]")
	private static WebElement AdminEmpname;

	@FindBy(xpath ="//div[@role='listbox']//span")
	private static List<WebElement> userroleoptions;

	@FindBy(xpath="//div/label[contains(.,'User Role')]//parent::"
			+"div//following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']")
	private static WebElement userrole;

	@FindBy(xpath="//button[contains(.,'Search')]")
	private static WebElement searchbutton;

	@FindBy(xpath="//button[contains(.,'Add')]")
	private static WebElement Addbutton;

	@FindBy(xpath="//div/label[contains(.,'User Role')]//parent::div//following-sibling::div/div")
	private static WebElement Adduserrole;

	@FindBy(xpath="//div/label[contains(.,'Status')]//parent::div//following-sibling::div/div")
	private static WebElement AddStatus;

	@FindBy(xpath="//div/label[contains(.,'Username')]//parent::div//following-sibling::div/input")
	private static WebElement Addusername;

	@FindBy(xpath="//div/label[text()='Password']//parent::div//following-sibling::div/input")
	private static WebElement Addpassword;

	@FindBy(xpath="//div/label[contains(.,'Confirm')]//parent::div//following-sibling::div/input")
	private static WebElement Addconfirmpassword;

	@FindBy(xpath="//span[contains(.,'Passwords do not match')]")
	private static WebElement passwordmismatcherror;

	@FindBy(xpath="//button[contains(.,'Save')]")
	private static WebElement Savebutton;

	@FindBy(xpath="//div[@class='oxd-table-header']//following-sibling::span")
	private static WebElement Selectallcheckbox;
	
	@FindBy(xpath="//button[contains(.,'Delete')]")
	private static WebElement Deletebutton;
	
	@FindBy(xpath="//button[contains(.,' Yes, Delete')]")
	private static WebElement Yesdeletealertbutton;
	
	/**
	 *  Search and Admin by username, user role,Emp name,and Status
	 * @param Username Enter the username
	 * @param Userrole select the User role
	 * @param Empname Enter the Employee name
	 * @param Status  select the Status
	 */
	public static void Adminuserssearch(String Username,String Userrole,String Empname,String Status) {
		clickelement(AdminMenu);
		sendkeys(Systemusers,Username);
		selectaoption(userroleoptions,userrole, Userrole);
		clickelement(AdminEmpname);
		sendkeys(AdminEmpname,Empname);
		selectaoption(StatusOptions,status,Status);
		clickelement(searchbutton);

	}


	/**
	 * Add the user to the list
	 * @param Userrole Select the user role
	 * @param Empname Enter the Employee name
	 * @param Status Select the status
	 * @param username Enter the Username
	 * @param Password Enter the password
	 * @param Confirmpassword Enter the confirm password
	 */
	public static void Adduser(String Userrole,String Empname,String Status,String username,String Password,String Confirmpassword) {
		clickelement(AdminMenu);
		clickelement(Addbutton);
		selectaoption(userroleoptions, Adduserrole, Userrole);
		sendkeywithenter(AdminEmpname,Empname);
		
		selectaoption(StatusOptions,AddStatus,Status);
		sendkeys(Addusername,username);
		sendkeys(Addpassword,Password);
		sendkeys(Addconfirmpassword,Confirmpassword);
		clickelement(Savebutton);
		try {
			if(isdisplay(passwordmismatcherror));
			verifyisdisplay(isdisplay(passwordmismatcherror));
		}catch (NoSuchElementException e) {
			
		}
		}
	/**
	 * Delete all the employee data
	 */
	public static void DeleteAllRecords() {
		clickelement(AdminMenu);
		clickelement(Selectallcheckbox);
		clickelement(Deletebutton);
		clickelement(Yesdeletealertbutton);
	}

	}





