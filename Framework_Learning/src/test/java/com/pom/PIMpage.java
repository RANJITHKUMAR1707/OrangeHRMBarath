package com.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ExtentReport.Extentlogger;
import com.tests.BaseClass;

public class PIMpage extends BaseClass {
	static WebElement i;
	static WebElement j;

	@FindBy(xpath="//span[contains(.,'PIM')]")
	public static WebElement PIMMenu;

	@FindBy(xpath="//label[contains(.,'Employee Name')]//parent::div"
			+ "//following-sibling::div//input[contains(@placeholder,'Type for hints')]")
	private static WebElement Empname;

	@FindBy(xpath="//label[contains(.,'Employee Id')]//parent::div//following::div//input")
	private static WebElement Empid;

	@FindBy(xpath="//div[@role='option']/span")
	private static List<WebElement> options;

	@FindBy(xpath="//label[contains(.,'Include')]//preceding::div[@class='oxd-select-text oxd-select-text--active']")
	private static WebElement Empstatus;

	@FindBy(xpath="//button[contains(.,'Search')]")
	private static WebElement Searchbutton;

	@FindBy(xpath="//button[contains(.,'Add')]")
	private static WebElement Addbutton;

	@FindBy(xpath="//input[@name='firstName']")
	private static WebElement Firstname;

	@FindBy(xpath="//input[@name='lastName']")
	private static WebElement Lastname;

	@FindBy(xpath="//label[contains(.,'Employee Id')]//parent::div//following::div/input")
	private static WebElement Employeeid;

	@FindBy(xpath="//button[contains(.,'Save')]")
	private static WebElement Savebutton;

	@FindBy(xpath="//div[@class='oxd-table-header']//following-sibling::span")
	private static WebElement Selectallcheckbox;

	@FindBy(xpath="//button[contains(.,'Delete')]")
	private static WebElement Deletebutton;

	@FindBy(xpath="//button[contains(.,' Yes, Delete')]")
	private static WebElement Yesdeletealertbutton;

	@FindBy(xpath="//button[contains(@class,'image-action')]")
	private static WebElement Image;

	@FindBy(xpath="//div[@class='oxd-toast-content oxd-toast-content--success']")
	public  static WebElement Savedsuccessmessage;

	@FindBy(xpath ="//div[@class='oxd-table-card']")
	public static WebElement Recordfound;

	@FindBy(xpath="//button/i[@class='oxd-icon bi-trash']")
	public static WebElement deletebuttonElement;

	@FindBy(xpath="//div[contains(@class,'oxd-table-row oxd-table-row--with-border')]")
	public static List<WebElement> PIMmemployeerecordrow;

	@FindBy(xpath="(//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'])[1]"
			+ "//div[@class='oxd-table-cell oxd-padding-cell']/div")
	public static List<WebElement> PIMemployeerecordcolumn;

	@FindBy(xpath ="//button[@type='button']/i[contains(@class,'right')]")
	public static WebElement Employeerecordsnextbutton;

	public static String dynamicrowxpath="//div[contains(@class,'oxd-table-row oxd-table-row--with-border')]";
	public static String dynamiccolxpath="/div";

	/**
	 * Search the Employee name
	 * @param Employeename Enter the Employee name
	 * @param Employeeid Enter the Employee id
	 */
	public static void employeesearch(String Employeename,String Employeeid) {

		clickelement(PIMMenu);
		sendkeywithenter(Empname,Employeename);
		Extentlogger.pass("Employeename was entered successfully->"+Employeename, false);
		sendkeys(Empid,Employeeid);
		clickelement(Searchbutton);
	}
	/**
	 * Add Employee name 
	 * @param firstname Enter the Firstname
	 * @param lastname Enter the last name
	 * @param number enter the empnumber
	 * @throws InterruptedException 
	 * 
	 */
	public static void Addemployee(String firstname,String lastname,String number) throws InterruptedException {
		clickelement(PIMMenu);
		clickelement(Addbutton);
		sendkeys(Firstname,firstname);		
		sendkeys(Lastname,lastname); 
		clickelement(Employeeid);
		Robotclassfordeletetextbox();
		sendkeys(Employeeid,number);
		implictwait(20);
		clickelement(Savebutton);

	}
	/**
	 * Delete all the employee data
	 */
	public static void DeleteAllRecords() {
		clickelement(PIMMenu);
		clickelement(Selectallcheckbox);
		clickelement(Deletebutton);
		clickelement(Yesdeletealertbutton);
	}


}





