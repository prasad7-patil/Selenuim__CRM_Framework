package org.Treshna.practice;

import java.time.Duration;
import java.util.Set;

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
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		//Random random = new Random();
		//int randomNum = random.nextInt(100);
		driver.get("http://rmgtestingserver:8888/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String orgName="mindtree";
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//a/img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys("9591579799");
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		WebElement HomeMajorTab = driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']"));
		js.executeScript("arguments[0].click();", HomeMajorTab);
	
		WebElement contactsMajorTab = driver.findElement(By.xpath("//a[contains(.,'Contacts')]"));
		//Actions action=new Actions(driver);
		//action.click(contactsMajorTab);
		js.executeScript("arguments[0].click();", contactsMajorTab);
		WebElement createContact = driver.findElement(By.xpath("//img[@alt='Create Contact...']"));
		js.executeScript("arguments[0].click();", createContact);
		driver.findElement(By.xpath("//td[text()='Mobile ']/preceding-sibling::td//img[@title='Select']")).click();
		String parentwid = driver.getWindowHandle();
		Set<String> allwid = driver.getWindowHandles();
		driver.findElement(By.name("lastname")).sendKeys("supertramp");
		for (String wid : allwid) {
			driver.switchTo().window(wid);
			if (wid.equalsIgnoreCase("Accounts&action")) {
				break;
			}
		}
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		driver.switchTo().window(parentwid);
		driver.findElement(By.name("button")).click();
		System.out.println("PASS: Data transfer is successfull ");
		driver.close();
	}
	

}
