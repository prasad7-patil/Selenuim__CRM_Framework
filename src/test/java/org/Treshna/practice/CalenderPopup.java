package org.Treshna.practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopup {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		String requiredDate="20";
		String requiredMonth="January";//MMMM-->February,MM---->02,MMM---->FEB
		String requiredYear="2024";
		int requiredMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(requiredMonth).get(ChronoField.MONTH_OF_YEAR);
		int requiredYearInNum = Integer.parseInt(requiredYear);
		//Random random = new Random();
		//int randomNum = random.nextInt(100);
		driver.get("http://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		//driver.findElement(By.name("user_password")).sendKeys("admin");
		//driver.findElement(By.id("submitButton")).click();
		//driver.findElement(By.xpath("//img[@alt='Open Calendar...']")).click();
		String actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();

		String[] str=actualMonthYear.split(" ");
		String actualMonth=str[0];
		String actualYear=str[1];
		int actualMonthInNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH)	.parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
		int actualYearInNum = Integer.parseInt(actualYear);

		while (requiredMonthInNum>actualMonthInNum || requiredYearInNum>actualYearInNum) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualMonthYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str=actualMonthYear.split(" ");
			actualMonth=str[0];
			actualYear=str[1];
			actualMonthInNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH)	.parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
			actualYearInNum = Integer.parseInt(actualYear);

		}
		while (requiredMonthInNum<actualMonthInNum || requiredYearInNum<actualYearInNum) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualMonthYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str=actualMonthYear.split(" ");
			actualMonth=str[0];
			actualYear=str[1];
			actualMonthInNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH)	.parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
			actualYearInNum = Integer.parseInt(actualYear);

		}
		driver.findElement(By.xpath("//a[text()='"+requiredDate+"']")).click();
		driver.close();

	}
	
}
