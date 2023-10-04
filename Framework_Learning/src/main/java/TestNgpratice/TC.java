package TestNgpratice;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
/**
 * TC Attributes
 */
public class TC extends TestNGanotations{
	@Test(priority = 1)
	public static void TC_01() {
		System.out.println("Test 1");
		//assertTrue(false);
	}
	@Test(enabled = false)
	public static void TC_02() {
		System.out.println("Test 2");
	}
	@Test(priority = 2,dependsOnMethods = "TC_01")
	public static void TC_03() {
		System.out.println("Test 3");
	}
	@Test(priority = 4,invocationTimeOut = 1000)
	public static void TC_04() {
		System.out.println("Test 4");
	}
	@Test(invocationCount = 5)
	public static void TC_05() {
		System.out.println("Test 5");
	}
}
