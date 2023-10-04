package TestNgpratice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class test{

		private static  ExtentReports extent;
		static ExtentSparkReporter spark;
		/**
		 * invoke the report begining of the execution
		 * @throws IOException 
		 */
		@BeforeSuite
		public static void invokereport()  {
			if(Objects.isNull(extent)) {
				extent = new ExtentReports();
				File Configer = new File("extentreport.xml");
				spark = new ExtentSparkReporter("C:/Users/bhardwaj.viswanatha/eclipse-workspace1/Framework_Learning/extent-report/index.html");
				extent.setSystemInfo("OS Details", System.getProperty("os.name"));
				extent.setSystemInfo("OS verison", System.getProperty("os.version"));
				extent.setSystemInfo("Java version", System.getProperty("java.version"));
				
				try {
					spark.loadXMLConfig(Configer);
				} catch (IOException e) {
					e.printStackTrace();
				}
				extent.attachReporter(spark);
			}
		}
		/**
		 * flush the report end of the execution
		 * @throws IOException 
		 */
		@AfterSuite
		public static void flushreport() throws IOException {
			if(Objects.nonNull(extent)) {
				System.out.println("run");
				extent.flush();
              Desktop.getDesktop().browse(new File("C:/Users/bhardwaj.viswanatha/eclipse-workspace1/Framework_Learning/extent-report/index.html").toURI());
               }
		}
	@Test
	private static void test() {
		ExtentTest test=extent.createTest("Test");
		test.pass("Test1 successfull1");
	}
	}
	
