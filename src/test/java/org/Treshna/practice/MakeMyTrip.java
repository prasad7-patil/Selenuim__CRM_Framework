package org.Treshna.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	driver.findElement(By.id("fromCity")).sendKeys("New Delhi");
	List<WebElement> fromAutoSuggestion = driver.findElements(By.tagName("li"));
	//from.click();
	//List<WebElement> allTheElements = from.findElements(By.xpath("//input[@placeholder='From']"));
	
	for (WebElement webElement : fromAutoSuggestion) {
		if (webElement.getText().contains("New Delhi")) {
			webElement.click();
			break;
		}
	}
	
	driver.switchTo().activeElement().sendKeys("Pune");
	List<WebElement> toAutoSuggestion = driver.findElements(By.tagName("li"));
	for (WebElement webElement : toAutoSuggestion) {
		if (webElement.getText().contains("")) {
			js.executeScript("arguments[0].click();", webElement);
			break;
		}
	}
}
}
