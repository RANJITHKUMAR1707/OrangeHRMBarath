package TestNgpratice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGanotations {

	@BeforeSuite
	public static void Beforesuite() {
		System.out.println("This execute Before suite");
	}
	@BeforeTest
	public static void BeforeTest() {
		System.out.println("This execute Before Test");
	}
	@org.testng.annotations.BeforeClass
	public static void BeforeClass() {
		System.out.println("This execute Before Class");
	}
	@BeforeMethod
	public static void Beforemethod() {
		System.out.println("This execute Before Method");
	}
	
	@AfterMethod
	public static void AfterMethod() {
		System.out.println("This execute After Method");
	}
	@AfterClass
	public static void AfterClass() {
		System.out.println("This execute After Class");
	}
	@AfterTest
	public static void AfterTest() {
		System.out.println("This execute After Test");
	}
	@AfterSuite
	public static void AfterSuite() {
		System.out.println("This execute After Suite");
	}
	
}
