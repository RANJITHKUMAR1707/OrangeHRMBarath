package com.tests;

import org.testng.annotations.Test;

import com.pom.Adminpage;
import com.pom.Loginpage;
import com.pom.PIMpage;

public class Admin extends BaseClass{
	
	
	@Test(priority = 1)
	private void deleteadmin() {
		Loginpage.Login(prop.getProperty("UN"),prop.getProperty("PW"));
	Adminpage.DeleteAllRecords();
		verifyisdisplay(isdisplay(PIMpage.Savedsuccessmessage));
	}
	
	@Test(priority = 2,dataProvider = "adminpage",dataProviderClass = AdminDataprovider.class,enabled=true)
	private void AddAdminuser(String Userrole,String Empname,String Status,String username,String Password,String Confirmpassword) {
		
		Loginpage.Login(prop.getProperty("UN"),prop.getProperty("PW"));
		
		Adminpage.Adduser(Userrole,Empname,Status,username,Password,Confirmpassword);
		
	}
	
	@Test(priority = 3,enabled=false)
	private void searchAdmin() {
		Loginpage.Login(prop.getProperty("UN"),prop.getProperty("PW"));
		Adminpage.Adminuserssearch("Bharadwaj","ESS", "bharadwaj  V","Disabled");
	}
}
