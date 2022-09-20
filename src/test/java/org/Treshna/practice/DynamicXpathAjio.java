package org.Treshna.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpathAjio {
	public static void main(String[] args) throws Throwable, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("ajio");
		String productCategory=sheet.getRow(1).getCell(0).getStringCellValue();
		String productName=sheet.getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//a[text()='"+productCategory+"']")).click();
		driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
		String productPrice = driver.findElement(By.xpath("//div[text()='"+productName+"']/following-sibling::div//span[@class='price  ']")).getText();
		System.out.println(productPrice);
		sheet.getRow(1).createCell(2).setCellValue(productPrice);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata.xlsx");
		wb.write(fos);
		

	}
}
