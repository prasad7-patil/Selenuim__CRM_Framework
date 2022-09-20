package org.Treshna.practice;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsPractice {


	public static ExtentTest stest;
	//private ExtentTest test;

	@Test
	
	public void extentReport() {

		//ExtentSparkReporter----->is to give to the reports
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport/extentreport.html");
		spark.config().setDocumentTitle("0rg.Treshna.CRM");
		spark.config().setReportName("reportName-Treshna");
		spark.config().setTheme(Theme.DARK);

		//step2 ---->to create the create
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(spark);
		//step3---to write something into report
		ExtentTest test = reports.createTest("test1");
		//one way--> test.log(Status.PASS,"test successfully created")
		//second way
		test.pass("Test1 Pass");
		test.fail("Test1 fail");
		test.warning("Test1 warning");
		test.skip("Test1 skips");
		test.info("Test1 info" );
		test.assignAuthor("prasad");
		
		reports.createTest("test2");
		reports.createTest("test3");
		reports.createTest("test4");
		reports.setSystemInfo("author", "shiv");
		reports.setSystemInfo("windows", "11");
		reports.setSystemInfo("browser", "chrome");
		reports.flush();//-->saves the document







	}
}
