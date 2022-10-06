package HardCodedTestCases;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.Treshna.genericUtility.DataType;
import org.Treshna.genericUtility.ExcelUtility;
import org.Treshna.genericUtility.FileUtility;
import org.Treshna.genericUtility.IConstantPath;
import org.Treshna.genericUtility.JavaUtility;
import org.Treshna.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOraganizationAndCheckInContactModule1 {
	public static void main(String[] args) {
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		JavaUtility javaUtility = new JavaUtility();
		fileUtility.initializePropertyFile(IConstantPath.PROPERTY_PATH);
		excelUtility.initializeExcelFile(IConstantPath.EXCEL_PATH);
		//changes
		//fetch the data from the excel and property file
		String browser = fileUtility.getDataFromThePropertyFile( "browser");
		String username = fileUtility.getDataFromThePropertyFile( "username");
		String password = fileUtility.getDataFromThePropertyFile( "password");
		String url = fileUtility.getDataFromThePropertyFile( "url");
		String time = fileUtility.getDataFromThePropertyFile( "timeouts");
		long timeout = (long)javaUtility.convertStringIntoAnyDatatype(time, DataType.LONG);
		
		
		String org_name = excelUtility.getDataFromExcel( "organization", 12, 1)+javaUtility.getRandomNumber(100);
		String phone = excelUtility.getDataFromExcel("organization", 12, 2);
		String contact_name = excelUtility.getDataFromExcel("organization", 12, 3);
		/**WebDriverManager.chromedriver().setup();

		//WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		//Random random = new Random();
		//int randomNum = random.nextInt(100);
		driver.get("http://rmgtestingserver:8888/");
		*/
		
	
		WebDriver driver=webDriverUtility.openBrowserWithApplication(browser, timeout, url);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//a/img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(org_name);
		driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		WebElement HomeMajorTab = driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']"));
		webDriverUtility.clickByJavaScripExecutor( HomeMajorTab);
		js.executeScript("arguments[0].click();", HomeMajorTab);
	
		WebElement contactsMajorTab = driver.findElement(By.xpath("//a[contains(.,'Contacts')]"));
		//Actions action=new Actions(driver);
		//action.click(contactsMajorTab);
		js.executeScript("arguments[0].click();", contactsMajorTab);
		
		WebElement createContact = driver.findElement(By.xpath("//img[@alt='Create Contact...']"));
		webDriverUtility.clickByJavaScripExecutor(createContact);
		js.executeScript("arguments[0].click();", createContact);
		driver.findElement(By.xpath("//td[text()='Mobile ']/preceding-sibling::td//img[@title='Select']")).click();
		String parentwid = driver.getWindowHandle();
		Set<String> allwid = driver.getWindowHandles();
		driver.findElement(By.name("lastname")).sendKeys(contact_name);
		for (String wid : allwid) {
			driver.switchTo().window(wid);
			if (wid.equalsIgnoreCase("Accounts&action")) {
				break;
			}
		}
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='"+org_name+"']")).click();
		driver.switchTo().window(parentwid);
		driver.findElement(By.name("button")).click();
		System.out.println("PASS: Data transfer is successfull ");
		driver.close();
	}
	

}
