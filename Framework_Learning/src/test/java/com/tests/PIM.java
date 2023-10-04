package com.tests;

import org.testng.annotations.Test;

import com.pom.Loginpage;
import com.pom.PIMpage;

public class PIM extends BaseClass {

	
	@Test(priority=1,enabled =true)
	private void deleteemployee() {
		Loginpage.Login(prop.getProperty("UN"),prop.getProperty("PW"));
		PIMpage.DeleteAllRecords();
		verifyisdisplay(isdisplay(PIMpage.Savedsuccessmessage));
		
	}
	/**
	 * Create an Employee and check the success message is display or not
	 * @throws InterruptedException 
	 */
	@Test(priority = 2,dataProvider = "Addemployee",dataProviderClass = PIMDataprovider.class,enabled=true)
	public void createemployee(String Firstname,String Lastname,String Empid) throws InterruptedException {
		Loginpage.Login(prop.getProperty("UN"),prop.getProperty("PW"));

		PIMpage.Addemployee(Firstname, Lastname,Empid);
		implictwait(10);
		verifyisdisplay(isdisplay(PIMpage.Savedsuccessmessage));

	}

	/**
	 * Search the Employee based on the information
	 */
	@Test(priority = 3,dataProvider = "Addemployee",dataProviderClass = PIMDataprovider.class,enabled =true)
	private void Employeeinfosearch(String Firstname,String Lastname,String Empid) {
		Loginpage.Login(prop.getProperty("UN"),prop.getProperty("PW") );

		PIMpage.employeesearch(Firstname.concat(" "+Lastname), Empid);
		verifyisdisplay(isdisplay(PIMpage.Recordfound));
		implictwait(10);
	}


	@Test(priority = 4,enabled =true)
	private void getemployeedata() {
		Loginpage.Login(prop.getProperty("UN"),prop.getProperty("PW"));
		clickelement(PIMpage.PIMMenu);
		exportexceldata(PIMpage.PIMmemployeerecordrow,PIMpage.PIMemployeerecordcolumn,PIMpage.Employeerecordsnextbutton,
				PIMpage.dynamicrowxpath,PIMpage.dynamiccolxpath);

	}
}

