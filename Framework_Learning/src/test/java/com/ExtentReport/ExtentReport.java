package com.ExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.configure.Factory;

public class ExtentReport{

	public static ExtentReports extent;
	/**
	 * invoke the report begining of the execution
	 * @throws IOException 
	 */
	public static  void invokereport()  {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();

			//			ExtentSparkReporter failedreport=new ExtentSparkReporter("FailedTC.html").filter().statusFilter()
			//					.as(new Status[] {Status.FAIL,Status.SKIP}).apply();
			//			failedreport.config().setDocumentTitle("Failed TestReport");
			//			failedreport.config().setReportName("Failed Test Cases Report");
			//			failedreport.config().setTheme(Theme.DARK);

			File Configer = new File("extentreport.xml");
			ExtentSparkReporter spark = new ExtentSparkReporter(Factory.getExtentReportFilePath());
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
	public static void flushreport() {
		if(Objects.nonNull(extent)) {
			System.out.println("run");
			extent.flush();
			try {
				 File reportFile = new File(Factory.getExtentReportFilePath());
		            if (reportFile.exists()) {
		            	Desktop.getDesktop().browse(reportFile.toURI());
		            } else {
		                System.out.println("Extent Report file does not exist: " + reportFile);
		            }
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			//			Desktop.getDesktop().browse(new File("FailedTC.html").toURI());


		}
	}
	/**
	 * create a test name for an Extent report
	 * @param testcasename 
	 */
	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}
}
