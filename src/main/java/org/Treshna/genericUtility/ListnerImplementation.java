package org.Treshna.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener{

	private ExtentReports reports;
	private ExtentTest test;
	public static ExtentTest stest;

	@Override//BT
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport/extentreport.html");
		spark.config().setDocumentTitle("0rg.Treshna.CRM");
		spark.config().setReportName("reportName-Treshna");
		spark.config().setTheme(Theme.DARK);
		;

		//step2 ---->to create the create
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("author", "shiv");
		reports.setSystemInfo("windows", "11");
		reports.setSystemInfo("browser", "chrome");

	}

	@Override//Bm
	public void onTestStart(ITestResult result) {
		//step3---to write something into report
		test = reports.createTest(result.getMethod().getMethodName());
		// test.assignAuthor("prasad");
		//test.assignCategory("regression");
	}

	@Override//AM
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+" Pass");
		stest=test;

	}

	@Override//AM
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+" fail");
		test.fail(result.getThrowable());//----->it will attach the exception details
		System.out.println(Thread.currentThread().getId());
		//two ways to attach screen shot to report
		/*//way 1
		 *  String path=null; 
		 *  try { path = new WebDriverUtility().screenshot(BaseClass.sdriver, BaseClass.SjavaUtility,result.getMethod().getMethodName()); 
		 * //drawback of the above method is that it will consume memory in the local computer } catch (Throwable e) { 
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 * test.addScreenCaptureFromPath(path);
		 */
		//way 2
		String path=null; 
		try { path = new WebDriverUtility().screenshot(BaseClass.sdriver); 
		 } catch (Throwable e) { 
		// TODO Auto-generated catch block 
			 e.printStackTrace(); }
		 test.addScreenCaptureFromBase64String(path);
		
		


	}

	@Override//AM
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"skips");
		test.fail(result.getThrowable());//----->it will attach the exception details


	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}


	@Override
	public void onFinish(ITestContext context) {
		reports.flush();

	}

}
