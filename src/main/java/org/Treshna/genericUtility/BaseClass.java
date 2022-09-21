package org.Treshna.genericUtility;

import org.Treshna.objectRepository.CommonPage;
import org.Treshna.objectRepository.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class BaseClass {
	protected WebDriver driver;
	private String browser;
	private String username;
	private String password;
	private String url;
	private String time;
	protected long timeout;
	protected int randomNumber;
	protected FileUtility fileUtility;
	protected ExcelUtility excelUtility;
	protected WebDriverUtility webDriverUtility;
	protected JavaUtility javaUtility; 
	private LoginPage loginPage;
	protected CommonPage  commonPage;
	public static WebDriver sdriver;
	public static JavaUtility SjavaUtility;
	protected SoftAssert softAssert;
	
	//HELLO -->changes by te1

	/**
	 * initialize the all utility class
	 * open excel, property file
	 * read the common data
	 * create the instance for the browser
	 * minimize, implicit wait
	 * open the application
	 * initialize the java script executor, waibdriver wait
	 * create the instance for common object repo
	 */
	@BeforeClass

	public void ClassSetUp() {
		//instances of generic utility
		 fileUtility = new FileUtility();
		 excelUtility = new ExcelUtility();
		webDriverUtility = new WebDriverUtility();
		javaUtility = new JavaUtility();
		SjavaUtility=javaUtility;
		
		

		//initialize the excel and property file
		fileUtility.initializePropertyFile(IConstantPath.PROPERTY_PATH);
		excelUtility.initializeExcelFile(IConstantPath.EXCEL_PATH);

		//fetch the data from property file
		browser = fileUtility.getDataFromThePropertyFile( "browser");
		username = fileUtility.getDataFromThePropertyFile( "username");
		password = fileUtility.getDataFromThePropertyFile( "password");
		url = fileUtility.getDataFromThePropertyFile( "url");
		time = fileUtility.getDataFromThePropertyFile( "timeouts");
		timeout = (long)javaUtility.convertStringIntoAnyDatatype(time, DataType.LONG);
		randomNumber = javaUtility.getRandomNumber(100);

		//launching the browser and initializing the  java script and action class
		driver=webDriverUtility.openBrowserWithApplication(browser,timeout, url);
		sdriver=driver;
		webDriverUtility.downcastJavaScripExecutor(driver);
		webDriverUtility.initializeTheActionClass(driver);
		loginPage=new LoginPage(driver);
		commonPage =new CommonPage (driver);
		softAssert = new SoftAssert();


	}
	@BeforeMethod
	//login the application
	public void methodSetUP1() {
		loginPage.login(username, password);

	}
	@AfterMethod
	//logout from the application and save the application
	public void MethodTearDown() {
		commonPage.signOut(webDriverUtility);
		excelUtility.saveExcel();
	}

	@AfterClass
	//close the browser
	public void classTearDown() {
		webDriverUtility.closeTheBrowser(driver);
		excelUtility.closeExcelWorkbook();
	}

}